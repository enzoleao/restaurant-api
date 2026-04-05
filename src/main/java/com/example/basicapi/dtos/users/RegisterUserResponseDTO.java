package com.example.basicapi.dtos.users;

import com.example.basicapi.entity.User;
import lombok.Getter;

@Getter
public class RegisterUserResponseDTO {

    private Long id;
    private String name;
    private String email;

    public RegisterUserResponseDTO(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public static RegisterUserResponseDTO fromEntity(User user) {
        return new RegisterUserResponseDTO(
                user.getId(),
                user.getName(),
                user.getEmail()
        );
    }
}
