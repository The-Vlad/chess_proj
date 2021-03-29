package chessgame.windows;

import chessgame.Vector2i;

import javax.swing.*;
import java.awt.*;

public abstract class Window extends JFrame {
    private final Vector2i default_size = new Vector2i(800, 600);
    Color background_color = new Color(255, 255, 207);

    public Window(){
        super("Chess Game");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(default_size.x, default_size.y);
        setVisible(true);
    }

    public Window(Vector2i size){
        super("Chess Game");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(size.x, size.y);
        setVisible(true);
    }

    //public abstract Vector2 getSize();
    public abstract Window go();
}
