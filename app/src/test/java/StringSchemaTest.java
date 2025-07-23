import hexlet.code.Validator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;


import static org.junit.jupiter.api.Assertions.assertEquals;

public final class StringSchemaTest {
    private Validator v;

    @BeforeEach
    public void setUp() {
        this.v = new Validator(); // только Validator
    }



    @Test
    public void testAllRules() throws IOException {
        var schema = this.v.string();

        var expected = true;
        var actual = schema.required().minLength(2).contains("ow").isValid("Hower");
        assertEquals(expected, actual);
    }

    @Test
    public void testWithOutRequired() throws IOException {
        var schema = this.v.string();

        var expected = true;
        var actual = schema.isValid("");
        assertEquals(expected, actual);
    }

    @Test
    public void testRequiredContains() throws IOException {
        var schema = this.v.string();

        var expected = true;
        var actual = schema.required().contains("owe").isValid("Hower");
        assertEquals(expected, actual);
    }

    @Test
    public void testMinLength() throws IOException {
        var schema = this.v.string();

        var expected = true;
        var actual = schema.minLength(4).isValid("Hower");
        assertEquals(expected, actual);
    }

    @Test
    public void testMinLengthContains() throws IOException {
        var schema = this.v.string();

        var expected = true;
        var actual = schema.minLength(4).contains("owe").isValid("Hower");
        assertEquals(expected, actual);
    }

    @Test
    public void testNullWithoutRequired() {
        var schema = v.string();
        var actual = schema.isValid(null);
        var expected = true;
        assertEquals(expected, actual);
    }

}

