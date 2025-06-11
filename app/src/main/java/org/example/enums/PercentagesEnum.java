package org.example.enums;

public enum PercentagesEnum {
    MINIMUN("Minimo"),
    MEDIUM("Medio"),
    MAXIMUM("Maximo");
   
    private final String value;

    private PercentagesEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    
}
