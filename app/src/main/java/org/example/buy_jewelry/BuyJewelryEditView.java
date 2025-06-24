package org.example.buy_jewelry;

import java.util.HashMap;
import java.util.function.Function;

import org.example.view.FormView;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;

public class BuyJewelryEditView extends FormView {
    private final BuyJewelryModel model;

    private final Region jewelryView;
    private final  Region buyPercentagesView;
     private final  Region buyCaratagePercentagesView;

    private final HashMap<String, Function<Object, Object>> actions;

    private Button calculateButton;
    private Label calculateLabel;

    
    public BuyJewelryEditView( 
        BuyJewelryModel model, 
        Region jewelryView,
        Region buyPercentagesView,
        Region buyCaratagePercentagesView,
        HashMap<String, Function<Object, Object>> actions
    ) 
    {
        super();
        this.model = model;
        this.jewelryView = jewelryView;
        this.buyPercentagesView = buyPercentagesView;
        this.buyCaratagePercentagesView = buyCaratagePercentagesView;
        this.actions = actions;
        makeView();
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
        calculateButton.visibleProperty().bind(model.calculate());
        calculateButton.setOnMouseClicked(event -> {
            actions.get("calculate").apply(event);
        });
    
    }

    @Override
    protected void addActionsToCreateButton() {
        getCreateButton().visibleProperty().bind(calculateButton.visibleProperty());
        getCreateButton().setOnMouseClicked(event -> {
            System.out.println("Miau");
           actions.get("store").apply(null);
        });
    }

  

    
}
