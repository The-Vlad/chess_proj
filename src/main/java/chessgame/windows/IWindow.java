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
    final Vector2i default_size = new Vector2i(1000, 900);

    /**
     * Background color of main theme
     */
    Color background_color = new Color(247,238,155);
    Color background_color2 = new Color(144,144,144);
}
