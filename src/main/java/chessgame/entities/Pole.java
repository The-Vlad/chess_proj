package chessgame.entities;

import chessgame.Vector3ifig;

import  javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class Pole extends JPanel {
    private Cell[][] cage = new Cell[9][9];
    private Action action;

    private King white_king;
    private King black_king;
    private ArrayList<Figure> figures = new ArrayList<>();

    /**
     * Создаёт поле с установленными фигурами
     * @param side длина стороны
     */
    public Pole(int side, AbstractAction on_cell_click) {
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

        action = on_cell_click;

        GridLayout layout = new GridLayout(8, 8, 0, 0);
        setLayout(layout);
        //добавление фигур на поле

        int icon_size = (int)(getPreferredSize().width * 0.8) / 8;
        double icon_scale =  (double)icon_size / base_icon_size;

        //black figure
        black_king = new King('b', 0, 4, icon_scale);
        cage[0][0].figure_in_cell = new Rook('b', 0, 0, icon_scale);
        cage[0][1].figure_in_cell = new Knight('b', 0, 1, icon_scale);
        cage[0][2].figure_in_cell = new Bishop('b', 0, 2, icon_scale);
        cage[0][3].figure_in_cell = new Queen('b', 0, 3, icon_scale);
        cage[0][4].figure_in_cell = black_king;
        cage[0][5].figure_in_cell = new Bishop('b', 0, 5, icon_scale);
        cage[0][6].figure_in_cell = new Knight('b', 0, 6, icon_scale);
        cage[0][7].figure_in_cell = new Rook('b', 0, 7, icon_scale);

        for (int i = 0; i < 8; i++) {
            cage[1][i].figure_in_cell = new Pawn('b', 1, i, icon_scale);

            figures.add(cage[0][i].figure_in_cell);
            figures.add(cage[1][i].figure_in_cell);
        }

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 8; j++) {
                cage[i][j].setIcon(cage[i][j].figure_in_cell.icon_figure);
            }
        }

        //white figure
        white_king = new King('w', 7, 4, icon_scale);
        cage[7][0].figure_in_cell = new Rook('w', 7, 0, icon_scale);
        cage[7][1].figure_in_cell = new Knight('w', 7, 1, icon_scale);
        cage[7][2].figure_in_cell = new Bishop('w', 7, 2, icon_scale);
        cage[7][3].figure_in_cell = new Queen('w', 7, 3, icon_scale);
        cage[7][4].figure_in_cell = white_king;
        cage[7][5].figure_in_cell = new Bishop('w', 7, 5, icon_scale);
        cage[7][6].figure_in_cell = new Knight('w', 7, 6, icon_scale);
        cage[7][7].figure_in_cell = new Rook('w', 7, 7, icon_scale);


        for (int i = 0; i < 8; i++) {
            cage[6][i].figure_in_cell = new Pawn('w', 6, i, icon_scale);

            figures.add(cage[7][i].figure_in_cell);
            figures.add(cage[6][i].figure_in_cell);
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

    public Pole(AbstractAction on_cell_click) {
        this.action = on_cell_click;

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
        black_king = new King('b', 0, 4);
        cage[0][0].figure_in_cell = new Rook('b', 0, 0);
        cage[0][1].figure_in_cell = new Knight('b', 0, 1);
        cage[0][2].figure_in_cell = new Bishop('b', 0, 2);
        cage[0][3].figure_in_cell = new Queen('b', 0, 3);
        cage[0][4].figure_in_cell = black_king;
        cage[0][5].figure_in_cell = new Bishop('b', 0, 5);
        cage[0][6].figure_in_cell = new Knight('b', 0, 6);
        cage[0][7].figure_in_cell = new Rook('b', 0, 7);

        for (int i = 0; i < 8; i++) {
            cage[1][i].figure_in_cell = new Pawn('b', 1, i);

            figures.add(cage[0][i].figure_in_cell);
            figures.add(cage[1][i].figure_in_cell);
        }

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 8; j++) {
                cage[i][j].setIcon(cage[i][j].figure_in_cell.icon_figure);
            }
        }

        //white figure
        white_king = new King('w', 7, 4);

        cage[7][0].figure_in_cell = new Rook('w', 7, 0);
        cage[7][1].figure_in_cell = new Knight('w', 7, 1);
        cage[7][2].figure_in_cell = new Bishop('w', 7, 2);
        cage[7][3].figure_in_cell = new Queen('w', 7, 3);
        cage[7][4].figure_in_cell = white_king;
        cage[7][5].figure_in_cell = new Bishop('w', 7, 5);
        cage[7][6].figure_in_cell = new Knight('w', 7, 6);
        cage[7][7].figure_in_cell = new Rook('w', 7, 7);
        for (int i = 0; i < 8; i++) {
            cage[6][i].figure_in_cell = new Pawn('w', 6, i);

            figures.add(cage[7][i].figure_in_cell);
            figures.add(cage[6][i].figure_in_cell);
        }

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                add(cage[i][j]);
            }
        }

        //pack();


    }

    public   Cell getCell(int x,int y) {
        return cage[x][y];
    }

    public void updatePole() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                cage[i][j].updateTheme();
            }
        }
    }

    public void moveFigure(Cell cell, Cell cell_to_move) {
        if (cell_to_move.figure_in_cell != null) {
            removeFigure(cell_to_move);
        }

        cell_to_move.figure_in_cell = cell.figure_in_cell;
        cell_to_move.figure_in_cell.o_x = cell_to_move.o_x;
        cell_to_move.figure_in_cell.o_y = cell_to_move.o_y;
        cell.figure_in_cell = null;
        changeImageInCell(cell);
        changeImageInCell(cell_to_move);
    }

    public void moveFigure(Figure figure, Cell cell_to_move) {
        moveFigure(cage[figure.o_x][figure.o_y], cell_to_move);
    }

    public void moveFigure(Figure figure, Figure figure_to_eat) {
        moveFigure(cage[figure.o_x][figure.o_y], cage[figure_to_eat.o_x][figure_to_eat.o_y]);
    }

    public void removeFigure(Cell cell) {
        removeFigure(cell.figure_in_cell);
    }

    public void removeFigure(Figure figure) {
        figures.remove(figure);
    }

    // Почему метод возвращает Icon?
    private Icon changeImageInCell(Cell ob) {
        if (ob.figure_in_cell == null) {
            ob.setIcon(null);
            return null;
        } else {
            ob.setIcon(ob.figure_in_cell.icon_figure);
            return ob.figure_in_cell.icon_figure;
        }
    }

    public ArrayList<Figure> getFigures() {
        return figures;
    }

    public King getWhiteKing() {
        return white_king;
    }

    public King getBlackKing() {
        return black_king;
    }

}
