package chessgame.entities;

public class Queen extends Figure {
    public Queen(char color, int o_x, int o_y, double icon_scale) {
        super("King", color, o_x, o_y, icon_scale);
    }

    public Queen(char color, int o_x, int o_y) {
        super("Queen", color, o_x, o_y, 1);
    }

    @Override
    public String getIconName() {
        if (this.color_figure == 'w') {
            return "queen_w";
        }
        return "queen";
    }

    public boolean move_check(Cell cell_to_move, Pole pole) {
        System.out.println(o_y + " " + o_x);
        System.out.println(cell_to_move.o_y + " " + cell_to_move.o_x);
        int y = o_y;
        int x = o_x;
        char opposite_color;
        if (color_figure == 'w') {
            opposite_color = 'b';
        }
        else {
            opposite_color = 'w';
        }

        // если пытаются идти не по прямой и не по диагонали
        if (Math.abs(cell_to_move.o_x - o_x) != Math.abs(cell_to_move.o_y - o_y) && cell_to_move.o_x != o_x && cell_to_move.o_y != o_y) {
            return false;
        }

        if ((cell_to_move.figure_in_cell == null) || (cell_to_move.figure_in_cell.color_figure == opposite_color)) {


            if (y > cell_to_move.o_y && x > cell_to_move.o_x) {
                for (int i = 0; i < 9; i++) {
                    {
                        if (y - 1 == cell_to_move.o_y && x - 1 == cell_to_move.o_x) {
                            return true;
                        }
                        y--;
                        x--;
                        Cell cell1 = pole.getCell(x, y);
                        if (cell1.figure_in_cell != null) {
                            System.out.println("Can't go");
                            return false;
                        }
                    }

                }
            } else if (y < cell_to_move.o_y && x > cell_to_move.o_x) {
                for (int i = 0; i < 9; i++) {
                    {
                        if (y + 1 == cell_to_move.o_y && x - 1 == cell_to_move.o_x) {
                            return true;
                        }
                        y++;
                        x--;
                        Cell cell1 = pole.getCell(x, y);
                        if (cell1.figure_in_cell != null) {
                            System.out.println("Can't go");
                            return false;
                        }
                    }
                }
            } else if (y > cell_to_move.o_y && x < cell_to_move.o_x) {
                for (int i = 0; i < 9; i++) {
                    {
                        if (y - 1 == cell_to_move.o_y && x + 1 == cell_to_move.o_x) {
                            return true;
                        }
                        y--;
                        x++;
                        Cell cell1 = pole.getCell(x, y);
                        if (cell1.figure_in_cell != null) {
                            System.out.println("Can't go");
                            return false;
                        }
                    }
                }
            } else if (y < cell_to_move.o_y && x < cell_to_move.o_x) {
                for (int i = 0; i < 9; i++) {
                    {
                        if (y + 1 == cell_to_move.o_y && x + 1 == cell_to_move.o_x) {
                            return true;
                        }
                        y++;
                        x++;
                        Cell cell1 = pole.getCell(x, y);
                        if (cell1.figure_in_cell != null) {
                            System.out.println("Can't go");
                            return false;
                        }
                    }
                }
            } else if (y == cell_to_move.o_y && x > cell_to_move.o_x) {
                System.out.println("hi");
                for (int i = 0; i < 9; i++) {
                    {
                        if (x - 1 == cell_to_move.o_x) {
                            return true;
                        }
                        x--;
                        Cell cell1 = pole.getCell(x, y);
                        if (cell1.figure_in_cell != null) {
                            System.out.println("Can't go");
                            return false;
                        }
                    }

                }
            } else if (y == cell_to_move.o_y && x < cell_to_move.o_x) {
                for (int i = 0; i < 9; i++) {
                    {
                        if (x + 1 == cell_to_move.o_x) {
                            return true;
                        }
                        x++;
                        Cell cell1 = pole.getCell(x, y);
                        if (cell1.figure_in_cell != null) {
                            System.out.println("Can't go");
                            return false;
                        }
                    }
                }
            } else if (y > cell_to_move.o_y && x == cell_to_move.o_x) {
                for (int i = 0; i < 9; i++) {
                    {
                        if (y - 1 == cell_to_move.o_y) {
                            return true;
                        }
                        y--;
                        Cell cell1 = pole.getCell(x, y);
                        if (cell1.figure_in_cell != null) {
                            System.out.println("Can't go");
                            return false;
                        }
                    }
                }
            } else if (y < cell_to_move.o_y && x == cell_to_move.o_x) {
                for (int i = 0; i < 9; i++) {
                    {
                        if (y + 1 == cell_to_move.o_y) {
                            return true;
                        }
                        y++;
                        Cell cell1 = pole.getCell(x, y);
                        if (cell1.figure_in_cell != null) {
                            System.out.println("Can't go");
                            return false;
                        }
                    }
                }
            }
        }


        return  false;
    }
}




