package org.example.clients;

import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.util.Builder;

public class ClientView implements Builder<Region> {
    private final ClientModel model;
    private final ClientInteractor interactor;

    private final StackPane container = new StackPane();

    private Region createView;

    public ClientView(ClientModel model, ClientInteractor interactor, Region createView){
        this.model = model;
        this.interactor = interactor;
        this.createView = createView;
        makeView();
    }

    @Override
    public Region build() {
        return container;
    }

    private void makeView(){
        container.getChildren().addAll(createView);
    }
}
