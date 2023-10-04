package com.andreseptian.usermanagement.service.implementation;

import com.andreseptian.usermanagement.domain.User;
import com.andreseptian.usermanagement.dto.UserDTO;
import com.andreseptian.usermanagement.dtomapper.UserDTOMapper;
import com.andreseptian.usermanagement.repository.UserRepository;
import com.andreseptian.usermanagement.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository<User> userRepository;

    @Override
    public UserDTO createUser(User user) {
        return UserDTOMapper.fromUser(userRepository.create(user));
    }
}