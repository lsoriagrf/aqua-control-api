package com.bethlisdev.aqua_control_api.dto;

public class AuthenticatedUserDto {

    private final String userId;
    private final String email;
    private final String fullName;
    private final String pictureUrl;
    private final boolean emailVerified;

    public AuthenticatedUserDto(String userId,
            String email,
            String fullName,
            String pictureUrl,
            boolean emailVerified) {
        this.userId = userId;
        this.email = email;
        this.fullName = fullName;
        this.pictureUrl = pictureUrl;
        this.emailVerified = emailVerified;
    }

    public String getUserId() {
        return userId;
    }

    public String getEmail() {
        return email;
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
}
