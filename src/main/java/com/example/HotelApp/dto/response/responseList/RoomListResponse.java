package com.example.HotelApp.dto.response.responseList;

import com.example.HotelApp.dto.response.RoomResponse;
import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Data
@ToString
public class RoomListResponse {

    private List<RoomResponse> roomResponseList = new ArrayList<>();
}
