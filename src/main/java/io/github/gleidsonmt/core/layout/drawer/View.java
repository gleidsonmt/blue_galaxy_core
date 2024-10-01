package io.github.gleidsonmt.core.layout.drawer;

import javafx.scene.Node;
import io.github.gleidsonmt.core.layout.drawer.Module;

/**
 * @author Gleidson Neves da Silveira | gleidisonmt@gmail.com
 * Create on  19/07/2024
 */
public class View extends Module {

    protected Node content;

    public View(String name) {
        this(name, null);
    }

    public View(String name, Node content ) {
        super(name);
        this.content = content;
    }

    public View(String name, Node content, Module... children ) {
        super(name, children);
        this.content = content;
    }

    public void setContent(Node content) {
        this.content = content;
    }

    public Node getContent() {
        return content;
    }
}
