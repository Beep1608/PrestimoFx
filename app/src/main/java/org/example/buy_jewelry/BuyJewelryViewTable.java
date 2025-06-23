package org.example.buy_jewelry;

import java.util.HashMap;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

import org.example.jewelry.JewelryObject;
import org.example.view.FormView;
import org.example.view.TableView;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;

public class BuyJewelryViewTable extends TableView<BuyJewelryObject> {
    private final BuyJewelryModel model;
    private final HashMap<String, Function<Object, Object>> actions;

    public BuyJewelryViewTable( 
        BuyJewelryModel model,
        HashMap<String, Function<Object, Object>> actions
    ) 
    {
        super();
        this.model = model;
        this.actions = actions;
        List<BuyJewelryObject> lista = (List<BuyJewelryObject> ) actions.get("index").apply(null);
        BuyJewelryObject firstElement = lista.get(1);
        System.out.println("Id: "+firstElement.getId());
                //ObservableList<BuyJewelryObject> data = FXCollections.observableArrayList(lista);
        ObservableList<BuyJewelryObject> data2 = FXCollections.observableArrayList(
            new BuyJewelryObject(1)
        );

        System.out.println("Cargando datos: " + data2.size());
        setData(data2);


    }

    @Override   
    protected List<TableColumn<BuyJewelryObject, ?>> createColumns() {
           loadData();
        TableColumn<BuyJewelryObject, Integer> id = new TableColumn<>("id");
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        // Más columnas...

        return List.of(id);
    }

    
      private void loadData() {
        try {
           ObservableList<BuyJewelryObject> data = FXCollections.observableArrayList(
                    new BuyJewelryObject(1),
                    new BuyJewelryObject(2),
                    new BuyJewelryObject(3)
                );
                System.out.println("Cargando datos de prueba: " + data.size());
                setData(data);
        } catch (Exception e) {
            System.err.println("Error al cargar datos: " + e.getMessage());
            e.printStackTrace();
        }
    }



    
}
