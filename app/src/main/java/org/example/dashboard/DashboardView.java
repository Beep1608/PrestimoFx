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
import org.jenvy.components.Nav;
import org.jenvy.components.NavTree;
import org.jenvy.view.router.PageProvider;

import java.util.Set;

public class DashboardView extends org.jenvy.view.DashboardView {
    

    private final DashboardModel model;

    private final Region buyView;
    private final Region loanView;

    public DashboardView(DashboardModel model, Region buyView, Region loanView){
        this.model = model;
        this.buyView = buyView;
        this.loanView  = loanView;

    }

   



}
