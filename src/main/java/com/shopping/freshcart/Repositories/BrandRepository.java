package com.shopping.freshcart.Repositories;

import com.shopping.freshcart.Models.Entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Long> {
    // Custom query methods if needed
}
