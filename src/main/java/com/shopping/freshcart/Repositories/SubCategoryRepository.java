package com.shopping.freshcart.Repositories;

import com.shopping.freshcart.Models.Entity.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubCategoryRepository extends JpaRepository<SubCategory, Long> {
    // Custom query methods if needed
}