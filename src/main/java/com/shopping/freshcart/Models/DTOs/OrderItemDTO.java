package com.shopping.freshcart.Models.DTOs;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemDTO {
    private Long id;
    private Integer quantity;
    private BigDecimal price;
    private Long productId;

    // Constructors, getters, and setters
}