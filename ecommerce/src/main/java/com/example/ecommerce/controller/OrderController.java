package com.example.ecommerce.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecommerce.dto.OrderRequestDTO;
import com.example.ecommerce.entity.OrderEntity;
import com.example.ecommerce.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService){
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<OrderEntity> createOrder(@RequestBody OrderRequestDTO orderRequestDTO){
        OrderEntity createdOrder = orderService.createOrder(orderRequestDTO);
        return ResponseEntity.ok(createdOrder);
    }
   
}
