package com.utad.desarrollo.seguro.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "bank_account")
public class BankAccountEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_bank_account")
    private Long bankAccountId;

    @Column(name = "iban")
    private String iban;

    @Column(name = "balance")
    private Double balance;
    
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "owner")
    private UserEntity owner;

    public Long getBankAccountId() {
        return bankAccountId;
    }

    public void setBankAccountId(
            Long bankAccountId) {
        this.bankAccountId = bankAccountId;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(
            String iban) {
        this.iban = iban;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(
            Double balance) {
        this.balance = balance;
    }
    
    public UserEntity getOwner() {
        return owner;
    }

    public void setOwner(
            UserEntity owner) {
        this.owner = owner;
    }

}
