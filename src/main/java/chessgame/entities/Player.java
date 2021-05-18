package chessgame.entities;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Player {

    ArrayList <Figure> mas_eating_figure= new ArrayList<Figure>();// массив в котором будут храниться съединные фигуры
    char figure_color;
    boolean turn_move = false;// очередь хода
      public Player(char figure_color)
    {
        this.figure_color=figure_color;
        if(this.figure_color=='w')
        {
         turn_move=true;
        }

    }
     static public boolean move(int x_in_cell,int y_in_cell,Figure figure_in_cell, int x_cell_to_move, int y_cell_to_move,Figure figure_in_cell_to_move)//x=y and y=x to coord
    {
        System.out.println(figure_in_cell);
        if (figure_in_cell instanceof Pawn) {

            if (figure_in_cell.color_figure == 'w') {
                System.out.println("Hello world!");
                if ((y_in_cell == y_cell_to_move && x_in_cell - 1 == y_cell_to_move) || (y_in_cell == y_cell_to_move && x_in_cell - 2 == x_cell_to_move)) {
                    figure_in_cell = null;
                    figure_in_cell_to_move = figure_in_cell;
                    System.out.println("Hello world!");
                    return true;

                }
            }
        }
        return false;
    }
}
