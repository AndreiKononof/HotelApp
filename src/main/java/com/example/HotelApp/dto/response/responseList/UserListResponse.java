package com.example.HotelApp.dto.response.responseList;

import com.example.HotelApp.dto.response.UserResponse;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class UserListResponse {

    private List<UserResponse> users = new ArrayList<>();
}
