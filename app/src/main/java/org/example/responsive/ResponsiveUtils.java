package org.example.responsive;

import javafx.scene.Node;
import javafx.scene.layout.Region;
import org.example.enums.SIZES;

public class ResponsiveUtils {

    public static void responsiveHeigth(Region nodeChild, Region nodeParent ){

        //Large
        if(nodeParent.getHeight() <= SIZES.BIG_HEIGHT){

            nodeChild.setMaxHeight(nodeParent.getHeight() *  0.5 );
            nodeChild.setMinHeight(nodeParent.getHeight() *  0.5 );
        }

        //Medium
        if(nodeParent.getHeight() <= SIZES.MEDIUM_HEIGHT){
            nodeChild.setMaxHeight(nodeParent.getHeight() * 0.7 );
            nodeChild.setMinHeight(nodeParent.getHeight() * 0.7 );
        }

        //Short
        if(nodeParent.getHeight() <= SIZES.SHORT_HEIGHT){
            nodeChild.setMaxHeight(nodeParent.getHeight() * 0.8 );
            nodeChild.setMinHeight(nodeParent.getHeight() * 0.8 );
        }
    }
}
