package com.example.HotelApp.dto.request;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class HotelRequest {

    @NotBlank(message = "Название отеля должно быть заполнено!")
    private String name;

    @NotBlank(message = "Город должен быть указан!")
    private String town;

    @NotBlank(message = "Адрес отеля дожен быть заполнен!")
    private String address;

    @NotBlank(message = "Растояние от центра города должно быть заполнено!")
    @Positive(message = "Растояние от центра города должно быть больше 0!")
    private Double distanceToCenter;

}
