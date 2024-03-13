package com.shopping.freshcart.Models.DTOs;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {
    private Long id;
    private Long userId;
    private Double totalOrderPrice;
    private Double taxPrice;
    private Double shippingPrice;
    private String paymentMethodType;
    private Boolean isPaid;
    private LocalDateTime paidAt;
    private Boolean isDelivered;
    // Other fields if needed
}