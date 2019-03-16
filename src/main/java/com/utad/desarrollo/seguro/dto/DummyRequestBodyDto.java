package com.utad.desarrollo.seguro.dto;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @author Pavel
 *
 */
public class DummyRequestBodyDto {

    /**
     * 
     */
    @NotBlank
    private String attribute1;

    @NotNull
    @Min(0)
    private String attribute2;

    private DummyRequestSubAttribute attribute3;

    @NotEmpty
    private List<@NotBlank String> attribute4;

    
    private List<@Valid DummyRequestBodySubAttribute> attribute5;

    
    public String getAttribute1() {
        return attribute1;
    }

    
    public void setAttribute1(
            String attribute1) {
        this.attribute1 = attribute1;
    }

    
    public String getAttribute2() {
        return attribute2;
    }

    
    public void setAttribute2(
            String attribute2) {
        this.attribute2 = attribute2;
    }

    
    public DummyRequestSubAttribute getAttribute3() {
        return attribute3;
    }

    
    public void setAttribute3(
            DummyRequestSubAttribute attribute3) {
        this.attribute3 = attribute3;
    }

    
    public List<String> getAttribute4() {
        return attribute4;
    }

    
    public void setAttribute4(
            List<String> attribute4) {
        this.attribute4 = attribute4;
    }

    
    public List<DummyRequestBodySubAttribute> getAttribute5() {
        return attribute5;
    }

    
    public void setAttribute5(
            List<DummyRequestBodySubAttribute> attribute5) {
        this.attribute5 = attribute5;
    }

    
   

    
}
