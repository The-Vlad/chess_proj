package chessgame.entities;

public class Bishop extends Figure {

    public Bishop(char color, double icon_scale) {
        super("King", color, icon_scale);
    }

    public Bishop(char color) {
        super("Bishop", color, 1);
    }

    @Override
    public String getIconName() {
        if (this.color_figure == 'w') {
            return "bishop_w";
        }
        return "bishop";
    }
    public  boolean move_check(Cell cell,Cell cell_to_move)
    {
        System.out.println(cell.o_y+" "+ cell.o_x);
        System.out.println(cell_to_move.o_y+" "+cell_to_move.o_x);
        if(cell.figure_in_cell.color_figure=='w' ) {
            if ((cell_to_move.figure_in_cell == null) || (cell_to_move.figure_in_cell.color_figure == 'b')) {
                int y = cell.o_y;
                int x = cell.o_x;
                if (y > cell_to_move.o_y && x > cell_to_move.o_x) {
                    for (int i = 0; i < 9; i++) {
                        {
                            if (y == cell_to_move.o_y && x == cell_to_move.o_x) {
                                cell_to_move.figure_in_cell = cell.figure_in_cell;
                                cell.figure_in_cell = null;
                                return true;
                            }
                            y--;
                            x--;
                        }

                    }
                } else if (y < cell_to_move.o_y && x > cell_to_move.o_x) {
                    for (int i = 0; i < 9; i++) {
                        {
                            if (y == cell_to_move.o_y && x == cell_to_move.o_x) {
                                cell_to_move.figure_in_cell = cell.figure_in_cell;
                                cell.figure_in_cell = null;
                                return true;
                            }
                            y++;
                            x--;
                        }
                    }
                } else if (y > cell_to_move.o_y && x < cell_to_move.o_x) {
                    for (int i = 0; i < 9; i++) {
                        {
                            if (y == cell_to_move.o_y && x == cell_to_move.o_x) {
                                cell_to_move.figure_in_cell = cell.figure_in_cell;
                                cell.figure_in_cell = null;
                                return true;
                            }
                            y--;
                            x++;
                        }
                    }
                } else if (y < cell_to_move.o_y && x < cell_to_move.o_x) {
                    for (int i = 0; i < 9; i++) {
                        {
                            if (y == cell_to_move.o_y && x == cell_to_move.o_x) {
                                cell_to_move.figure_in_cell = cell.figure_in_cell;
                                cell.figure_in_cell = null;
                                return true;
                            }
                            y++;
                            x++;
                        }
                    }
                }
            }
        }else if(cell.figure_in_cell.color_figure=='b' ) {
            if ((cell_to_move.figure_in_cell == null) || (cell_to_move.figure_in_cell.color_figure == 'w')) {
                int y = cell.o_y;
                int x = cell.o_x;
                if (y > cell_to_move.o_y && x > cell_to_move.o_x) {
                    for (int i = 0; i < 9; i++) {
                        {
                            if (y == cell_to_move.o_y && x == cell_to_move.o_x) {
                                cell_to_move.figure_in_cell = cell.figure_in_cell;
                                cell.figure_in_cell = null;
                                return true;
                            }
                            y--;
                            x--;
                        }

                    }
                } else if (y < cell_to_move.o_y && x > cell_to_move.o_x) {
                    for (int i = 0; i < 9; i++) {
                        {
                            if (y == cell_to_move.o_y && x == cell_to_move.o_x) {
                                cell_to_move.figure_in_cell = cell.figure_in_cell;
                                cell.figure_in_cell = null;
                                return true;
                            }
                            y++;
                            x--;
                        }
                    }
                } else if (y > cell_to_move.o_y && x < cell_to_move.o_x) {
                    for (int i = 0; i < 9; i++) {
                        {
                            if (y == cell_to_move.o_y && x == cell_to_move.o_x) {
                                cell_to_move.figure_in_cell = cell.figure_in_cell;
                                cell.figure_in_cell = null;
                                return true;
                            }
                            y--;
                            x++;
                        }
                    }
                } else if (y < cell_to_move.o_y && x < cell_to_move.o_x) {
                    for (int i = 0; i < 9; i++) {
                        {
                            if (y == cell_to_move.o_y && x == cell_to_move.o_x) {
                                cell_to_move.figure_in_cell = cell.figure_in_cell;
                                cell.figure_in_cell = null;
                                return true;
                            }
                            y++;
                            x++;
                        }
                    }
                }
            }
        }
        return  false;
    }
}
