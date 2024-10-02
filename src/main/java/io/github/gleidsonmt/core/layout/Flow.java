package io.github.gleidsonmt.core.layout;

import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Region;

/**
 * @author Gleidson Neves da Silveira | gleidisonmt@gmail.com
 * Create on  28/09/2024
 */
public interface Flow {

    void openByCursor(Region container, MouseEvent e);

    void openAbsolute(Region container, Pos position, Insets insets);

    void openRelative(Region container, Node target, double x, double y);

    void openFromLeft(Region container,  Insets insets);

    void openFromLeft(Region container);

    void slideInFromLeft(Region continer);

    void slideOutFromLeft(Region continer);

    Timeline reverse();

    void remove(Region container);
}
