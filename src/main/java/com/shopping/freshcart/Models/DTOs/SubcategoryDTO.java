package com.shopping.freshcart.Models.DTOs;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SubcategoryDTO {
    private Long id;
    private String name;
    private String slug;
    private Long categoryId;
    // Other fields if needed
}