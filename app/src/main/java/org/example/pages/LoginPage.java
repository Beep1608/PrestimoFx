package org.example.pages;

import atlantafx.base.controls.*;
import atlantafx.base.theme.Styles;
import atlantafx.base.util.Animations;
import atlantafx.base.util.PasswordTextFormatter;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextFormatter;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.*;
import javafx.util.Duration;
import javafx.util.StringConverter;
import javafx.util.converter.DefaultStringConverter;
import org.example.enums.SIZES;
import org.example.interactors.LoginInteractor;
import org.example.models.LoginModel;
import org.example.responsive.ResponsiveUtils;
import org.jenvy.interactor.Interactor;
import org.jenvy.model.Model;
import org.jenvy.view.router.Page;
import org.kordamp.ikonli.bytedance.BytedanceIconsBoldAL;
import org.kordamp.ikonli.bytedance.BytedanceIconsBoldMZ;
import org.kordamp.ikonli.fluentui.FluentUiRegularAL;
import org.kordamp.ikonli.javafx.FontIcon;

import javax.swing.text.Style;

public class LoginPage extends VBox implements Page {

    private final LoginModel model;
    private final LoginInteractor interactor;

    private final HBox container = new HBox();

    private final VBox logoContainer = new VBox();

    private final VBox inputsContainer = new VBox();

    CustomTextField email = new CustomTextField();

    PasswordTextField password = new PasswordTextField();


    Button loginButton = new Button("Iniciar Sesión !");

    HBox loginButtonContainer = new HBox(loginButton);

    VBox notificationContainer = new VBox();

    Card loginCard  = new Card();

    Message succes;
    public LoginPage(){
        this.model = new LoginModel();
        this.interactor = new LoginInteractor(model);
        container.getChildren().addAll(logoContainer,this);
        container.setAlignment(Pos.CENTER);
        HBox.setHgrow(logoContainer, Priority.ALWAYS);
        init();
    }

    private void init(){

        loginCard.setMinWidth(300);
        loginCard.setMinHeight(200);

        //Controles del Login

        Label title  = new Label("Bienvenido a  [nombre] !");
        title.getStyleClass().addAll(Styles.TITLE_2);

        email.setPromptText("Email");
        email.setLeft(new FontIcon(BytedanceIconsBoldMZ.MAIL));
        email.setOnMouseClicked(mouseEvent -> {
            email.pseudoClassStateChanged(Styles.STATE_DANGER, false);
        });


        password.setPromptText("Contraseña");
        password.setLeft(new FontIcon(BytedanceIconsBoldAL.LOCK));
        password.setOnMouseClicked(mouseEvent -> {
            password.pseudoClassStateChanged(Styles.STATE_DANGER, false);
        });

        PasswordTextFormatter passwordFormatter = PasswordTextFormatter.create(password, '•');
        passwordFormatter.revealPasswordProperty().bind(password.revealPasswordProperty());

        password.setTextFormatter(passwordFormatter);

        FontIcon showPasswordIcon = new FontIcon(FluentUiRegularAL.EYE_HIDE_20);
        showPasswordIcon.setCursor(Cursor.HAND);
        showPasswordIcon.setOnMouseClicked(e ->{
            showPasswordIcon.setIconCode(password.getRevealPassword() ? FluentUiRegularAL.EYE_HIDE_20 : FluentUiRegularAL.EYE_SHOW_20);

            password.setRevealPassword(!password.getRevealPassword());
            password.positionCaret( password.getText().length());
        });

        password.setRight(showPasswordIcon);


        loginButton.setCursor(Cursor.HAND);
        loginButton.getStyleClass().addAll(Styles.BUTTON_OUTLINED, Styles.ACCENT, Styles.LARGE);
        HBox.setHgrow(loginButton, Priority.ALWAYS);
        loginButton.setOnAction(actionEvent -> {
            boolean mail = emptyMail();
            boolean pass = emptyPassword();
            if(!mail &&  !pass){
                login();
            }
        });



        loginButtonContainer.setAlignment(Pos.CENTER);
        loginButtonContainer.setPadding(new Insets(20,0,0,0));



        loginButtonContainer.widthProperty().addListener((observableValue, oldValue, newValue) -> {
            loginButton.setPrefWidth(newValue.doubleValue());
        });


        inputsContainer.setSpacing(10);
        inputsContainer.getChildren().addAll(email,password, loginButtonContainer);

        loginCard.setHeader(title);
        loginCard.setBody(inputsContainer);
        loginCard.getStyleClass().addAll(Styles.ELEVATED_2);

        container.widthProperty().addListener((observableValue, oldValue, newValue) -> {
            this.setPrefWidth(newValue.doubleValue() * 0.5);
        });

        this.setPadding(new Insets(10,300,10,300));


        this.getChildren().addAll(loginCard, notificationContainer);

        this.setAlignment(Pos.BOTTOM_CENTER);


        logoContainer.getStyleClass().add("test-one");
        logoContainer.setAlignment(Pos.CENTER_LEFT);
        logoContainer.getChildren().addAll(new Label("Hola"));

        succes = new Message("Inicio de sesión exitoso", "Bienvenido de nuevo !",new FontIcon(FluentUiRegularAL.CHECKMARK_CIRCLE_20));
        succes.setVisible(false);
        notificationContainer.getChildren().add(succes);
        responsive();
    }

    private boolean emptyMail(){

        if(email.getText().equals("")){

            email.pseudoClassStateChanged(Styles.STATE_DANGER, true);
            return true;

        }

        return false;
    }

    private boolean emptyPassword(){
        if(
                ((PasswordTextFormatter)password.getTextFormatter()).getPassword().equals("")
        ){

            password.pseudoClassStateChanged(Styles.STATE_DANGER,true);
            return true;
        }

        return false;
    }

    private void login(){
        if(interactor.login(email.getText(), ((PasswordTextFormatter)password.getTextFormatter()).getPassword()))
        {
            succes.setVisible(true);
            loginButton.pseudoClassStateChanged(Styles.STATE_SUCCESS,true);

            succes.getStyleClass().addAll(Styles.ACCENT, Styles.ELEVATED_1, Styles.SUCCESS);
            var succesAnimation = Animations.slideInRight(succes, Duration.seconds(1));

            notificationContainer.setPadding(new Insets(10,0,0,0));


            notificationContainer.setAlignment(Pos.TOP_LEFT);
            succesAnimation.setOnFinished(actionEvent -> {
                nav(HomePage.class);
            });
            succesAnimation.playFromStart();





        }

    }

    /*
    /* Metodos responsivos
     */

    private void responsive (){
        responsiveNotification();
    }
    private void responsiveNotification(){
        this.heightProperty().addListener((observableValue, oldValue, newValue) -> {
            if(this.getHeight() <= SIZES.SHORT_HEIGHT){
                notificationContainer.setMinHeight((newValue.doubleValue() * 0.5) - loginCard.getHeight() );
            }else {
                notificationContainer.setMinHeight((newValue.doubleValue() * 0.5) - loginCard.getHeight() +100);
            }
        });
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
