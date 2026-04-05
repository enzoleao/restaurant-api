package com.example.basicapi.controller;

import com.example.basicapi.dtos.auth.AuthRequestDTO;
import com.example.basicapi.dtos.auth.AuthResponseDTO;
import com.example.basicapi.dtos.users.RegisterUserRequestDTO;
import com.example.basicapi.entity.User;
import com.example.basicapi.services.AuthService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/auth")
public class AuthController {

    private  final AuthService authService;

    AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public AuthResponseDTO login(@RequestBody AuthRequestDTO authRequestDTO) {
        return authService.login(authRequestDTO);
    }

    @PostMapping("/register")
    public User resgiter(@RequestBody RegisterUserRequestDTO dto ) {
        return authService.resgiter(
                dto.getName(),
                dto.getEmail(),
                dto.getPassword()
        );
    }
}
