package com.andreseptian.usermanagement.service;

import com.andreseptian.usermanagement.domain.Role;

import java.util.Collection;


public interface RoleService {
    Role getRoleByUserId(Long id);

    Collection<Role> getRoles();
}

