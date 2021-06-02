package chessgame.entities;

public class Rook extends Figure {

    public Rook(char color, int o_x, int o_y, double icon_scale) {
        super("Rook", color, o_x, o_y, icon_scale);
    }

    public Rook(char color, int o_x, int o_y) {
        super("Rook", color, o_x, o_y, 1);
    }

    @Override
    public String getIconName() {
        if (this.color_figure == 'w') {
            return "rook_w";
        }
        return "rook";
    }
    public  boolean move_check(Cell cell_to_move, Pole pole)
    {
        // если пытаются пойти не по прямой
        if (cell_to_move.o_x != o_x && cell_to_move.o_y != o_y) {
            return false;
        }

        if(color_figure=='w' ) {
            if ((cell_to_move.figure_in_cell == null) || (cell_to_move.figure_in_cell.color_figure == 'b')) {
                int y = o_y;
                int x = o_x;
                if (y == cell_to_move.o_y && x > cell_to_move.o_x) {
                    System.out.println("hi");
                    for (int i = 0; i < 9; i++) {
                        {
                            if (x - 1 == cell_to_move.o_x) {
                                return true;
                            }
                            x--;
                            Cell cell1= pole.getCell(x,y);
                            if(cell1.figure_in_cell!=null)
                            {
                                System.out.println("Can't go");
                                return false;
                            }
                        }

                    }
                } else if (y == cell_to_move.o_y && x <cell_to_move.o_x) {
                    for (int i = 0; i < 9; i++) {
                        {
                            if ( x +1 == cell_to_move.o_x) {
                                return true;
                            }
                            x++;
                            Cell cell1= pole.getCell(x,y);
                            if(cell1.figure_in_cell!=null)
                            {
                                System.out.println("Can't go");
                                return false;
                            }
                        }
                    }
                } else if (y > cell_to_move.o_y && x ==cell_to_move.o_x) {
                    for (int i = 0; i < 9; i++) {
                        {
                            if (y - 1 == cell_to_move.o_y) {
                                return true;
                            }
                            y--;
                            Cell cell1= pole.getCell(x,y);
                            if(cell1.figure_in_cell!=null)
                            {
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
                            Cell cell1= pole.getCell(x,y);
                            if(cell1.figure_in_cell!=null)
                            {
                                System.out.println("Can't go");
                                return false;
                            }
                        }
                    }
                }
            }
        }else if(color_figure=='b' ) {
            if ((cell_to_move.figure_in_cell == null) || (cell_to_move.figure_in_cell.color_figure == 'w')) {
                int y = o_y;
                int x = o_x;
                if (y == cell_to_move.o_y && x > cell_to_move.o_x) {
                    System.out.println("hi");
                    for (int i = 0; i < 9; i++) {
                        {
                            if (x - 1 == cell_to_move.o_x) {
                                return true;
                            }
                            x--;
                            Cell cell1= pole.getCell(x,y);
                            if(cell1.figure_in_cell!=null)
                            {
                                System.out.println("Can't go");
                                return false;
                            }
                        }

                    }
                } else if (y == cell_to_move.o_y && x <cell_to_move.o_x) {
                    for (int i = 0; i < 9; i++) {
                        {
                            if ( x +1 == cell_to_move.o_x) {
                                return true;
                            }
                            x++;
                            Cell cell1= pole.getCell(x,y);
                            if(cell1.figure_in_cell!=null)
                            {
                                System.out.println("Can't go");
                                return false;
                            }
                        }
                    }
                } else if (y > cell_to_move.o_y && x ==cell_to_move.o_x) {
                    for (int i = 0; i < 9; i++) {
                        {
                            if (y - 1 == cell_to_move.o_y) {
                                return true;
                            }
                            y--;
                            Cell cell1= pole.getCell(x,y);
                            if(cell1.figure_in_cell!=null)
                            {
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
                            Cell cell1= pole.getCell(x,y);
                            if(cell1.figure_in_cell!=null)
                            {
                                System.out.println("Can't go");
                                return false;
                            }
                        }
                    }
                }
            }
        }
     return  false;
    }
}
