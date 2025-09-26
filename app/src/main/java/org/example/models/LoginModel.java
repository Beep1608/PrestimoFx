package org.example.models;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import org.example.entity.UserEntity;
import org.jenvy.model.Model;

public class LoginModel extends Model {

    private final SimpleObjectProperty<UserEntity> user = new SimpleObjectProperty<>();


    public ObjectProperty<UserEntity> user(){
        return user;
    }
}
