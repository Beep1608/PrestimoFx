package org.example.buy_caratages_percentages;

import java.util.HashMap;

import org.example.buy_percentages.BuyPercentagesInteractor;
import org.example.components.CustomLabeledComboBox;
import org.example.utils.Responsive;

import javafx.scene.layout.Region;
import javafx.util.Builder;

public class BuyCaratagePercentagesView implements  Builder<Region> {

    private final BuyCaratagePercentagesModel model;
    private final BuyCaratagePercentagesInteractor interactor;

    private CustomLabeledComboBox comboBox;

    public BuyCaratagePercentagesView(BuyCaratagePercentagesModel model, BuyCaratagePercentagesInteractor interactor ){
        this.model = model;
        this.interactor = interactor;
        createCombo();
    }


    @Override
    public Region build() {
        return comboBox;
    }

    public String getComboValue(){
        return comboBox.getCombo().getValue().toString();
    }

    private void createCombo(){
        comboBox =  new CustomLabeledComboBox("Porcentajes en compra");
        comboBox.getCombo().getItems().addAll("Minimo", "Medio", "Maximo");
        configureCombo();
        Responsive.bindingToParentWidth(comboBox, 1);
    }

    private void configureCombo(){
        comboBox.getCombo().valueProperty().bindBidirectional(model.selectedString());
       comboBox.getCombo().valueProperty().addListener((obsVal, oldVal, newVal)->{
           if(model.create().get()){
               System.out.println(newVal.toString());
               model.selectedString().set(newVal.toString());
               interactor.getLast();
               interactor.updateSelected();
           }

           if(model.edit().get()){
               model.selectedString().set(newVal.toString());
               interactor.updateSelected();
           }
       });
    }

    
  

}
