package org.example.jewelry;

import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.util.Builder;

public class JewelryView implements Builder<Region> {
    
    private final StackPane container;
    private final JewelryModel model;
  
    public JewelryView(JewelryModel model,Region create){

        this.model = model;
        this.container = new StackPane(create);
    }

    @Override
    public Region build() {
        return container; 
    }

    
}
