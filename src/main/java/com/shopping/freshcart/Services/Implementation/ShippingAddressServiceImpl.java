package com.shopping.freshcart.Services.Implementation;

import com.shopping.freshcart.Models.DTOs.ShippingAddressDTO;
import com.shopping.freshcart.Models.Entity.ShippingAddress;
import com.shopping.freshcart.Models.Mappers.ShippingAddressMapper;
import com.shopping.freshcart.Repositories.ShippingAddressRepository;
import com.shopping.freshcart.Services.ShippingAddressService;
import org.springframework.stereotype.Service;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class ShippingAddressServiceImpl implements ShippingAddressService {
    private final ShippingAddressRepository shippingAddressRepository;
    private final ShippingAddressMapper shippingAddressMapper;

    public ShippingAddressServiceImpl(ShippingAddressRepository shippingAddressRepository, ShippingAddressMapper shippingAddressMapper) {
        this.shippingAddressRepository = shippingAddressRepository;
        this.shippingAddressMapper = shippingAddressMapper;
    }

    @Override
    public List<ShippingAddressDTO> getAllShippingAddresses() {
        List<ShippingAddress> shippingAddresses = shippingAddressRepository.findAll();
        return shippingAddressMapper.toDTOList(shippingAddresses);
    }

    @Override
    public ShippingAddressDTO getShippingAddressById(Long id) {
        ShippingAddress shippingAddress = shippingAddressRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Not-found Shipping Address with id: " + id));
        return shippingAddressMapper.toDTO(shippingAddress);
    }


    @Override
    public ShippingAddressDTO createShippingAddress(ShippingAddressDTO shippingAddressDTO) {
        ShippingAddress shippingAddress = shippingAddressMapper.toEntity(shippingAddressDTO);
        ShippingAddress savedShippingAddress = shippingAddressRepository.save(shippingAddress);
        return shippingAddressMapper.toDTO(savedShippingAddress);
    }

    @Override
    public ShippingAddressDTO updateShippingAddress(Long id, ShippingAddressDTO shippingAddressDTO) {
        ShippingAddress existingShippingAddress = shippingAddressRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Not-found Shipping Address with id: " + id));
        shippingAddressMapper.updateEntityFromDTO(shippingAddressDTO, existingShippingAddress);
        ShippingAddress updatedShippingAddress = shippingAddressRepository.save(existingShippingAddress);
        return shippingAddressMapper.toDTO(updatedShippingAddress);
    }

    @Override
    public void deleteShippingAddress(Long id) {
        ShippingAddress shippingAddress = shippingAddressRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Not-found Shipping Address with id : " + id));
        shippingAddressRepository.delete(shippingAddress);
    }
}
