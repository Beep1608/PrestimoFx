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
        //actions.put("calculate", this::calculate);

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
        System.out.println();
        System.out.println("Jewelry : "+ jewelryModel.id());
        System.out.println();
         buyCaratagePercentagesController.getLast();
         BuyCaratagePercentagesModel buyCaratagePercentagesModel = buyCaratagePercentagesController.getModel();
         System.out.println();
        System.out.println("Buy Caratage : "+ buyCaratagePercentagesModel.toString());
        System.out.println();
         buyPercentagesController.getLast();
         BuyPercentagesModel buyPercentagesModel = buyPercentagesController.getModel();
         System.out.println();
         System.out.println("Buy  : "+ buyPercentagesModel.toString());
         System.out.println();
        metalPricesController.getLast();
        MetalPricesModel metalPricesModel = metalPricesController.getModel();
        System.out.println();
        System.out.println("MetalPrices  : "+ metalPricesModel.toString());
        System.out.println();
        constantsController.getLast();
        ConstantsModel constantsModel = constantsController.getModel();
        System.out.println();
        System.out.println("Constants  : "+ constantsModel.toString());
        System.out.println();              
        calculate(jewelryModel, 
        buyCaratagePercentagesModel, 
        buyPercentagesModel, 
        metalPricesModel, 
        constantsModel);
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

    //TODO: Implementar logica de calculo de compra de joyería

    private void calculate(
        JewelryModel jewelryModel,
        BuyCaratagePercentagesModel buyCaratagePercentagesModel,
        BuyPercentagesModel buyPercentagesModel,
        MetalPricesModel metalPricesModel,
        ConstantsModel constantsModel
    )
    {
        /**
         * Paso 1 
         */

         model.price_gr_inter().set(
            metalPricesModel.price_onz()
            .divide(constantsModel.conversion_factor())
            .get()
         );
        
         //---------

        /**
         *  Paso 2
         */

         model.revenue_extern_sale().set(
            model.price_gr_inter()
            .subtract(constantsModel.security_value())
            .get()
        );

         //------------------

         /**
          * Paso 3
          */
        
            model.price_local_gr().set(
                model.revenue_extern_sale()
                .subtract(constantsModel.revenue_gr())
                .get()
            );

          //----------


          /**
           * Paso 4
           */
          model.caratage_price().set(
            model.price_local_gr()
            .divide(24)
            .get()  
          );

           //-------------

        /**
         * Paso 5 
         */
        double caratage = Double.parseDouble( 
            jewelryModel.caratage().get().replace("K", "")
        );
         model.caratage_price_final().set(
            model.caratage_price()
            .multiply(caratage)
            .get()
         );

         model.caratage_price_final_pa().set(
            model.caratage_price_final()
            .multiply(buyCaratagePercentagesModel.selected())
            .get()
         );
        
         //---------

         /**
          * Paso 6
          */
          model.price_gr_final().set(
            model.caratage_price_final_pa()
            .multiply(jewelryModel.weight())
            .get()
          );
          model.max_purchase_amount().set(
            model.price_gr_final()
            .multiply(buyPercentagesModel.selected())
            .get()
          );

        model.percentage_buy_caratage_applied().set(
            buyCaratagePercentagesModel
            .selected()
            .get()
        );
        model.percentage_buy_applied().set(
            buyPercentagesModel
            .selected()
            .get()
        );

        //id's
        model.constants_id().set(constantsModel.id().get());
        model.metal_price_id().set(metalPricesModel.id().get());
        model.percentages_buy_id().set(buyPercentagesModel.id().get());
        model.percentage_buy_caratage_applied().set(buyCaratagePercentagesModel.id().get());
        model.jewelry_id().set(jewelryModel.id().get());


    }

}
