package org.example.clients;

import javafx.beans.property.*;
import org.example.clients.dto.ClientCreateDto;

public class ClientModel {

    private final SimpleIntegerProperty id = new SimpleIntegerProperty();
    private final SimpleBooleanProperty create = new SimpleBooleanProperty(false);
    private final SimpleBooleanProperty index  = new SimpleBooleanProperty(false);
    private final SimpleListProperty<ClientCreateDto> suggestions = new SimpleListProperty<>();
    private final SimpleStringProperty name = new SimpleStringProperty();
    private final SimpleStringProperty address = new SimpleStringProperty();
    private final SimpleStringProperty city = new SimpleStringProperty();
    private final SimpleStringProperty state = new SimpleStringProperty();


    public IntegerProperty id(){
        return id;
    }

    public BooleanProperty create(){
        return create;
    }

    public BooleanProperty index(){
        return index;
    }

    public ListProperty<ClientCreateDto> suggestions(){
        return suggestions;
    }

    public StringProperty name(){
        return name;
    }

    public StringProperty address(){
        return address;
    }

    public StringProperty city(){
        return city;
    }

    public StringProperty state (){
        return state;
    }
}
