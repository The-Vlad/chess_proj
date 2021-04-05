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
                if ((i + j) % 2 == 0) {
                    cage[i][j].setBackground(Color.MAGENTA);
                }
                else {
                    cage[i][j].setBackground(Color.BLUE);
                }
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
            cage[1][i].icon_figure= new ImageIcon("figure/pawn.png");
            cage[1][i].setIcon(cage[1][i].icon_figure);
        }

        cage[0][2].icon_figure=new ImageIcon("figure/bishop.png");
        cage[0][2].setIcon( cage[0][2].icon_figure);
        cage[0][5].icon_figure=new ImageIcon("figure/bishop.png");
        cage[0][5].setIcon( cage[0][5].icon_figure);
        cage[0][1].icon_figure=new ImageIcon("figure/knight.png");
        cage[0][1].setIcon( cage[0][1].icon_figure);
        cage[0][6].icon_figure=new ImageIcon("figure/knight.png");
        cage[0][6].setIcon( cage[0][6].icon_figure);
        cage[0][4].icon_figure=new ImageIcon("figure/king.png");
        cage[0][4].setIcon( cage[0][4].icon_figure);
        cage[0][3].icon_figure=new ImageIcon("figure/queen.png");
        cage[0][3].setIcon( cage[0][3].icon_figure);
        cage[0][0].icon_figure=new ImageIcon("figure/rook.png");
        cage[0][0].setIcon( cage[0][0].icon_figure);
        cage[0][7].icon_figure=new ImageIcon("figure/rook.png");
        cage[0][7].setIcon( cage[0][7].icon_figure);

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
            cage[6][i].icon_figure= new ImageIcon("figure/pawn_w.png");
            cage[6][i].setIcon(cage[6][i].icon_figure);
        }
        cage[7][2].icon_figure=new ImageIcon("figure/bishop_w.png");
        cage[7][2].setIcon( cage[7][2].icon_figure);
        cage[7][5].icon_figure=new ImageIcon("figure/bishop_w.png");
        cage[7][5].setIcon( cage[7][5].icon_figure);
        cage[7][1].icon_figure=new ImageIcon("figure/knight_w.png");
        cage[7][1].setIcon( cage[7][1].icon_figure);
        cage[7][6].icon_figure=new ImageIcon("figure/knight_w.png");
        cage[7][6].setIcon( cage[7][6].icon_figure);
        cage[7][4].icon_figure=new ImageIcon("figure/king_w.png");
        cage[7][4].setIcon( cage[7][4].icon_figure);
        cage[7][3].icon_figure=new ImageIcon("figure/queen_w.png");
        cage[7][3].setIcon( cage[7][3].icon_figure);
        cage[7][0].icon_figure=new ImageIcon("figure/rook_w.png");
        cage[7][0].setIcon( cage[7][0].icon_figure);
        cage[7][7].icon_figure=new ImageIcon("figure/rook_w.png");
        cage[7][7].setIcon( cage[7][7].icon_figure);



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

    public class ButtonListener extends AbstractAction// класс слушателя, должен  вызывать методы хода от игрока
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            JButton button=(JButton)e.getSource();
            button.setBackground(Color.WHITE);
        }
    }

    /*public static void main(String[] args) {
        Pole ob=new Pole();
    }*/
}
