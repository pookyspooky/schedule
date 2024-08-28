package com.sparta.schedule.service;

import com.sparta.schedule.dto.schedule.requset.ScheduleSaveRequestDto;
import com.sparta.schedule.dto.schedule.requset.ScheduleUpdateRequestDto;
import com.sparta.schedule.dto.schedule.response.ScheduleDatailResponseDto;
import com.sparta.schedule.dto.schedule.response.ScheduleSaveResponseDto;
import com.sparta.schedule.dto.schedule.response.ScheduleSimpleResponseDto;
import com.sparta.schedule.dto.schedule.response.ScheduleUpdateResponseDto;
import com.sparta.schedule.dto.user.response.UserDatailResponseDto;
import com.sparta.schedule.entity.Intermediate;
import com.sparta.schedule.entity.Schedule;
import com.sparta.schedule.entity.User;
import com.sparta.schedule.repository.IntermediateRepository;
import com.sparta.schedule.repository.ScheduleRepository;
import com.sparta.schedule.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;
    private final IntermediateRepository intermediateRepository;
    private final UserRepository userRepository;

    // 일정 저장
    @Transactional
    public ScheduleSaveResponseDto saveSchedule(ScheduleSaveRequestDto requestDto) {
        Schedule schedule = new Schedule(requestDto.getUserId(), requestDto.getTitle(), requestDto.getContent());
        Schedule savedSchedule = scheduleRepository.save(schedule);
        User user = userRepository.findById(requestDto.getUserId()).orElseThrow(() -> new IllegalArgumentException("찾을 수 없습니ㅏ."));

        Intermediate intermediate = new Intermediate(savedSchedule, user);
        intermediateRepository.save(intermediate);

        return ScheduleSaveResponseDto.entityToDto(savedSchedule);
    }

    // 일정 전체 조회
    public Page<ScheduleSimpleResponseDto> getSchedules(int page, int size) {
        Pageable pageable = PageRequest.of(page -1, size, Sort.by("updatedDate").descending());
        Page<Schedule> schedulePage = scheduleRepository.findAll(pageable);
        return schedulePage.map(ScheduleSimpleResponseDto::entityToDto);
    }

    // 일정 단건 조회
    public ScheduleDatailResponseDto getSchedule(Long scheduleId) {
        Schedule schedule = scheduleRepository.findById(scheduleId).orElseThrow(() -> new IllegalArgumentException("찾을 수 없습니다."));
        List<Intermediate> intermediates = intermediateRepository.findAllBySchedule(schedule);
        List<User> users = intermediates.stream().map(Intermediate::getUser).toList();
        List<UserDatailResponseDto> responseDto = users.stream().map(UserDatailResponseDto::new).toList();

        return ScheduleDatailResponseDto.entityToDto(schedule,responseDto);
    }

    // 일정 수정
    @Transactional
    public ScheduleUpdateResponseDto updateSchedule(Long scheduleId, ScheduleUpdateRequestDto requestDto) {
        Schedule schedule = scheduleRepository.findById(scheduleId).orElseThrow(() -> new NullPointerException("찾을 수 없습니다."));

        schedule.update(
                requestDto.getUserId(),
                requestDto.getTitle(),
                requestDto.getContent()

        );

        return ScheduleUpdateResponseDto.entityToDto(schedule);
    }

    // 일정 삭제
    @Transactional
    public void deleteSchedule(Long scheduleId) {
        Schedule schedule = scheduleRepository.findById(scheduleId).orElseThrow(() -> new NullPointerException("찾을 수 없습니다."));

        scheduleRepository.delete(schedule);
    }
}
