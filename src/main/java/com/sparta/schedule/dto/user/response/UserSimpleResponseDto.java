package com.sparta.schedule.dto.user.response;

import com.sparta.schedule.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class UserSimpleResponseDto {
    private final Long id;
    private final String userName;
    private final String email;
    private final LocalDateTime createdDate;
    private final LocalDateTime updatedDate;

    public static UserSimpleResponseDto entityToDto(User user) {
        return new UserSimpleResponseDto(
                user.getId(), user.getUsername(), user.getEmail(), user.getCreatedDate(), user.getUpdatedDate()
        );
    }
}
