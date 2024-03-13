package com.shopping.freshcart.Models.DTOs;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
    private Long id;
    private String title;
    private String description;
    private Double price;
    private Long categoryId;
    private Long brandId;
    private Double priceAfterDiscount;
    private Double ratingsAverage;
    private Integer ratingsQuantity;
    // Other fields if needed
}