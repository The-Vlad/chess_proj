package chessgame.entities;

public class King extends Figure {
    public King(char color) {
        super("King", color);
    }

    @Override
    public String getIconName() {
        if (this.color_figure == 'w') {
            return "king_w";
        }
        return "king";
    }
    public  boolean move_check(Cell cell,Cell cellToMove)
    {
        return  false;
    }
}
