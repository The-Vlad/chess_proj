package chessgame.entities;

public class Bishop extends Figure {
    public Bishop(char color) {
        super("Bishop", color);
    }

    @Override
    public String getIconName() {
        if (this.color_figure == 'w') {
            return "bishop_w";
        }
        return "bishop";
    }
}
