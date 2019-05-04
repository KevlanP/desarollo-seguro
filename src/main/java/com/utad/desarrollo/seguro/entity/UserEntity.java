package com.utad.desarrollo.seguro.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_user")
    private Long userId;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "role")
    private String role;

    @OneToMany(mappedBy = "owner", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BankAccountEntity> ownedBankAccounts;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "allowed_bank_accounts", joinColumns = @JoinColumn(name = "id_user"), inverseJoinColumns = @JoinColumn(name = "id_bank_account"))
    private List<BankAccountEntity> allowedAccounts;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(
            Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(
            String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(
            String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(
            String role) {
        this.role = role;
    }

    public List<BankAccountEntity> getOwnedBankAccounts() {
        return ownedBankAccounts;
    }

    public void setOwnedBankAccounts(
            List<BankAccountEntity> ownedBankAccounts) {
        this.ownedBankAccounts = ownedBankAccounts;
    }

    public List<BankAccountEntity> getAllowedAccounts() {
        return allowedAccounts;
    }

    public void setAllowedAccounts(
            List<BankAccountEntity> allowedAccounts) {
        this.allowedAccounts = allowedAccounts;
    }

}
