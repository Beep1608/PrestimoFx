package org.example.pages;

import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import org.jenvy.interactor.Interactor;
import org.jenvy.model.Model;
import org.jenvy.view.router.Page;
import org.jenvy.view.router.PageProvider;

public class ExamplePage extends VBox implements Page {

    private PageProvider provider;

    String name = "ExamplePage";
    public ExamplePage(){
        Button button = new Button("Boton");
        button.setOnAction(event -> {
            nav(ExampleTwoPage.class);
        });
        getChildren().addAll(new Label("Ejemplo 1"), button);

    }


    @Override
    public Parent view() {
        return this;
    }

    @Override
    public String name() {
        return "ExampleOne";
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
        System.out.println("Reset : "+name());
    }
}
