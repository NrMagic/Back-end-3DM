package com.example.ecommerce.dto;

import com.example.ecommerce.entity.UserEntity;
import com.example.ecommerce.entity.OrderItemEntity;

import java.time.LocalDate;
import java.util.List;

public class OrderRequestDTO {

    private LocalDate moment;
    private String status;
    private UserEntity client; 
    private List<OrderItemEntity> items; // lista de itens do pedido

    public OrderRequestDTO() {
    }

    public OrderRequestDTO(LocalDate moment, String status, UserEntity client,
            List<OrderItemEntity> items) {
        this.moment = moment;
        this.status = status;
        this.client = client;
        this.items = items;
    }
    public LocalDate getMoment() {
        return moment;
    }
    public void setMoment(LocalDate moment) {
        this.moment = moment;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public UserEntity getClient() {
        return client;
    }
    public void setClient(UserEntity client) {
        this.client = client;
    }
    public List<OrderItemEntity> getItems() {
        return items;
    }
    public void setItems(List<OrderItemEntity> items) {
        this.items = items;
    }

        }