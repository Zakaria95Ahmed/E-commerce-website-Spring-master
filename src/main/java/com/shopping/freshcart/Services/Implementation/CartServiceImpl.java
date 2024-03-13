package com.shopping.freshcart.Services.Implementation;

import com.shopping.freshcart.Models.DTOs.CartDTO;
import com.shopping.freshcart.Models.Entity.Cart;
import com.shopping.freshcart.Models.Mappers.CartMapper;
import com.shopping.freshcart.Repositories.CartRepository;
import com.shopping.freshcart.Services.CartService;
import org.springframework.stereotype.Service;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class CartServiceImpl implements CartService {
    private final CartRepository cartRepository;
    private final CartMapper cartMapper;

    public CartServiceImpl(CartRepository cartRepository, CartMapper cartMapper) {
        this.cartRepository = cartRepository;
        this.cartMapper = cartMapper;
    }

    @Override
    public List<CartDTO> getAllCarts() {
        List<Cart> carts = cartRepository.findAll();
        return cartMapper.toDTOList(carts);
    }

    @Override
    public CartDTO getCartById(Long id) {
        Cart cart = cartRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Not-found Cart id: " +id));
        return cartMapper.toDTO(cart);
    }

    @Override
    public CartDTO createCart(CartDTO cartDTO) {
        Cart cart = cartMapper.toEntity(cartDTO);
        Cart savedCart = cartRepository.save(cart);
        return cartMapper.toDTO(savedCart);
    }

    @Override
    public CartDTO updateCart(Long id, CartDTO cartDTO) {
        Cart existingCart = cartRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Not-found Cart id : "+ id));
        cartMapper.updateEntityFromDTO(cartDTO, existingCart);
        Cart updatedCart = cartRepository.save(existingCart);
        return cartMapper.toDTO(updatedCart);
    }

    @Override
    public void deleteCart(Long id) {
        Cart cart = cartRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Not-found Cart id: "+ id));
        cartRepository.delete(cart);
    }
}

