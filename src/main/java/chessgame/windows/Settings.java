package chessgame.windows;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.awt.Color;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Settings implements IWindow {
    public static final String SETTINGSPATH = "src/main/resources/settings.json";

    private static JSONObject settings_object = Settings.getJSON(SETTINGSPATH);

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

    /**
     *
     * @return Возвращает Map с двумя ключами black и white, в каждом из которых находится Color
     */
    public static Map<String, Color> getPoleTheme() {
        String theme = settings_object.getString("pole-active-theme");
        JSONObject value = settings_object.getJSONObject("pole-themes").getJSONObject(theme);
        HashMap<String, Color> map = new HashMap<>();
        JSONArray black_colors = value.getJSONArray("black");
        map.put("black", new Color(black_colors.getInt(0), black_colors.getInt(1), black_colors.getInt(2)));
        JSONArray white_colors = value.getJSONArray("white");
        map.put("white", new Color(white_colors.getInt(0), white_colors.getInt(1), white_colors.getInt(2)));
        return map;
    }

}
