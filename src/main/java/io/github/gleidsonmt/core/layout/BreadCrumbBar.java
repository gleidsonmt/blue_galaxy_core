package io.github.gleidsonmt.core.layout;

import io.github.gleidsonmt.core.layout.drawer.Module;
import io.github.gleidsonmt.core.layout.drawer.View;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.geometry.Pos;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Text;

/**
 * @author Gleidson Neves da Silveira | gleidisonmt@gmail.com
 * Create on  29/07/2024
 */
public class BreadCrumbBar extends FlowPane {

    public enum Variant {
        VARIANT_ONE, VARIANT_TWO
    }

    private ObjectProperty<Module> currentModule;

    public BreadCrumbBar(ObjectProperty<Module> currentModule) {
        setAlignment(Pos.CENTER_LEFT);
        setHgap(5);
        this.currentModule = new SimpleObjectProperty<>();
        this.currentModule.bindBidirectional(currentModule);

        this.currentModule.addListener((observableValue, module, newValue) -> {
            getChildren().clear();
            recur(newValue);
            if (getChildren().size() > 1) getChildren().remove(getChildren().size() - 1);

        });
    }

    public void recur(Module module) {
        if (module != null) {
            if (module instanceof View view) {
                getChildren().add(0, createLink(module));
            } else {
                getChildren().add(0, createText(module));
            }
            getChildren().add(1, createSeparator());
            recur(module.getParent());
        }
    }

    private Hyperlink createLink(Module module) {
        Hyperlink text = new Hyperlink(module.getName());
        text.setOnAction(e -> {
            currentModule.set(module);
        });
        text.setStyle("-fx-font-weight: bold;");
        return text;
    }

    private Text createText(Module module) {
        Text text = new Text(module.getName());
        text.setStyle("-fx-font-weight: bold;");
        return text;
    }

    private Label createSeparator() {
        Label label = new Label("/");
        return label;
    }
}