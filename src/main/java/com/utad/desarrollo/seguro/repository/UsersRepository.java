package com.utad.desarrollo.seguro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.utad.desarrollo.seguro.entity.UserEntity;

public interface UsersRepository
        extends JpaRepository<UserEntity, Long> {

    UserEntity findByUsername(
            String username);

}
