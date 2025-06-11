package org.example.buy_caratages_percentages;

import java.util.HashMap;

import org.example.components.CustomLabeledComboBox;
import org.example.utils.Responsive;

import javafx.scene.layout.Region;
import javafx.util.Builder;

public class BuyCaratagePercentagesView implements  Builder<Region> {

    private final BuyCaratagePercentagesModel model;
    private final  HashMap<String, Runnable> actions ;

    private CustomLabeledComboBox comboBox;

    public BuyCaratagePercentagesView(BuyCaratagePercentagesModel model, HashMap<String, Runnable> actions ){
        this.model = model;
        this.actions = actions;
    }


    @Override
    public Region build() {
        createCombo();
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
       comboBox.getCombo().valueProperty().addListener((obsVal, oldVal, newVal)->{
            System.out.println(newVal.toString());
            model.selectedString().set(newVal.toString());
            actions.get("getLast").run();
            actions.get("updateSelected").run();
       });
    }

    
  

}
