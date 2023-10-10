package com.andreseptian.usermanagement.service;

import com.andreseptian.usermanagement.domain.User;
import com.andreseptian.usermanagement.dto.UserDTO;

public interface UserService {
    UserDTO createUser(User user);

    UserDTO getUserByEmail(String email);

    void sendVerificationCode(UserDTO user);

    UserDTO verifyCode(String email, String code);

    void resetPassword(String email);

    UserDTO verifyPasswordKey(String key);

    void renewPassword(String key, String password, String confirmPassword);
}

