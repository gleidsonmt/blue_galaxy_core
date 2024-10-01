package io.github.gleidsonmt.core.layout;

import io.github.gleidsonmt.core.Context;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

import javax.swing.*;

/**
 * @author Gleidson Neves da Silveira | gleidisonmt@gmail.com
 * Create on  27/09/2024
 */
public class Wrapper {

    private final Foreground foreground = new Foreground();
    private final Context context;
    public Wrapper(Context context) {
        this.context = context;
    }

    public void show() {
        context.root().addChild(foreground);
    }

    public void close() {
        foreground.setOnMouseClicked(null);
        context.root().removeChild(foreground);
    }

    public void setOnClick(EventHandler<MouseEvent> eventHandler) {
        foreground.setOnMouseClicked(eventHandler);
    }

}
