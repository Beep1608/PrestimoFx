package org.example.view;

import org.example.utils.Responsive;

import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.TableColumn;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.util.Builder;

public abstract class TableView<T> implements Builder<Region>{

    private VBox container;
    private  javafx.scene.control.TableView<T> table;

    public TableView (){
       run();
    }

    @Override
    public Region build() {
        
        return container;
    }

    private void run(){
        createContainer();

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
        table = new javafx.scene.control.TableView<>();
       
        table.setColumnResizePolicy(javafx.scene.control.TableView.CONSTRAINED_RESIZE_POLICY_FLEX_LAST_COLUMN);
        table.getColumns().setAll(createColumns());

        Responsive.bindingToParent(table, 1, 1);
        return table;
    }

  


    protected abstract java.util.List<TableColumn<T, ?>> createColumns();

    protected javafx.scene.control.TableView<T> getTable(){
        return table;
    }

    public void setData(ObservableList<T> data) {
        table.setItems(data);
        System.out.println(data.size());
      
    }
 
    
}
