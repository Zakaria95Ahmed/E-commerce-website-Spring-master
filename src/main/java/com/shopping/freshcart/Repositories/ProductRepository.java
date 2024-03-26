package com.shopping.freshcart.Repositories;

import com.shopping.freshcart.Models.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    // Custom additional query methods if needed
}