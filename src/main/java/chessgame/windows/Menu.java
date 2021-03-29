package chessgame.windows;

import chessgame.Vector2f;

import javax.swing.*;
import java.awt.*;
import java.lang.Math.*;

public class Menu extends Window {

    JPanel pnl_left = new JPanel();
    JPanel pnl_right = new JPanel();

    public Menu() {
        super();
        setLayout(null);

        pnl_left.setBackground(background_color);
        pnl_left.setBounds(0,0,(int)(getWidth() * 0.3), getHeight());
        pnl_right.setBounds((int)(getWidth() * 0.3),0,getWidth() - (int)(getWidth() * 0.3), getHeight());
        pnl_right.setBackground(new Color(0,0,0));

        add(pnl_left);
        add(pnl_right);

        pnl_right.setLayout(null);
        pnl_right
    }


    @Override
    public Window go(){
        // return new Game()
        while(true){
            if (true) {
                break;
            }
        }
        // if exit then return null
        return this;
    }
}
