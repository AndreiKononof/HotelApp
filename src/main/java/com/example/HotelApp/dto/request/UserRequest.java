package com.example.HotelApp.dto.request;

import com.example.HotelApp.model.enums.Role;
import com.example.HotelApp.validation.EnumRoleValid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.ToString;


@Data
@ToString
public class UserRequest {

    @NotBlank(message = "Имя пользователя должно быть заполнено!")
    private String name;

    @NotBlank(message = "Email должен быть заполнен!")
    @Email(message = "Email заполнен не корректно!")
    private String email;

    @NotBlank(message = "Пароль необходимо заполнить!")
    private String password;

    @EnumRoleValid
    private Role role;
}
