package com.shopping.freshcart.Security.UserAccount.Services;

import com.shopping.freshcart.Repositories.UserRepository;
import com.shopping.freshcart.Security.Permissions.UserRolesAuthentications;
import com.shopping.freshcart.Security.UserAccount.Model.DTO.UserDTO;
import com.shopping.freshcart.Security.UserAccount.Model.Entity.User;
import com.shopping.freshcart.Security.UserAccount.Model.Entity.UserData;
import com.shopping.freshcart.Security.UserAccount.Model.Mapper.UserMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserDetailsService, UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    ////-------Best-Practice------////
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email)
                .map(user -> {
                    userRepository.save(user);
                    UserData userData = new UserData(user);
                    log.info("The user (" + email + ") found");
                    return userData;
                })
                .orElseThrow(() -> {
                    log.error("No user found by email: " + email);
                    return new UsernameNotFoundException("No user found by email: " + email);
                });
    }

    // Add any additional methods for user-related operations
    public void resetPassword(String email) {
        Optional<User> userOptional = userRepository.findByEmail(email);
        userOptional.ifPresentOrElse(
                user -> {
                    String password = generatePassword();
                    String encryptedPassword = bCryptPasswordEncoder.encode(password);
                    user.setPassword(encryptedPassword);
                    userRepository.save(user);
                    log.info("New user password: " + password);
                },
                () -> {
                    throw new EntityNotFoundException("No user found for email: " + email);
                }
        );
    }

    ////-------Best-Practice------////
    //// ----- Update-Password -----////
    public void changePassword(String email, String newPassword) {
        Optional<User> userOptional = userRepository.findByEmail(email);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            String encryptedPassword = encryptPassword(newPassword);
            user.setPassword(encryptedPassword);
            try {
                userRepository.save(user);
                // Send password changed notification if needed
                // sendPasswordChangedNotification(user.getFirstName(), newPassword, user.getEmail());
            } catch (Exception e) {
                // Handle exception
                log.error("Error updating password for user: " + email, e);
            }
        } else {
            // Handle user not found
            log.error("User not found with email: " + email);
        }
    }

    private String encryptPassword(String password) {
        return bCryptPasswordEncoder.encode(password);
    }


    private UserRolesAuthentications getRoleEnumName(String role) {
        return UserRolesAuthentications.valueOf(role.toUpperCase());
    }

//    private String encodePassword(String password) {
//        return bCryptPasswordEncoder.encode(password);
//    }

    private String generatePassword() {
        return RandomStringUtils.randomAlphanumeric(10);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<User> users = userRepository.findAll();
        return userMapper.toDTOList(users);
    }

    @Override
    public UserDTO getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Not-found User id : " + id));
        return userMapper.toDTO(user);
    }


    public UserDTO createUser(UserDTO userDTO) {
        User user = userMapper.toEntity(userDTO);
        User savedUser = userRepository.save(user);
        return userMapper.toDTO(savedUser);
    }


    public UserDTO updateUser(Long id, UserDTO userDTO) {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Not-found UserId : " + id));
        userMapper.updateUserFromDTO(userDTO, existingUser);
        User updatedUser = userRepository.save(existingUser);
        return userMapper.toDTO(updatedUser);
    }

    @Override
    public void deleteUser(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Not-found Userid : " + id));
        userRepository.delete(user);
    }


}
