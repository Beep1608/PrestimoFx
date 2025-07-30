package org.example.clients;

import javafx.geometry.Insets;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.util.Builder;
import org.example.clients.dto.ClientCreateDto;
import org.example.components.CustomTextField;
import org.jenvy.components.FormContainer;
import org.jenvy.components.FormSearchInputText;

import java.util.List;

public class ClientCreateView implements Builder<Region> {
    private final ClientModel model;
    private final ClientInteractor interactor;
    private FormContainer container;

    public ClientCreateView(ClientModel model, ClientInteractor interactor){
        this.model = model;
        this.interactor = interactor;
        makeView();
    }
    @Override
    public Region build() {
        return container;
    }

    private void makeView(){
        container = new FormContainer("Información del cliente");
        container.setPadding(new Insets(0,10,10,10));
        createFields();
    }

    private void createFields(){
        FormSearchInputText<ClientCreateDto> name = new FormSearchInputText<>(model.suggestions());
        CustomTextField address = new CustomTextField();
        address.setPromptText("Ingrese la dirección del cliente");
        CustomTextField city = new CustomTextField();
        city.setPromptText("Ingrese la ciudad del cliente");

        CustomTextField state = new CustomTextField();
        state.setPromptText("Ingrese el estado del cliente");


        container.getChildren().addAll(name,address,city,state);
    }
}
