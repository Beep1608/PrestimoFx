package org.example.buy_jewelry;

import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.util.Builder;

public class BuyJewelryView implements Builder<Region>{

    private final StackPane container;
    private final BuyJewelryModel model;

    public BuyJewelryView(BuyJewelryModel model,Region index, Region create){
        this.model = model;
        this.container = new StackPane(index,create);
        //container.setMouseTransparent(true);

    }

    @Override
    public Region build() {
       return container;
    }

    
}
