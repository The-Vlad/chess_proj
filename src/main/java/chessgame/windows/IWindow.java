package chessgame.windows;

import chessgame.Vector2i;

import javax.swing.*;
import java.awt.*;

/**
 * Interface that contains all constants for Window components
 */
public interface IWindow {
    /**
     * Default size of Window represent by Vector2i
     */
    final Vector2i default_size = new Vector2i(800, 600);

    /**
     * Background color of main theme
     */
    Color background_color = new Color(255, 255, 207);
}
