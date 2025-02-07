package com.picpaysimplificado.picpaysimplificado.dto;

import java.math.BigDecimal;

import com.picpaysimplificado.picpaysimplificado.domain.UserType;

public record UserDto(String firstName, String lastName, String document, BigDecimal balance, String email, String password, UserType userType) {
    
}
