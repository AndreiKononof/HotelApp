package com.example.HotelApp.dto.request;

import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;


@Data
@ToString
public class HotelListRequest {

    private List<HotelRequest> hotels = new ArrayList<>();
}
