package com.example.HotelApp.dto.response.pagination;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

@Data
public class PageInfo {
    @NotNull(message = "Поле размера предоставляемого списка должно быть заполнено!")
    @Positive(message = "Поле размера предоставляемого списка должно быть больше 0!")
    private int size;

    @NotNull(message = "Поле предоставляемой страницы должно быть заполнено!")
    @PositiveOrZero(message = "Поле пердоставляемой страницы должно быть больше или равно 0!")
    private int page;

}
