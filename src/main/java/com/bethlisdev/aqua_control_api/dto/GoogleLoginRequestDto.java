package com.bethlisdev.aqua_control_api.dto;

import com.bethlisdev.aqua_control_api.Messages;
import jakarta.validation.constraints.NotBlank;

public class GoogleLoginRequestDto {

    @NotBlank(message = Messages.GOOGLE_ID_TOKEN_REQUIRED)
    private final String idToken;

    public GoogleLoginRequestDto(String idToken) {
        this.idToken = idToken;
    }

    public String getIdToken() {
        return idToken;
    }
}
