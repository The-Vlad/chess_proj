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
    public   void move(int x_in_cell,int y_in_cell,Figure figure_in_cell, int x_cell_to_move, int y_cell_to_move)
    {
        if(figure_in_cell instanceof Pawn)
        {
            if(((Pawn) figure_in_cell).first_move==true  && figure_in_cell.color_figure=='w')
            {

            }

        }

    }


}
