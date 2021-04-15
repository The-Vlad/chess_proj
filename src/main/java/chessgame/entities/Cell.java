package chessgame.entities;

import javax.swing.*;

public class Cell extends JButton {
 public Figure figure_in_cell=new Null_figure();
 public  int o_x;
 public int o_y;
 Icon icon_figure=null;
  public Cell(int x,int  y)
  {
   o_x=x;
   o_y=y;
  }
}
