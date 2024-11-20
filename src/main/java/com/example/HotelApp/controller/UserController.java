package com.example.HotelApp.controller;

import com.example.HotelApp.dto.request.UserRequest;
import com.example.HotelApp.dto.response.UserListResponse;
import com.example.HotelApp.dto.response.UserResponse;
import com.example.HotelApp.mapper.UserMapper;
import com.example.HotelApp.model.User;
import com.example.HotelApp.service.interfaces.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
@Slf4j
public class UserController {

    private final UserService userService;

    private final UserMapper userMapper;

    @GetMapping("/{name}")
    public ResponseEntity<UserResponse> getUser(@PathVariable String name){
        log.info("Запрос: Запрошен пользователь с именем {}",name);
        User user = userService.findByName(name);
        return ResponseEntity.status(HttpStatus.OK).body(userMapper.userToUserResponse(user));
    }

    @GetMapping
    public ResponseEntity<UserListResponse> getAllUser(){
        log.info("Запрос: Все пользователи");
        return ResponseEntity.status(HttpStatus.OK).body(
                userMapper.userListToUserListResponse(userService.findAll())
        );
    }


    @PostMapping()
    public ResponseEntity<UserResponse> create(@Valid @RequestBody UserRequest userRequest){
        log.info("Запрос: Создание {}", userRequest);
        User user = userService.create(userMapper.userRequestToUser(userRequest));
        return ResponseEntity.status(HttpStatus.CREATED).body(userMapper.userToUserResponse(user));
    }

    @DeleteMapping("/id")
    public ResponseEntity<Void> delete(Long id){
        log.info("Запрос: удаление пользователя с ID - {}",id);
        userService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}
