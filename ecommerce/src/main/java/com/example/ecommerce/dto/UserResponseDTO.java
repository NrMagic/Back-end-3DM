package com.example.ecommerce.dto;

import com.example.ecommerce.enums.RoleEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponseDTO {

    private String name;
    private String email;
    private String phone;
    private RoleEnum roles;

    public UserResponseDTO(String name, String email, String phone, RoleEnum roles) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.roles = roles;
    }
}