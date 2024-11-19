package com.example.HotelApp.dto.response;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class HotelResponse {

    private Long id;

    private String name;

    private String title;

    private String address;

    private Double distanceToCenter;

    private Double rating;

    private Integer countRating;
}
