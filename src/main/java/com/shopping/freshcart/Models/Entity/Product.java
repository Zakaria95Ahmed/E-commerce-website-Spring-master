package com.shopping.freshcart.Models.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;


@Entity
@Table(name = "products")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String slug;
    private String description;
    private Integer quantity;
    private Double price;
    private String imageCover;
    @ElementCollection
    private List<String> images;
    @ManyToOne
    private Category category;
    @ManyToOne
    private Brand brand;
    @ManyToMany
    private List<SubCategory> subcategories;
    private Double priceAfterDiscount;
    private Double ratingsAverage;
    private Integer ratingsQuantity;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Integer sold;

}
