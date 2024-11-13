package com.example.scheduler2.dto.schedule;

import lombok.Getter;

@Getter
public class CreateScheduleRequestDto {
    private final String title;
    private final String contents;

    public CreateScheduleRequestDto(String userName,  String title, String contents) {
        this.title = title;
        this.contents = contents;
    }
}
