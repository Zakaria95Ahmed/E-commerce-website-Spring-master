package com.shopping.freshcart.Models.Mappers;

import com.shopping.freshcart.Models.DTOs.CategoryDTO;
import com.shopping.freshcart.Models.Entity.Category;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import java.util.List;


@Mapper(componentModel = "spring")
public interface CategoryMapper {
    CategoryDTO toDTO(Category category);
    Category toEntity(CategoryDTO categoryDTO);
    List<CategoryDTO> toDTOList(List<Category> categories);
    List<Category> toEntityList(List<CategoryDTO> categoryDTOs);
    void updateCategoryFromDTO(CategoryDTO categoryDTO, @MappingTarget Category category);
}