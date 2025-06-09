package org.example.components;

import org.example.utils.IconFactory;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

public class SideBar extends HBox {

    private Timeline timeline;

    private VBox vBox;
    private ToggleButton hidener;
    private String iconUrl = getClass().getResource("/img/right-arrow.png").toExternalForm();

    public SideBar() {
        run();
    }


    private void run() {
        addLeftSide();
        addHidener();
        configureTimeline();
      
    }


    private void configureTimeline() {
            timeline = new Timeline();
            timeline.setCycleCount(2);
            timeline.setAutoReverse(true);
            timeline.getKeyFrames().add(new KeyFrame(Duration.millis(1000), 
            new KeyValue(vBox.scaleXProperty(), 460), 
            new KeyValue(hidener.translateXProperty(),365),
            new KeyValue(hidener.rotateProperty(),180)
            ));
            for (Node element : vBox.getChildren()) {
                timeline.getKeyFrames().get(0).getValues().add(new KeyValue(element.scaleXProperty(), 10));
            }

            timeline.currentTimeProperty().addListener((obsVal, oldVal, newVal)->{
                if(newVal.toMillis() == timeline.getTotalDuration().divide(2).toMillis() ){
                        
                    timeline.pause();
                  
                }
            });

            timeline.statusProperty().addListener( (obsVal, oldVal, newVal) -> {
                if(newVal == Animation.Status.STOPPED){
                    vBox.setScaleX(0);
                    vBox.setPrefWidth(0);
                    hidener.setTranslateX(0);
                    hidener.setRotate(0);
                }
            });
    }

    
    private void addLeftSide() {
        this.vBox = new VBox();
        this.vBox.getStyleClass().add("left-side");
     
        vBox.setPrefWidth(0);
        
        
       

        this.getChildren().add(vBox);
    }

    private void addHidener(){
        this.hidener = new ToggleButton();
        this.hidener.getStyleClass().add("hiddener");
        IconFactory.createIconGraphic(iconUrl, 15, 15, hidener);
        hidener.setOnMouseClicked(event -> {
            if(hidener.selectedProperty().get()){
                vBox.setPrefWidth(1);
                for (Node element : vBox.getChildren()) {
                    ((Button)element).setPrefWidth(1);
                    ((Button)element).setText("Miau");
                }
                this.getTimeline().play();
            }
            if(this.getTimeline().getStatus() == Animation.Status.PAUSED){
              this.getTimeline().play();
            }
        });

        this.getChildren().add(hidener);
        
    }


    public VBox getVBox() {
        return vBox;
    }
    public Timeline getTimeline(){
        return timeline;
    }
}
