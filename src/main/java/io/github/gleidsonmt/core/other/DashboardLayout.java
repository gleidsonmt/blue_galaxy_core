package io.github.gleidsonmt.core.other;

import io.github.gleidsonmt.core.*;
import io.github.gleidsonmt.core.layout.BreadCrumbBar;
import io.github.gleidsonmt.core.layout.drawer.Drawer;
import io.github.gleidsonmt.core.layout.drawer.Module;
import io.github.gleidsonmt.core.layout.drawer.View;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

/**
 * @author Gleidson Neves da Silveira | gleidisonmt@gmail.com
 * Create on  21/07/2024
 */
public class DashboardLayout extends Layout {

    private BorderPane root;
    private BreadCrumbBar crumb;
    private VBox body = new VBox();

    public DashboardLayout() {
        super(new BorderPane());
        root = (BorderPane) super.root;
        crumb = new BreadCrumbBar(super.currentViewProperty());
        body.getChildren().add(0, crumb);
        root.setCenter(body);
        body.setPadding(new Insets(15));


//        setContainer(root);
//        StackPane foreground = new StackPane();
//        getChildren().addAll(foreground);

//        root.centerProperty().bindBidirectional(super.currentViewProperty());

        super.currentViewProperty().addListener(new ChangeListener<Module>() {
            @Override
            public void changed(ObservableValue<? extends Module> observableValue, Module oldValue, Module newValue) {
//                System.out.println("(newValue instanceof View) = " + (newValue instanceof View));
                if (newValue instanceof View view) {
                    if (body.getChildren().size() <= 1) {
                        body.getChildren().add(1, view.getContent());
                    } else {
                        body.getChildren().set(1, view.getContent());
                    }
                }
            }
        });

    }

    public void recur(Module module) {
        if (module != null) {
            if (module instanceof View) {
                crumb.getChildren().add(0, new Hyperlink(module.getName()));
            } else {
                crumb.getChildren().add(0, new Text(module.getName()));
            }
            crumb.getChildren().add(1, new Label("/"));
            recur(module.getParent());
        }
    }

    public void setDrawer(Drawer drawer) {
        root.setLeft(drawer);
    }

//    @Override
//    protected void setView(View view) {
//
//    }
}
