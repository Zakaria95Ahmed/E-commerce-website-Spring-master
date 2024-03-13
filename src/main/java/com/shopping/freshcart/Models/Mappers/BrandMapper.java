package com.shopping.freshcart.Models.Mappers;

import com.shopping.freshcart.Models.DTOs.BrandDTO;
import com.shopping.freshcart.Models.Entity.Brand;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BrandMapper {
    BrandMapper INSTANCE = Mappers.getMapper(BrandMapper.class);

    BrandDTO toDTO(Brand brand);
    Brand toEntity(BrandDTO brandDTO);

    List<BrandDTO> toDTOList(List<Brand> brands);
    List<Brand> toEntityList(List<BrandDTO> brandDTOs);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntityFromDTO(BrandDTO brandDTO, @MappingTarget Brand brand);
}
