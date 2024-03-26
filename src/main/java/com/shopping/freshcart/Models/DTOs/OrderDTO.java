package com.shopping.freshcart.Models.DTOs;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {
    private Long id;
    private LocalDateTime orderDate;
    private String status;
    private BigDecimal totalAmount;
    private Long userId;
    private List<OrderItemDTO> orderItems;

    // Constructors, getters, and setters
}