package com.example.basicapi.controller;

import com.example.basicapi.services.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/users")
public class UserController {

    private  final UserService userService;
    UserController(UserService userService) {
        this.userService = userService;
    }

}
