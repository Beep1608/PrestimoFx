package org.example.buy_jewelry;

import java.util.HashMap;
import java.util.function.Consumer;

import org.example.jewelry.JewelryView;

import javafx.scene.layout.Region;

public class BuyJewelryController {
    
   
    private final BuyJewelryModel model;
    private final BuyJewelryInteractor interactor;
    private final BuyJewelryView view;
    private final  HashMap<String, Consumer<BuyJewelryModel>> actions = new HashMap<>();

    //Models Required
    private final JewelryView jewelryViews;


    public BuyJewelryController(JewelryView jewelryViews) {
        this.model = new BuyJewelryModel();
        this.interactor = new BuyJewelryInteractor(model);
     
        this.jewelryViews = jewelryViews;

        
        actions.put("store", this::store);

        this.view = new BuyJewelryView(model,jewelryViews.build(), actions);

    }

    public Region getView() {
        return view.build();
    }

    //TODO: implementar logica de guardado
    private void store(BuyJewelryModel model) {
        System.out.println("Miua2");
        jewelryViews.save();

    }

}
