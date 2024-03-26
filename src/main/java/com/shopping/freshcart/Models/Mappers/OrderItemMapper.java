package com.shopping.freshcart.Models.Mappers;

import com.shopping.freshcart.Models.DTOs.OrderItemDTO;
import com.shopping.freshcart.Models.Entity.OrderItem;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import java.util.List;



@Mapper(componentModel = "spring", uses = {ProductMapper.class})
public interface OrderItemMapper {
    OrderItemDTO toDTO(OrderItem orderItem);
    OrderItem toEntity(OrderItemDTO orderItemDTO);
    List<OrderItemDTO> toDTOList(List<OrderItem> orderItems);
    List<OrderItem> toEntityList(List<OrderItemDTO> orderItemDTOs);
    void updateOrderItemFromDTO(OrderItemDTO orderItemDTO, @MappingTarget OrderItem orderItem);
}