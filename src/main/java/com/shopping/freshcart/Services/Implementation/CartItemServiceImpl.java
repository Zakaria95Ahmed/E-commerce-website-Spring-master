package com.shopping.freshcart.Services.Implementation;

import com.shopping.freshcart.Models.DTOs.CartItemDTO;
import com.shopping.freshcart.Models.Entity.CartItem;
import com.shopping.freshcart.Models.Mappers.CartItemMapper;
import com.shopping.freshcart.Repositories.CartItemRepository;
import com.shopping.freshcart.Services.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import jakarta.persistence.EntityNotFoundException;

import java.util.List;

@SuppressWarnings("FieldCanBeLocal")
@Transactional
@Service
public class CartItemServiceImpl implements CartItemService {
    private final CartItemRepository cartItemRepository;
    private final CartItemMapper cartItemMapper;

    @Autowired
    public CartItemServiceImpl(CartItemRepository cartItemRepository, CartItemMapper cartItemMapper) {
        this.cartItemRepository = cartItemRepository;
        this.cartItemMapper = cartItemMapper;
    }

    @Override
    public List<CartItemDTO> getAllCartItems() {
        List<CartItem> cartItems = cartItemRepository.findAll();
        return cartItemMapper.toDTOList(cartItems);
    }

    @Override
    public CartItemDTO getCartItemById(Long id) {
        CartItem cartItem = cartItemRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Not-found CartItem id: "+ id));
        return cartItemMapper.toDTO(cartItem);
    }

    @Override
    public CartItemDTO createCartItem(CartItemDTO cartItemDTO) {
        CartItem cartItem = cartItemMapper.toEntity(cartItemDTO);
        CartItem savedCartItem = cartItemRepository.save(cartItem);
        return cartItemMapper.toDTO(savedCartItem);
    }

    @Override
    public CartItemDTO updateCartItem(Long id, CartItemDTO cartItemDTO) {
        CartItem existingCartItem = cartItemRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Not-found CartItem id: "+ id));
        cartItemMapper.updateEntityFromDTO(cartItemDTO, existingCartItem);
        CartItem updatedCartItem = cartItemRepository.save(existingCartItem);
        return cartItemMapper.toDTO(updatedCartItem);
    }

    @Override
    public void deleteCartItem(Long id) {
        CartItem cartItem = cartItemRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Not-found CartItem id: " +id));
        cartItemRepository.delete(cartItem);
    }
}

