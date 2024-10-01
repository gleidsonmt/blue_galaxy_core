package io.github.gleidsonmt.core.layout;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.layout.GridPane;

/**
 * @author Gleidson Neves da Silveira | gleidisonmt@gmail.com
 * Create on  25/09/2024
 */
public class ResponsiveGrid extends GridPane {

    public ResponsiveGrid() {
        widthProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                System.out.println("newValue = " + newValue);
            }
        });
    }
}
