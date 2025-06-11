package org.example.jewelry;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class JewelryModel  {
   
    private final SimpleIntegerProperty id  = new SimpleIntegerProperty();
    private final SimpleStringProperty metal = new SimpleStringProperty();
    private final SimpleStringProperty caratage = new SimpleStringProperty();
    private final SimpleDoubleProperty weight = new SimpleDoubleProperty();
    private final SimpleStringProperty description = new SimpleStringProperty();
    private final SimpleStringProperty imagePath = new SimpleStringProperty();
    private final SimpleStringProperty imageFormat = new SimpleStringProperty();


    


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


}
