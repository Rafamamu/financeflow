package com.rafamamu.financeflow.mapper;

import com.rafamamu.financeflow.dto.UserRequestDTO;
import com.rafamamu.financeflow.dto.UserResponseDTO;
import com.rafamamu.financeflow.model.User;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UserMapper {

    public static  UserResponseDTO toResponse (User user) {
        return UserResponseDTO.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .build();
    }

    public static User toUserEntity(UserRequestDTO requestDTO) {

        return User.builder()
                .name(requestDTO.getName())
                .email(requestDTO.getEmail())
                .password(requestDTO.getPassword())
                .build();

    }
}
