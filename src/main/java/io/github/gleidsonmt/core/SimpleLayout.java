package io.github.gleidsonmt.core;

import javafx.scene.layout.Pane;

/**
 * @author Gleidson Neves da Silveira | gleidisonmt@gmail.com
 * Create on  19/08/2024
 */
public class SimpleLayout<T extends Pane> extends Layout<T> {

    public SimpleLayout(T node) {
        super(node);
    }

}
