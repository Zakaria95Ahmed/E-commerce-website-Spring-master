package com.shopping.freshcart.Repositories;

import com.shopping.freshcart.Models.Entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
    // Custom query methods if needed
}