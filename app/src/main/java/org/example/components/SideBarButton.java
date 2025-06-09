package org.example.components;

import org.example.utils.IconFactory;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class SideBarButton extends HBox {

    private String buttonName;
    private String iconPath;
    private final double BUTTON_WIDTH = 200.0;
 

    public SideBarButton(String buttonName) {
        this.buttonName = buttonName;
      //  this.iconPath = iconPath;
        this.getStyleClass().add("sidebar-button-container");
        initializeButton();
        this.setAlignment(Pos.CENTER);
    }

    private void initializeButton() {
        Button button = new Button(buttonName);
        button.setPrefWidth(BUTTON_WIDTH);
        button.getStyleClass().add("sidebar-button");
       // IconFactory.createIcon(iconPath, 10,10,this);
        this.getChildren().add(button);
    }

    public String getButtonName() {
        return buttonName;
    }

    public String getIconPath() {
        return iconPath;
    }
    
}
