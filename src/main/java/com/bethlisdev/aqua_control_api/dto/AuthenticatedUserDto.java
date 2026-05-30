package com.bethlisdev.aqua_control_api.dto;

public class AuthenticatedUserDto {

    private final Integer id;
    private final String googleId;
    private final String email;
    private final String firstName;
    private final String lastName;
    private final String fullName;
    private final String pictureUrl;
    private final boolean emailVerified;
    private final boolean active;

    public AuthenticatedUserDto(Integer id,
            String googleId,
            String email,
            String firstName,
            String lastName,
            String fullName,
            String pictureUrl,
            boolean emailVerified,
            boolean active) {
        this.id = id;
        this.googleId = googleId;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.fullName = fullName;
        this.pictureUrl = pictureUrl;
        this.emailVerified = emailVerified;
        this.active = active;
    }

    public Integer getId() {
        return id;
    }

    public String getGoogleId() {
        return googleId;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFullName() {
        return fullName;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public boolean isEmailVerified() {
        return emailVerified;
    }

    public boolean isActive() {
        return active;
    }
}
