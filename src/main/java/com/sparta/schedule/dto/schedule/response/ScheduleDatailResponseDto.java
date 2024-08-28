package com.sparta.schedule.dto.schedule.response;

import com.sparta.schedule.dto.user.response.UserDatailResponseDto;
import com.sparta.schedule.entity.Schedule;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@AllArgsConstructor
public class ScheduleDatailResponseDto {
    private final Long id;
    private final Long userId;
    private final String title;
    private final String content;
    private final LocalDateTime createdDate;
    private final LocalDateTime updatedDate;
    List<UserDatailResponseDto> userDatailResponseDtoList;

    public static ScheduleDatailResponseDto entityToDto(Schedule schedule, List<UserDatailResponseDto> userDatailResponseDtoList) {
        return new ScheduleDatailResponseDto(
                schedule.getId(),
                schedule.getUserId(),
                schedule.getTitle(),
                schedule.getContent(),
                schedule.getCreatedDate(),
                schedule.getUpdatedDate(),
                userDatailResponseDtoList
        );
    }
}
