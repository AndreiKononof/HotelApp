package com.example.HotelApp.dto.request;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class HotelRequest {

    @NotNull(message = "Название отеля должно быть заполнено! (name = ?)")
    private String name;

    @NotNull(message = "Город должен быть указан! (town = ?)")
    private String town;

    @NotNull(message = "Адрес отеля дожен быть заполнен! (address = ?)")
    private String address;

    @NotNull(message = "Растояние от центра города должно быть заполнено! (distanceToCenter = ?)")
    @Positive(message = "Растояние от центра города должно быть больше 0!")
    private Double distanceToCenter;

}
