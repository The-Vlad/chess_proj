package chessgame.entities;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Pole extends JPanel {
    private Cell[][] cage = new Cell[9][9];
    private Action action = new ButtonListener();

    /**
     * Создаёт поле с установленными фигурами
     * @param side длина стороны
     */
    public Pole(int side) {
        setPreferredSize(new Dimension(side, side));

        int base_icon_size = 60; // это так

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                cage[i][j] = new Cell(i, j);

                cage[i][j].addActionListener(action);//  подключаем слушателя

                cage[i][j].setPreferredSize(new Dimension(100, 100));
            }
        }

        //setDefaultCloseOperation(EXIT_ON_CLOSE);
        //setVisible(true);

        GridLayout layout = new GridLayout(8, 8, 0, 0);
        setLayout(layout);
        //добавление фигур на поле

        int icon_size = (int)(getPreferredSize().width * 0.8) / 8;
        double icon_scale =  (double)icon_size / base_icon_size;

        //black figure
        cage[0][0].figure_in_cell = new Rook('b', icon_scale);
        cage[0][1].figure_in_cell = new Knight('b', icon_scale);
        cage[0][2].figure_in_cell = new Bishop('b', icon_scale);
        cage[0][3].figure_in_cell = new Queen('b', icon_scale);
        cage[0][4].figure_in_cell = new King('b', icon_scale);
        cage[0][5].figure_in_cell = new Bishop('b', icon_scale);
        cage[0][6].figure_in_cell = new Knight('b', icon_scale);
        cage[0][7].figure_in_cell = new Rook('b', icon_scale);

        for (int i = 0; i < 8; i++) {
            cage[1][i].figure_in_cell = new Pawn('b', icon_scale);
        }

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 8; j++) {
                cage[i][j].setIcon(cage[i][j].figure_in_cell.icon_figure);
            }
        }

        //white figure
        cage[7][0].figure_in_cell = new Rook('w', icon_scale);
        cage[7][1].figure_in_cell = new Knight('w', icon_scale);
        cage[7][2].figure_in_cell = new Bishop('w', icon_scale);
        cage[7][3].figure_in_cell = new Queen('w', icon_scale);
        cage[7][4].figure_in_cell = new King('w', icon_scale);
        cage[7][5].figure_in_cell = new Bishop('w', icon_scale);
        cage[7][6].figure_in_cell = new Knight('w', icon_scale);
        cage[7][7].figure_in_cell = new Rook('w', icon_scale);
        for (int i = 0; i < 8; i++) {
            cage[6][i].figure_in_cell = new Pawn('w', icon_scale);
        }

        for (int i = 6; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                cage[i][j].setIcon(cage[i][j].figure_in_cell.icon_figure);
            }
        }

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                add(cage[i][j]);
            }
        }
    }

    public Pole() {
        //super("Game");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                cage[i][j] = new Cell(i, j);// клеткам присваиваются координаты и цвета/костыль

                cage[i][j].addActionListener(action);//  подключаем слушателя

                cage[i][j].setPreferredSize(new Dimension(100, 100));
            }
        }

        //setDefaultCloseOperation(EXIT_ON_CLOSE);
        //setVisible(true);

        GridLayout layout = new GridLayout(8, 8, 0, 0);
        setLayout(layout);
        //добавление фигур на поле

        //black figure
        cage[0][0].figure_in_cell = new Rook('b');
        cage[0][1].figure_in_cell = new Knight('b');
        cage[0][2].figure_in_cell = new Bishop('b');
        cage[0][3].figure_in_cell = new Queen('b');
        cage[0][4].figure_in_cell = new King('b');
        cage[0][5].figure_in_cell = new Bishop('b');
        cage[0][6].figure_in_cell = new Knight('b');
        cage[0][7].figure_in_cell = new Rook('b');

        for (int i = 0; i < 8; i++) {
            cage[1][i].figure_in_cell = new Pawn('b');
        }

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 8; j++) {
                cage[i][j].setIcon(cage[i][j].figure_in_cell.icon_figure);
            }
        }

        //white figure
        cage[7][0].figure_in_cell = new Rook('w');
        cage[7][1].figure_in_cell = new Knight('w');
        cage[7][2].figure_in_cell = new Bishop('w');
        cage[7][3].figure_in_cell = new Queen('w');
        cage[7][4].figure_in_cell = new King('w');
        cage[7][5].figure_in_cell = new Bishop('w');
        cage[7][6].figure_in_cell = new Knight('w');
        cage[7][7].figure_in_cell = new Rook('w');
        for (int i = 0; i < 8; i++) {
            cage[6][i].figure_in_cell = new Pawn('w');
        }

        for (int i = 6; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                cage[i][j].setIcon(cage[i][j].figure_in_cell.icon_figure);
            }
        }


        if (cage[1][1].figure_in_cell instanceof Pawn && cage[1][1].figure_in_cell.color_figure == 'b')// пример проверки
        {
        }

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                add(cage[i][j]);
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

    boolean press_cell = false;
    Cell button;

    public class ButtonListener extends AbstractAction// класс слушателя, должен  вызывать методы хода от игрока
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            int x = 0;
            int y = 0;
            Figure fig = null;

            if (press_cell == false) {
                button = (Cell) e.getSource();
                fig = button.figure_in_cell;
                press_cell = true;
            } else {
                Cell button1 = (Cell) e.getSource();
                int x_1 = button1.o_x;
                int y_1 = button1.o_y;
                Figure fig_1 = button1.figure_in_cell;
                press_cell = false;
//                button1.setBackground(Color.WHITE);

                Player.move(button, button1);
//                button1.figure_in_cell=null;

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
        } else {
            ob.setIcon(ob.figure_in_cell.icon_figure);
            System.out.println(ob.o_x);
            System.out.println(ob.o_y);
//            System.out.println(ob.getIcon().toString());
            return ob.figure_in_cell.icon_figure;
        }
    }

    /*public static void main(String[] args) {
        Pole ob=new Pole();
    }*/
}
