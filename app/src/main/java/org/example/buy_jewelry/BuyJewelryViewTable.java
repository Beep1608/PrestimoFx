package org.example.buy_jewelry;

import java.util.HashMap;
import java.util.function.Consumer;

import org.example.view.FormView;
import org.example.view.TableView;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;

public class BuyJewelryViewTable extends TableView {
    private final BuyJewelryModel model;
    private final HashMap<String, Consumer<Void>> actions;

    public BuyJewelryViewTable( 
        BuyJewelryModel model,
        HashMap<String, Consumer<Void>> actions
    ) 
    {
        super();
        this.model = model;
        this.actions = actions;
    }
    
}
