package chessgame.entities;

public class Queen extends Figure {
    public Queen(char color, double icon_scale) {
        super("King", color, icon_scale);
    }

    public Queen(char color) {
        super("Queen", color, 1);
    }

    @Override
    public String getIconName() {
        if (this.color_figure == 'w') {
            return "queen_w";
        }
        return "queen";
    }
}
