package com.sparta.schedule.controller;

import com.sparta.schedule.dto.user.requset.UserSaveRequestDto;
import com.sparta.schedule.dto.user.requset.UserUpdateRequestDtp;
import com.sparta.schedule.dto.user.response.UesrUpdateResponsDto;
import com.sparta.schedule.dto.user.response.UserDatailResponseDto;
import com.sparta.schedule.dto.user.response.UserSaveResponseDto;
import com.sparta.schedule.dto.user.response.UserSimpleResponseDto;
import com.sparta.schedule.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    // 유저 저장
    @PostMapping("/users")
    public ResponseEntity<UserSaveResponseDto> saveUser (@RequestBody UserSaveRequestDto requsetDto) {
        return ResponseEntity.ok(userService.saveUser(requsetDto));
    }

    // 유저 전체 조회
    @GetMapping("/users")
    public ResponseEntity<List<UserSimpleResponseDto>> getUsers() {
        return ResponseEntity.ok(userService.getUsers());
    }

    // 유저 단건 조회
    @GetMapping("/users/{usersId}")
    public ResponseEntity<UserDatailResponseDto> getUser(@PathVariable Long usersId) {
        return ResponseEntity.ok(userService.getUser(usersId));
    }


    // 유저 수정
    @PutMapping("/users/{usersId}")
    public ResponseEntity<UesrUpdateResponsDto> updateUser(@PathVariable Long usersId, @RequestBody UserUpdateRequestDtp requestDtp) {
        return ResponseEntity.ok(userService.updateUser(usersId, requestDtp));
    }

    // 유저 삭제
    @DeleteMapping("/users/{usersId}")
    public void deleteUser(@PathVariable Long usersId) {userService.deleteUser(usersId);
    }
}

