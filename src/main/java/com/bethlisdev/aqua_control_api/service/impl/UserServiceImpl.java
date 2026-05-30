package com.bethlisdev.aqua_control_api.service.impl;

import java.time.LocalDateTime;
import org.springframework.stereotype.Service;
import com.bethlisdev.aqua_control_api.Messages;
import com.bethlisdev.aqua_control_api.entity.UserEntity;
import com.bethlisdev.aqua_control_api.exception.GoogleAuthenticationException;
import com.bethlisdev.aqua_control_api.repository.UserRepository;
import com.bethlisdev.aqua_control_api.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    private static final String GOOGLE_AUTH_SOURCE = "GOOGLE_AUTH";
    private static final int MAX_GOOGLE_ID_LENGTH = 100;
    private static final int MAX_FIELD_LENGTH = 50;

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserEntity syncUserFromGoogleLogin(String googleId, String email, String fullName) {
        return userRepository.findByGoogleId(googleId)
                .map(user -> {
                    validateActiveUser(user);
                    return user;
                })
                .orElseGet(() -> createUser(googleId, email, fullName));
    }

    private UserEntity createUser(String googleId, String email, String fullName) {
        NameParts nameParts = splitFullName(fullName);
        UserEntity user = new UserEntity();
        user.setGoogleId(truncate(googleId, MAX_GOOGLE_ID_LENGTH));
        user.setEmail(truncate(email, MAX_FIELD_LENGTH));
        user.setFirstName(truncate(nameParts.firstName(), MAX_FIELD_LENGTH));
        user.setLastName(truncate(nameParts.lastName(), MAX_FIELD_LENGTH));
        user.setStatus(true);
        user.setCreatedAt(LocalDateTime.now());
        user.setCreatedBy(GOOGLE_AUTH_SOURCE);
        return userRepository.save(user);
    }

    private void validateActiveUser(UserEntity user) {
        if (Boolean.FALSE.equals(user.getStatus())) {
            throw new GoogleAuthenticationException(Messages.USER_INACTIVE);
        }
    }

    private NameParts splitFullName(String fullName) {
        if (fullName == null || fullName.isBlank()) {
            return new NameParts("User", "");
        }
        String trimmed = fullName.trim();
        int separatorIndex = trimmed.indexOf(' ');
        if (separatorIndex < 0) {
            return new NameParts(trimmed, "");
        }
        return new NameParts(
                trimmed.substring(0, separatorIndex),
                trimmed.substring(separatorIndex + 1).trim());
    }

    private String truncate(String value, int maxLength) {
        if (value == null) {
            return "";
        }
        return value.length() <= maxLength ? value : value.substring(0, maxLength);
    }

    private record NameParts(String firstName, String lastName) {
    }
}
