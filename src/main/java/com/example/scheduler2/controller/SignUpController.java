package com.example.scheduler2.controller;

import com.example.scheduler2.dto.user.CreateUserRequestDto;
import com.example.scheduler2.dto.user.UserResponseDto;
import com.example.scheduler2.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/signUp")
public class SignUpController {

    private final UserService userService;

    public SignUpController(UserService userService) {
        this.userService = userService;
    }

    //유저 생성
    @PostMapping
    public ResponseEntity<?> saveUser(@RequestBody CreateUserRequestDto requestDto) {
        UserResponseDto userResponseDto = userService.saveUser(requestDto.getUserName(), requestDto.getEmail(), requestDto.getPassword());

        return new ResponseEntity<>(userResponseDto, HttpStatus.CREATED);
    }

}
