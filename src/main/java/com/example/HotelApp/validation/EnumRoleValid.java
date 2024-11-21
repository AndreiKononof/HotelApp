package com.example.HotelApp.validation;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = EnumRoleValidValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface EnumRoleValid {

    String message() default "Введеное значение не соответсвует ожидаемому! Доступны - USER, ADMINISTRATOR";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
