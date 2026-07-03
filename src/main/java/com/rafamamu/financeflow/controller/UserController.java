package com.rafamamu.financeflow.controller;

import com.rafamamu.financeflow.dto.UserRequestDTO;
import com.rafamamu.financeflow.dto.UserResponseDTO;
import com.rafamamu.financeflow.model.User;
import com.rafamamu.financeflow.service.UserService;
import jakarta.validation.Valid;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;

    }

    @PostMapping("/userRegister")
    public UserResponseDTO createUser(@Valid @RequestBody UserRequestDTO  request) {
        return  userService.createUser(request);
    }

    @GetMapping("/meuPerfil")
    public String getPerfil() {
        return "Segue as credenciais do Usuário: "+
                SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
    }



}
