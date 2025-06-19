package org.example.buy_jewelry;

import java.util.HashMap;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

import org.example.view.FormView;
import org.example.view.TableView;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;

public class BuyJewelryViewTable extends TableView {
    private final BuyJewelryModel model;
    private final HashMap<String, Function<Object, Object>> actions;

    public BuyJewelryViewTable( 
        BuyJewelryModel model,
        HashMap<String, Function<Object, Object>> actions
    ) 
    {
        super();
        this.model = model;
        this.actions = actions;
        List<BuyJewelryObject> lista = (List<BuyJewelryObject> ) actions.get("index").apply(null);
        BuyJewelryObject firstElement = lista.get(0);
        System.out.println("Id: "+firstElement.getId());
    }


    
}
