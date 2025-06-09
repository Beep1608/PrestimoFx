package org.example.dashboard;


import org.example.components.SideBar;
import org.example.components.SideBarButton;
import org.example.enums.DashboardEnum;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.util.Builder;

public class DashboardView implements Builder<Region>{
    

    private final DashboardModel model;
    private final HBox mainContainer  =new HBox();


    private VBox sideBar;
    private HBox buyButton;

    private final Region buyView;

    public DashboardView(DashboardModel model, Region buyView){
        this.model = model;
        this.buyView = buyView;
    }
  
    @Override
    public Region build() {
       mainContainer.getStyleClass().add("dashboard");
        makeView();
      return mainContainer;
    }

    private void makeView(){
        createSideBar();
        createSidebarButtons();
        configureRigthSide();
        
    }
    
    private void createSideBar(){
        sideBar = new VBox();
        sideBar.getStyleClass().add("sidebar");
        sideBar.setPadding(new Insets(10));
        sideBar.setSpacing(10);
        sideBar.setPrefWidth(DashboardEnum.LEFT_SIDE.getValue());

        mainContainer.getChildren().add(sideBar);
    }

    

    private void createSidebarButtons(){
        buyButton = new SideBarButton("Buy");
        buyButton.setOnMouseClicked(event -> {
            
            System.out.println("Compra realizada");
        });
        sideBar.getChildren().add(buyButton);
    }

    private void configureRigthSide(){

        mainContainer.widthProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                buyView.setPrefWidth(newValue.doubleValue() - sideBar.getWidth());
            }
        });
       
        mainContainer.getChildren().add(buyView);
    }

   



}
