package com.bethlisdev.aqua_control_api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.bethlisdev.aqua_control_api.dto.AuthenticatedUserDto;
import com.bethlisdev.aqua_control_api.dto.GoogleLoginRequestDto;
import com.bethlisdev.aqua_control_api.service.AuthService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public AuthenticatedUserDto loginWithGoogle(@Valid @RequestBody GoogleLoginRequestDto request) {
        return authService.authenticateUser(request.getIdToken());
    }
}
