package com.andreseptian.usermanagement.service;

import com.andreseptian.usermanagement.domain.User;
import com.andreseptian.usermanagement.dto.UserDTO;

public interface UserService {
    UserDTO createUser(User user);
}

