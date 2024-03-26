package com.shopping.freshcart.Models.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;


@Table(name = "order_item ")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer quantity;
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    // Constructors, getters, and setters
}