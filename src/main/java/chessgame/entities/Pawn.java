package chessgame.entities;

public class Pawn extends Figure {
    public Pawn(char color, double icon_scale) {
        super("King", color, icon_scale);
    }

    public Pawn(char color) {
        super("Pawn", color, 1);
    }
     public boolean first_move=false;

    @Override
    public String getIconName() {
        if (this.color_figure == 'w') {
            return "pawn_w";
        }
        return "pawn";
    }
     public boolean move_check(Cell cell,Cell cell_to_move, Pole pole) // координата y  соответствует o_x  и наоборот
     {
         if(first_move==false) {
             if (cell.figure_in_cell.color_figure == 'w') {
                 if (cell_to_move.figure_in_cell == null) {
                     if (((cell.o_y == cell_to_move.o_y && (cell.o_x - 1 == cell_to_move.o_x || cell.o_x - 2 == cell_to_move.o_x)))) {
                         cell_to_move.figure_in_cell = cell.figure_in_cell;
                         cell.figure_in_cell = null;
                         first_move=true;
                         return true;
                     }
                 } else if (cell_to_move.figure_in_cell.color_figure == 'b') {
                     if (((cell.o_y == cell_to_move.o_y + 1) || (cell.o_y == cell_to_move.o_y - 1)) && (cell.o_x - 1 == cell_to_move.o_x)) {
                         cell_to_move.figure_in_cell = cell.figure_in_cell;
                         cell.figure_in_cell = null;
                         first_move=true;
                         return true;
                     }
                 }

             } else if (cell.figure_in_cell.color_figure == 'b') {
                 if (cell_to_move.figure_in_cell == null) {
                     if (cell.o_y == cell_to_move.o_y && (cell.o_x + 1 == cell_to_move.o_x || cell.o_x + 2 == cell_to_move.o_x)) {
                         cell_to_move.figure_in_cell = cell.figure_in_cell;
                         cell.figure_in_cell = null;
                         first_move=true;
                         return true;
                     }
                 } else if (cell_to_move.figure_in_cell.color_figure == 'w') {
                     if (((cell.o_y == cell_to_move.o_y + 1) || (cell.o_y == cell_to_move.o_y - 1)) && (cell.o_x + 1 == cell_to_move.o_x)) {
                         cell_to_move.figure_in_cell = cell.figure_in_cell;
                         cell.figure_in_cell = null;
                         first_move=true;
                         return true;
                     }
                 }
             }
         } else if(first_move==true)
         {
             if (cell.figure_in_cell.color_figure == 'w') {
                 if (cell_to_move.figure_in_cell == null) {
                     if (((cell.o_y == cell_to_move.o_y && (cell.o_x - 1 == cell_to_move.o_x)))) {
                         cell_to_move.figure_in_cell = cell.figure_in_cell;
                         cell.figure_in_cell = null;
                         return true;
                     }
                 } else if (cell_to_move.figure_in_cell.color_figure == 'b') {
                     if (((cell.o_y == cell_to_move.o_y + 1) || (cell.o_y == cell_to_move.o_y - 1)) && (cell.o_x - 1 == cell_to_move.o_x)) {
                         cell_to_move.figure_in_cell = cell.figure_in_cell;
                         cell.figure_in_cell = null;
                         return true;
                     }
                 }

             } else if (cell.figure_in_cell.color_figure == 'b') {
                 if (cell_to_move.figure_in_cell == null) {
                     if (cell.o_y == cell_to_move.o_y && (cell.o_x + 1 == cell_to_move.o_x)) {
                         cell_to_move.figure_in_cell = cell.figure_in_cell;
                         cell.figure_in_cell = null;
                         return true;
                     }
                 } else if (cell_to_move.figure_in_cell.color_figure == 'w') {
                     if (((cell.o_y == cell_to_move.o_y + 1) || (cell.o_y == cell_to_move.o_y - 1)) && (cell.o_x + 1 == cell_to_move.o_x)) {
                         cell_to_move.figure_in_cell = cell.figure_in_cell;
                         cell.figure_in_cell = null;
                         return true;
                     }
                 }
             }

         }
         return false;
     }
}




