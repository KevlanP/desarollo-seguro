package com.utad.desarrollo.seguro.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

public class DummyRequestBodySubAttribute {

    @Email
    @NotNull
    private String subAttribute1;

    private Long subAttribute2;

    
    public String getSubAttribute1() {
        return subAttribute1;
    }

    
    public void setSubAttribute1(
            String subAttribute1) {
        this.subAttribute1 = subAttribute1;
    }

    
    public Long getSubAttribute2() {
        return subAttribute2;
    }

    
    public void setSubAttribute2(
            Long subAttribute2) {
        this.subAttribute2 = subAttribute2;
    }

}
