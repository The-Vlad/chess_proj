package chessgame.entities;

public class Rook extends Figure {
    public Rook(char color) {
        super("Rook", color);
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
