package chessgame.entities;

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

    public Icon icon_figure;

    public Figure(String name_figure, char color) {
        this.name_figure = name_figure;
        this.color_figure = color;
        updateIcon();
    }

    public void updateIcon() {
        icon_figure = new ImageIcon(Settings.getFigureTheme() + "/" + getIconName() + ".png");
    }

    /**
     *
     * @return название файла иконки без расширения
     */
    public abstract String getIconName();

    public static void main(String[] args) {
//        Figure figure = new Figure("name");
//        System.out.println(figure.theme.get());
    }
}