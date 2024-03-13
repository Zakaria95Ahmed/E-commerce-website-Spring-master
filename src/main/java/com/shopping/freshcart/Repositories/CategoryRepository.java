package com.shopping.freshcart.Repositories;

import com.shopping.freshcart.Models.Entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    // Custom query methods if needed
}
