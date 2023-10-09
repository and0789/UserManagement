package com.andreseptian.usermanagement.service.implementation;

import com.andreseptian.usermanagement.domain.Role;
import com.andreseptian.usermanagement.repository.RoleRepository;
import com.andreseptian.usermanagement.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {
    private final RoleRepository<Role> roleRoleRepository;

    @Override
    public Role getRoleByUserId(Long id) {
        return roleRoleRepository.getRoleByUserId(id);
    }
}