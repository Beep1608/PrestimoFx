package org.example.buy_jewelry;

import java.util.HashMap;
import java.util.function.Consumer;

import org.example.buy_caratages_percentages.BuyCaratagePercentagesController;
import org.example.buy_caratages_percentages.BuyCaratagePercentagesModel;
import org.example.buy_percentages.BuyPercentagesController;
import org.example.buy_percentages.BuyPercentagesModel;
import org.example.constants.ConstantsController;
import org.example.constants.ConstantsModel;
import org.example.jewelry.JewelryController;
import org.example.jewelry.JewelryModel;
import org.example.metal_prices.MetalPricesController;
import org.example.metal_prices.MetalPricesModel;
import org.hibernate.Session;

import javafx.scene.layout.Region;

public class BuyJewelryController {
    
   
    private final BuyJewelryModel model;
    private final BuyJewelryInteractor interactor;
    private final BuyJewelryView view;
    private final  HashMap<String, Consumer<Void>> actions = new HashMap<>();

    //Controllers Required
    private final JewelryController jewelryController;
    private final BuyPercentagesController buyPercentagesController;
    private final BuyCaratagePercentagesController buyCaratagePercentagesController;
    private final MetalPricesController metalPricesController;
    private final ConstantsController constantsController;


    public BuyJewelryController(
        JewelryController jewelryController, 
        BuyPercentagesController buyPercentagesController,
        BuyCaratagePercentagesController buyCaratagePercentagesController,
        MetalPricesController metalPricesController,
        ConstantsController constantsController,
        Session session
    ) 
    {
        this.model = new BuyJewelryModel();
        this.interactor = new BuyJewelryInteractor(model, session);
     
        this.jewelryController = jewelryController;
        this.buyPercentagesController = buyPercentagesController;
        this.buyCaratagePercentagesController = buyCaratagePercentagesController;
        this.metalPricesController = metalPricesController;
        this.constantsController = constantsController;

        
        actions.put("store", this::store);

        this.view = new BuyJewelryView(
            model,
            jewelryController.getView(), 
            buyPercentagesController.getView(),
            buyCaratagePercentagesController.getView(),
            actions
        );

    }

    public Region getView() {
        return view.build();
    }

    //TODO: implementar logica de guardado
    private void store(Void unsed) {
      
        jewelryController.store(null);
        JewelryModel jewelryModel = jewelryController.getModel();

        buyCaratagePercentagesController.getLast();
        BuyCaratagePercentagesModel buyCaratagePercentagesModel = buyCaratagePercentagesController.getModel();

        buyPercentagesController.getLast();
        BuyPercentagesModel buyPercentagesModel = buyPercentagesController.getModel();
        
        metalPricesController.getLast();
        MetalPricesModel metalPricesModel = metalPricesController.getModel();

        constantsController.getLast();
        ConstantsModel constantsModel = constantsController.getModel();

        // Task<Void> task = new Task<Void>() {
        //     @Override
        //     protected Void call() throws Exception {

        //         interactor.store();
                
        //         return null;
        //     }
        // };

        // task.setOnSucceeded(evt -> {
        //     System.out.println("Compra registrada exitosamente.");
        // });

        // Thread saveThread = new Thread(task);
        // saveThread.start();

        

    }

}
