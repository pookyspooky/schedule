package com.sparta.schedule.dto.schedule.response;

import com.sparta.schedule.entity.Schedule;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ScheduleUpdateResponseDto {
    private final Long id;
    private final Long userId;
    private final String title;
    private final String content;

    public static ScheduleUpdateResponseDto entityToDto(Schedule schedule) {
        return new ScheduleUpdateResponseDto(schedule.getId(), schedule.getUserId(), schedule.getTitle(), schedule.getContent());
    }
}
