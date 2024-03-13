package com.shopping.freshcart.Services;

import com.shopping.freshcart.Models.DTOs.SubcategoryDTO;

import java.util.List;

public interface SubCategoryService {
    List<SubcategoryDTO> getAllSubcategories();
    SubcategoryDTO getSubcategoryById(Long id);
    SubcategoryDTO createSubcategory(SubcategoryDTO subcategoryDTO);
    SubcategoryDTO updateSubcategory(Long id, SubcategoryDTO subcategoryDTO);
    void deleteSubcategory(Long id);
}