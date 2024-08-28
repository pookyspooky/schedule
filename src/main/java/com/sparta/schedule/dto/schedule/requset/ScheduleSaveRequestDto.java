package com.sparta.schedule.dto.schedule.requset;

import lombok.Getter;

@Getter
public class ScheduleSaveRequestDto {
    private Long userId;
    private String title;
    private String content;
}
