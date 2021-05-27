package chessgame.entities;

public class Pawn extends Figure {
    public Pawn(char color, double icon_scale) {
        super("King", color, icon_scale);
    }

    public Pawn(char color) {
        super("Pawn", color, 1);
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




