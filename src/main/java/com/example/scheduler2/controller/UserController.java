package com.example.scheduler2.controller;

import com.example.scheduler2.dto.schedule.ScheduleResponseDto;
import com.example.scheduler2.dto.schedule.UpdateRequestDto;
import com.example.scheduler2.dto.user.CreateUserRequestDto;
import com.example.scheduler2.dto.user.UpdateUserRrequestDto;
import com.example.scheduler2.dto.user.UserResponseDto;
import com.example.scheduler2.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    //유저 생성
    @PostMapping
    public ResponseEntity<UserResponseDto> saveUser(@RequestBody CreateUserRequestDto requestDto) {
       UserResponseDto userResponseDto = userService.saveUser(requestDto.getUserName(), requestDto.getEmail());

        return new ResponseEntity<>(userResponseDto, HttpStatus.CREATED);
    }

    //유저 전체 조회
    @GetMapping
    public  ResponseEntity<List<UserResponseDto>> findAll() {
        List<UserResponseDto> userResponseDtos = userService.findAll();

        return new ResponseEntity<>(userResponseDtos, HttpStatus.OK);
    }

//    선택 유저 조회
    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> findById(@PathVariable Long id) {
        UserResponseDto userResponseDto = userService.findById(id);

        return new ResponseEntity<>(userResponseDto, HttpStatus.OK);
    }

    //선택 유저 수정
    @Transactional
    @PatchMapping("/{id}")
    public ResponseEntity<UserResponseDto> updateSchedule(
            @PathVariable Long id,
            @RequestBody UpdateUserRrequestDto requestDto) {

        UserResponseDto userResponseDto = userService.updateSchedule(id, requestDto.getUserName(), requestDto.getEmail());

        return new ResponseEntity<>(userResponseDto, HttpStatus.OK);
    }

    //유저 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        userService.deleteSchedule(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
