package com.example.ecommerce.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@Entity
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private LocalDate moment;
    private String status;
//  Anotation pra falar que é uma relação de muitos pra 1
    @ManyToOne
//  define qual coluna será usada como chave estrangeira na tabela
    @JoinColumn(name  = "cliente_id")
    private UserEntity client;

}