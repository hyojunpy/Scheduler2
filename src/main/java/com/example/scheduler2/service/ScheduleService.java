package com.example.scheduler2.service;

import com.example.scheduler2.dto.schedule.ScheduleResponseDto;
import com.example.scheduler2.entity.Schedule;
import com.example.scheduler2.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;


    //일정 생성
    public ScheduleResponseDto saveSchedule(String title, String contents) {

        Schedule schedule = new Schedule(title, contents);

        Schedule savedSchedule = scheduleRepository.save(schedule);

        return new ScheduleResponseDto(savedSchedule.getId(), savedSchedule.getTitle(), savedSchedule.getContents());
    }

    //일정 전체 조회
    public List<ScheduleResponseDto> findAll() {

        return scheduleRepository.findAll().stream().map(ScheduleResponseDto::toDto).toList();
    }

    //선택 일정 조회
    public ScheduleResponseDto findById(Long id) {
        Schedule findId = scheduleRepository.findByIdOrElseThrow(id);

        return new ScheduleResponseDto(findId.getId(), findId.getTitle(), findId.getContents());
    }

    //선택 일정 수정
    public ScheduleResponseDto updateSchedule(Long id, String title, String contents) {
        Schedule findId = scheduleRepository.findByIdOrElseThrow(id);

        findId.updateSchedule(title, contents);

        return new ScheduleResponseDto(findId.getId(), findId.getTitle(), findId.getContents());
    }

    //일정 삭제
    public void deleteSchedule(Long id) {
        Schedule findId = scheduleRepository.findByIdOrElseThrow(id);

        scheduleRepository.deleteById(findId.getId());
    }
}
