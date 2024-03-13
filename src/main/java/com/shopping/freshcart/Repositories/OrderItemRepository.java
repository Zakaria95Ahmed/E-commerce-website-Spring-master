package com.shopping.freshcart.Repositories;

import com.shopping.freshcart.Models.Entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
    // Custom query methods if needed
    List<OrderItem> findByOrderId(Long orderId);

}