package com.utad.desarrollo.seguro.dto;

public class BankAccountDto {

    private String iban;

    private Double balance;

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

}
