package org.example.jewelry;

import java.util.HashMap;
import java.util.function.Consumer;

import javafx.util.converter.NumberStringConverter;
import org.example.components.CustomComboBox;
import org.example.components.CustomTextArea;
import org.example.components.CustomTextField;
import org.example.components.ImageContainer;
import org.example.enums.CaratagesEnum;
import org.example.enums.MetalsEnum;
import org.example.utils.Responsive;

import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.util.Builder;

public class JewelryCreateView implements Builder<Region> {
    private final JewelryModel model;
    private final JewelryInteractor interactor;

    private  VBox container ;


    public JewelryCreateView(JewelryModel model, JewelryInteractor interactor) {
        this.model = model;
        this.interactor = interactor;
        makeView();
    }

    @Override
    public Region build() {
        return container;
    }

    private  void makeView(){
        Button back = new Button("Regresar");
        back.setOnAction(event -> {
            model.index().set(true);
        });
        container = new VBox();
        CustomComboBox comboBox = new CustomComboBox();
        Responsive.bindingToParentWidth(comboBox, 1);
        comboBox.getItems().addAll(MetalsEnum.GOLD.getValue(), 
                                    MetalsEnum.SILVER.getValue());
        comboBox.setPromptText("Seleccione un metal");

        comboBox.valueProperty().bindBidirectional(model.metal());


        CustomComboBox caratageCombo = new CustomComboBox();
        Responsive.bindingToParentWidth(caratageCombo, 1);
        caratageCombo.getItems().addAll(CaratagesEnum.CARATAGE_8.getValue(), 
                                        CaratagesEnum.CARATAGE_10.getValue(),
                                        CaratagesEnum.CARATAGE_14.getValue(),
                                        CaratagesEnum.CARATAGE_18.getValue(),
                                        CaratagesEnum.CARATAGE_22.getValue(),
                                        CaratagesEnum.CARATAGE_24.getValue());
        caratageCombo.setPromptText("Seleccione un kilataje");

         caratageCombo.valueProperty().bindBidirectional(model.caratage());

        VBox imageContainer = new VBox();
        imageContainer.setSpacing(10);

        ImageContainer imageForm = new ImageContainer("",
        getClass()
        .getResource("/img/right-arrow.png")
        .getPath(), 280);

        HBox imageButtonsContainer = new HBox();
        model.image().addListener((observable, oldValue, newValue) -> {
            if(newValue != null || !newValue.equals("")){
                imageForm.doPreviewEdit(model.image().get());
            }
        });
        Button previewButton = new Button("Añadir Imagen");
        previewButton.getStyleClass().add("preview-button");
        previewButton.setOnMouseClicked(event -> {
            imageForm.doPreview();
            model.image().setValue(imageForm.getImage().getUrl());
            System.out.println("Image url: "+ model.image().get());
        });

        
        imageButtonsContainer.getChildren().add(previewButton);
        imageContainer.getChildren().addAll(imageForm, imageButtonsContainer);

        CustomTextField weigthField = new CustomTextField();
        Responsive.bindingToParentWidth(weigthField, 1);
        weigthField.setPromptText("Ingrese la cantidad en gramos");
        weigthField.textProperty().bindBidirectional(model.weight(), new NumberStringConverter());

        CustomTextArea descriptionField = new CustomTextArea();
        descriptionField.setPromptText("Ingrese una descripción de la joya");
        descriptionField.setMinHeight(100);
        Responsive.bindingToParentWidth(descriptionField, 1);
        descriptionField.textProperty().bindBidirectional(model.description());


        container.setSpacing(5);
        container.getChildren().addAll(comboBox, caratageCombo, imageContainer, weigthField, descriptionField);

    }


    
}
