package io.github.gleidsonmt.core.root;

import io.github.gleidsonmt.core.layout.Foreground;
import javafx.geometry.Pos;
import javafx.scene.Node;

/**
 * @author Gleidson Neves da Silveira | gleidisonmt@gmail.com
 * Create on  23/07/2024
 */
public interface Root {

    void addChild( Node node);

    void addChild( Node node, Pos pos);

    void addChild(int index, Node node, Pos pos);

    void addChild(int index, Node node);

    void removeChild(Node node);
}
