package chessgame.entities;

import chessgame.windows.Settings;

import javax.swing.*;
import java.awt.*;

public class Cell extends JButton {

    public Figure figure_in_cell=null;
    public int o_x;
    public int o_y;
    public Color color;

    public Cell(int x, int y) {
        o_x = x;
        o_y = y;

        if ((o_x + o_y) % 2 == 0) {
            color = Settings.getPoleTheme().get("white");
        }
        else {
            color = Settings.getPoleTheme().get("black");
        }

        this.setBackground(color);
    }

    public void updateTheme() {
        if ((o_x + o_y) % 2 == 0) {
            color = Settings.getPoleTheme().get("white");
        }
        else {
            color = Settings.getPoleTheme().get("black");
        }
        this.setBackground(color);
        if (figure_in_cell != null) {
            figure_in_cell.updateIcon();
            setIcon(figure_in_cell.icon_figure);
        }
    }
}
