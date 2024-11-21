package com.example.HotelApp.dto.utilDtoClass;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class BookingHotelRequest {
    @NotNull(message = "ID Отеля должен быть заполнен!")
    @Positive(message = "ID отеля не может быть меньше или равен 0!")
    private Long hotelId;
}
