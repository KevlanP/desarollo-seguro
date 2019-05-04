package com.utad.desarrollo.seguro.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.utad.desarrollo.seguro.entity.BankAccountEntity;

public interface BankAccountsRepository
        extends JpaRepository<BankAccountEntity, Long> {
    //void deleteByIban( String iban);

    BankAccountEntity findByIban(String iban);
    
    List<BankAccountEntity> findByOwnerUserId(Long userId);

}
