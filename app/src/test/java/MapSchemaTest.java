import hexlet.code.Validator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MapSchemaTest {
    private Validator v;

    @BeforeEach
    public void setUp() {
        Validator v = new Validator();
    }

    @Test
    public void isValidWithOut() throws IOException {
        var schema = v.map();
        Map<String, String> data = new HashMap<>();
//        data.put();

        var expected = true;
        var actual = schema.isValid(data);
        assertEquals(expected, actual);
    }
    

    @Test
    public void isValidNullHashMap() throws IOException {
        var schema = v.map();
        Map<String, String> data = new HashMap<>();

        var expected = true;
        var actual = schema.isValid(data);
        assertEquals(expected, actual);
    }

    @Test
    public void isValidWithAll() throws IOException {
        var schema = v.map();
        Map<String, String> data = new HashMap<>();
        data.put("1", "value1");
        data.put("2", "value2");

        var expected = true;
        var actual = schema.required().sizeof(2).isValid(data);
        assertEquals(expected, actual);
    }
}
