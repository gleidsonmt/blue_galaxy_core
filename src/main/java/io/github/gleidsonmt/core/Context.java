package io.github.gleidsonmt.core;


import io.github.gleidsonmt.core.layout.Flow;
import io.github.gleidsonmt.core.layout.Foreground;
import io.github.gleidsonmt.core.root.Root;
import javafx.scene.Scene;

/**
 * @author Gleidson Neves da Silveira | gleidisonmt@gmail.com
 * Create on  23/07/2024
 */
public interface Context {

     void setLayout(Layout layout);

     Scene scene();

     Root root();

     Flow flow();
}
