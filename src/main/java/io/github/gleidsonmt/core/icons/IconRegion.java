package io.github.gleidsonmt.core.icons;

import io.github.gleidsonmt.core.Start;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

import java.util.Objects;

/**
 * @author Gleidson Neves da Silveira | gleidisonmt@gmail.com
 * Create on  02/07/2024
 */
public class IconRegion extends Region {

    public IconRegion(String imgName) {
        this(imgName, 20);
    }

    public IconRegion(String imgName, double size) {
        this.getStyleClass().add("icon");
        Image image = new Image(Objects.requireNonNull(Start.class.getResource("img/" + imgName)).toExternalForm());

        this.setMinSize(size, size);
        this.setBackground(new Background(new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(size, size, true, true, true, false))));

//        this.setOpacity(0.8);
    }
}
