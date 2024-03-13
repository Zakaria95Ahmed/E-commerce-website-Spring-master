package com.shopping.freshcart.Models.DTOs;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BrandDTO {
    private Long id;
    private String name;
    private String slug;
    private String image;
    // Other fields if needed
}
