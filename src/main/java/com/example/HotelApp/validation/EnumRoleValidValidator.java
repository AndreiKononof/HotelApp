package com.example.HotelApp.validation;

import com.example.HotelApp.model.enums.Role;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class EnumRoleValidValidator implements ConstraintValidator<EnumRoleValid, Role> {


    @Override
    public boolean isValid(Role role, ConstraintValidatorContext constraintValidatorContext) {
        if(role.name().equals(Role.USER) || role.name().equals( Role.ADMINISTRATOR)) return true;
        return false;
    }
}
