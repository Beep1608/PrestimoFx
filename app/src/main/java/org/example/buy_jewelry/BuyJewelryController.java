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
        actions.put("calculate", this::calculate);
       // actions.put("bindings", this::makeBindings);
       

        this.view = new BuyJewelryView(
            model,
            jewelryController.getView(), 
            buyPercentagesController.getView(),
            buyCaratagePercentagesController.getView(),
            actions
        );
       makeBindings();

    }

    public Region getView() {
        return view.build();
    }

    //TODO: implementar logica de guardado
    private void store(Void unsed) {
      
        jewelryController.store(null); 
        model.jewelry_id().set(
            jewelryController
            .getModel()
            .id()
            .get()
        );  
        interactor.store();   

        //
        //  Task<Void> task = new Task<Void>() {
        //      @Override
        //      protected Void call() throws Exception {

        //          //interactor.store();
        //         // JewelryModel jewelryModel = jewelryController.getModel();
        //         // System.out.println("Jewelry : "+ jewelryModel.metal());

        //         // buyCaratagePercentagesController.getLast();
        //         // BuyCaratagePercentagesModel buyCaratagePercentagesModel = buyCaratagePercentagesController.getModel();
        //         // System.out.println("Buy Caratage : "+ buyCaratagePercentagesModel.toString());

        //         // buyPercentagesController.getLast();
        //         // BuyPercentagesModel buyPercentagesModel = buyPercentagesController.getModel();
        //         // System.out.println("Buy  : "+ buyPercentagesModel.toString());
        //         // metalPricesController.getLast();
        //         // MetalPricesModel metalPricesModel = metalPricesController.getModel();
        //         // System.out.println("MetalPrices  : "+ metalPricesModel.toString());
        //         // constantsController.getLast();
        //         // ConstantsModel constantsModel = constantsController.getModel();
        //         // System.out.println("Constants  : "+ constantsModel.toString());
        //          return null;
        //      }
        //  };

        //  task.setOnSucceeded(evt -> {
        //      System.out.println("Compra registrada exitosamente.");
        //  });

        //  Thread saveThread = new Thread(task);
        //  saveThread.start();

        

    }

    private void calculate(Void unused){

        
        JewelryModel jewelryModel = jewelryController.getModel();
        
        buyCaratagePercentagesController.getLast();
        BuyCaratagePercentagesModel buyCaratagePercentagesModel = buyCaratagePercentagesController.getModel();
        
        buyPercentagesController.getLast();
        BuyPercentagesModel buyPercentagesModel = buyPercentagesController.getModel();
        
        metalPricesController.getLast();
        MetalPricesModel metalPricesModel = metalPricesController.getModel();
        
        constantsController.getLast();
        ConstantsModel constantsModel = constantsController.getModel();


        interactor.calculate(
        model,
        jewelryModel, 
        buyCaratagePercentagesModel, 
        buyPercentagesModel, 
        metalPricesModel, 
        constantsModel);
    }

    private void makeBindings(){
        model.calculate().bind(
            jewelryController.getModel().metal().isEmpty()
            .or(jewelryController.getModel().caratage().isEmpty())
            .or(jewelryController.getModel().image().isEmpty())
            .or(jewelryController.getModel().weight().isEqualTo(0))
            .or(jewelryController.getModel().description().isEmpty())
            .or(buyPercentagesController.getModel().selected().isEqualTo(0))
            .or(buyCaratagePercentagesController.getModel().selected().isEqualTo(0))
            .not() // visible solo si todos los anteriores son falsos
        );

    }

    //TODO: Implementar logica de calculo de compra de joyería

    

}
