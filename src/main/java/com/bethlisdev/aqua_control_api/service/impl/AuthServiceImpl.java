package com.bethlisdev.aqua_control_api.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtException;
import org.springframework.stereotype.Service;
import com.bethlisdev.aqua_control_api.Messages;
import com.bethlisdev.aqua_control_api.dto.AuthenticatedUserDto;
import com.bethlisdev.aqua_control_api.entity.UserEntity;
import com.bethlisdev.aqua_control_api.exception.GoogleAuthenticationException;
import com.bethlisdev.aqua_control_api.service.AuthService;
import com.bethlisdev.aqua_control_api.service.UserService;

@Service
public class AuthServiceImpl implements AuthService {

    private final JwtDecoder googleJwtDecoder;
    private final String googleClientId;
    private final UserService userService;

    public AuthServiceImpl(JwtDecoder jwtDecoder,
            @Value("${security.oauth2.google.client-id}") String googleClientId,
            UserService userService) {
        this.googleJwtDecoder = jwtDecoder;
        this.googleClientId = googleClientId;
        this.userService = userService;
    }

    @Override
    public AuthenticatedUserDto authenticateUser(String idToken) {
        Jwt jwtToken = decodeToken(idToken);
        validateAudience(jwtToken);
        UserEntity user = userService.syncUserFromGoogleLogin(
                jwtToken.getClaimAsString("sub"),
                jwtToken.getClaimAsString("email"),
                jwtToken.getClaimAsString("name"));
        return buildAuthenticatedUser(jwtToken, user);
    }

    private Jwt decodeToken(String idToken) {
        try {
            return googleJwtDecoder.decode(idToken);
        } catch (JwtException ex) {
            throw new GoogleAuthenticationException(Messages.GOOGLE_ID_TOKEN_INVALID_OR_EXPIRED);
        }
    }

    private void validateAudience(Jwt jwtToken) {
        Object audienceClaim = jwtToken.getClaims().get("aud");
        if (audienceClaim == null) {
            throw new GoogleAuthenticationException(Messages.GOOGLE_TOKEN_AUDIENCE_INVALID);
        }

        if (audienceClaim instanceof String audience
                && !googleClientId.equals(audience)) {
            throw new GoogleAuthenticationException(Messages.GOOGLE_TOKEN_AUDIENCE_INVALID);
        }

        if (audienceClaim instanceof List<?> audiences
                && audiences.stream().noneMatch(value -> googleClientId.equals(value))) {
            throw new GoogleAuthenticationException(Messages.GOOGLE_TOKEN_AUDIENCE_INVALID);
        }

        if (!(audienceClaim instanceof String) && !(audienceClaim instanceof List<?>)) {
            throw new GoogleAuthenticationException(Messages.GOOGLE_TOKEN_AUDIENCE_INVALID);
        }
    }

    private AuthenticatedUserDto buildAuthenticatedUser(Jwt jwtToken, UserEntity user) {
        String fullName = jwtToken.getClaimAsString("name");
        String pictureUrl = jwtToken.getClaimAsString("picture");
        Boolean emailVerified = jwtToken.getClaim("email_verified");

        return new AuthenticatedUserDto(
                user.getId(),
                user.getGoogleId(),
                user.getEmail(),
                user.getFirstName(),
                user.getLastName(),
                fullName,
                pictureUrl,
                emailVerified != null && emailVerified,
                Boolean.TRUE.equals(user.getStatus()));
    }
}
