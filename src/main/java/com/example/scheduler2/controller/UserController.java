package com.example.scheduler2.controller;

import com.example.scheduler2.dto.user.UpdateUserRrequestDto;
import com.example.scheduler2.dto.user.UserResponseDto;
import com.example.scheduler2.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.bcel.Const;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    //유저 전체 조회
    @GetMapping
    public  ResponseEntity<?> findAll() {
        List<UserResponseDto> userResponseDtos = userService.findAll();

        return new ResponseEntity<>(userResponseDtos, HttpStatus.OK);
    }

//    선택 유저 조회
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(
            @PathVariable Long id,
            HttpServletRequest request) {
        UserResponseDto userResponseDto = userService.findById(id);

        HttpSession session = request.getSession();
        log.info(session.toString());

        return new ResponseEntity<>(userResponseDto, HttpStatus.OK);
    }

    //선택 유저 수정
    @Transactional
    @PatchMapping("/{id}")
    public ResponseEntity<?> updateSchedule(
            @PathVariable Long id,
            @RequestBody UpdateUserRrequestDto requestDto) {

        UserResponseDto userResponseDto = userService.updateSchedule(id, requestDto.getUserName(), requestDto.getEmail());

        return new ResponseEntity<>(userResponseDto, HttpStatus.OK);
    }

    //유저 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        userService.deleteSchedule(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
