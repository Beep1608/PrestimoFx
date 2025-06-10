package org.example.buy_percentages;

import java.util.HashMap;
import java.util.function.Consumer;

import org.example.components.CustomLabeledComboBox;
import org.example.utils.Responsive;

import javafx.scene.layout.Region;
import javafx.util.Builder;

public class BuyPercentageView implements  Builder<Region> {

    private final BuyPercentagesModel model;
    private final HashMap<String, Consumer<Void>> actions;

    private CustomLabeledComboBox comboBox;

    public BuyPercentageView(BuyPercentagesModel model, HashMap<String, Consumer<Void>> actions ){
        this.model = model;
        this.actions = actions;
    }


    @Override
    public Region build() {
        createCombo();
        return comboBox;
    }

    private void createCombo(){
        comboBox =  new CustomLabeledComboBox("Porcentajes en compra");
        comboBox.getCombo().getItems().addAll("Minimo", "Medio", "Maximo");
        configureCombo();
        Responsive.bindingToParentWidth(comboBox, 1);
    }

    
    private void configureCombo(){
        comboBox.getCombo().valueProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                String selectedPercentage = newValue.toString();
                

                switch (selectedPercentage) {
                    case "Minimo":
                        model.selected().set(model.minimum().get());
                        break;
                    case "Medio":
                          model.selected().set(model.medium().get());
                        break;
                    case "Maximo":
                          model.selected().set(model.maximum().get());
                        break;
                }
                
                System.out.println("Porcentaje seleccionado: " + selectedPercentage + " - Valor: " + model.selected());
            }
        });

    }

}
