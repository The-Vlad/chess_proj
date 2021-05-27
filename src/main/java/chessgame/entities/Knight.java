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
}
