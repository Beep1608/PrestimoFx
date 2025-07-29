package org.example.jewelry;

import javafx.beans.property.*;

public class JewelryModel  {
   
    private final SimpleIntegerProperty id  = new SimpleIntegerProperty();
    private final SimpleStringProperty metal = new SimpleStringProperty();
    private final SimpleStringProperty caratage = new SimpleStringProperty();
    private final SimpleDoubleProperty weight = new SimpleDoubleProperty();
    private final SimpleStringProperty description = new SimpleStringProperty();
    private final SimpleStringProperty imagePath = new SimpleStringProperty();
    private final SimpleStringProperty imageFormat = new SimpleStringProperty();

    private final SimpleBooleanProperty index = new SimpleBooleanProperty(false);
    private final SimpleBooleanProperty create = new SimpleBooleanProperty(false);
    private final SimpleBooleanProperty edit  = new SimpleBooleanProperty(false);




    public JewelryModel() {
      
        
    }
    
    public IntegerProperty id(){
        return  id;
    }

    public StringProperty metal() {
        return metal;
    }
    public StringProperty caratage() {
        return caratage;
    }
    public DoubleProperty weight() {
        return weight;
    }
    public StringProperty description() {
        return description;
    }


    public StringProperty image(){
        return  imagePath;
    }

    public StringProperty format(){
        return  imageFormat;
    }

    public BooleanProperty index(){
        return index;
    }

    public BooleanProperty create(){
        return create;
    }

    public BooleanProperty edit(){
        return edit;
    }

}
