package org.example.pages;

import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import org.jenvy.interactor.Interactor;
import org.jenvy.model.Model;
import org.jenvy.view.router.Page;

public class HomePage extends VBox implements Page {

    public HomePage(){
        init();
    }

    private void init(){
        this.getChildren().add(new Label("Holaaaaa"));
    }

    @Override
    public Parent view() {
        return this;
    }

    @Override
    public String name() {
        return "HomePage";
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

    }
}
