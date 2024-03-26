package com.shopping.freshcart.Models.DTOs;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CartItemDTO {
    private Long id;
    private Integer quantity;
    private Long productId;

    // Constructors, getters, and setters
}