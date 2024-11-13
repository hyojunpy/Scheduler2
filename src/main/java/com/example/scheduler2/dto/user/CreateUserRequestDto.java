package com.example.scheduler2.dto.user;

import lombok.Getter;

@Getter
public class CreateUserRequestDto {
    private final String userName;

    private final String email;

    public CreateUserRequestDto(String userName, String email) {
        this.userName = userName;
        this.email = email;
    }
}
