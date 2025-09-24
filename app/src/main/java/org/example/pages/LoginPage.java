package org.example.pages;

import atlantafx.base.controls.Card;
import atlantafx.base.controls.CustomTextField;
import atlantafx.base.controls.Tile;
import atlantafx.base.theme.Styles;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import org.example.interactors.LoginInteractor;
import org.example.models.LoginModel;
import org.jenvy.interactor.Interactor;
import org.jenvy.model.Model;
import org.jenvy.view.router.Page;
import org.kordamp.ikonli.bytedance.BytedanceIconsBoldMZ;
import org.kordamp.ikonli.javafx.FontIcon;

public class LoginPage extends VBox implements Page {

    private final LoginModel model;
    private final LoginInteractor interactor;

    private final HBox container = new HBox();

    private final VBox logoContainer = new VBox();

    private final VBox inputsContainer = new VBox();
    public LoginPage(){
        this.model = new LoginModel();
        this.interactor = new LoginInteractor();
        init();
        container.getChildren().addAll(logoContainer,this);
        container.setAlignment(Pos.CENTER);
        HBox.setHgrow(logoContainer, Priority.ALWAYS);
    }

    private void init(){
        this.setAlignment(Pos.CENTER_LEFT);
        Card loginCard = new Card();
        loginCard.setMinWidth(300);
        loginCard.setMinHeight(200);

        //Controles del Login

        Label title  = new Label("Iniciar Sesión");
        title.getStyleClass().addAll(Styles.TITLE_2);

        CustomTextField email = new CustomTextField();
        email.setPromptText("Email");
        email.setLeft(new FontIcon(BytedanceIconsBoldMZ.MAIL));


        loginCard.setHeader(title);
        loginCard.setCon
        loginCard.getStyleClass().addAll(Styles.ELEVATED_2);

        container.widthProperty().addListener((observableValue, oldValue, newValue) -> {
            this.setPrefWidth(newValue.doubleValue() * 0.5);
        });

        this.setPadding(new Insets(10,300,10,300));

        this.getChildren().addAll(loginCard);

        this.setAlignment(Pos.CENTER_LEFT);


        logoContainer.getStyleClass().add("test-one");
        logoContainer.setAlignment(Pos.CENTER_LEFT);
        logoContainer.getChildren().addAll(new Label("Hola"));
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
