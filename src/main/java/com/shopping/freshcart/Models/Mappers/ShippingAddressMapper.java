package com.shopping.freshcart.Models.Mappers;

import com.shopping.freshcart.Models.DTOs.ShippingAddressDTO;
import com.shopping.freshcart.Models.Entity.ShippingAddress;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ShippingAddressMapper {
    ShippingAddressMapper INSTANCE = Mappers.getMapper(ShippingAddressMapper.class);

    ShippingAddressDTO toDTO(ShippingAddress shippingAddress);
    ShippingAddress toEntity(ShippingAddressDTO shippingAddressDTO);

    List<ShippingAddressDTO> toDTOList(List<ShippingAddress> shippingAddresses);
    List<ShippingAddress> toEntityList(List<ShippingAddressDTO> shippingAddressDTOs);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntityFromDTO(ShippingAddressDTO shippingAddressDTO, @MappingTarget ShippingAddress shippingAddress);
}
