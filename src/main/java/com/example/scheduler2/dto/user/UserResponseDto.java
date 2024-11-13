package com.example.scheduler2.dto.user;

import com.example.scheduler2.entity.User;
import lombok.Getter;

@Getter
public class UserResponseDto {

    private final Long userId;

    private final String userName;

    private final String email;

    public UserResponseDto(Long userId, String userName, String email) {
        this.userId = userId;
        this.userName = userName;
        this.email = email;
    }

    public static UserResponseDto toDto(User user) {
        return new UserResponseDto(user.getUserId(),user.getUserName(), user.getEmail());
    }

}
