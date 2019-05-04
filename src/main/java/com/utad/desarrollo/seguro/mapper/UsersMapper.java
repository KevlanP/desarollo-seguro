package com.utad.desarrollo.seguro.mapper;

import org.springframework.stereotype.Service;

import com.utad.desarrollo.seguro.dto.UserDto;
import com.utad.desarrollo.seguro.entity.UserEntity;

@Service
public class UsersMapper {

    public UserDto toDto(
            UserEntity userEntity) {

        if (userEntity == null) {
            return null;
        }

        UserDto userDto = new UserDto();

        userDto.setUserId(userEntity.getUserId());
        userDto.setUsername(userEntity.getUsername());
        userDto.setPassword(userEntity.getPassword());
        userDto.setRole(userEntity.getRole());

        return userDto;

    }

}
