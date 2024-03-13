package com.shopping.freshcart.Services.Implementation;

import com.shopping.freshcart.Models.DTOs.SubcategoryDTO;
import com.shopping.freshcart.Models.Entity.SubCategory;
import com.shopping.freshcart.Models.Mappers.SubCategoryMapper;
import com.shopping.freshcart.Repositories.SubCategoryRepository;
import com.shopping.freshcart.Services.SubCategoryService;
import org.springframework.stereotype.Service;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class SubCategoryServiceImpl implements SubCategoryService {
    private final SubCategoryRepository subcategoryRepository;
    private final SubCategoryMapper subcategoryMapper;

    public SubCategoryServiceImpl(SubCategoryRepository subcategoryRepository, SubCategoryMapper subcategoryMapper) {
        this.subcategoryRepository = subcategoryRepository;
        this.subcategoryMapper = subcategoryMapper;
    }

    @Override
    public List<SubcategoryDTO> getAllSubcategories() {
        List<SubCategory> subcategories = subcategoryRepository.findAll();
        return subcategoryMapper.toDTOList(subcategories);
    }

    @Override
    public SubcategoryDTO getSubcategoryById(Long id) {
        SubCategory subcategory = subcategoryRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Not-found SubCategory id : " + id));
        return subcategoryMapper.toDTO(subcategory);
    }

    @Override
    public SubcategoryDTO createSubcategory(SubcategoryDTO subcategoryDTO) {
        SubCategory subcategory = subcategoryMapper.toEntity(subcategoryDTO);
        SubCategory savedSubcategory = subcategoryRepository.save(subcategory);
        return subcategoryMapper.toDTO(savedSubcategory);
    }

    @Override
    public SubcategoryDTO updateSubcategory(Long id, SubcategoryDTO subcategoryDTO) {
        SubCategory existingSubcategory = subcategoryRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Not-found SubCategory id : "+ id));
        subcategoryMapper.updateEntityFromDTO(subcategoryDTO, existingSubcategory);
        SubCategory updatedSubcategory = subcategoryRepository.save(existingSubcategory);
        return subcategoryMapper.toDTO(updatedSubcategory);
    }

    @Override
    public void deleteSubcategory(Long id) {
        SubCategory subcategory = subcategoryRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Not-found SubCategory id: "+ id));
        subcategoryRepository.delete(subcategory);
    }
}

