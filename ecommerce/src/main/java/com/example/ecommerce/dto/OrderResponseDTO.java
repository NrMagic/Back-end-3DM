package com.example.ecommerce.dto;

import java.time.LocalDate;

import com.example.ecommerce.enums.StatusDoPedido;

public class OrderResponseDTO {

    private Long id; // id do pedido
    private LocalDate moment;
    private StatusDoPedido status;
    private Long clientId;
    private String clientName;
    private Long paymentId;
    private String paymentStatus;

    public OrderResponseDTO() {
    }

    public OrderResponseDTO(Long id, LocalDate moment, StatusDoPedido status,
                            Long clientId, String clientName,
                            Long paymentId, String paymentStatus) {
        this.id = id;
        this.moment = moment;
        this.status = status;
        this.clientId = clientId;
        this.clientName = clientName;
        this.paymentId = paymentId;
        this.paymentStatus = paymentStatus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getMoment() {
        return moment;
    }

    public void setMoment(LocalDate moment) {
        this.moment = moment;
    }

    public StatusDoPedido getStatus() {
        return status;
    }

    public void setStatus(StatusDoPedido status) {
        this.status = status;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public Long getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Long paymentId) {
        this.paymentId = paymentId;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
}