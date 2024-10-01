package io.github.gleidsonmt.core;

import io.github.gleidsonmt.core.layout.Flow;
import io.github.gleidsonmt.core.layout.Foreground;
import io.github.gleidsonmt.core.layout.IFlow;
import io.github.gleidsonmt.core.root.IRoot;
import io.github.gleidsonmt.core.root.Root;
import javafx.scene.Scene;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.TestOnly;

/**
 * @author Gleidson Neves da Silveira | gleidisonmt@gmail.com
 * Create on  23/07/2024
 */
public class IContext implements Context {

//    private Node layout;
    private Foreground foreground;
    private Scene scene;

    private final IRoot root;
    private final IFlow flow;

    public IContext(IRoot root) {
        this.root = root;
        flow = new IFlow(root);
//        foreground = new Foreground();
    }

    @Override
    public void setLayout(Layout layout) {
//        this.layout = layout;
        if (!((IRoot) this.root).getChildren().isEmpty()) {
            ((IRoot) this.root).getChildren().set(0, layout.getRoot());
        } else {
            System.out.println("pass");

            ((IRoot) this.root).getChildren().add(0, layout.getRoot());
        }
    }

//    @Override
//    public Node getLayout() {
//        return this.layout;
//    }

    @Override
    public Scene scene() {
        return this.scene;
    }

    @TestOnly
    @ApiStatus.Internal
    @Override
    public Root root() {
        return this.root;
    }

    @Override
    public Flow flow() {
        return flow;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }
}
