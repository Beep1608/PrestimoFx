package org.example.loan_jewelry.index;

import javafx.collections.FXCollections;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import org.example.buy_jewelry.dto.BuyJewelryIndex;
import org.example.loan_jewelry.LoanJewelryInteractor;
import org.jenvy.dto.Dto;
import org.jenvy.view.IndexView;

import java.util.List;

public class LoanJewelryIndexView extends IndexView {

    private final LoanJewelryInteractor interactor;

    public LoanJewelryIndexView(LoanJewelryIndexModel model, LoanJewelryInteractor interactor) {
        super(model);
        this.interactor = interactor;
        model.items().set(FXCollections.observableArrayList(interactor.index()));
    }

    @Override
    protected List<TableColumn<LoanJewelryIndexDto, ?>> createColumns() {
        TableColumn<LoanJewelryIndexDto, Integer> id = new TableColumn<>("Id");
        id.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<LoanJewelryIndexDto, Double> amount = new TableColumn<>("Monto");
        amount.setCellValueFactory(new PropertyValueFactory<>("amount"));

        TableColumn<LoanJewelryIndexDto, String> weight = new TableColumn<>("Peso");
        weight.setCellValueFactory(new PropertyValueFactory<>("weight"));

        TableColumn<LoanJewelryIndexDto, String> caratage = new TableColumn<>("Kilataje");
        caratage.setCellValueFactory(new PropertyValueFactory<>("caratage"));

        TableColumn<LoanJewelryIndexDto, String> description = new TableColumn<>("Descripción");
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