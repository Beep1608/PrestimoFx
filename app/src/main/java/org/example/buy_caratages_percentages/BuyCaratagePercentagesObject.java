package  org.example.buy_caratages_percentages;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="percentages_buy_caratage")
public class BuyCaratagePercentagesObject {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    private double minimum;
    private double medium;
    private double maximum;


    public int getId(){
        return  id;
    }

    public double getMinimum(){
        return  minimum;
    }

    public double getMedium(){
        return  medium;
    }
    public double getMaximum(){
        return  maximum;
    }
}
