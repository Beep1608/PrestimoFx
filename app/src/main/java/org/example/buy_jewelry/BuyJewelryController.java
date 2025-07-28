package org.example.buy_jewelry;

import java.util.HashMap;
import java.util.function.Function;

import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import org.example.buy_caratages_percentages.BuyCaratagePercentagesController;
import org.example.buy_jewelry.dto.BuyJewelryIndex;
import org.example.buy_jewelry.index.BuyJewelryIndexModel;
import org.example.buy_jewelry.index.BuyJewelryIndexView;
import org.example.buy_percentages.BuyPercentagesController;
import org.example.constants.ConstantsController;
import org.example.jewelry.JewelryController;
import org.example.metal_prices.MetalPricesController;
import org.hibernate.Session;

import javafx.scene.layout.Region;

public class BuyJewelryController {
    
   
    private final BuyJewelryModel model;
    private final BuyJewelryInteractor interactor;
    //Main
    private final BuyJewelryView view;

    //Create
    private final BuyJewelryCreateView createView;
    
    //Index
    private final BuyJewelryIndexModel indexModel;
    private final BuyJewelryIndexView indexView;


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
        this.jewelryController = jewelryController;
        this.buyPercentagesController = buyPercentagesController;
        this.buyCaratagePercentagesController = buyCaratagePercentagesController;
        this.metalPricesController = metalPricesController;
        this.constantsController = constantsController;

        this.model = new BuyJewelryModel();

        this.interactor = new BuyJewelryInteractor(model,
                session,
                jewelryController,
                buyCaratagePercentagesController.getModel(),
                buyPercentagesController.getModel(),
                metalPricesController.getModel(),
                constantsController.getModel()
        );
       

        this.createView = new BuyJewelryCreateView(
            model,
            interactor,
            jewelryController.getView(), 
            buyPercentagesController.getView(),
            buyCaratagePercentagesController.getView()
        );

        this.indexModel = new BuyJewelryIndexModel();
        this.indexView = new BuyJewelryIndexView(indexModel, interactor);

        this.view = new BuyJewelryView(model, indexView.build(), createView.build());
       createBindings();
       createListeners();
       createActions();


    }

    public Region getView() {
        return view.build();
    }




    private void createBindings(){
       //model.calculate().bind(
       //    jewelryController.getModel().metal().isEmpty()
       //    .or(jewelryController.getModel().caratage().isEmpty())
       //    .or(jewelryController.getModel().image().isEmpty())
       //    .or(jewelryController.getModel().weight().isEqualTo(0))
       //    .or(jewelryController.getModel().description().isEmpty())
       //    .or(buyPercentagesController.getModel().selected().isEqualTo(0))
       //    .or(buyCaratagePercentagesController.getModel().selected().isEqualTo(0))
       //    .not() // visible solo si todos los anteriores son falsos
       //);
        createView.getCalculateButton().disableProperty().bind(
                jewelryController.getModel().metal().isEmpty()
                .or(jewelryController.getModel().caratage().isEmpty())
                .or(jewelryController.getModel().weight().isEqualTo(0))
                .or(buyPercentagesController.getModel().selected().isEqualTo(0))
                .or(buyCaratagePercentagesController.getModel().selected().isEqualTo(0))
                .not()
        );


        createView.build().visibleProperty().bind(Bindings.or(model.create(),model.edit()));
        indexView.build().visibleProperty().bind(model.index());

    }

    private void createListeners(){
        model.edit().addListener((observable, oldValue, newValue) ->{
            if(newValue){
                model.create().set(false);
                model.index().set(false);
                model.currentAction().set("Editar");
                //BuyJewelryObject buy = interactor.findById(indexModel.selectedItem().get().getId());
                interactor.loadDataToEdit(indexModel.selectedItem().get().getId());

                jewelryController.getModel().id().set(model.jewelry_id().get());
                jewelryController.getModel().edit().set(true);

                buyCaratagePercentagesController.getModel().id().set(model.percentages_caratage_id().get());
                buyCaratagePercentagesController.getModel().selected().set(model.percentage_buy_caratage_applied().get());
                buyCaratagePercentagesController.getModel().edit().set(true);

                buyPercentagesController.getModel().id().set(model.percentages_buy_id().get());
                buyPercentagesController.getModel().selected().set(model.percentage_buy_applied().get());
                buyPercentagesController.getModel().edit().set(true);

                constantsController.getModel().id().set(model.constants_id().get());
                constantsController.getModel().edit().set(true);

                metalPricesController.getModel().id().set(model.metal_price_id().get());
                metalPricesController.getModel().edit().set(true);

                System.out.println("Modelo de porcentaje de compra: "+ buyPercentagesController.getModel().minimum().get());
            }
        });

        model.create().addListener((observable, oldValue, newValue) ->{
            if(newValue){

                model.index().set(false);
                model.edit().set(false);
                model.currentAction().set("Crear");
                jewelryController.getModel().create().set(true);
                constantsController.getModel().create().set(true);
                metalPricesController.getModel().create().set(true);
                buyPercentagesController.getModel().create().set(true);
                buyCaratagePercentagesController.getModel().create().set(true);
            }
        });

        model.index().addListener((observable, oldValue, newValue) ->{
            if(newValue){
                indexModel.items().set(FXCollections.observableArrayList( interactor.index()));
                model.create().set(false);
                model.edit().set(false);

            }
        });

        jewelryController.getModel().metal().addListener((observable, oldValue, newValue) -> {
            if(newValue != null){
                if(!newValue.equals(oldValue)){
                    model.calculate().set(true);
                }
            }else{
                model.calculate().set(true);
            }

        });

        jewelryController.getModel().caratage().addListener((observable, oldValue, newValue) -> {
            if(newValue != null){
                if(!newValue.equals(oldValue)){
                    model.calculate().set(true);
                }
            }else{
                model.calculate().set(true);
            }

        });

        jewelryController.getModel().weight().addListener((observable, oldValue, newValue) -> {
            if(newValue != null){
                if(!newValue.equals(oldValue)){
                    model.calculate().set(true);
                }
            }else{
                model.calculate().set(true);
            }

        });

        buyPercentagesController.getModel().selected().addListener((observable, oldValue, newValue) -> {
            if(newValue != null){
                if(!newValue.equals(oldValue)){
                    model.calculate().set(true);
                }
            }else{
                model.calculate().set(true);
            }
        });

        buyCaratagePercentagesController.getModel().selected().addListener((observable, oldValue, newValue) -> {
            if(newValue != null){
                if(!newValue.equals(oldValue)){
                    model.calculate().set(true);
                }
            }else{
                model.calculate().set(true);
            }
        });
    }



    private void createActions(){
        indexView.getEditButton().setOnAction(evt->{
            model.edit().set(true);
        });

        indexView.getCreateButton().setOnAction(event -> {
            model.create().set(true);
        });
    }




    

}
