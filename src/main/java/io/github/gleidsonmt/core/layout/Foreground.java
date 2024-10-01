package io.github.gleidsonmt.core.layout;

import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

/**
 * @author Gleidson Neves da Silveira | gleidisonmt@gmail.com
 * Create on  23/07/2024
 */
public class Foreground extends StackPane {

    public Foreground() {
        setBackground(
                new Background(
                        new BackgroundFill(
                                Color.gray(0.5, 0.3),
                                CornerRadii.EMPTY,
                                Insets.EMPTY)
                )
        );
    }

}
