package org.example.components;

import org.example.utils.Responsive;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class CustomLabeledComboBox extends VBox {
    
    private Label label;
    private CustomComboBox combo;

    public CustomLabeledComboBox(String labelText) {
        super();
        this.label = new Label(labelText);
        initialize();
    }

    private void initialize() {
        this.getStyleClass().add("custom-labeled-combo-box");
        combo = new CustomComboBox();
        Responsive.bindingToParentWidth(combo, 1);
        setSpacing(5);
        getChildren().addAll(label,combo);
    }

    public CustomComboBox getCombo() {
        return combo;
    }

    public Label getLabelText() {
        return label;
    }

    public void setLabelText(String labelText) {
        label.setText(labelText); 
    }
    
}
