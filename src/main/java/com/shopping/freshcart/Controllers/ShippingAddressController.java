package com.shopping.freshcart.Controllers;

import com.shopping.freshcart.Models.DTOs.ShippingAddressDTO;
import com.shopping.freshcart.Services.ShippingAddressService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/shipping-addresses")
public class ShippingAddressController {
    private final ShippingAddressService shippingAddressService;

    public ShippingAddressController(ShippingAddressService shippingAddressService) {
        this.shippingAddressService = shippingAddressService;
    }

    @GetMapping
    public ResponseEntity<List<ShippingAddressDTO>> getAllShippingAddresses() {
        List<ShippingAddressDTO> shippingAddresses = shippingAddressService.getAllShippingAddresses();
        return ResponseEntity.ok(shippingAddresses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ShippingAddressDTO> getShippingAddressById(@PathVariable Long id) {
        ShippingAddressDTO shippingAddress = shippingAddressService.getShippingAddressById(id);
        return ResponseEntity.ok(shippingAddress);
    }

    @PostMapping
    public ResponseEntity<ShippingAddressDTO> createShippingAddress(@RequestBody ShippingAddressDTO shippingAddressDTO) {
        ShippingAddressDTO createdShippingAddress = shippingAddressService.createShippingAddress(shippingAddressDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdShippingAddress);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ShippingAddressDTO> updateShippingAddress(@PathVariable Long id, @RequestBody ShippingAddressDTO shippingAddressDTO) {
        ShippingAddressDTO updatedShippingAddress = shippingAddressService.updateShippingAddress(id, shippingAddressDTO);
        return ResponseEntity.ok(updatedShippingAddress);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteShippingAddress(@PathVariable Long id) {
        shippingAddressService.deleteShippingAddress(id);
        return ResponseEntity.noContent().build();
    }
}
