package chessgame.windows;

import chessgame.Vector2i;

import javax.swing.*;
import java.awt.*;

public interface IWindow {
    final Vector2i default_size = new Vector2i(800, 600);
    Color background_color = new Color(255, 255, 207);
}
