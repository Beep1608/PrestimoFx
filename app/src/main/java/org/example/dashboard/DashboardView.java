package org.example.dashboard;


import javafx.scene.layout.StackPane;
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

public class DashboardView extends org.jenvy.view.DashboardView {
    

    private final DashboardModel model;
    private final HBox mainContainer  =new HBox();
    private final StackPane rigthContainer = new StackPane();

    private VBox sideBar;
    private HBox buyButton;
    private HBox loanButton;

    private final Region buyView;
    private final Region loanView;

    public DashboardView(DashboardModel model, Region buyView, Region loanView){
        super();
        this.model = model;
        this.buyView = buyView;
        this.loanView  = loanView;
        mainContainer.getStyleClass().add("dashboard");
      //  makeView();
    }
  
   // @Override
   // public Region build() {
   //   return mainContainer;
   // }

    private void makeView(){
        //createSideBar();
        //createSidebarButtons();
        //configureRigthSide();
        
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
        buyButton = new SideBarButton("Compra") {
            @Override
            public void buttonActions() {
                model.buyView.set(true);
                model.loanView.set(false);
                System.out.println("Compra realizada");
            }
        };


        loanButton = new SideBarButton("Prestamo") {
            @Override
            public void buttonActions() {
                model.loanView.set(true);
                model.buyView.set(false);
                System.out.println("Prestamo");
            }
        };

        sideBar.getChildren().addAll(buyButton, loanButton);
    }

    private void configureRigthSide(){

        mainContainer.widthProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                buyView.setPrefWidth(newValue.doubleValue() - sideBar.getWidth());
            }
        });
        rigthContainer.getChildren().addAll(buyView,loanView);
        mainContainer.getChildren().add(rigthContainer);
    }

   



}
