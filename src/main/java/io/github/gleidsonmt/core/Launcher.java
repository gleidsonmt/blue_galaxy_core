package io.github.gleidsonmt.core;

import io.github.gleidsonmt.core.root.IRoot;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.List;
import java.util.Objects;

/**
 * @author Gleidson Neves da Silveira | gleidisonmt@gmail.com
 * Create on  23/07/2024
 */
public abstract class Launcher extends Application {

    private final IRoot root = new IRoot();
    private IContext context;
    private Layout layout;

    private List<String> stylesheets;

    @Override
    public void start(Stage stage) throws Exception {

        context = new IContext(root);
        System.getProperties().put("context", context);
        Scene scene = new Scene(root, 800, 800);
        context.setScene(scene);

        build(context);
//        root.getChildren().add(0, layout.getRoot());

        scene.getStylesheets().addAll(
                Objects.requireNonNull(Start.class.getResource("css/colors.css")).toExternalForm(),
                Objects.requireNonNull(Start.class.getResource("css/blue_galaxy.css")).toExternalForm(),
                Objects.requireNonNull(Start.class.getResource("css/immersive_scroll.css")).toExternalForm(),
                Objects.requireNonNull(Start.class.getResource("css/shape.css")).toExternalForm(),
                Objects.requireNonNull(Start.class.getResource("css/helpers.css")).toExternalForm(),
                Objects.requireNonNull(Start.class.getResource("css/typographic.css")).toExternalForm(),
                Objects.requireNonNull(Start.class.getResource("css/drawer/variante_one.css")).toExternalForm()
        );

//        if (stylesheets != null) {
//            scene.getStylesheets().addAll(stylesheets);
//        }
        stage.setTitle("Dash View");
        stage.getIcons().add(new Image(Start.class.getResource("img/logo_68.png").toExternalForm()));
        stage.setScene(scene);
        stage.show();

//        ScenicView.show(scene);
//        CSSFX.start(stage);
    }

    public void setLayout(Layout layout) {
        this.layout = layout;
//        root.getChildren().forEach(e -> {
//            if (e.getStyleClass().contains("layout")) {
//                root.getChildren().remove(e);
//            }
//        });
        root.getChildren().clear();
        root.getChildren().add(0, layout.getRoot());
    }

    public void addStylesheets(List<String> list) {
        this.stylesheets = list;
    }

    public void addStylesheets(String... list) {
        this.stylesheets = List.of(list);
    }

    public abstract void build(Context context) throws Exception;

}
