package chessgame.entities;

public class Knight extends Figure {
    public Knight(char color) {
        super("Knight", color);
    }

    @Override
    public String getIconName() {
        if (this.color_figure == 'w') {
            return "knight_w";
        }
        return "knight";
    }
}
