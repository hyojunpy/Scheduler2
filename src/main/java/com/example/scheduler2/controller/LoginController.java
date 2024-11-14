package com.example.scheduler2.controller;

import com.example.scheduler2.dto.user.LoginRequestDto;
import com.example.scheduler2.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@Slf4j
public class LoginController {
    private final UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login (
            @RequestBody LoginRequestDto requestDto,
            HttpServletRequest request) {
        boolean isAuth = userService.loginUser(requestDto.getEmail(), requestDto.getPassword());

        if(isAuth) {
            HttpSession session = request.getSession(true);
            session.setAttribute("email", requestDto.getEmail());
            log.info(session.toString());
            return ResponseEntity.ok("로그인 성공");
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("로그인 실패");
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logout (HttpServletRequest request){
        HttpSession session = request.getSession(false);

        if(session != null) {
            session.invalidate();
            return ResponseEntity.ok("로그아웃 성공");
        }
        else return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("로그아웃 실패");

    }



}
