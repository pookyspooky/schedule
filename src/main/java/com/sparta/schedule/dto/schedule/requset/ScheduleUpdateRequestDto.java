package com.sparta.schedule.dto.schedule.requset;

import lombok.Getter;

@Getter
public class ScheduleUpdateRequestDto {
    private Long userId;
    private String title;
    private String content;
}
