package chessgame.entities;

public class Knight extends Figure {
    public Knight(char color, double icon_scale) {
        super("King", color, icon_scale);
    }

    public Knight(char color) {
        super("Knight", color, 1);
    }

    @Override
    public String getIconName() {
        if (this.color_figure == 'w') {
            return "knight_w";
        }
        return "knight";
    }
    public  boolean move_check(Cell cell,Cell cell_to_move,Pole pole)
    {
        if(cell.figure_in_cell.color_figure=='w') {
            if ((cell_to_move.figure_in_cell == null) || (cell_to_move.figure_in_cell.color_figure == 'b')) {
                if (((cell.o_x - 2 == cell_to_move.o_x) && ((cell.o_y - 1 == cell_to_move.o_y) || (cell.o_y + 1 == cell_to_move.o_y))) ||
                        ((cell.o_x - 1 == cell_to_move.o_x) && ((cell.o_y - 2 == cell_to_move.o_y) || (cell.o_y + 2 == cell_to_move.o_y))) ||
                        ((cell.o_x + 1 == cell_to_move.o_x) && ((cell.o_y - 2 == cell_to_move.o_y) || (cell.o_y + 2 == cell_to_move.o_y))) ||
                        ((cell.o_x + 2 == cell_to_move.o_x) && ((cell.o_y - 1 == cell_to_move.o_y) || (cell.o_y + 1 == cell_to_move.o_y)))
                ) {
                    return true;
                }
            }
            } else if (cell.figure_in_cell.color_figure == 'b') {
                if ((cell_to_move.figure_in_cell == null) || (cell_to_move.figure_in_cell.color_figure == 'w')) {
                    if (((cell.o_x - 2 == cell_to_move.o_x) && ((cell.o_y - 1 == cell_to_move.o_y) || (cell.o_y + 1 == cell_to_move.o_y))) ||
                            ((cell.o_x - 1 == cell_to_move.o_x) && ((cell.o_y - 2 == cell_to_move.o_y) || (cell.o_y + 2 == cell_to_move.o_y))) ||
                            ((cell.o_x + 1 == cell_to_move.o_x) && ((cell.o_y - 2 == cell_to_move.o_y) || (cell.o_y + 2 == cell_to_move.o_y))) ||
                            ((cell.o_x + 2 == cell_to_move.o_x) && ((cell.o_y - 1 == cell_to_move.o_y) || (cell.o_y + 1 == cell_to_move.o_y)))
                    ) {
                        return true;
                    }

                }
            }
       return false;
    }
}
