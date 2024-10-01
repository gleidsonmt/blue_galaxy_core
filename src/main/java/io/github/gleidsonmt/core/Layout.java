package io.github.gleidsonmt.core;

import io.github.gleidsonmt.core.layout.Flow;
import io.github.gleidsonmt.core.layout.Foreground;
import io.github.gleidsonmt.core.layout.Wrapper;
import io.github.gleidsonmt.core.layout.drawer.Drawer;
import javafx.animation.Timeline;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import io.github.gleidsonmt.core.layout.drawer.Module;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;

import java.util.Stack;

/**
 * @author Gleidson Neves da Silveira | gleidisonmt@gmail.com
 * Create on  21/07/2024
 */
public abstract class Layout<T extends Pane> {

    private final ObjectProperty<Module> currentView = new SimpleObjectProperty<>();

    protected T root;
    private final Context context;

    protected final Flow flow;
    protected final Wrapper wrapper;

    public Layout(T node) {
        this.root = node;
        this.root.setId("layout");
        context = (Context) System.getProperties().get("context");
        wrapper = new Wrapper(context);
        flow = context.flow();
    }

    public ObjectProperty<Module> currentViewProperty() {
        return currentView;
    }

    public void setCurrentView(Module currentView) {
        this.currentView.set(currentView);
    }

    public T getRoot() {
        return root;
    }

    public void setRoot(T root) {
        this.root = root;
    }

    protected void openDrawer(Region drawer) {
        wrapper.show();
        flow.slideFromLeft(drawer);
        wrapper.setOnClick(e -> {
            Timeline timeline = flow.reverse();
            timeline.setOnFinished(ev -> {
                closeDrawer(drawer);
                drawer.setTranslateX(0);
                timeline.setOnFinished(null);
            });
        });
    }

    protected void closeDrawer(Region region) {
        flow.remove(region);
        wrapper.close();
    }

//    private void open(Pane drawer, DrawerDirection direction) {
//        context.root().addChild(drawer, Pos.CENTER_LEFT);
//        drawer.setTranslateY(drawer.mi);
//    }

    public enum DrawerDirection {
        LEFT, RIGHT
    }

}
