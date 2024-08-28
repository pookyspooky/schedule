package com.sparta.schedule.dto.user.response;

import com.sparta.schedule.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UesrUpdateResponsDto {
    private final Long id;
    private final String username;
    private final String email;

    public static UesrUpdateResponsDto entityToDto(User user) {
        return new UesrUpdateResponsDto(user.getId(), user.getUsername(), user.getEmail());
    }
}
