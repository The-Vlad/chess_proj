package chessgame.entities;

import  javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Pole  extends JFrame{
    public JPanel pole_panel = new JPanel();

     private Cell [][] cage= new Cell[9][9];
     private Action action= new ButtonListener();


    public Pole()
    {
        //super("Game");
        for (int i=0;i<8;i++)
        {
            for (int j=0;j<8;j++)
            {
                cage[i][j]= new Cell(i,j);// клеткам присваиваются координаты и цвета/костыль

                cage[i][j].addActionListener(action);//  подключаем слушателя

                cage[i][j].setPreferredSize(new Dimension(100,100));
            }
        }

        //setDefaultCloseOperation(EXIT_ON_CLOSE);
        //setVisible(true);

        GridLayout layout =new GridLayout(8,8,0,0);
        pole_panel.setLayout(layout);
        //добавление фигур на поле

        //black figure
        cage[0][0].figure_in_cell= new Rook('b');
        cage[0][1].figure_in_cell= new Knight('b');
        cage[0][2].figure_in_cell= new Bishop('b');
        cage[0][3].figure_in_cell= new Queen('b');
        cage[0][4].figure_in_cell= new King('b');
        cage[0][5].figure_in_cell= new Bishop('b');
        cage[0][6].figure_in_cell= new Knight('b');
        cage[0][7].figure_in_cell= new Rook('b');

        for(int i=0;i<8;i++)
        {
            cage[1][i].figure_in_cell=new Pawn('b');
        }

        for(int i = 0; i < 2; i++) {
            for(int j = 0; j < 8; j++) {
                cage[i][j].setIcon(cage[i][j].figure_in_cell.icon_figure);
            }
        }

        //white figure
        cage[7][0].figure_in_cell= new Rook('w');
        cage[7][1].figure_in_cell= new Knight('w');
        cage[7][2].figure_in_cell= new Bishop('w');
        cage[7][3].figure_in_cell= new Queen('w');
        cage[7][4].figure_in_cell= new King('w');
        cage[7][5].figure_in_cell= new Bishop('w');
        cage[7][6].figure_in_cell= new Knight('w');
        cage[7][7].figure_in_cell= new Rook('w');
        for(int i=0;i<8;i++)
        {
            cage[6][i].figure_in_cell=new Pawn('w');
        }

        for(int i = 6; i < 8; i++) {
            for(int j = 0; j < 8; j++) {
                cage[i][j].setIcon(cage[i][j].figure_in_cell.icon_figure);
            }
        }


        if(cage[1][1].figure_in_cell instanceof Pawn && cage[1][1].figure_in_cell.color_figure=='b')// пример проверки
        {
        }

        for (int i=0;i<8;i++)
        {
            for (int j=0;j<8;j++)
            {
                pole_panel.add(cage[i][j]);
            }
        }

        //pack();


    }


    public void updatePole() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                cage[i][j].updateTheme();
            }
        }
        }

    boolean press_cell= false;
    Cell button;
    public class ButtonListener extends AbstractAction// класс слушателя, должен  вызывать методы хода от игрока
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            int x=0;
            int y=0;
            Figure fig=null ;

            if(press_cell==false) {
                button = (Cell) e.getSource();
                fig = button.figure_in_cell;
                press_cell = true;
            }
            else
            {
                Cell button1 = (Cell) e.getSource();
                int x_1= button1.o_x;
                int y_1= button1.o_y;
                Figure fig_1=button1.figure_in_cell;
                press_cell=false;
               Player.move(button,button1);
                changeImageInCell(button);
                changeImageInCell(button1);
            }
        }
    }

    // Почему метод возвращает Icon?
    public Icon changeImageInCell(Cell ob) {
        if (ob.figure_in_cell == null) {
            ob.setIcon(null);
            return null;
        }
        else {
            ob.setIcon(ob.figure_in_cell.icon_figure);
//            System.out.println(ob.getIcon().toString());
            return ob.figure_in_cell.icon_figure;
        }
    }

    /*public static void main(String[] args) {
        Pole ob=new Pole();
    }*/
}
