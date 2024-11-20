package com.example.HotelApp.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class RoomRequest {

    @NotNull(message = "Наименованеи комнаты должно быть заполнено!")
    private String name;

    @NotNull(message = "Описание комнаты должно быть заполнено!")
    private String description;

    @NotNull(message = "Номер комнаты должен быть заполнен!")
    @Positive(message = "Номер комнаты должен быть больше 0!")
    private Integer number;

    @NotNull(message = "Цена за конмнату должна быть заполнена!")
    @Positive(message = "Цена должна быть больше 0!")
    private Double price;

    @NotNull(message = "Максимальное количество размещающихся должно быть заполнено!")
    @Positive(message = "Максимальное количество размещающихся должно быть больше 0!")
    private Integer maxCountPeople;

    @NotNull(message = "ID Отеля необходимо заполнить!")
    private Long hotelId;


}
