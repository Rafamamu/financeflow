package com.rafamamu.financeflow.controller;

import com.rafamamu.financeflow.model.User;
import com.rafamamu.financeflow.service.UserService;
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
    public User createUser(@RequestBody User user) {
         return  userService.createUser(user);

    }



}
