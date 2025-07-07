import hexlet.code.Validator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumberSchemaTest {
    private Validator v;

    @BeforeEach
    public void setUp() {
        this.v = new Validator();
    }

    @Test
    public void isValidWithOut() throws IOException {
        var schema = this.v.number();

        var expected = true;
        var actual = schema.isValid(4);
        assertEquals(expected, actual);
    }

    @Test
    public void isValidNullCheck() throws IOException {
        var schema = this.v.number();

        var expected = true;
        var actual = schema.isValid(null);
        assertEquals(expected, actual);
    }

    @Test
    public void positiveAndIsValid() throws IOException {
        var schema = this.v.number();

        var expected = true;
        var actual = schema.positive().isValid(null);
        assertEquals(expected, actual);
    }

    @Test
    public void checkedAll() throws IOException {
        var schema = this.v.number();

        var expected = true;
        var actual = schema.required().positive().range(30, 60).isValid(54);
        assertEquals(expected, actual);
    }


}
