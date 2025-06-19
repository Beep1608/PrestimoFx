package org.example.buy_jewelry;

import java.util.HashMap;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

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
import org.example.utils.ActionHandler;
import org.hibernate.Session;

import jakarta.persistence.criteria.CriteriaBuilder.In;
import javafx.scene.layout.Region;

public class BuyJewelryController {
    
   
    private final BuyJewelryModel model;
    private final BuyJewelryInteractor interactor;
    private final BuyJewelryView createView;
    
    //Index
    private final BuyJewelryViewTable indexView; 


    private final  HashMap<String, Function<Object, Object>> actions = new HashMap<>();

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
       actions.put("index", this::index);
       

        this.createView = new BuyJewelryView(
            model,
            jewelryController.getView(), 
            buyPercentagesController.getView(),
            buyCaratagePercentagesController.getView(),
            actions
        );

        this.indexView = new BuyJewelryViewTable(model, actions);
       makeBindings();

    }

    public Region getView() {
        return indexView.build();
    }

    //TODO: implementar logica de guardado
    private Object store(Object unsed) {
      
        jewelryController.store(null); 
        model.jewelry_id().set(
            jewelryController
            .getModel()
            .id()
            .get()
        );  
        interactor.store();   
        return null;

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

    private Object calculate(Object unused){

        
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
        return null;
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

    private List<BuyJewelryObject>  index(Object unused){
        return interactor.index();
    }

    //TODO: Implementar logica de calculo de compra de joyería

    

}
