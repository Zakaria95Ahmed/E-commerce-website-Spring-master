package com.shopping.freshcart.Controllers;


import com.shopping.freshcart.Models.DTOs.SubcategoryDTO;
import com.shopping.freshcart.Services.SubCategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subcategories")
public class SubCategoryController {
    private final SubCategoryService subcategoryService;

    public SubCategoryController(SubCategoryService subcategoryService) {
        this.subcategoryService = subcategoryService;
    }

    @GetMapping
    public ResponseEntity<List<SubcategoryDTO>> getAllSubcategories() {
        List<SubcategoryDTO> subcategories = subcategoryService.getAllSubcategories();
        return ResponseEntity.ok(subcategories);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SubcategoryDTO> getSubcategoryById(@PathVariable Long id) {
        SubcategoryDTO subcategory = subcategoryService.getSubcategoryById(id);
        return ResponseEntity.ok(subcategory);
    }

    @PostMapping
    public ResponseEntity<SubcategoryDTO> createSubcategory(@RequestBody SubcategoryDTO subcategoryDTO) {
        SubcategoryDTO createdSubcategory = subcategoryService.createSubcategory(subcategoryDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdSubcategory);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SubcategoryDTO> updateSubcategory(@PathVariable Long id, @RequestBody SubcategoryDTO subcategoryDTO) {
        SubcategoryDTO updatedSubcategory = subcategoryService.updateSubcategory(id, subcategoryDTO);
        return ResponseEntity.ok(updatedSubcategory);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSubcategory(@PathVariable Long id) {
        subcategoryService.deleteSubcategory(id);
        return ResponseEntity.noContent().build();
    }
}
