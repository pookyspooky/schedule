package com.sparta.schedule.controller;

import com.sparta.schedule.dto.comment.requset.CommentSaveRequsetDto;
import com.sparta.schedule.dto.comment.requset.CommentUpdateRequsetDto;
import com.sparta.schedule.dto.comment.response.CommentDatailResponseDto;
import com.sparta.schedule.dto.comment.response.CommentSaveResponseDto;
import com.sparta.schedule.dto.comment.response.CommentSimpleResponseDto;
import com.sparta.schedule.dto.comment.response.CommentUpdateResponseDto;
import com.sparta.schedule.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    // 댓글 저장
    @PostMapping("/schedules/{scheduleId}/comments")
    public ResponseEntity<CommentSaveResponseDto> saveComment(@PathVariable Long scheduleId, @RequestBody CommentSaveRequsetDto requsetDto) {
        return ResponseEntity.ok(commentService.saveComment(scheduleId, requsetDto));
    }

    // 댓글 전체 조회
    @GetMapping("/comments")
    public ResponseEntity<List<CommentSimpleResponseDto>> getComments() {
        return ResponseEntity.ok(commentService.getComments());
    }

    // 댓글 단건조회
    @GetMapping("/comments/{commentId}")
    public ResponseEntity<CommentDatailResponseDto> getComment(@PathVariable Long commentId) {
        return ResponseEntity.ok(commentService.getComment(commentId));
    }

    // 댓글 수정
    @PutMapping("/comments/{commentId}")
    public ResponseEntity<CommentUpdateResponseDto> updateComment(@PathVariable Long commentId, @RequestBody CommentUpdateRequsetDto requsetDto) {
        return ResponseEntity.ok(commentService.updateComment(commentId, requsetDto));
    }

    // 댓글 삭제
    @DeleteMapping("/comments/{commentId}")
    public void deleteComment(@PathVariable Long commentId) {
        commentService.deleteComment(commentId);
    }
}
