package chessgame.windows;

import chessgame.App;
import chessgame.entities.Pawn;
import chessgame.entities.Pole;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import java.awt.*;
import java.awt.event.*;
import java.io.FileWriter;
import java.io.Writer;
import java.util.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Settings implements IWindow {
    public static final String SETTINGSPATH = "src/main/resources/settings.json";

    // for theme buttons
    public static final Color ENABLEDCOLOR = new Color(200, 100, 100);
    public static final Color DISABLEDCOLOR = new Color(100, 100, 100);

    App application;

    private static JSONObject settings_object = Settings.getJSON(SETTINGSPATH);
    private Pole pole = new Pole(300, null);
    private JPanel settings_panel = new JPanel();
    private JPanel right_panel = new JPanel(new GridBagLayout());
    private ThemeScroller pole_theme_scroller = new ThemeScroller();
    private ThemeScroller figure_theme_scroller = new ThemeScroller();

    private ArrayList<FigureThemeButton> figure_buttons = new ArrayList<>();
    private ArrayList<PoleThemeButton> pole_buttons = new ArrayList<>();

    private static JSONObject getJSON(String path_string) {
        Path path = Paths.get(path_string);
        try {
            String string_json = String.join("", Files.readAllLines(path));
            return new JSONObject(string_json);
        }
        catch (IOException e) {
            throw new RuntimeException("Couldn't read settings file");
        }
    }

    /**
     *
     * @return возвращает путь к директории с иконками
     */
    public static String getFigureTheme() {
        String theme = settings_object.getString("figure-active-theme");
        return settings_object.getJSONObject("figure-themes").getString(theme);
    }

    private static void setFigureTheme(String theme) {
        settings_object.put("figure-active-theme", theme);
        try {
            Writer writer = new FileWriter(SETTINGSPATH);
            settings_object.write(writer, 2, 4);
            writer.close();
        }
        catch (IOException e) {
            throw new RuntimeException("Couldn't read settings file");
        }
    }

    /**
     * Возвращает текущую тему доски, то есть её цвета
     * @return Map с двумя ключами black и white, в каждом из которых находится Color
     */
    public static Map<String, Color> getPoleTheme() {
        String theme = settings_object.getString("pole-active-theme");
        return Settings.getPoleTheme(theme);
    }

    /**
     * Возвращает определённую тему доски, то есть её цвета
     * @param theme тема, цвета которой необходимо получить
     * @return Map с двумя ключами black и white, в каждом из которых находится Color
     */
    private static Map<String, Color> getPoleTheme(String theme) {
        JSONObject value = settings_object.getJSONObject("pole-themes").getJSONObject(theme);
        HashMap<String, Color> map = new HashMap<>();
        JSONArray black_colors = value.getJSONArray("black");
        map.put("black", new Color(black_colors.getInt(0), black_colors.getInt(1), black_colors.getInt(2)));
        JSONArray white_colors = value.getJSONArray("white");
        map.put("white", new Color(white_colors.getInt(0), white_colors.getInt(1), white_colors.getInt(2)));
        JSONArray check_colors = value.getJSONArray("check");
        map.put("check", new Color(check_colors.getInt(0), check_colors.getInt(1), check_colors.getInt(2)));
        return map;
    }

    private static void setPoleTheme(String theme) {
        settings_object.put("pole-active-theme", theme);
        try {
            Writer writer = new FileWriter(SETTINGSPATH);
            settings_object.write(writer, 2, 4);
            writer.close();
        }
        catch (IOException e) {
            throw new RuntimeException("Couldn't read settings file");
        }
    }

    public Settings(App application) {
        this.application = application; // ссылка на application нужна только для перехода на другие окна

        settings_panel.setBackground(IWindow.background_color);
        figure_theme_scroller.setOpaque(false);
        pole_theme_scroller.setOpaque(false);
        right_panel.setOpaque(false);

        // нудное размещение элементов
        settings_panel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 2;
        c.weightx = 1;
        c.weighty = 1;
        c.fill = GridBagConstraints.BOTH;
        settings_panel.add(figure_theme_scroller, c);
        c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 2;
        c.weightx = 1;
        c.weighty = 1;
        //c.fill = GridBagConstraints.BOTH;
        settings_panel.add(pole, c);
        c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 2;
        c.weightx = 1;
        c.weighty = 1;
        c.fill = GridBagConstraints.BOTH;
        settings_panel.add(pole_theme_scroller, c);
        c = new GridBagConstraints();
        c.gridx = 2;
        c.gridy = 0;
        c.gridheight = 3;
        c.weightx = 0.5;
        c.weighty = 1;
        c.fill = GridBagConstraints.BOTH;
        settings_panel.add(right_panel, c);

        // размещение кнопок на правой панели (пока что только кнопки меню)
        GridBagConstraints menu_button_constraints = new GridBagConstraints();
        menu_button_constraints.insets = new Insets(0, 0, 100, 0);
        menu_button_constraints.anchor = GridBagConstraints.SOUTH;
        menu_button_constraints.weightx = 1;
        menu_button_constraints.weighty = 1;
        JButton menu_button = new JButton("Menu");
        menu_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                application.setContentPane(application.menu.menu_panel);
                application.setVisible(true);
            }
        });
        right_panel.add(menu_button, menu_button_constraints);

        // устанавливаем слушатель на settings_panel, чтобы знать, когда он становится текущим окном, и включаем ThemeScrollerы
        settings_panel.addAncestorListener ( new AncestorListener()
        {
            public void ancestorAdded ( AncestorEvent event )
            {
                figure_theme_scroller.setActive(true);
            }

            public void ancestorRemoved ( AncestorEvent event )
            {
                figure_theme_scroller.setActive(false);
            }

            public void ancestorMoved ( AncestorEvent event )
            {
                // Component container moved
            }
        } );


        Iterator<String> themes = settings_object.getJSONObject("figure-themes").keys();
        while (themes.hasNext()) {
            String theme = themes.next();
            FigureThemeButton figure_button = new FigureThemeButton(theme);
            figure_buttons.add(figure_button);
            figure_theme_scroller.add(figure_button);
        }

        themes = settings_object.getJSONObject("pole-themes").keys();
        while (themes.hasNext()) {
            String theme = themes.next();
            PoleThemeButton pole_button = new PoleThemeButton(theme);
            pole_buttons.add(pole_button);
            pole_theme_scroller.add(pole_button);
        }
    }

    public JPanel getMainPanel() {
        return settings_panel;
    }

    class ThemeScroller extends JScrollPane {
        // TODO - переделать метод add под будущий базовый класс ThemeButton

        private static final int SCROLLSPEED = 3;

        private int last_mouse_x;
        private double mouse_acceleration = 0.2;
        private int mouse_speed;
        SwingWorker<Object, Object> dynamic_scroller_worker; // отвечает за перемотку зажатием мышки
        private boolean scroller_active = false;

        private JScrollBar scrollbar;

        private MouseListener mouse_listener = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {}

            @Override
            public void mousePressed(MouseEvent e) {
                last_mouse_x = e.getX();
            }

            @Override
            public void mouseReleased(MouseEvent e) {}

            @Override
            public void mouseEntered(MouseEvent e) {}

            @Override
            public void mouseExited(MouseEvent e) {}
        };
        private MouseMotionListener mouse_motion_listener = new MouseMotionAdapter() { // определяет скорость перемотки зажатием мышки
            @Override
            public void mouseDragged(MouseEvent e) {
                super.mouseDragged(e);
                mouse_speed -= (e.getX() - last_mouse_x) * 8;
                last_mouse_x = e.getX();
            }
        };
        private MouseWheelListener mouse_wheel_listener = new MouseWheelListener() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                JScrollBar scrollbar = getHorizontalScrollBar();
                scrollbar.setValue(scrollbar.getValue() - SCROLLSPEED * e.getWheelRotation());
            }
        };

        private JPanel theme_panel;

        public ThemeScroller() {
            setBorder(null);

            theme_panel = new JPanel();
            theme_panel.setLayout(new GridBagLayout());
            theme_panel.setOpaque(false); // у themescrollerа не должен быть собственный фон
            setViewportView(theme_panel);
            getViewport().setOpaque(false); // у themescrollerа не должен быть собственный фон

            createHorizontalScrollBar();
            setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
            scrollbar = getHorizontalScrollBar();
            scrollbar.setValue(scrollbar.getMaximum() / 2);
            addMouseWheelListener(mouse_wheel_listener);
            addMouseMotionListener(mouse_motion_listener);
            addMouseListener(mouse_listener);
        }

        public Component add(Component comp) {
            GridBagConstraints theme_constraints = new GridBagConstraints();
            theme_constraints.insets = new Insets(0, 10, 0, 10);
            theme_panel.add(comp, theme_constraints);

            // чтобы нажимая и тыкая на все внутренние компоненты всё равно можно было управлять мышкой, мы передаём все наши мышечные обработчики компонентам
            comp.addMouseListener(mouse_listener);
            comp.addMouseMotionListener(mouse_motion_listener);
            comp.addMouseWheelListener(mouse_wheel_listener);

            return comp;
        }

        // TODO - сделать все лишние add приватными

        /**
         * запускает процессы для правильного отображения
         * @param active_state указывает, находится ли сейчас FigureThemeScroller на экране
         */
        public void setActive(boolean active_state) {
            if (scroller_active == active_state) {
                return;
            }

            scroller_active = active_state;
            if (scroller_active) {
                dynamic_scroller_worker = new SwingWorker<Object, Object>() {
                    private int frame_length = 10;
                    private double fps = 1000.0 / frame_length;

                    @Override
                    protected Object doInBackground() throws Exception {
                        System.out.println("dynamic scroller worker started");
                        double frame_length_second = frame_length / 1000.0;

                        while(scroller_active) {
                            scrollbar.setValue(scrollbar.getValue() + (int)(frame_length_second * mouse_speed));

                            // Почему-то максимальный getValue и getVisibleAmount вместе получают длину всей панельки
                            if (scrollbar.getValue() == 0 || scrollbar.getValue() + scrollbar.getVisibleAmount() == theme_panel.getWidth()) {
                                mouse_speed = 0;
                            }
                            if (mouse_speed > 0) {
                                mouse_speed -= mouse_acceleration * frame_length;
                            }
                            else if (mouse_speed < 0) {
                                mouse_speed += mouse_acceleration * frame_length;
                            }
                            Thread.sleep(frame_length);
                        }
                        mouse_speed = 0;
                        return null;
                    }
                };
                dynamic_scroller_worker.execute();
            }
        }
    }

    // Оба класса FigureThemeButton используют settings_object, то есть напрямую зависят от объекта Settings
    // и заслуженно сидят внутри него. Но можно подправить код так, чтобы они были полностью независимы.
    // Поправка: в Settings также находится figure_buttons, но его можно перенести сюда
    class FigureThemeButton extends JPanel {

        private final String theme;

        public FigureThemeButton(String theme) {
            super(new GridLayout(2, 1));

            this.theme = theme;
            if(this.theme.equals(settings_object.getString("figure-active-theme"))) {
                setEnabled();
            }
            else {
                setDisabled();
            }

            String theme_path = settings_object.getJSONObject("figure-themes").getString(theme);

            Icon white_icon = new ImageIcon(theme_path + "/" + new Pawn('w', 0, 0).getIconName() + ".png");
            JLabel white_figure = new JLabel(white_icon);
            white_figure.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
            add(white_figure);
            Icon black_icon = new ImageIcon(theme_path + "/" + new Pawn('b', 0, 0).getIconName() + ".png");
            JLabel black_figure = new JLabel(black_icon);
            black_figure.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.BLACK));
            add(black_figure);

            //this.setPreferredSize(new Dimension(60, 60));
            Border border = BorderFactory.createLineBorder(Color.BLACK, 2, true);
            setBorder(border);

            // УСТАНОВКА ТЕМЫ
            addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    Settings.setFigureTheme(theme);

                    pole.updatePole();

                    for (FigureThemeButton figure_button : figure_buttons) {
                        figure_button.setDisabled();
                    }
                    setEnabled();
                }


                // похер на остальные ивенты
                @Override
                public void mousePressed(MouseEvent e) {

                }

                @Override
                public void mouseReleased(MouseEvent e) {

                }

                @Override
                public void mouseEntered(MouseEvent e) {

                }

                @Override
                public void mouseExited(MouseEvent e) {

                }
            });
        }

        /**
         * Выделяет кнопку как выбранную
         */
        private void setEnabled() {
            setBackground(ENABLEDCOLOR);
        }

        /**
         * Убирает выделение кнопки
         */
        private void setDisabled() {
            setBackground(DISABLEDCOLOR);
        }

    }

    // Возможно вы скажете, что это почти что такой же класс, как и FigureThemeButton, и что они могли бы наследоваться
    // от базового класса или хотя бы интерфейс имплементировать, но мне лень думать, как здесь вычленять общие элементы
    class PoleThemeButton extends JPanel {
        private final String theme;

        public PoleThemeButton(String theme) {
            super(new GridLayout(2, 1));

            this.theme = theme;
            if (this.theme.equals(settings_object.getString("pole-active-theme"))) {
                setEnabled();
            } else {
                setDisabled();
            }

            // как же херово выглядит... Ну я тут добавляю сначала панельки, в которые затем размещаю шахматные клетки,
            // и всё это добавляю в сам PoleThemeButton
            JPanel upper_panel = new JPanel(new GridBagLayout());
            upper_panel.setOpaque(false);
            JLabel white_cell = new JLabel();
            white_cell.setOpaque(true); // зачем вообще использовать Label, если можно использовать Panel? Хз, я даже не знаю кто эффективнее
            white_cell.setPreferredSize(new Dimension(40, 40));
            white_cell.setBackground(Settings.getPoleTheme(theme).get("white"));
            upper_panel.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
            upper_panel.add(white_cell);
            add(upper_panel);
            JPanel lower_label = new JPanel(new GridBagLayout());
            lower_label.setOpaque(false);
            JLabel black_cell = new JLabel();
            black_cell.setOpaque(true);
            black_cell.setPreferredSize(new Dimension(40, 40));
            black_cell.setBackground(Settings.getPoleTheme(theme).get("black"));
            lower_label.add(black_cell);
            lower_label.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.BLACK));
            add(lower_label);

            setPreferredSize(new Dimension(60, 120));
            Border border = BorderFactory.createLineBorder(Color.BLACK, 2, true);
            setBorder(border);


            // УСТАНОВКА ТЕМЫ
            addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    Settings.setPoleTheme(theme);

                    pole.updatePole();

                    for (PoleThemeButton pole_button : pole_buttons) {
                        pole_button.setDisabled();
                    }
                    setEnabled();
                }


                // похер на остальные ивенты
                @Override
                public void mousePressed(MouseEvent e) {

                }

                @Override
                public void mouseReleased(MouseEvent e) {

                }

                @Override
                public void mouseEntered(MouseEvent e) {

                }

                @Override
                public void mouseExited(MouseEvent e) {

                }
            });
        }

        /**
         * Выделяет кнопку как выбранную
         */
        private void setEnabled() {
            setBackground(ENABLEDCOLOR);
        }

        /**
         * Убирает выделение кнопки
         */
        private void setDisabled() {
            setBackground(DISABLEDCOLOR);
        }
    }
}
