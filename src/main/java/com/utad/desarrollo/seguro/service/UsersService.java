package com.utad.desarrollo.seguro.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.utad.desarrollo.seguro.dto.*;
import com.utad.desarrollo.seguro.entity.UserEntity;
import com.utad.desarrollo.seguro.mapper.*;
import com.utad.desarrollo.seguro.repository.*;

@Service
@Transactional
public class UsersService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private UsersMapper usersMapper;

    public UserDto getByUsername(
            String username) {
        UserEntity userEntity= usersRepository.findByUsername(username);
        UserDto userDto = usersMapper.toDto(userEntity);
        return userDto;
        
        //return usersMapper.toDto(usersRepository.findByUsername(username));

    }

}
