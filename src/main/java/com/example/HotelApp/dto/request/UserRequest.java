package com.example.HotelApp.dto.request;

import com.example.HotelApp.model.Role;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.ToString;


@Data
@ToString
public class UserRequest {

    @NotNull(message = "Имя пользователя должно быть заполнено!")
    private String name;

    @NotNull(message = "Email должен быть заполнен!")
    private String email;

    @NotNull(message = "Пароль необходимо заполнить!")
    private String password;


    private Role role;
}
