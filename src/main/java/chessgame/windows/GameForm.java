package chessgame.windows;

import chessgame.App;
import chessgame.entities.*;
import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;

import javax.swing.*;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * @author Naumov V.V.
 * Class that forms Game window
 */
public class GameForm extends JFrame implements IWindow {
    public JPanel game_panel;

    private Pole pole;
    private JButton toMenuButton;
    private JPanel board_panel;

    private Player white_player = new Player('w');
    private Player black_player = new Player('b');
    private Player current_player = white_player;

    private Cell highlighted_check_cell = null;

    /**
     * Constructor that defines listeners to the components
     *
     * @param application reference to the application window
     */
    public GameForm(App application) {
        pole = new Pole(new ButtonListener());
        board_panel.add(pole);

        toMenuButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                application.setContentPane(application.menu.menu_panel);
                application.setVisible(true);
            }
        });

        // этот слушатель срабатывает, когда окно становится активным
        game_panel.addAncestorListener ( new AncestorListener()
        {
            public void ancestorAdded ( AncestorEvent event )
            {
                pole.updatePole();
            }

            public void ancestorRemoved ( AncestorEvent event )
            {

            }

            public void ancestorMoved ( AncestorEvent event )
            {
                // Component container moved
            }
        } );
    }

    public Container getMainPanel() {
        return game_panel;
    }

    /**
     * Проверяет наличие шаха на доске
     * @param king Король, которому может угрожать шах
     * @return true, если есть шах
     */
    public boolean checkCheck(King king) {
        ArrayList<Figure> figures = pole.getFigures();
        for (Figure figure : figures) {
            if (figure.color_figure != king.color_figure && figure.move_check(pole.getCell(king.o_x, king.o_y), pole)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Проверяет наличие мата на доске. Да, это плохое название метода
     * @param king Король, которому может угрожать мат
     * @return true, если есть мат
     */
    public boolean checkMate(King king) {
        // TODO
        return false;
    }

    public void makeTurn(Cell cell, Cell cell_to_move) {
        // подсвеченная во время шаха клетка. Шах длится только ход, поэтому на следующий мы её гасим
        if (highlighted_check_cell != null) {
            highlighted_check_cell.removeHighlight();
            highlighted_check_cell = null;
        }

        pole.moveFigure(cell, cell_to_move);

        if (cell_to_move.figure_in_cell instanceof Pawn)
        {
            if((cell_to_move.figure_in_cell.color_figure=='w') && cell_to_move.o_x==0)
            {
                pole.removeFigure(cell_to_move);
                 pole.addFigure(cell_to_move, new Queen( 'w',cell_to_move.o_x,cell_to_move.o_y));
            }else if((cell_to_move.figure_in_cell.color_figure=='b') && cell_to_move.o_x==7)
            {
                pole.removeFigure(cell_to_move);
                pole.addFigure(cell_to_move, new Queen( 'b',cell_to_move.o_x,cell_to_move.o_y));
            }
        }

        King current_king;
        if (current_player.getColor() == 'w') {
            current_king = pole.getWhiteKing();
        }
        else {
            current_king = pole.getBlackKing();
        }

        // если ход игрока приводит к шаху его же короля, мы возвращаем фигуру на место. В связи с этим...
        // TODO - либо checkCheck перенести в Pole, либо разделить moveFigure и changeImageInCell
        if (checkCheck(current_king)) {
            pole.moveFigure(cell_to_move, cell);
            return;
        }

        King opposite_king;//Навльни
        if (current_player.getColor() == 'w') {
            opposite_king = pole.getBlackKing();
        }
        else {
            opposite_king = pole.getWhiteKing();
        }
        // чтобы красиво подсвечивать шахи проверяем наличие оного у другого игрока (уберите это и сделайте потом норм графику пж)
        if (checkCheck(opposite_king)) {
            highlighted_check_cell = pole.getCell(opposite_king.o_x, opposite_king.o_y);
            highlighted_check_cell.highlightCheck();
        }

        if (current_player == white_player) {
            current_player = black_player;
        }
        else {
            current_player = white_player;
        }

    }

    public class ButtonListener extends AbstractAction// класс слушателя, должен  вызывать методы хода от игрока
    {
        boolean press_cell = false;
        Cell button;

        @Override
        public void actionPerformed(ActionEvent e) {
            // если нажали на кнопку с фигурой текущего цвета, то её выбрали для хода
            if (((Cell) e.getSource()).figure_in_cell != null && ((Cell) e.getSource()).figure_in_cell.color_figure == current_player.getColor()) {
                button = ((Cell) e.getSource());
                press_cell = true;
                return;
            }
            if (press_cell == true) {
                Cell button1 = (Cell) e.getSource();
                press_cell = false;;

                if (button.figure_in_cell.move_check(button1, pole)) {
                    makeTurn(button, button1);
                }
            }
        }
    }
    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        game_panel = new JPanel();
        game_panel.setLayout(new GridLayoutManager(3, 3, new Insets(0, 0, 0, 0), -1, -1));
        game_panel.setBackground(new Color(-905650));
        final Spacer spacer1 = new Spacer();
        game_panel.add(spacer1, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final Spacer spacer2 = new Spacer();
        game_panel.add(spacer2, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final Spacer spacer3 = new Spacer();
        game_panel.add(spacer3, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        toMenuButton = new JButton();
        toMenuButton.setText("ToMenu");
        game_panel.add(toMenuButton, new GridConstraints(1, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        board_panel = new JPanel();
        board_panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        board_panel.setBackground(new Color(-1117618));
        game_panel.add(board_panel, new GridConstraints(1, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return game_panel;
    }
}
