package org.example.constants;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class ConstantsModel  {

    private final SimpleDoubleProperty conversion_factor = new SimpleDoubleProperty();
    private final SimpleDoubleProperty security_value = new SimpleDoubleProperty();
    private final SimpleDoubleProperty revenue_gr = new SimpleDoubleProperty();
   
    static String table = "constants";
    static String[] fieldNames = new String[]{
        "conversion_factor",
        "security_value",
        "revenue_gr"
    };

    public DoubleProperty conversion_factor() {
        return conversion_factor;
    }
    public DoubleProperty security_value() {
        return security_value;
    }
    public DoubleProperty revenue_gr() {
        return revenue_gr;
    }



    
}
