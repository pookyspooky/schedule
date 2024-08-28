package com.sparta.schedule.controller;

import com.sparta.schedule.dto.schedule.requset.ScheduleSaveRequestDto;
import com.sparta.schedule.dto.schedule.requset.ScheduleUpdateRequestDto;
import com.sparta.schedule.dto.schedule.response.ScheduleDatailResponseDto;
import com.sparta.schedule.dto.schedule.response.ScheduleSaveResponseDto;
import com.sparta.schedule.dto.schedule.response.ScheduleSimpleResponseDto;
import com.sparta.schedule.dto.schedule.response.ScheduleUpdateResponseDto;
import com.sparta.schedule.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;

    // 일정 저장
    @PostMapping("/schedules")
    public ResponseEntity<ScheduleSaveResponseDto> saveSchedule(@RequestBody ScheduleSaveRequestDto requestDto) {
        return ResponseEntity.ok(scheduleService.saveSchedule(requestDto));
    }

    // 일정 전체 조회
    @GetMapping("/schedules")
    public ResponseEntity<Page<ScheduleSimpleResponseDto>> getSchedules(
            @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int size
    ) {
        return ResponseEntity.ok(scheduleService.getSchedules(page, size));
    }

    // 일정 단건 조회
    @GetMapping("/schedules/{scheduleId}")
    public ResponseEntity<ScheduleDatailResponseDto> getSchedule(@PathVariable Long scheduleId) {
        return ResponseEntity.ok(scheduleService.getSchedule(scheduleId));
    }

    // 일정 수정
    @PutMapping("/schedules/{scheduleId}")
    public ResponseEntity<ScheduleUpdateResponseDto> updateSchedule(@PathVariable Long scheduleId, @RequestBody ScheduleUpdateRequestDto requestDto) {
        return ResponseEntity.ok(scheduleService.updateSchedule(scheduleId, requestDto));
    }

    // 일정 삭제
    @DeleteMapping("/schedules/{scheduleId}")
    public void deleteSchedule(@PathVariable Long scheduleId) {
        scheduleService.deleteSchedule(scheduleId);
    }
}
