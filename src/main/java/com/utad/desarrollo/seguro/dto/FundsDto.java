package com.utad.desarrollo.seguro.dto;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

public class FundsDto {

    @NotBlank
    private String iban;

    @NotNull
    private Double funds;

    public String getIban() {
        return iban;
    }

    public void setIban(
            String iban) {
        this.iban = iban;
    }

    public Double getFunds() {
        return funds;
    }

    public void setFunds(
            Double funds) {
        this.funds = funds;
    }

}
