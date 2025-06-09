package org.example.enums;

public enum MetalsEnum {
    GOLD("Oro"),
    SILVER("Plata");
   
    private final String value;

    private MetalsEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
