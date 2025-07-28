package org.example.buy_jewelry;

import java.util.HashMap;
import java.util.function.Function;

import javafx.beans.binding.Bindings;
import org.example.buy_percentages.BuyPercentagesInteractor;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import org.jenvy.components.FormView;
import org.jenvy.model.Model;

public class BuyJewelryCreateView extends FormView {
    private final BuyJewelryModel model;
    private final BuyJewelryInteractor interactor;

    private final Region jewelryView;
    private final  Region buyPercentagesView;
     private final  Region buyCaratagePercentagesView;

    private Button calculateButton;
    private Label calculateLabel;

    
    public BuyJewelryCreateView( 
        BuyJewelryModel model,
        BuyJewelryInteractor interactor,
        Region jewelryView,
        Region buyPercentagesView,
        Region buyCaratagePercentagesView
    ) 
    {
        super();
        this.model = model;
        this.jewelryView = jewelryView;
        this.buyPercentagesView = buyPercentagesView;
        this.buyCaratagePercentagesView = buyCaratagePercentagesView;
        this.interactor = interactor;
       makeView();
       createBindigs();
        
    }

    @Override
    protected void addFieldsToGeneralDataContainer() {

        generalDataCotainer.getContentContainer().setSpacing(10);
        generalDataCotainer
        .getContentContainer()
        .getChildren()
        .add(jewelryView);
    }

    @Override
    protected void addFieldsToSpecialDataContainer() {
    

        HBox buttonContainer = new HBox();

        calculateButton = new Button("Calcular");
        calculateButton.getStyleClass().add("calculate-button");
        buttonContainer.getChildren().add(calculateButton);
        calculateLabel = new Label();
        calculateLabel.textProperty().bind(model.max_purchase_amount().asString());
        addActionsToCalculateButton();
        specialDataContainer
        .getContentContainer()
        .getChildren()
        .addAll(buyCaratagePercentagesView, 
        buyPercentagesView, 
        calculateLabel,
        buttonContainer);
    }

    private void addActionsToCalculateButton(){
        //calculateButton.visibleProperty().bind(model.calculate());
        calculateButton.setOnMouseClicked(event -> {
            model.calculate().set(false);
            interactor.calculate();
        });
    
    }

    @Override
    protected void addActionsToCreateButton() {
       // getCreateButton().visibleProperty().bind(calculateButton.visibleProperty());
        getCreateButton().setOnMouseClicked(event -> {
            if(model.create().get()){
                interactor.store();
            }
           if(model.edit().get()){
               System.out.println("Usted esta editando");
               interactor.edit();
           }

        });
    }

    @Override
    protected void addActionsToBackButton() {

        model.index().set(true);

    }

    private void createBindigs(){
        createButton.disableProperty().bind(model.calculate());
        createButton.textProperty().bind(model.currentAction());
    }

    public Button getCalculateButton(){
        return calculateButton;
    }



}
