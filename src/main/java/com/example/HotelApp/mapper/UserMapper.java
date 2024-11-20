package com.example.HotelApp.mapper;


import com.example.HotelApp.dto.request.UserRequest;
import com.example.HotelApp.dto.response.UserListResponse;
import com.example.HotelApp.dto.response.UserResponse;
import com.example.HotelApp.mapper.delegate.UserDelegate;
import com.example.HotelApp.model.User;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@DecoratedWith(UserDelegate.class)
@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

    User userRequestToUser(UserRequest userRequest);

    User userRequestToUser(String name, UserRequest userRequest);

    UserResponse userToUserResponse(User user);

    List<UserResponse> userListToListResponse(List<User> users);

    default UserListResponse userListToUserListResponse(List<User> users){
        UserListResponse response = new UserListResponse();
        response.setUsers(userListToListResponse(users));
        return response;
    }

}
