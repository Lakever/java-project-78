import hexlet.code.Validator;
import hexlet.code.schemas.BaseSchema;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public final class MapSchemaTest {
    private Validator v;

    @BeforeEach
    public void setUp() {
        this.v = new Validator();
    }

    @Test
    public void isValidWithOut() throws IOException {
        var schema = this.v.map();
        Map<String, String> data = new HashMap<>();

        var expected = true;
        var actual = schema.isValid(data);
        assertEquals(expected, actual);
    }


    @Test
    public void isValidNullHashMap() throws IOException {
        var schema = this.v.map();
        Map<String, String> data = new HashMap<>();

        var expected = true;
        var actual = schema.isValid(data);
        assertEquals(expected, actual);
    }

    @Test
    public void isValidNullAfterRequired() throws IOException {
        var schema = this.v.map();
        Map<String, String> data = new HashMap<>();

        var expected = true;
        var actual = schema.isValid(data);
        assertEquals(expected, actual);
    }

    @Test
    public void isValidWithAll() throws IOException {
        var schema = this.v.map();
        Map<String, String> data = new HashMap<>();
        data.put("1", "value1");
        data.put("2", "value2");

        var expected = true;
        var actual = schema.required().sizeof(2).isValid(data);
        assertEquals(expected, actual);
    }

    @Test
    public void isValidWithShape() throws IOException {
        var schema = this.v.map();
        Map<String, BaseSchema<String>> schemas = new HashMap<>();
        schemas.put("lastname", this.v.string().required());
        schemas.put("firstname", this.v.string().required().minLength(1));

        Map<String, String> data = new HashMap<>();
        data.put("lastname", "Torkhov");
        data.put("firstname", "Nikita");
        schema.shape(schemas);


        var expected = true;
        var actual = schema.isValid(data);
        assertEquals(expected, actual);
    }

    @Test
    public void isValidWithShapeNullOption() throws IOException {
        var schema = this.v.map();
        Map<String, BaseSchema<String>> schemas = new HashMap<>();
        schemas.put("lastname", this.v.string().required());
        schemas.put("firstname", this.v.string().required().minLength(1));
        schema.shape(schemas);

        Map<String, String> data = new HashMap<>();
        data.put("lastname", "Torkhov");
        data.put("firstname", null);

        var expected = false;
        var actual = schema.isValid(data);
        assertEquals(expected, actual);
    }
}
