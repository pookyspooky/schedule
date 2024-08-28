package com.sparta.schedule.dto.user.response;

import com.sparta.schedule.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class UserDatailResponseDto {
    private final Long id;
    private final String userName;
    private final String email;
    private final LocalDateTime createdDate;
    private final LocalDateTime updatedDate;

    public UserDatailResponseDto(User user) {
        this.id = user.getId();
        this.userName = user.getUsername();
        this.email = user.getEmail();
        this.createdDate = user.getCreatedDate();
        this.updatedDate = user.getUpdatedDate();
    }

    public static UserDatailResponseDto entityToDto(User user) {
        return new UserDatailResponseDto(
                user.getId(), user.getUsername(), user.getEmail(), user.getCreatedDate(), user.getUpdatedDate()
        );
    }


}
