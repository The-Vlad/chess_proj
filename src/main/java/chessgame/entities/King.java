package chessgame.entities;
public class King extends Figure {
    public King(char color, double icon_scale) {
        super("King", color, icon_scale);
    }

    public King(char color) {
        super("King", color, 1);
    }

    @Override
    public String getIconName() {
        if (this.color_figure == 'w') {
            return "king_w";
        }
        return "king";
    }
    public  boolean move_check(Cell cell,Cell cell_to_move,Pole pole)

    {         System.out.println(cell.o_y+" "+ cell.o_x);
        System.out.println(cell_to_move.o_y+" "+cell_to_move.o_x);
        if(cell.figure_in_cell.color_figure=='w' ) {
        if ((cell_to_move.figure_in_cell == null) || (cell_to_move.figure_in_cell.color_figure == 'b')) {
            if(cell.o_y== cell_to_move.o_y&&(cell.o_x-1==cell_to_move.o_x||cell.o_x+1==cell_to_move.o_x))
            {
                 return true;
            }else  if(cell.o_x== cell_to_move.o_x&&(cell.o_y-1==cell_to_move.o_y||cell.o_y+1==cell_to_move.o_y))
            {
                return true;
            } else  if(cell.o_y-1== cell_to_move.o_y&&cell.o_x-1== cell_to_move.o_x)
            {
                return true;
            }if(cell.o_y+1== cell_to_move.o_y&&cell.o_x-1== cell_to_move.o_x)
            {
                return true;
            } else if(cell.o_y-1== cell_to_move.o_y&&cell.o_x+1== cell_to_move.o_x)
            {
                return true;
            } else if(cell.o_y+1== cell_to_move.o_y&&cell.o_x+1== cell_to_move.o_x)
            {
                return true;
            }
        }
        } else if(cell.figure_in_cell.color_figure=='b')
            {
                if ((cell_to_move.figure_in_cell == null) || (cell_to_move.figure_in_cell.color_figure == 'w')) {
                    if(cell.o_y== cell_to_move.o_y&&(cell.o_x-1==cell_to_move.o_x||cell.o_x+1==cell_to_move.o_x))
                    {
                        return true;
                    }else  if(cell.o_x== cell_to_move.o_x&&(cell.o_y-1==cell_to_move.o_y||cell.o_y+1==cell_to_move.o_y))
                    {
                        return true;
                    } else  if(cell.o_y-1== cell_to_move.o_y&&cell.o_x-1== cell_to_move.o_x)
                    {
                        return true;
                    }if(cell.o_y+1== cell_to_move.o_y&&cell.o_x-1== cell_to_move.o_x)
                    {
                        return true;
                    } else if(cell.o_y-1== cell_to_move.o_y&&cell.o_x+1== cell_to_move.o_x)
                    {
                        return true;
                    } else if(cell.o_y+1== cell_to_move.o_y&&cell.o_x+1== cell_to_move.o_x)
                    {
                        return true;
                    }
                }
            }
        return  false;
    }
}
