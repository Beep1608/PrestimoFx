package org.example.components;

import javafx.scene.control.ComboBox;
public class CustomComboBox extends ComboBox{
    
    public CustomComboBox(){
        super();
        initialize();
    }

    private void initialize(){
     this.getStyleClass().add("custom-combo-box");   
    }
    
}
