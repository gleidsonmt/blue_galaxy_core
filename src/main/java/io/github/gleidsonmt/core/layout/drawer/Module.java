package io.github.gleidsonmt.core.layout.drawer;

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

import java.util.Arrays;

/**
 * @author Gleidson Neves da Silveira | gleidisonmt@gmail.com
 * Create on  19/07/2024
 */
public class Module  {

    private final ObservableList<Module> modules;
    private final String name;
    private Module parent;
    private Pane container;
    private Node graphic;

    private boolean animated;

    public Module(String name,  Module... _modules) {
        this.modules = FXCollections.observableArrayList(_modules);
        this.name = name;

        Arrays.stream(_modules).forEach(el -> el.setParent(this));

        modules.addListener((ListChangeListener<Module>) change -> {
            if(change.next()) {
                modules.forEach(e -> e.setParent(Module.this));
            }
        });

    }

    public void setAnimated(boolean animated) {
        this.animated = animated;
    }

    public ObservableList<Module> getModules() {
        return modules;
    }

    public String getName() {
        return name;
    }

    void setParent(Module parent) {
        this.parent = parent;
    }

    public Module getParent() {
        return parent;
    }

    public Pane getContainer() {
        return container;
    }

    public void setContainer(Pane container) {
        this.container = container;
    }

    public boolean isAnimated() {
        return animated;
    }

    public Node getGraphic() {
        return graphic;
    }

    public void setGraphic(Node graphic) {
        this.graphic = graphic;
    }

    @Override
    public String toString() {
        return getName();
    }


}
