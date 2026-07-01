package com.rafamamu.financeflow.controller;

import com.rafamamu.financeflow.dto.LoginRequestDTO;
import com.rafamamu.financeflow.model.User;
import com.rafamamu.financeflow.service.JwtService;
import com.rafamamu.financeflow.service.UserService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class AuthController {

    private final UserService userService;
    private final JwtService jwtService;

    public AuthController(UserService userService, JwtService jwtService) {

        this.userService = userService;
        this.jwtService = jwtService;
    }

    @PostMapping("/auth/login")
    public String userAuthLogin(@Valid @RequestBody LoginRequestDTO request) {

        User user = userService.findByEmail(request.getEmail());
        if (userService.checkPassword(request.getPassword(), user.getPassword())) {

            return jwtService.generateToken(user);
        } else {
            throw new RuntimeException("Senha incorreta!");
        }
    }
}
