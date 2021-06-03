package chessgame.entities;
public class King extends Figure {
    public King(char color, int o_x, int o_y, double icon_scale) {
        super("King", color, o_x, o_y, icon_scale);
    }

    public King(char color, int o_x, int o_y) {
        super("King", color, o_x, o_y, 1);
    }

    @Override
    public String getIconName() {
        if (this.color_figure == 'w') {
            return "king_w";
        }
        return "king";
    }
    public  boolean move_check(Cell cell_to_move,Pole pole)
    {         System.out.println(o_y+" "+ o_x);
        System.out.println(cell_to_move.o_y+" "+cell_to_move.o_x);
        if(color_figure=='w' ) {
        if ((cell_to_move.figure_in_cell == null) || (cell_to_move.figure_in_cell.color_figure == 'b')) {
            if(o_y== cell_to_move.o_y&&(o_x-1==cell_to_move.o_x||o_x+1==cell_to_move.o_x))
            {
                 return true;
            }else  if(o_x== cell_to_move.o_x&&(o_y-1==cell_to_move.o_y||o_y+1==cell_to_move.o_y))
            {
                return true;
            } else  if(o_y-1== cell_to_move.o_y&&o_x-1== cell_to_move.o_x)
            {
                return true;
            }if(o_y+1== cell_to_move.o_y&&o_x-1== cell_to_move.o_x)
            {
                return true;
            } else if(o_y-1== cell_to_move.o_y&&o_x+1== cell_to_move.o_x)
            {
                return true;
            } else if(o_y+1== cell_to_move.o_y&&o_x+1== cell_to_move.o_x)
            {
                return true;
            }
        }
        //dfdffd
        } else if(color_figure=='b')
            {
                if ((cell_to_move.figure_in_cell == null) || (cell_to_move.figure_in_cell.color_figure == 'w')) {
                    if(o_y== cell_to_move.o_y&&(o_x-1==cell_to_move.o_x||o_x+1==cell_to_move.o_x))
                    {
                        return true;
                    }else  if(o_x== cell_to_move.o_x&&(o_y-1==cell_to_move.o_y||o_y+1==cell_to_move.o_y))
                    {
                        return true;
                    } else  if(o_y-1== cell_to_move.o_y&&o_x-1== cell_to_move.o_x)
                    {
                        return true;
                    }if(o_y+1== cell_to_move.o_y&&o_x-1== cell_to_move.o_x)
                    {
                        return true;
                    } else if(o_y-1== cell_to_move.o_y&&o_x+1== cell_to_move.o_x)
                    {
                        return true;
                    } else if(o_y+1== cell_to_move.o_y&&o_x+1== cell_to_move.o_x)
                    {
                        return true;
                    }
                }
            }
        return  false;
    }
}
