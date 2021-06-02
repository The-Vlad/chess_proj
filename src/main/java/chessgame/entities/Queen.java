package chessgame.entities;

public class Queen extends Figure {
    public Queen(char color, double icon_scale) {
        super("King", color, icon_scale);
    }

    public Queen(char color) {
        super("Queen", color, 1);
    }

    @Override
    public String getIconName() {
        if (this.color_figure == 'w') {
            return "queen_w";
        }
        return "queen";
    }

    public boolean move_check(Cell cell, Cell cell_to_move, Pole pole) {
        System.out.println(cell.o_y + " " + cell.o_x);
        System.out.println(cell_to_move.o_y + " " + cell_to_move.o_x);
        int y = cell.o_y;
        int x = cell.o_x;
        if (cell.figure_in_cell.color_figure == 'w') {
            if ((cell_to_move.figure_in_cell == null) || (cell_to_move.figure_in_cell.color_figure == 'b')) {

                if (y > cell_to_move.o_y && x > cell_to_move.o_x) {
                    for (int i = 0; i < 9; i++) {
                        {
                            if (y - 1 == cell_to_move.o_y && x - 1 == cell_to_move.o_x) {
                                return true;
                            }
                            y--;//=x
                            x--;//=y
                            Cell cell1 = pole.getCell(x, y);
                            if (cell1.figure_in_cell != null) {
                                System.out.println("Can't go");
                                return false;
                            }
                        }

                    }
                } else if (y < cell_to_move.o_y && x > cell_to_move.o_x) {
                    for (int i = 0; i < 9; i++) {
                        {
                            if (y + 1 == cell_to_move.o_y && x - 1 == cell_to_move.o_x) {
                                return true;
                            }
                            y++;
                            x--;
                            Cell cell1 = pole.getCell(x, y);
                            if (cell1.figure_in_cell != null) {
                                System.out.println("Can't go");
                                return false;
                            }
                        }
                    }
                } else if (y > cell_to_move.o_y && x < cell_to_move.o_x) {
                    for (int i = 0; i < 9; i++) {
                        {
                            if (y - 1 == cell_to_move.o_y && x + 1 == cell_to_move.o_x) {
                                return true;
                            }
                            y--;
                            x++;
                            Cell cell1 = pole.getCell(x, y);
                            if (cell1.figure_in_cell != null) {
                                System.out.println("Can't go");
                                return false;
                            }
                        }
                    }
                } else if (y < cell_to_move.o_y && x < cell_to_move.o_x) {
                    for (int i = 0; i < 9; i++) {
                        {
                            if (y + 1 == cell_to_move.o_y && x + 1 == cell_to_move.o_x) {
                                return true;
                            }
                            y++;
                            x++;
                            Cell cell1 = pole.getCell(x, y);
                            if (cell1.figure_in_cell != null) {
                                System.out.println("Can't go");
                                return false;
                            }
                        }
                    }
                } else if (y == cell_to_move.o_y && x > cell_to_move.o_x) {
                    System.out.println("hi");
                    for (int i = 0; i < 9; i++) {
                        {
                            if (x - 1 == cell_to_move.o_x) {
                                return true;
                            }
                            x--;
                            Cell cell1 = pole.getCell(x, y);
                            if (cell1.figure_in_cell != null) {
                                System.out.println("Can't go");
                                return false;
                            }
                        }

                    }
                } else if (y == cell_to_move.o_y && x < cell_to_move.o_x) {
                    for (int i = 0; i < 9; i++) {
                        {
                            if (x + 1 == cell_to_move.o_x) {
                                return true;
                            }
                            x++;
                            Cell cell1 = pole.getCell(x, y);
                            if (cell1.figure_in_cell != null) {
                                System.out.println("Can't go");
                                return false;
                            }
                        }
                    }
                } else if (y > cell_to_move.o_y && x == cell_to_move.o_x) {
                    for (int i = 0; i < 9; i++) {
                        {
                            if (y - 1 == cell_to_move.o_y) {
                                return true;
                            }
                            y--;
                            Cell cell1 = pole.getCell(x, y);
                            if (cell1.figure_in_cell != null) {
                                System.out.println("Can't go");
                                return false;
                            }
                        }
                    }
                } else if (y < cell_to_move.o_y && x == cell_to_move.o_x) {
                    for (int i = 0; i < 9; i++) {
                        {
                            if (y + 1 == cell_to_move.o_y) {
                                return true;
                            }
                            y++;
                            Cell cell1 = pole.getCell(x, y);
                            if (cell1.figure_in_cell != null) {
                                System.out.println("Can't go");
                                return false;
                            }
                        }
                    }
                }
            }
        } else if (cell.figure_in_cell.color_figure == 'b') {
            if ((cell_to_move.figure_in_cell == null) || (cell_to_move.figure_in_cell.color_figure == 'w')) {
                if (y > cell_to_move.o_y && x > cell_to_move.o_x) {
                    for (int i = 0; i < 9; i++) {
                        {
                            if (y - 1 == cell_to_move.o_y && x - 1 == cell_to_move.o_x) {
                                return true;
                            }
                            y--;
                            x--;
                            Cell cell1 = pole.getCell(x, y);
                            if (cell1.figure_in_cell != null) {
                                System.out.println("Can't go");
                                return false;
                            }
                        }

                    }
                } else if (y < cell_to_move.o_y && x > cell_to_move.o_x) {
                    for (int i = 0; i < 9; i++) {
                        {
                            if (y + 1 == cell_to_move.o_y && x - 1 == cell_to_move.o_x) {
                                return true;
                            }
                            y++;
                            x--;
                            Cell cell1 = pole.getCell(x, y);
                            if (cell1.figure_in_cell != null) {
                                System.out.println("Can't go");
                                return false;
                            }
                        }
                    }
                } else if (y > cell_to_move.o_y && x < cell_to_move.o_x) {
                    for (int i = 0; i < 9; i++) {
                        {
                            if (y - 1 == cell_to_move.o_y && x + 1 == cell_to_move.o_x) {
                                return true;
                            }
                            y--;
                            x++;
                            Cell cell1 = pole.getCell(x, y);
                            if (cell1.figure_in_cell != null) {
                                System.out.println("Can't go");
                                return false;
                            }
                        }
                    }
                } else if (y < cell_to_move.o_y && x < cell_to_move.o_x) {
                    for (int i = 0; i < 9; i++) {
                        {
                            if (y + 1 == cell_to_move.o_y && x + 1 == cell_to_move.o_x) {
                                return true;
                            }
                            y++;
                            x++;
                            Cell cell1 = pole.getCell(x, y);
                            if (cell1.figure_in_cell != null) {
                                System.out.println("Can't go");
                                return false;
                            }
                        }
                    }
                } else if (y == cell_to_move.o_y && x > cell_to_move.o_x) {
                    System.out.println("hi");
                    for (int i = 0; i < 9; i++) {
                        {
                            if (x - 1 == cell_to_move.o_x) {
                                return true;
                            }
                            x--;
                            Cell cell1 = pole.getCell(x, y);
                            if (cell1.figure_in_cell != null) {
                                System.out.println("Can't go");
                                return false;
                            }
                        }

                    }
                } else if (y == cell_to_move.o_y && x < cell_to_move.o_x) {
                    for (int i = 0; i < 9; i++) {
                        {
                            if (x + 1 == cell_to_move.o_x) {
                                return true;
                            }
                            x++;
                            Cell cell1 = pole.getCell(x, y);
                            if (cell1.figure_in_cell != null) {
                                System.out.println("Can't go");
                                return false;
                            }
                        }
                    }
                } else if (y > cell_to_move.o_y && x == cell_to_move.o_x) {
                    for (int i = 0; i < 9; i++) {
                        {
                            if (y - 1 == cell_to_move.o_y) {
                                return true;
                            }
                            y--;
                            Cell cell1 = pole.getCell(x, y);
                            if (cell1.figure_in_cell != null) {
                                System.out.println("Can't go");
                                return false;
                            }
                        }
                    }
                } else if (y < cell_to_move.o_y && x == cell_to_move.o_x) {
                    for (int i = 0; i < 9; i++) {
                        {
                            if (y + 1 == cell_to_move.o_y) {
                                return true;
                            }
                            y++;
                            Cell cell1 = pole.getCell(x, y);
                            if (cell1.figure_in_cell != null) {
                                System.out.println("Can't go");
                                return false;
                            }
                        }
                    }
                }
            }
        }
        return  false;
    }
}




