package com.example.ecommerce.dto;

import com.example.ecommerce.enums.RoleEnum;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequestDTO {

    @NotBlank(message = "Nome é obrigatório")
    private String name;

    @Email(message = "Email inválido")
    @NotBlank(message = "Email é obrigatório")
    private String email;

    private String phone;

    @NotBlank(message = "Senha é obrigatória")
    private String password;

    private RoleEnum roles;

    public UserRequestDTO(@NotBlank(message = "Nome é obrigatório") String name,
            @Email(message = "Email inválido") @NotBlank(message = "Email é obrigatório") String email, String phone,
            @NotBlank(message = "Senha é obrigatória") String password, RoleEnum roles) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.roles = roles;
    }
    public UserRequestDTO() {   

}
}