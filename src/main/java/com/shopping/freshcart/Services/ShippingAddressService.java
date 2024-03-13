package com.shopping.freshcart.Services;

import com.shopping.freshcart.Models.DTOs.ShippingAddressDTO;

import java.util.List;

public interface ShippingAddressService {
    List<ShippingAddressDTO> getAllShippingAddresses();
    ShippingAddressDTO getShippingAddressById(Long id);
    ShippingAddressDTO createShippingAddress(ShippingAddressDTO shippingAddressDTO);
    ShippingAddressDTO updateShippingAddress(Long id, ShippingAddressDTO shippingAddressDTO);
    void deleteShippingAddress(Long id);
}