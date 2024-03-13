package com.shopping.freshcart.Repositories;

import com.shopping.freshcart.Models.Entity.ShippingAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShippingAddressRepository extends JpaRepository<ShippingAddress, Long> {
    // Custom query methods if needed
}