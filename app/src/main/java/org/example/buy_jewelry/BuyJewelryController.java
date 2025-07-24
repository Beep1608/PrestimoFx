package org.example.buy_jewelry;

import java.util.HashMap;
import java.util.function.Function;

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

    //Edit
    private final BuyJewelryEditView editView;

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
                jewelryController.getModel(),
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

        this.editView = new BuyJewelryEditView(
            model,
            jewelryController.getView(), 
            buyPercentagesController.getView(),
            buyCaratagePercentagesController.getView(),
            actions
        );

        this.indexModel = new BuyJewelryIndexModel();
        this.indexView = new BuyJewelryIndexView(indexModel, interactor);

        this.view = new BuyJewelryView(model, indexView.build(), createView.build(),editView.build());
       makeBindings();

       actions();

    }

    public Region getView() {
        return view.build();
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

        createView.build().visibleProperty().bind(model.create());
        indexView.build().visibleProperty().bind(model.index());
        editView.build().visibleProperty().bind(model.edit());
        interactor.makeViewsBindigns(
                model.create(),
                model.edit(),
                model.index()
        );

    }



    private void actions(){
        indexView.getEditButton().setOnAction(evt->{
            model.edit().set(true);
            System.out.println(indexModel.selectedItem().get().getId());
            BuyJewelryObject buy = interactor.findById(indexModel.selectedItem().get().getId());
            jewelryController.getInteractor().loadDataToEdit(buy.getJewelry_id());

            System.out.println("JOYA . "+ jewelryController.getModel().id());
        });
    }




    

}
