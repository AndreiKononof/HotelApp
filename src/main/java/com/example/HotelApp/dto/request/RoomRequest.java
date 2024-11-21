package com.example.HotelApp.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class RoomRequest {

    @NotBlank(message = "Наименованеи комнаты должно быть заполнено!")
    private String name;

    @NotBlank(message = "Описание комнаты должно быть заполнено!")
    private String description;

    @NotBlank(message = "Номер комнаты должен быть заполнен!")
    @Positive(message = "Номер комнаты должен быть больше 0!")
    private Integer number;

    @NotBlank(message = "Цена за конмнату должна быть заполнена!")
    @Positive(message = "Цена должна быть больше 0!")
    private Double price;

    @NotBlank(message = "Максимальное количество размещающихся должно быть заполнено!")
    @Positive(message = "Максимальное количество размещающихся должно быть больше 0!")
    private Integer maxCountPeople;

    @NotBlank(message = "ID Отеля необходимо заполнить!")
    private Long hotelId;


}
