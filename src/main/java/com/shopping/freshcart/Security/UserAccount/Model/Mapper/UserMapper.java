package com.shopping.freshcart.Security.UserAccount.Model.Mapper;

import com.shopping.freshcart.Security.UserAccount.Model.DTO.UserDTO;
import com.shopping.freshcart.Security.UserAccount.Model.Entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDTO toDTO(User user);
    User toEntity(UserDTO userDTO);
    List<UserDTO> toDTOList(List<User> users);
    List<User> toEntityList(List<UserDTO> userDTOs);
    void updateUserFromDTO(UserDTO userDTO, @MappingTarget User user);

}
