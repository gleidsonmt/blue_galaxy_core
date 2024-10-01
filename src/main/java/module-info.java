module io.github.gleidsonmt.core {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.jetbrains.annotations;
    requires java.desktop;

    opens io.github.gleidsonmt.core to javafx.fxml;
    exports io.github.gleidsonmt.core;
    exports io.github.gleidsonmt.core.icons;
    exports io.github.gleidsonmt.core.layout.drawer;
    exports io.github.gleidsonmt.core.layout;
}