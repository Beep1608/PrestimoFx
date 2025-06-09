package org.example.components;

import org.example.utils.Responsive;

import javafx.scene.image.ImageView;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.stage.FileChooser;
import java.io.File;

public class ImageContainer extends FormContainer {
    private final int imageSize = 350; // Default height for the image
    

    private ImageView imageView;
    private final FileChooser fileChooser;    
    public ImageContainer(String title, String imageUrl, int height) {
        super(title);
       
        getStyleClass().add("image-container");        
        imageView = new ImageView();
        imageView.getStyleClass().add("image-view");
        imageView.setFitWidth(650);
        imageView.setFitHeight(imageSize);
        imageView.setPreserveRatio(false);
        imageView.setSmooth(true);
        imageView.setCache(true);
        
        Image image = new Image(imageUrl, 800, imageSize, false, true);
        imageView.setImage(image);
        
        getContentContainer().getChildren().add(imageView);
        getContentContainer().setAlignment(Pos.CENTER);
   
        imageView.maxHeight(imageSize);
    

        // Initialize FileChooser
        fileChooser = new FileChooser();
        fileChooser.setTitle("Select Image");
        fileChooser.getExtensionFilters().addAll(
            new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg")
        );
    }

    public void doPreview() {
        File file = fileChooser.showOpenDialog(imageView.getScene().getWindow());
        if (file != null) {
            Image image = new Image(file.toURI().toString());
            imageView.setImage(image);
        }
    }

    public void stopPreview() {
        imageView.setImage(null);
    }
}
