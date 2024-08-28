package com.sparta.schedule.dto.comment.response;

import com.sparta.schedule.entity.Comment;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CommentUpdateResponseDto {
    private final Long id;
    private final String comment;
    private final String username;

    public static CommentUpdateResponseDto entityToDto(Comment comment) {
        return new CommentUpdateResponseDto(comment.getId(), comment.getComment(), comment.getUsername());
    }
}
