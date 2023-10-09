package com.andreseptian.usermanagement.service;

import com.andreseptian.usermanagement.domain.Role;


public interface RoleService {
    Role getRoleByUserId(Long id);
}

