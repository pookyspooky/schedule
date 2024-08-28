package com.sparta.schedule.dto.schedule.response;

import com.sparta.schedule.entity.Schedule;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class ScheduleSimpleResponseDto {
    private final Long id;
    private final String name;
    private final String title;
    private final String content;
    private final LocalDateTime createDate;
    private final LocalDateTime updateDate;
    private final int comment;

    public static ScheduleSimpleResponseDto entityToDto (Schedule schedule) {
        return new ScheduleSimpleResponseDto(
                schedule.getId(),
                schedule.getName(),
                schedule.getTitle(),
                schedule.getContent(),
                schedule.getCreatedDate(),
                schedule.getUpdatedDate(),
                schedule.getCommentList().size()
        );
    }
}
