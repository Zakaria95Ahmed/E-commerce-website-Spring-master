package com.shopping.freshcart.Repositories;

import com.shopping.freshcart.Models.Entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    // Custom query methods if needed
}