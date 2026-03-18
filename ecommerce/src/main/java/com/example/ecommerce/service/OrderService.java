package com.example.ecommerce.service;

import com.example.ecommerce.dto.OrderRequestDTO;
import com.example.ecommerce.entity.OrderEntity;
import com.example.ecommerce.entity.OrderItemEntity;
import com.example.ecommerce.repository.OrderRepository;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    // Criar um novo pedido
    public OrderEntity createOrder(OrderRequestDTO orderRequestDTO) {
        OrderEntity order = new OrderEntity();
        order.setMoment(orderRequestDTO.getMoment());
        order.setStatus(orderRequestDTO.getStatus());
        order.setClient(orderRequestDTO.getClient());

        // Configurar itens do pedido
        if (orderRequestDTO.getItems() != null) {
            orderRequestDTO.getItems().forEach(item -> item.setOrder(order));
            order.setItems(orderRequestDTO.getItems());
        }

        return orderRepository.save(order);
    }

    // Buscar todos os pedidos
    public List<OrderEntity> getAllOrders() {
        return orderRepository.findAll();
    }

    // Buscar pedido por ID
    public Optional<OrderEntity> getOrderById(Long id) {
        return orderRepository.findById(id);
    }

    // Atualizar um pedido existente
    public OrderEntity updateOrder(Long id, OrderRequestDTO orderRequestDTO) {
        OrderEntity order = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado com ID: " + id));

        order.setMoment(orderRequestDTO.getMoment());
        order.setStatus(orderRequestDTO.getStatus());
        order.setClient(orderRequestDTO.getClient());

        // Atualizar itens do pedido
        order.getItems().clear(); // remove itens antigos
        if (orderRequestDTO.getItems() != null) {
            orderRequestDTO.getItems().forEach(item -> item.setOrder(order));
            order.getItems().addAll(orderRequestDTO.getItems());
        }

        return orderRepository.save(order);
    }

    // Deletar pedido
    public void deleteOrder(Long id) {
        if (!orderRepository.existsById(id)) {
            throw new RuntimeException("Pedido não encontrado com ID: " + id);
        }
        orderRepository.deleteById(id);
    }
}