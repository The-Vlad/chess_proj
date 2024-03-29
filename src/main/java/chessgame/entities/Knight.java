package chessgame.entities;

public class Knight extends Figure {
    public Knight(char color, int o_x, int o_y, double icon_scale) {
        super("King", color, o_x, o_y, icon_scale);
    }

    public Knight(char color, int o_x, int o_y) {
        super("Knight", color, o_x, o_y, 1);
    }

    @Override
    public String getIconName() {
        if (this.color_figure == 'w') {
            return "knight_w";
        }
        return "knight";
    }
    public  boolean move_check(Cell cell_to_move,Pole pole)
    {
        if(color_figure=='w') {
            if ((cell_to_move.figure_in_cell == null) || (cell_to_move.figure_in_cell.color_figure == 'b')) {
                if (((o_x - 2 == cell_to_move.o_x) && ((o_y - 1 == cell_to_move.o_y) || (o_y + 1 == cell_to_move.o_y))) ||
                        ((o_x - 1 == cell_to_move.o_x) && ((o_y - 2 == cell_to_move.o_y) || (o_y + 2 == cell_to_move.o_y))) ||
                        ((o_x + 1 == cell_to_move.o_x) && ((o_y - 2 == cell_to_move.o_y) || (o_y + 2 == cell_to_move.o_y))) ||
                        ((o_x + 2 == cell_to_move.o_x) && ((o_y - 1 == cell_to_move.o_y) || (o_y + 1 == cell_to_move.o_y)))
                ) {
                    return true;
                }
            }
            } else if (color_figure == 'b') {
                if ((cell_to_move.figure_in_cell == null) || (cell_to_move.figure_in_cell.color_figure == 'w')) {
                    if (((o_x - 2 == cell_to_move.o_x) && ((o_y - 1 == cell_to_move.o_y) || (o_y + 1 == cell_to_move.o_y))) ||
                            ((o_x - 1 == cell_to_move.o_x) && ((o_y - 2 == cell_to_move.o_y) || (o_y + 2 == cell_to_move.o_y))) ||
                            ((o_x + 1 == cell_to_move.o_x) && ((o_y - 2 == cell_to_move.o_y) || (o_y + 2 == cell_to_move.o_y))) ||
                            ((o_x + 2 == cell_to_move.o_x) && ((o_y - 1 == cell_to_move.o_y) || (o_y + 1 == cell_to_move.o_y)))
                    ) {
                        return true;
                    }

                }
            }
       return false;
    }
}
