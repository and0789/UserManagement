package com.andreseptian.usermanagement.service.implementation;

import com.andreseptian.usermanagement.domain.Role;
import com.andreseptian.usermanagement.domain.User;
import com.andreseptian.usermanagement.dto.UserDTO;
import com.andreseptian.usermanagement.repository.RoleRepository;
import com.andreseptian.usermanagement.repository.UserRepository;
import com.andreseptian.usermanagement.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.andreseptian.usermanagement.dtomapper.UserDTOMapper.fromUser;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository<User> userRepository;
    private final RoleRepository<Role> roleRoleRepository;

    @Override
    public UserDTO createUser(User user) {
        return mapToUserDTO(userRepository.create(user));
    }

    @Override
    public UserDTO getUserByEmail(String email) {
        return mapToUserDTO(userRepository.getUserByEmail(email));
    }

    @Override
    public void sendVerificationCode(UserDTO user) {
        userRepository.sendVerificationCode(user);
    }

    @Override
    public UserDTO verifyCode(String email, String code) {
        return mapToUserDTO(userRepository.verifyCode(email, code));
    }

    @Override
    public void resetPassword(String email) {
        userRepository.resetPassword(email);
    }

    @Override
    public UserDTO verifyPasswordKey(String key) {
        return mapToUserDTO(userRepository.verifyPasswordKey(key));
    }

    @Override
    public void renewPassword(String key, String password, String confirmPassword) {
        userRepository.renewPassword(key, password, confirmPassword);
    }


    private UserDTO mapToUserDTO(User user) {
        return fromUser(user, roleRoleRepository.getRoleByUserId(user.getId()));
    }
}