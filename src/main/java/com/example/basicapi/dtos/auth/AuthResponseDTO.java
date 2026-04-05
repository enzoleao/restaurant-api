package com.example.basicapi.dtos.auth;

import com.example.basicapi.dtos.users.RegisterUserResponseDTO;
import lombok.Getter;

@Getter
public class AuthResponseDTO {
    private RegisterUserResponseDTO user;
    private String token;

    public AuthResponseDTO (RegisterUserResponseDTO user, String token) {
        this.user = user;
        this.token = token;
    }
}
