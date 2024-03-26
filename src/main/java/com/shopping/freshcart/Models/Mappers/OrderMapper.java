package com.shopping.freshcart.Models.Mappers;

import com.shopping.freshcart.Models.DTOs.OrderDTO;
import com.shopping.freshcart.Models.Entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import java.util.List;

@Mapper(componentModel = "spring", uses = {UserMapper.class, OrderItemMapper.class})
public interface OrderMapper {


    OrderDTO toDTO(Order order);
    Order toEntity(OrderDTO orderDTO);
    List<OrderDTO> toDTOList(List<Order> orders);
    List<Order> toEntityList(List<OrderDTO> orderDTOs);
    void updateOrderFromDTO(OrderDTO orderDTO, @MappingTarget Order order);




}