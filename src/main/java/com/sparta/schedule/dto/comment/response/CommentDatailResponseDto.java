package com.sparta.schedule.dto.comment.response;

import com.sparta.schedule.entity.Comment;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class CommentDatailResponseDto {
    private final Long id;
    private final String username;
    private final String comment;
    private final LocalDateTime createdDate;
    private final LocalDateTime updatedDate;

    public static CommentDatailResponseDto entityToDto(Comment comment) {
        return new CommentDatailResponseDto(
                comment.getId(),
                comment.getUsername(),
                comment.getComment(),
                comment.getCreatedDate(),
                comment.getUpdatedDate()
        );
    }
}
