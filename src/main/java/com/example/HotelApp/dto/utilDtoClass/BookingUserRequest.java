package com.example.HotelApp.dto.utilDtoClass;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class BookingUserRequest {

    @NotBlank(message = "Имя пользователя должено быть заполнено!")
    private String nameUser;
}
