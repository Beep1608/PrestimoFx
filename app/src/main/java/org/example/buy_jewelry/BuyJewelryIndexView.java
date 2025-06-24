package org.example.buy_jewelry;

import java.util.HashMap;
import java.util.List;
import java.util.function.Function;

import org.example.buy_jewelry.dto.BuyJewelryIndex;
import org.example.view.TableView;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;

public class BuyJewelryIndexView extends TableView<BuyJewelryIndex> {
    private final BuyJewelryModel model;
    private final HashMap<String, Function<Object, Object>> actions;
    private List<BuyJewelryIndex> lista;

    public BuyJewelryIndexView( 
        BuyJewelryModel model,
        HashMap<String, Function<Object, Object>> actions
    ) 
    {
        super();
        this.model = model;
        this.actions = actions;
        lista = (List<BuyJewelryIndex>) actions.get("index").apply(null);
        //setData(lista);
        loadData();
        //BuyJewelryIndex firstElement = lista.get(0);
        //System.out.println("Id: "+firstElement.getId());
        //System.out.println("max_purchase_amount: "+firstElement.getMax_Purchase_Amount());
        //System.out.println("weigth: "+firstElement.getWeigth());
        //System.out.println("caratage: "+firstElement.getCaratage());

     


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
             // Columna "Editar"
        TableColumn<BuyJewelryIndex, Void> editCol = new TableColumn<>("Editar");
            editCol.setCellFactory(param -> new TableCell<>() {
                private final Button btn = new Button("Editar");

                {
                    btn.setOnAction(event -> {
                        BuyJewelryIndex item = getTableView().getItems().get(getIndex());
                        
                        System.out.println("Editando: " + item.getId());
                        model.create().set(true);
                    });
                }
            
                @Override
                protected void updateItem(Void item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty) {
                        setGraphic(null);
                    } else {
                        setGraphic(btn);
                    }
                }
            });



        return List.of(id,amount,weight,caratage,description,editCol);
    }

    
    private void loadData() {
        try {
    
            
            System.out.println("Lista original size: " + lista.size());
            if (lista != null && !lista.isEmpty()) {
               ObservableList<BuyJewelryIndex> index = FXCollections.observableArrayList(lista);
                setData(index);
           
                System.out.println("Datos cargados en la tabla");
            } else {
                System.out.println("La lista está vacía o es null");
            }
        } catch (Exception e) {
            System.err.println("Error al cargar datos: " + e.getMessage());
            e.printStackTrace();
        }
    }


    
}
