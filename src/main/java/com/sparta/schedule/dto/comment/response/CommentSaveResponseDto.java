package com.sparta.schedule.dto.comment.response;

import com.sparta.schedule.entity.Comment;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class CommentSaveResponseDto {
    private final Long id;
    private final String comment;
    private final String username;
    private final LocalDateTime createdDate;
    private final LocalDateTime updatedDate;
    private final Long scheduleId;

    public static CommentSaveResponseDto entityToDto(Comment comment) {
        return new CommentSaveResponseDto(
                comment.getId(),
                comment.getComment(),
                comment.getUsername(),
                comment.getCreatedDate(),
                comment.getUpdatedDate(),
                comment.getSchedule().getId()
        );
    }
}
