package com.example.HotelApp.dto.response;


import com.example.HotelApp.model.enums.Role;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class UserResponse {

    private String name;

    private String email;

    private Role role;
}
