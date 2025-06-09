package org.example.enums;

public enum CaratagesEnum {
   
    CARATAGE_8("8K"),
    CARATAGE_10("10K"),
    CARATAGE_14("14K"),
    CARATAGE_18("18K"),
    CARATAGE_22("22K"),
    CARATAGE_24("24K");

    private final String value;

    CaratagesEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
    
}
