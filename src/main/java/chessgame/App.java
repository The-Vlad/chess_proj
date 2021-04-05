/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package chessgame;

import chessgame.windows.*;

import javax.swing.*;

/**
 * Class - enter point to an application
 */
public class App extends JFrame implements IWindow{
    public GameForm game;
    public MenuForm menu;

    /**
     * Constructor that creates window
     */
    public App(){
        super("ChessGame");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(default_size.x, default_size.y);
    }

    /**
     * Method that runs application
     */
    public void go() {
        game = new GameForm(this);
        menu = new MenuForm(this);

        this.setContentPane(menu.menu_panel);
        this.pack();
        this.setVisible(true);
    }

    /**
     * Method as enter point
     * @param args some arguments
     */
    public static void main(String[] args) {
        new App().go();
    }
}
