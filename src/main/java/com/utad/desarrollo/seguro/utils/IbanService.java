package com.utad.desarrollo.seguro.utils;

import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class IbanService {

    private Random random = new Random();

    public String randomIban() {

        String iban = "ES";

        for (int i = 0; i < 22; i++) {
            iban = iban + random.nextInt(9);
        }

        return iban;

    }

}
