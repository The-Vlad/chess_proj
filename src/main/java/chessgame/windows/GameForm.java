package chessgame.windows;

import chessgame.App;
import chessgame.entities.Pole;
import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;

import javax.swing.*;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Naumov V.V.
 * Class that forms Game window
 */
public class GameForm extends JFrame implements IWindow {
    public JPanel game_panel;

    private Pole pole;
    private JButton toMenuButton;
    private JPanel board_panel;

    /**
     * Constructor that defines listeners to the components
     *
     * @param application reference to the application window
     */
    public GameForm(App application) {
        pole = new Pole();
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
