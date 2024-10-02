package io.github.gleidsonmt.core.layout;

import io.github.gleidsonmt.core.root.IRoot;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

/**
 * @author Gleidson Neves da Silveira | gleidisonmt@gmail.com
 * Create on  28/09/2024
 */
public class IFlow implements Flow {

    private IRoot root;

    private Timeline timeline = new Timeline();

    public IFlow(IRoot root) {
        this.root = root;
    }

    @Override
    public void openByCursor(Region container, MouseEvent e) {
        if (root.getChildren().contains(container)) return;
        root.getChildren().add(container);

        container.setMaxSize(Region.USE_PREF_SIZE, Region.USE_PREF_SIZE);

        StackPane.clearConstraints(container);
        StackPane.setAlignment(container, Pos.TOP_LEFT);

        var scene = container.getScene();

        double widthNeeded = e.getSceneX() + container.getPrefWidth();
        double heightNeeded = e.getSceneY() + container.getPrefHeight();

        double widthAvailable = scene.getWidth();
        double heightAvailable = scene.getHeight();

        container.setTranslateX(widthNeeded > widthAvailable ? widthAvailable - 200 : e.getSceneX());
        container.setTranslateY(heightNeeded > heightAvailable ? heightAvailable - 200 : e.getSceneY());
    }


    @Override
    public void openAbsolute(Region container, Pos position, Insets insets) {
        StackPane.clearConstraints(container);
        container.setMaxSize(Region.USE_PREF_SIZE, Region.USE_PREF_SIZE);

        StackPane.setAlignment(container, position);
        StackPane.setMargin(container, insets);

        root.addChild(container);

    }

    @Override
    public void openFromLeft(Region container, Insets insets) {
        openAbsolute(container, Pos.CENTER_LEFT, insets);
        container.setMaxHeight(Region.USE_COMPUTED_SIZE);
    }

    @Override
    public void openFromLeft(Region container) {
        openFromLeft(container, Insets.EMPTY);
    }

    @Override
    public void slideInFromLeft(Region container) {
        openFromLeft(container);
//        container.setTranslateX(0);
        timeline.getKeyFrames().setAll(
                new KeyFrame(Duration.ZERO, new KeyValue(
                        container.translateXProperty(), container.getWidth() * -1
                )),
                new KeyFrame(Duration.millis(200), new KeyValue(
                        container.translateXProperty(), 0
                ))
        );
        timeline.setOnFinished(e -> container.setTranslateX(0));
        timeline.setRate(1);
        timeline.play();
    }

    @Override
    public void slideOutFromLeft(Region container) {
        if (!root.getChildren().contains(container)){
            openFromLeft(container);
        }
//
//        container.setTranslateX(0);
        timeline.getKeyFrames().setAll(
                new KeyFrame(Duration.ZERO, new KeyValue(
                        container.translateXProperty(), 0
                )),
                new KeyFrame(Duration.millis(200), new KeyValue(
                        container.translateXProperty(), container.getWidth() * -1
                ))
        );
        timeline.setOnFinished(e -> {
            root.removeChild(container);
            container.setTranslateX(0);
        });
        timeline.setRate(1);
        timeline.play();
    }

    @Override
    public Timeline reverse() {
        timeline.setRate(-1);
        timeline.play();
        return timeline;
    }

    @Override
    public void remove(Region container) {
        root.removeChild(container);
    }

    public void openRelative(Region container, Node target, double x, double y) {

        StackPane.clearConstraints(container);
//        StackPane.setMargin(container, new Insets(10));
        container.setMaxSize(Region.USE_PREF_SIZE, Region.USE_PREF_SIZE);

        StackPane.setAlignment(container, Pos.TOP_LEFT);

        root.getChildren().add(container);

        double diffX = target.getScene().getWidth() - x;
        double diffY = target.getScene().getHeight() - y;

        Bounds bounds = target.localToScene(target.getLayoutBounds());

        double totalWidth = bounds.getMaxX() + container.getPrefWidth();
        double totalHeight = bounds.getMaxY() + container.getPrefHeight();

        container.setTranslateX(bounds.getMinX());
        container.setTranslateY(bounds.getMaxY());

        container.setOnMouseExited(e -> {
            root.getChildren().remove(container);
        });

        if (totalWidth > diffX) {
            container.setTranslateX((target.getScene().getWidth() - container.getPrefWidth()) - x);
//            container.setTranslateX( bounds.getMaxX() );
        } else {
            container.setTranslateX((bounds.getMinX()) + x);
        }

        if (totalHeight > diffY) {
            container.setTranslateY((target.getScene().getHeight() - container.getPrefHeight()) - y);
        } else {
            container.setTranslateY((bounds.getMaxY()) + y);
        }

//        if (diffX < container.getPrefWidth() && diffY < container.getPrefHeight()) {
//            container.setTranslateX((target.getScene().getWidth() - container.getPrefWidth())); // 10 eh um padding pra nao deixar juntinho demais
//            container.setTranslateY((target.getScene().getHeight() - container.getPrefHeight()) );
//        } else if (diffY < container.getPrefHeight()) {
//            container.setTranslateX(x);
//            container.setTranslateY((target.getScene().getHeight() - container.getPrefHeight()) );
//        } else if (diffX < container.getWidth()) {
//            System.out.println("first");
//
//            container.setTranslateX((target.getScene().getWidth() - container.getPrefWidth()) );
//            container.setTranslateY(y);
//        } else {
//            container.setTranslateX( bounds.getMinX() - x);
//            container.setTranslateY( bounds.getMaxY() + y);
//        }


    }
}
