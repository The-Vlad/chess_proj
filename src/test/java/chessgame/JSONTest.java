package chessgame;

import org.junit.Test;
import org.json.JSONObject;
import static org.junit.Assert.*;

/**
 * Класс, тестирующий работоспособность библиотеки org.json
 * <br>
 * Зачем? Хз
 */
public class JSONTest {
    @Test public void testJSONWorks(){
        JSONObject jo = new JSONObject("{ \"abc\" : \"def\" }");
        assertEquals("{\"abc\":\"def\"}", jo.toString());
    }
}
