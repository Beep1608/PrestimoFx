package org.example.view;

import org.example.buy_jewelry.BuyJewelryObject;
import org.example.jewelry.JewelryObject;
import org.example.utils.Responsive;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.TableColumn;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.util.Builder;

public class TableView implements Builder<Region>{

    private VBox container;
    private javafx.scene.control.TableView table;

    public TableView (){
       run();
    }

    @Override
    public Region build() {
        
        return container;
    }

    private void run(){
        createContainer();
        createTable();
    }

    private void createContainer(){
        container = new VBox(createTableContainer());
        container.setAlignment(Pos.CENTER);
        container.getStyleClass().add("table-view-container");
    }

    private Node createTableContainer(){
        VBox container = new VBox(createTable());
        Responsive.bindingToParent(container, 1, 0.8);
        return  container;
    }

    private Node createTable(){
        table = new javafx.scene.control.TableView();
        TableColumn <BuyJewelryObject,Integer> id =new TableColumn<>("Id");
        TableColumn <BuyJewelryObject,Integer> max_purchase_amount =new TableColumn<>("Monto de compra");
        TableColumn <JewelryObject,Double> weight =new TableColumn<>("Peso");
        TableColumn <JewelryObject,String> description =new TableColumn<>("Descripción");
        table.setColumnResizePolicy(javafx.scene.control.TableView.CONSTRAINED_RESIZE_POLICY_FLEX_LAST_COLUMN);
        table.getColumns().setAll(id,max_purchase_amount,weight,description);
        Responsive.bindingToParent(table, 1, 1);
        return table;
    }
    
}
