package chessgame.entities;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import chessgame.windows.Settings;
import org.json.JSONObject;

import javax.swing.*;

public abstract class Figure {
    public String name_figure;
    public char color_figure;

    private double icon_scale;
    public Icon icon_figure;

    public int o_x;
    public int o_y;

    public Figure(String name_figure, char color, int o_x, int o_y, double icon_scale) {
        this.name_figure = name_figure;
        this.color_figure = color;
        this.o_x = o_x;
        this.o_y = o_y;
        setIconScale(icon_scale);
        updateIcon();
    }

    public void updateIcon() {
        ImageIcon original_icon = new ImageIcon(Settings.getFigureTheme() + "/" + getIconName() + ".png");

        if (icon_scale != 1) {
            Image scaled_icon_image = original_icon.getImage().getScaledInstance(
                    (int)(icon_scale * original_icon.getIconWidth()), (int)(icon_scale * original_icon.getIconHeight()),  java.awt.Image.SCALE_SMOOTH);
            icon_figure = new ImageIcon(scaled_icon_image);
        }
        else {
            icon_figure = original_icon;
        }
    }

    public void setIconScale(double icon_scale) {
        this.icon_scale = icon_scale;
    }

    /**
     *
     * @return название файла иконки без расширения
     */
    public abstract String getIconName();

    public abstract boolean move_check(Cell cell,Cell cellToMove,Pole pole);

    public static void main(String[] args) {
//        Figure figure = new Figure("name");
//        System.out.println(figure.theme.get());
    }
}