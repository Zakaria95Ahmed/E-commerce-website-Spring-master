package com.shopping.freshcart.Models.Entity;




import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "`orders` ")@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private User user;
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItem> orderItems;
    @OneToOne(cascade = CascadeType.ALL)
    private ShippingAddress shippingAddress;
    private Double totalOrderPrice;
    private Double taxPrice;
    private Double shippingPrice;
    private String paymentMethodType;
    private Boolean isPaid;
    private LocalDateTime paidAt;
    private Boolean isDelivered;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
