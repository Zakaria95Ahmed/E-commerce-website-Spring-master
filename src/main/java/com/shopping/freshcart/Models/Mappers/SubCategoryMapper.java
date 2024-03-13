package com.shopping.freshcart.Models.Mappers;

import com.shopping.freshcart.Models.DTOs.SubcategoryDTO;
import com.shopping.freshcart.Models.Entity.SubCategory;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SubCategoryMapper {
    SubCategoryMapper INSTANCE = Mappers.getMapper(SubCategoryMapper.class);

    SubcategoryDTO toDTO(SubCategory subcategory);
    SubCategory toEntity(SubcategoryDTO subcategoryDTO);

    List<SubcategoryDTO> toDTOList(List<SubCategory> subcategories);
    List<SubCategory> toEntityList(List<SubcategoryDTO> subcategoryDTOs);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntityFromDTO(SubcategoryDTO subcategoryDTO, @MappingTarget SubCategory subcategory);
}