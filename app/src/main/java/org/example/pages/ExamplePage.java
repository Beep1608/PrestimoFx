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
            nav("dos");
        });
        getChildren().addAll(new Label("Ejemplo 1"), button);

    }

    @Override
    public PageProvider provider() {
        return provider;
    }

    @Override
    public void setProvider(PageProvider provider) {
        this.provider = provider;
    }

    @Override
    public Parent view() {
        return this;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public Class<? extends Model> model() {
        return null;
    }

    @Override
    public Class<? extends Interactor> interactor() {
        return null;
    }

    @Override
    public void reset() {

        System.out.println("Reseteando jijjijij");
    }
}
