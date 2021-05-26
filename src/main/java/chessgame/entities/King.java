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
}
