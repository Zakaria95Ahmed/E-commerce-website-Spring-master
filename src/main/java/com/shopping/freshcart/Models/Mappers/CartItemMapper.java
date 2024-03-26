package com.shopping.freshcart.Models.Mappers;

import com.shopping.freshcart.Models.DTOs.CartItemDTO;
import com.shopping.freshcart.Models.Entity.CartItem;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;


@Mapper(componentModel = "spring", uses = {ProductMapper.class})
public interface CartItemMapper {
    CartItemDTO toDTO(CartItem cartItem);
    CartItem toEntity(CartItemDTO cartItemDTO);
    List<CartItemDTO> toDTOList(List<CartItem> cartItems);
    List<CartItem> toEntityList(List<CartItemDTO> cartItemDTOs);

//    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
//    void updateEntityFromDTO(CartItemDTO cartItemDTO, @MappingTarget CartItem cartItem);
    void updateCartItemFromDTO(CartItemDTO cartItemDTO, @MappingTarget CartItem cartItem);


}