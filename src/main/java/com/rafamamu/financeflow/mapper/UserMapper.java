package com.rafamamu.financeflow.mapper;

import com.rafamamu.financeflow.dto.UserResponseDTO;
import com.rafamamu.financeflow.model.User;

public class UserMapper {

    public static  UserResponseDTO toResponse (User user) {
        return UserResponseDTO.()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .build();


    }
}
