package chessgame.entities;

public class Pawn extends Figure {
    public Pawn(char color) {
        super("Pawn", color);
    }
     public boolean first_move=true;

    @Override
    public String getIconName() {
        if (this.color_figure == 'w') {
            return "pawn_w";
        }
        return "pawn";
    }
}




