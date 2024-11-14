package com.example.scheduler2.dto.schedule;

import lombok.Getter;

@Getter
public class CreateScheduleRequestDto {
    private final String title;
    private final String contents;
    private final Long userId;

    public CreateScheduleRequestDto(String title, String contents, Long userId) {
        this.title = title;
        this.contents = contents;
        this.userId = userId;
    }
}
