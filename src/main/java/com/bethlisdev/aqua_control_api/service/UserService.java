package com.bethlisdev.aqua_control_api.service;

import com.bethlisdev.aqua_control_api.entity.UserEntity;

public interface UserService {

    public UserEntity syncUserFromGoogleLogin(String googleId, String email, String fullName);
}
