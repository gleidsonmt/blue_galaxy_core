package io.github.gleidsonmt.core.root;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.StackPane;

/**
 * @author Gleidson Neves da Silveira | gleidisonmt@gmail.com
 * Create on  23/07/2024
 */
public class IRoot extends StackPane implements Root {

     public IRoot() {
         setId("root");
    }

    @Override
    public void addChild( Node node) {
        getChildren().add( node);
    }

    @Override
    public void addChild( Node node, Pos pos) {
        getChildren().add( node);
        StackPane.setAlignment(node, pos);
    }

    @Override
    public void addChild(int index, Node node) {
         getChildren().add(index, node);
    }

    @Override
    public void addChild(int index, Node node, Pos pos) {
        getChildren().add(index, node);
        StackPane.setAlignment(node, pos);
    }

    @Override
    public void removeChild(Node node) {
        getChildren().remove(node);
    }
}
