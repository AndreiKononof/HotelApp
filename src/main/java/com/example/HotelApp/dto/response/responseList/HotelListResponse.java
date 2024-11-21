package com.example.HotelApp.dto.response.responseList;

import com.example.HotelApp.dto.response.HotelResponse;
import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Data
@ToString
public class HotelListResponse {

    private List<HotelResponse> hotels = new ArrayList<>();
}
