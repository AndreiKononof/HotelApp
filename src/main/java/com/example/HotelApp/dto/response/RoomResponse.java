package com.example.HotelApp.dto.response;

import lombok.Data;
import lombok.ToString;


@Data
@ToString
public class RoomResponse {

    private String name;

    private String description;

    private Integer number;

    private Double price;

    private Integer maxCountPeople;

    private String hotelName;
}
