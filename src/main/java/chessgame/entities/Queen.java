package chessgame.entities;

public class Queen extends Figure {
    public Queen(char color) {
        super("Queen", color);
    }

    @Override
    public String getIconName() {
        if (this.color_figure == 'w') {
            return "queen_w";
        }
        return "queen";
    }
}
