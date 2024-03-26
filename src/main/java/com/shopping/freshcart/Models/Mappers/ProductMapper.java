package com.shopping.freshcart.Models.Mappers;

import com.shopping.freshcart.Models.DTOs.ProductDTO;
import com.shopping.freshcart.Models.Entity.Product;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import java.util.List;


@Mapper(componentModel = "spring", uses = {CategoryMapper.class, BrandMapper.class})
public interface ProductMapper {
    ProductDTO toDTO(Product product);
    Product toEntity(ProductDTO productDTO);
    List<ProductDTO> toDTOList(List<Product> products);
    List<Product> toEntityList(List<ProductDTO> productDTOs);
    void updateProductFromDTO(ProductDTO productDTO, @MappingTarget Product product);
}