package com.example.ecommerce.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class OrderItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 🔗 Pedido
    @ManyToOne
    @JoinColumn(name = "order_id")
    private OrderEntity order;

    // 🔗 Produto
    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductEntity product;

    // 📊 Quantidade
    private Integer quantity;
}