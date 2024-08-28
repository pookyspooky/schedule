package com.sparta.schedule.service;

import com.sparta.schedule.dto.user.requset.UserSaveRequestDto;
import com.sparta.schedule.dto.user.requset.UserUpdateRequestDtp;
import com.sparta.schedule.dto.user.response.UesrUpdateResponsDto;
import com.sparta.schedule.dto.user.response.UserDatailResponseDto;
import com.sparta.schedule.dto.user.response.UserSaveResponseDto;
import com.sparta.schedule.dto.user.response.UserSimpleResponseDto;
import com.sparta.schedule.entity.User;
import com.sparta.schedule.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {
    private final UserRepository userRepository;

    // 유저 저장
    @Transactional
    public UserSaveResponseDto saveUser(UserSaveRequestDto requsetDto) {
        User user = new User(requsetDto.getUsername(), requsetDto.getEmail());
        User savedUser = userRepository.save(user);

        return UserSaveResponseDto.entityToDto(savedUser);
    }

    // 유저 전체 조회
    public List<UserSimpleResponseDto> getUsers() {
        List<User> users = userRepository.findAll();
        List<UserSimpleResponseDto> userSimpleResponseDtoList = new ArrayList<>();

        for (User user : users) {
            UserSimpleResponseDto dto = UserSimpleResponseDto.entityToDto(user);
            userSimpleResponseDtoList.add(dto);
        }
        return userSimpleResponseDtoList;
    }

    // 유저 단건 조회
    public UserDatailResponseDto getUser(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new NullPointerException("찾을 수 없습니다."));

        return UserDatailResponseDto.entityToDto(user);
    }

    // 유저 수정
    public UesrUpdateResponsDto updateUser(Long usersId, UserUpdateRequestDtp requestDtp) {
        User user = userRepository.findById(usersId).orElseThrow(() -> new NullPointerException("찾을 수 없습니다."));

        user.update(
                requestDtp.getUsername(),
                requestDtp.getEmail()
        );

        return UesrUpdateResponsDto.entityToDto(user);
    }

    // 유저 삭제
    public void deleteUser(Long usersId) {
        User user = userRepository.findById(usersId).orElseThrow(() -> new NullPointerException("찾을 수 없습니다."));

        userRepository.delete(user);
    }
}
