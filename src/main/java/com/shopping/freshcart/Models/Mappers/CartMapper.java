package com.shopping.freshcart.Models.Mappers;

import com.shopping.freshcart.Models.DTOs.CartDTO;
import com.shopping.freshcart.Models.Entity.Cart;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import java.util.List;


@Mapper(componentModel = "spring", uses = {UserMapper.class, CartItemMapper.class})
public interface CartMapper {
    CartDTO toDTO(Cart cart);
    Cart toEntity(CartDTO cartDTO);
    List<CartDTO> toDTOList(List<Cart> carts);
    List<Cart> toEntityList(List<CartDTO> cartDTOs);

    void updateCartFromDTO(CartDTO cartDTO, @MappingTarget Cart cart);
}