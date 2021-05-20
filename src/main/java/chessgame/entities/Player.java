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
     static public boolean move(Cell cell,Cell cell_to_move)
    {
        if (cell.figure_in_cell instanceof Pawn) {

            if (cell.figure_in_cell.color_figure == 'w') {
                if (cell.o_y == cell_to_move.o_y && (cell.o_x - 1 == cell_to_move.o_x || cell.o_x - 2 == cell_to_move.o_x)) {
                    cell_to_move.figure_in_cell = cell.figure_in_cell;
                    cell.figure_in_cell = null;
                    return true;

                }
            }
        }
        return false;
    }
}
