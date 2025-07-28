package org.example.buy_percentages;

import java.util.HashMap;

import org.hibernate.Session;

import javafx.scene.layout.Region;


public class BuyPercentagesController{

    private final BuyPercentagesModel model;
    private final BuyPercentagesInteractor interactor;
    private final BuyPercentageView view;
    public BuyPercentagesController(Session session){
        this.model = new BuyPercentagesModel();
    
        this.interactor = new BuyPercentagesInteractor(model, session);

        this.view = new BuyPercentageView(model, interactor);

        createListeners();
    }
    public Region getView(){
        return  view.build();
    }

    public BuyPercentagesModel getModel(){
        return model;
    }

    public void createListeners(){
        model.edit().addListener((observable, oldValue, newValue) -> {
                if(newValue){
                    model.create().set(false);
                    model.index().set(false);
                    interactor.loadDataToEdit();
                }
        });

        model.create().addListener((observable, oldValue, newValue) -> {
            System.out.println("Limpiando");
            if(newValue){
                model.edit().set(false);
                model.index().set(false);
                interactor.clean();
                interactor.getLast();
                System.out.println("Obteniendo percentages");
            }
        });
    }


}