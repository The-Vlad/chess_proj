package chessgame.entities;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


import chessgame.Vector3ifig;

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

    public char getColor() {
          return figure_color;
    }

}
