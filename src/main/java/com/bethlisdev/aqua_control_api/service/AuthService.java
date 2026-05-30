package com.bethlisdev.aqua_control_api.service;

import com.bethlisdev.aqua_control_api.dto.AuthenticatedUserDto;

public interface AuthService {

    public AuthenticatedUserDto authenticateUser(String idToken);
}
