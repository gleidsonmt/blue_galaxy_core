package io.github.gleidsonmt.core.icons;

import io.github.gleidsonmt.core.Start;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

import java.util.Objects;

/**
 * @author Gleidson Neves da Silveira | gleidisonmt@gmail.com
 * Create on  04/07/2024
 */
public class RectIcon extends Rectangle  {
    public RectIcon(String imgName, double size) {
        this.getStyleClass().add("rect-icon");
        Image image = new Image(Objects.requireNonNull(Start.class.getResource("img/" + imgName)).toExternalForm());

        this.setWidth(size);
        this.setHeight(size);

        this.setArcHeight(20);
        this.setArcWidth(20);
//        this.setPrefSize(size, size);
//        this.setBackground(new Background(new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(size, size, true, true, true, true))));
        this.setFill(new ImagePattern(image));
//        this.setOpacity(0.8);
    }
}
