package com.example.HotelApp.mapper.delegate;

import com.example.HotelApp.dto.request.UserRequest;
import com.example.HotelApp.exception.NotFoundException;
import com.example.HotelApp.mapper.UserMapper;
import com.example.HotelApp.model.User;
import com.example.HotelApp.service.interfaces.UserService;
import lombok.RequiredArgsConstructor;

import java.text.MessageFormat;

@RequiredArgsConstructor
public abstract class UserDelegate implements UserMapper {

    private final UserService userService;

    @Override
    public User userRequestToUser(String name, UserRequest userRequest) {
        User user = userService.findByName(name);
        if(user == null){
            throw new NotFoundException(MessageFormat.format("Пользователь с именем {} не найден", name));
        }
        user.setName(userRequest.getName());
        user.setEmail(userRequest.getEmail());
        user.setPassword(userRequest.getPassword());
        user.setRole(userRequest.getRole());
        return user;
    }
}
