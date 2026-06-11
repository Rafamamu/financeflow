package com.rafamamu.financeflow.service;

import com.rafamamu.financeflow.dto.UserRequestDTO;
import com.rafamamu.financeflow.dto.UserResponseDTO;
import com.rafamamu.financeflow.mapper.UserMapper;
import com.rafamamu.financeflow.model.User;
import com.rafamamu.financeflow.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


    public UserResponseDTO createUser(UserRequestDTO requestDTO) {
        User newUser = UserMapper.toEntity(requestDTO);
        newUser.setPassword(passwordEncoder.encode(newUser.getPassword()));
        User userSaved = userRepository.save(newUser);

        return UserMapper.toResponse(userSaved);
    }


}
