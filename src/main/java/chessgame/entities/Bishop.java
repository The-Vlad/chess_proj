package chessgame.entities;

public class Bishop extends Figure {

    public Bishop(char color, double icon_scale) {
        super("King", color, icon_scale);
    }

    public Bishop(char color) {
        super("Bishop", color, 1);
    }

    @Override
    public String getIconName() {
        if (this.color_figure == 'w') {
            return "bishop_w";
        }
        return "bishop";
    }
}
