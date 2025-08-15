package org.example.pages;

import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import org.jenvy.interactor.Interactor;
import org.jenvy.model.Model;
import org.jenvy.view.View;
import org.jenvy.view.router.Page;
import org.jenvy.view.router.PageProvider;

public class ExampleTwoPage extends VBox implements Page {

    private PageProvider provider;

    String name = "ExampleTwoPage";
    public ExampleTwoPage(){
        Button button = new Button("Boton");
        button.setOnAction(event -> {
            nav(ExamplePage.class);
        });
        getChildren().addAll(new Label("Ejemplo 2"), button);

    }

    @Override
    public Parent view() {
        return this;
    }

    @Override
    public String name() {
        return "ExampleTwo";
    }

    @Override
    public Model model() {
        return null;
    }

    @Override
    public Interactor interactor() {
        return null;
    }

    @Override
    public void reset() {
        System.out.println("Reset");
    }
}
