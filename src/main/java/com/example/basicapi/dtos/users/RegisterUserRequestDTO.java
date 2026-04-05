package com.example.basicapi.dtos.users;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterUserRequestDTO {
    private String name;
    private String email;
    private String password;

}
