package org.example.buy_jewelry;

import java.util.HashMap;
import java.util.function.Consumer;

import org.example.components.CustomLabeledComboBox;
import org.example.utils.Responsive;
import org.example.view.FormView;

import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;

public class BuyJewelryView extends FormView {
    private final BuyJewelryModel model;
    private final Region jewelryView;

    private final HashMap<String, Consumer<BuyJewelryModel>> actions;

    private Button calculateButton;
    
    public BuyJewelryView( 
        BuyJewelryModel model, 
        Region jewelryView,
        HashMap<String, Consumer<BuyJewelryModel>> actions
    ) 
    {
        super();
        this.model = model;
        this.jewelryView = jewelryView;
        this.actions = actions;
        
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
        CustomLabeledComboBox percentageCaratageBox = new CustomLabeledComboBox("Porcentajes en prestamo");
        percentageCaratageBox.getCombo().getItems().addAll("Minimo", "Medio", "Maximo");
        Responsive.bindingToParentWidth(percentageCaratageBox, 1);

        CustomLabeledComboBox percentageBuyBox =  new CustomLabeledComboBox("Porcentajes en compra");
        percentageBuyBox.getCombo().getItems().addAll("Minimo", "Medio", "Maximo");
        Responsive.bindingToParentWidth(percentageBuyBox, 1);

        HBox buttonContainer = new HBox();

        calculateButton = new Button("Calcular");
        calculateButton.getStyleClass().add("calculate-button");
        buttonContainer.getChildren().add(calculateButton);
        addActionsToCalculateButton();
        specialDataContainer.getContentContainer().getChildren().addAll(percentageCaratageBox, percentageBuyBox, buttonContainer);
    }

    private void addActionsToCalculateButton(){
        calculateButton.setOnMouseClicked(event -> {
           
        });
    
    }

    @Override
    protected void addActionsToCreateButton() {
        getCreateButton().setOnMouseClicked(event -> {
            System.out.println("Miau");
           actions.get("store").accept(model);
        });
    }

  


    // TODO: Implementar la lógica para calcular los porcentajes
    // Considerar añadir los porcentajes al modelo BuyJewelryModel y ser modificados por el combo
    
    private void configureBuyPercentages(CustomLabeledComboBox percentageCombo){
        percentageCombo.getCombo().valueProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                String selectedPercentage = newValue.toString();
                double percentageValue = 0.0;

                switch (selectedPercentage) {
                    case "Minimo":
                      
                        break;
                    case "Medio":
                        
                        break;
                    case "Maximo":
                      
                        break;
                }
                
                System.out.println("Porcentaje seleccionado: " + selectedPercentage + " - Valor: " + percentageValue);
            }
        });

    }

    
}
