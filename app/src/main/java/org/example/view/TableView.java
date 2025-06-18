package org.example.view;

import javafx.scene.control.Label;
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
        container = new VBox();
        container.getStyleClass().add("table-view-container");
    }

    private void createTable(){
        table = new javafx.scene.control.TableView();
        container.getChildren().add(table);
    }
    
}
