package com.shopping.freshcart.Services;

import com.shopping.freshcart.Models.DTOs.CartDTO;

import java.util.List;

public interface CartService {
    List<CartDTO> getAllCarts();
    CartDTO getCartById(Long id);
    CartDTO createCart(CartDTO cartDTO);
    CartDTO updateCart(Long id, CartDTO cartDTO);
    void deleteCart(Long id);
}