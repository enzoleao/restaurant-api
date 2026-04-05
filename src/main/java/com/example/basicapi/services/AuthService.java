package com.example.basicapi.services;

import com.example.basicapi.controller.AuthController;
import com.example.basicapi.dtos.auth.AuthRequestDTO;
import com.example.basicapi.dtos.auth.AuthResponseDTO;
import com.example.basicapi.dtos.users.RegisterUserResponseDTO;
import com.example.basicapi.entity.User;
import com.example.basicapi.exceptions.BadRequestException;
import com.example.basicapi.repositories.UserRepository;
import com.example.basicapi.security.JwtService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;

    public AuthService(UserRepository userRepository, JwtService jwtService, PasswordEncoder passwordEncoder) {
        this.jwtService = jwtService;
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    public AuthResponseDTO login (AuthRequestDTO authRequestDTO) {
        User user = userRepository.findByEmail(authRequestDTO.getEmail()).orElseThrow(()-> new BadRequestException("E-mail ou senha inválidos"));
        if (!passwordEncoder.matches(authRequestDTO.getPassword(), user.getPassword())) {
            throw new BadRequestException("E-mail ou senha inválidos");
        }
        String token = jwtService.generateToken(user);

        return new AuthResponseDTO(RegisterUserResponseDTO.fromEntity(user), token);
    }

    public User resgiter(String name, String email, String password) {
        if (userRepository.findByEmail(email).isPresent()) {
            throw new BadRequestException("Email já cadastrado");
        }
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(passwordEncoder.encode(password));

        return this.userRepository.save(user);
    }

}
