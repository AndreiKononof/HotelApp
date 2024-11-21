package com.example.HotelApp.dto.request;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class BookingRequest {

    @NotNull(message = "Дата вьезда должна быть заполнена!")
    private LocalDate dateEntry;

    @NotNull(message = "Дата выезда должна быть заполнена!")
    private LocalDate dateExit;

    @Positive(message = "ID комнаты не может быть меньше или равен 0!")
    private Long roomId;

    @Positive(message = "ID комнаты не может быть меньше или равен 0!")
    private Long userId;
}
