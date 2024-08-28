package com.sparta.schedule.service;

import com.sparta.schedule.dto.comment.requset.CommentSaveRequestDto;
import com.sparta.schedule.dto.comment.requset.CommentUpdateRequestDto;
import com.sparta.schedule.dto.comment.response.CommentDatailResponseDto;
import com.sparta.schedule.dto.comment.response.CommentSaveResponseDto;
import com.sparta.schedule.dto.comment.response.CommentSimpleResponseDto;
import com.sparta.schedule.dto.comment.response.CommentUpdateResponseDto;
import com.sparta.schedule.entity.Comment;
import com.sparta.schedule.entity.Schedule;
import com.sparta.schedule.repository.CommentRepository;
import com.sparta.schedule.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CommentService {

    private final CommentRepository commentRepository;
    private final ScheduleRepository scheduleRepository;

    // 댓글 저장
    @Transactional
    public CommentSaveResponseDto saveComment(Long scheduleId, CommentSaveRequestDto requestDto) {
        Schedule schedule = scheduleRepository.findById(scheduleId).orElseThrow(() -> new NullPointerException("찾을 수 없습니다."));
        Comment comment = new Comment(requestDto.getComment(), requestDto.getUsername(), schedule);
        Comment savedComment = commentRepository.save(comment);

        return CommentSaveResponseDto.entityToDto(savedComment);
    }

    // 댓글 전체 조회
    public List<CommentSimpleResponseDto> getComments() {
        List<Comment> comments = commentRepository.findAll();
        List<CommentSimpleResponseDto> commentSimpleResponseDtoList = new ArrayList<>();

        for (Comment comment : comments) {
            CommentSimpleResponseDto dto = CommentSimpleResponseDto.entityToDto(comment);
            commentSimpleResponseDtoList.add(dto);
        }
        return commentSimpleResponseDtoList;
    }

    // 댓글 단건 조회
    public CommentDatailResponseDto getComment(Long commentId) {
        Comment comment = commentRepository.findById(commentId).orElseThrow(() -> new NullPointerException("찾을 수 없습니다."));

        return CommentDatailResponseDto.entityToDto(comment);
    }

    // 댓글 수정
    @Transactional
    public CommentUpdateResponseDto updateComment(Long commentId, CommentUpdateRequestDto requestDto) {
        Comment comment = commentRepository.findById(commentId).orElseThrow(()-> new NullPointerException("찾을 수 없습니다."));

        comment.update(
                requestDto.getComment(),
                requestDto.getUsername()
        );
        return CommentUpdateResponseDto.entityToDto(comment);
    }

    // 댓글 삭제
    @Transactional
    public void deleteComment(Long commentId) {
        Comment comment = commentRepository.findById(commentId).orElseThrow(() -> new NullPointerException("찾을 수 없습니다."));

        commentRepository.delete(comment);
    }
}
