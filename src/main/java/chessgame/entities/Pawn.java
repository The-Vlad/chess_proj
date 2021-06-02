package chessgame.entities;

public class Pawn extends Figure {
    public Pawn(char color, int o_x, int o_y, double icon_scale) {
        super("King", color, o_x, o_y, icon_scale);
    }

    public Pawn(char color, int o_x, int o_y) {
        super("Pawn", color, o_x, o_y, 1);
    }
     public boolean first_move=false;

    @Override
    public String getIconName() {
        if (this.color_figure == 'w') {
            return "pawn_w";
        }
        return "pawn";
    }
     public boolean move_check(Cell cell_to_move, Pole pole) // координата y  соответствует o_x  и наоборот
     {
         if(first_move==false) {
             if (color_figure == 'w') {
                 if (cell_to_move.figure_in_cell == null) {
                     if (((o_y == cell_to_move.o_y && (o_x - 1 == cell_to_move.o_x || o_x - 2 == cell_to_move.o_x)))) {
                         first_move=true;
                         return true;
                     }
                 } else if (cell_to_move.figure_in_cell.color_figure == 'b') {
                     if (((o_y == cell_to_move.o_y + 1) || (o_y == cell_to_move.o_y - 1)) && (o_x - 1 == cell_to_move.o_x)) {
                         first_move=true;
                         return true;
                     }
                 }

             } else if (color_figure == 'b') {
                 if (cell_to_move.figure_in_cell == null) {
                     if (o_y == cell_to_move.o_y && (o_x + 1 == cell_to_move.o_x || o_x + 2 == cell_to_move.o_x)) {
                         first_move=true;
                         return true;
                     }
                 } else if (cell_to_move.figure_in_cell.color_figure == 'w') {
                     if (((o_y == cell_to_move.o_y + 1) || (o_y == cell_to_move.o_y - 1)) && (o_x + 1 == cell_to_move.o_x)) {
                         first_move=true;
                         return true;
                     }
                 }
             }
         } else if(first_move==true)
         {
             if (color_figure == 'w') {
                 if (cell_to_move.figure_in_cell == null) {
                     if (((o_y == cell_to_move.o_y && (o_x - 1 == cell_to_move.o_x)))) {
                         return true;
                     }
                 } else if (cell_to_move.figure_in_cell.color_figure == 'b') {
                     if (((o_y == cell_to_move.o_y + 1) || (o_y == cell_to_move.o_y - 1)) && (o_x - 1 == cell_to_move.o_x)) {
                         return true;
                     }
                 }

             } else if (color_figure == 'b') {
                 if (cell_to_move.figure_in_cell == null) {
                     if (o_y == cell_to_move.o_y && (o_x + 1 == cell_to_move.o_x)) {
                         return true;
                     }
                 } else if (cell_to_move.figure_in_cell.color_figure == 'w') {
                     if (((o_y == cell_to_move.o_y + 1) || (o_y == cell_to_move.o_y - 1)) && (o_x + 1 == cell_to_move.o_x)) {
                         return true;
                     }
                 }
             }

         }
         return false;
     }
}




