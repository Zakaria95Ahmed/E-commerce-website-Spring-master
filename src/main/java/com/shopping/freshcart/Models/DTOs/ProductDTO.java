package com.shopping.freshcart.Models.DTOs;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private String image;
    private Long categoryId;
    private Long brandId;

    // Constructors, getters, and setters
}