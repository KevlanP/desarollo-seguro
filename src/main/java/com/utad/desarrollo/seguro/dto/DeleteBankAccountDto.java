package com.utad.desarrollo.seguro.dto;

import javax.validation.constraints.NotBlank;

public class DeleteBankAccountDto {

@NotBlank
    private String iban;


    public String getIban() {
        return iban;
    }

    public void setIban(
            String iban) {
        this.iban = iban;
    }

   

}
 