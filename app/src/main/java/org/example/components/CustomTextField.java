package org.example.components;

import javafx.scene.control.TextField;

public class CustomTextField extends TextField  {
    public CustomTextField() {
        super();
        initialize();
    }

    private void initialize() {
        this.getStyleClass().add("custom-text-field");

    }
    
}
