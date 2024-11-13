package com.example.scheduler2.dto.user;

import lombok.Getter;

@Getter
public class UpdateUserRrequestDto {
    private final String userName;
    private final String email;

    public UpdateUserRrequestDto(String userName, String email) {
        this.userName = userName;
        this.email = email;
    }
}
