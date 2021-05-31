package chessgame.entities;

public class Rook extends Figure {

    public Rook(char color, double icon_scale) {
        super("Rook", color, icon_scale);
    }

    public Rook(char color) {
        super("Rook", color, 1);
    }

    @Override
    public String getIconName() {
        if (this.color_figure == 'w') {
            return "rook_w";
        }
        return "rook";
    }
    public  boolean move_check(Cell cell,Cell cellToMove)
    {
     return  false;
    }
}
