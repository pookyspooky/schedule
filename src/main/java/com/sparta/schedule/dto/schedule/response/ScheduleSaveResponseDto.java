package com.sparta.schedule.dto.schedule.response;

import com.sparta.schedule.entity.Schedule;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class ScheduleSaveResponseDto {
    private final Long id;
    private final Long userId;
    private final String title;
    private final String content;
    private final LocalDateTime createdDate;
    private final LocalDateTime updatedDate;

    public static ScheduleSaveResponseDto entityToDto(Schedule schedule) {
        return new ScheduleSaveResponseDto(
                schedule.getId(),
                schedule.getUserId(),
                schedule.getTitle(),
                schedule.getContent(),
                schedule.getCreatedDate(),
                schedule.getUpdatedDate()
        );
    }
}
