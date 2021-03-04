import  javax.swing.*;
import java.awt.*;

public class Pole  extends JFrame{
     public JButton [][] cage= new JButton[9][9];
public Pole()
{
    super("Game");
    for (int i=0;i<8;i++)
    {
        for (int j=0;j<8;j++)
        {
            cage[i][j]= new JButton();
            cage[i][j].setPreferredSize(new Dimension(100,100));
            if ((i + j) % 2 == 0) {
                cage[i][j].setBackground(Color.MAGENTA);
            }
            else {
                cage[i][j].setBackground(Color.BLUE);
            }
        }
    }
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setVisible(true);

    Container pane = this.getContentPane();
     GridLayout layout =new GridLayout(8,8,0,0);
     pane.setLayout(layout);
    for (int i=0;i<8;i++)
    {
        for (int j=0;j<8;j++)
        {
            pane.add(cage[i][j]);
        }
    }
    pack();

}
public static void main(String[] args) {
 Pole ob=new Pole();
    }
}
