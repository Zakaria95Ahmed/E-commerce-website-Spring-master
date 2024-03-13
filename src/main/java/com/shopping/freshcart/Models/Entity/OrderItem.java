package com.shopping.freshcart.Models.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "order_item ")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Product product;
    private Integer quantity;
    private Double price;
    @ManyToOne
    private Order order;


}
