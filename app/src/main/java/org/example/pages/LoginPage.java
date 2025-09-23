package org.example.pages;

import atlantafx.base.controls.Card;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import org.example.interactors.LoginInteractor;
import org.example.models.LoginModel;
import org.jenvy.interactor.Interactor;
import org.jenvy.model.Model;
import org.jenvy.view.router.Page;

public class LoginPage extends VBox implements Page {

    private final LoginModel model;
    private final LoginInteractor interactor;

    private final HBox container = new HBox();
    public LoginPage(){
        this.model = new LoginModel();
        this.interactor = new LoginInteractor();
        container.getChildren().addAll(new Label("Hola"),this);
        container.setAlignment(Pos.CENTER);
        init();
    }

    private void init(){
        this.setAlignment(Pos.CENTER_LEFT);
        Card login = new Card();
        login.setMinWidth(100);
        login.setMinHeight(100);

        this.getChildren().addAll( login);
    }

    @Override
    public Parent view() {
        return container;
    }

    @Override
    public String name() {
        return "Login";
    }

    @Override
    public Model model() {
        return model;
    }

    @Override
    public Interactor interactor() {
        return interactor;
    }

    @Override
    public void reset() {
        System.out.println("Resetenado Login");
    }
}
