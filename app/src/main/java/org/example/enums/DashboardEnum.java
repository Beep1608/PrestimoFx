package org.example.enums;

public enum DashboardEnum {

  LEFT_SIDE(230);
  
    private final int value;

    private DashboardEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
