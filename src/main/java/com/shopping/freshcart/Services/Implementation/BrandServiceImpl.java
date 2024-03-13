package com.shopping.freshcart.Services.Implementation;

import com.shopping.freshcart.Models.DTOs.BrandDTO;
import com.shopping.freshcart.Models.Entity.Brand;
import com.shopping.freshcart.Models.Mappers.BrandMapper;
import com.shopping.freshcart.Repositories.BrandRepository;
import com.shopping.freshcart.Services.BrandService;
import org.springframework.stereotype.Service;
import jakarta.persistence.EntityNotFoundException;

import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {
    private final BrandRepository brandRepository;
    private final BrandMapper brandMapper;

    public BrandServiceImpl(BrandRepository brandRepository, BrandMapper brandMapper) {
        this.brandRepository = brandRepository;
        this.brandMapper = brandMapper;
    }

    @Override
    public List<BrandDTO> getAllBrands() {
        List<Brand> brands = brandRepository.findAll();
        return brandMapper.toDTOList(brands);
    }

    @Override
    public BrandDTO getBrandById(Long id) {
        Brand brand = brandRepository.findById(id)
                .orElseThrow(() ->  new EntityNotFoundException("Brand not found with id: " + id));
        return brandMapper.toDTO(brand);
    }

    @Override
    public BrandDTO createBrand(BrandDTO brandDTO) {
        Brand brand = brandMapper.toEntity(brandDTO);
        Brand savedBrand = brandRepository.save(brand);
        return brandMapper.toDTO(savedBrand);
    }

    @Override
    public BrandDTO updateBrand(Long id, BrandDTO brandDTO) {
        Brand existingBrand = brandRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Brand not found with id: " + id));
        brandMapper.updateEntityFromDTO(brandDTO, existingBrand);
        Brand updatedBrand = brandRepository.save(existingBrand);
        return brandMapper.toDTO(updatedBrand);
    }

    @Override
    public void deleteBrand(Long id) {
        Brand brand = brandRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Brand not found with id: " + id));
        brandRepository.delete(brand);
    }
}
