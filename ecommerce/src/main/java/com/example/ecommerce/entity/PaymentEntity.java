package com.example.ecommerce.entity;
import jakarta.persistence.*;

import java.time.Instant;
import java.util.UUID;

@Entity
public class PaymentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    // Suprime Alerta em caso de MOMENT não seja utilizado
    @SuppressWarnings("unused")
    private Instant moment;

    @OneToOne
    @JoinColumn(name="order_id")
    private OrderEntity order;
}
