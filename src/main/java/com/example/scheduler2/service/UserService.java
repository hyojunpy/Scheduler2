package com.example.scheduler2.service;

import com.example.scheduler2.dto.user.UserResponseDto;
import com.example.scheduler2.entity.Schedule;
import com.example.scheduler2.entity.User;
import com.example.scheduler2.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    //유저 생성
    public UserResponseDto saveUser(String userName, String email, String password) {
        User user = new User(userName, email, password);

        User saveUser = userRepository.save(user);

        return  new UserResponseDto(saveUser.getUserId(), saveUser.getUserName(), saveUser.getEmail());
    }

    //유저 전체 조회
    public List<UserResponseDto> findAll() {
        return userRepository.findAll().stream().map(UserResponseDto::toDto).toList();
    }

    //유저 선택 조회
    public UserResponseDto findById(Long userId) {
        User findUser = userRepository.findByIdOrElseThrow(userId);

        return new UserResponseDto(findUser.getUserId(), findUser.getUserName(), findUser.getEmail());
    }

    //유저 선택 수정
    public UserResponseDto updateSchedule(Long id, String userName, String email) {
        User findUser = userRepository.findByIdOrElseThrow(id);

        findUser.updateUser(userName, email);


        return new UserResponseDto(findUser.getUserId(), findUser.getUserName(), findUser.getEmail());

    }

    //유저 삭제
    public void deleteSchedule(Long userId) {
        User findId = userRepository.findByIdOrElseThrow(userId);

        userRepository.deleteById(findId.getUserId());
    }

    public boolean loginUser(String email, String password) {
        User user = userRepository.findByEmail(email);

        if(user != null && user.getPassword().equals(password)) {
            return true;
        }
        return false;
    }
}
