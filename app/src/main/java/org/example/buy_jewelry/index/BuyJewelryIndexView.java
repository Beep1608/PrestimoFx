package org.example.buy_jewelry.index;

import java.util.List;

import javafx.collections.FXCollections;
import org.example.buy_jewelry.BuyJewelryInteractor;
import org.example.buy_jewelry.BuyJewelryModel;
import org.example.buy_jewelry.dto.BuyJewelryIndex;

import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import org.jenvy.dto.Dto;
import org.jenvy.model.IndexModel;
import org.jenvy.view.IndexView;

public class BuyJewelryIndexView extends IndexView {
    private final BuyJewelryInteractor interactor;
    public BuyJewelryIndexView(BuyJewelryIndexModel model, BuyJewelryInteractor interactor) {
        super(model);
        this.interactor= interactor;
        model.items().set(FXCollections.observableArrayList( interactor.index()));

    }

    @Override
    protected List<TableColumn<BuyJewelryIndex, ?>> createColumns() {
        TableColumn<BuyJewelryIndex, Integer> id = new TableColumn<>("Id");
       id.setCellValueFactory(new PropertyValueFactory<>("id"));

       TableColumn<BuyJewelryIndex, Double> amount = new TableColumn<>("Monto");
       amount.setCellValueFactory(new PropertyValueFactory<>("amount"));

       TableColumn<BuyJewelryIndex, String> weight = new TableColumn<>("Peso");
       weight.setCellValueFactory(new PropertyValueFactory<>("weight"));

       TableColumn<BuyJewelryIndex, String> caratage = new TableColumn<>("Kilataje");
       caratage.setCellValueFactory(new PropertyValueFactory<>("caratage"));

       TableColumn<BuyJewelryIndex, String> description = new TableColumn<>("Descripción");
       description.setCellValueFactory(new PropertyValueFactory<>("description"));
        return List.of(id,amount,weight,caratage,description);
    }

    @Override
    protected Button createButton() {
        return new Button("Crear");
    }

    @Override
    protected Button editButton() {
        return new Button("Editar");
    }




    
}
