package com.example.ecommerce.dto;

import java.util.UUID;

import com.example.ecommerce.enums.RoleEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponseDTO {

    private UUID id;
    private String name;
    private String email;
    private String phone;
    private RoleEnum roles;

    public UserResponseDTO(UUID id, String name, String email, String phone, RoleEnum roles) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.roles = roles;
    }

    public UserResponseDTO() {
    }
}