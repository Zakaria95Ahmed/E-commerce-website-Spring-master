package com.shopping.freshcart.Security.UserAccount.Services;

import com.shopping.freshcart.Security.UserAccount.Model.DTO.UserDTO;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface UserService {

    List<UserDTO> getAllUsers();
    UserDTO getUserById(Long id);
    UserDTO createUser(UserDTO userDTO);
    UserDTO updateUser(Long id, UserDTO userDTO);
    void deleteUser(Long id);
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);

    UserDetails loadUserByUsername(String userEmail);
}
