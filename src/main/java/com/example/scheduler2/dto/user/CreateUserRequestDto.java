package com.example.scheduler2.dto.user;

import lombok.Getter;

@Getter
public class CreateUserRequestDto {
    private final String userName;

    private final String email;

    private final String password;

    public CreateUserRequestDto(String userName, String email, String password) {
        this.userName = userName;
        this.email = email;
        this.password = password;
    }
}
