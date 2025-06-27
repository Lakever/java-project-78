import hexlet.code.Validator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringSchemaTest {
    private Validator v;

    @BeforeEach
    public void setUp() {
        Validator v = new Validator(); // только Validator
    }



    @Test
    public void testAllRules() throws IOException {
        var schema = v.string();

        var expected = true;
        var actual = schema.required().minLength(3).contains("ow").isValid("Hower");
        assertEquals(expected, actual);
    }

    @Test
    public void testWithOutRequired() throws IOException {
        var schema = v.string();

        var expected = true;
        var actual = schema.isValid("");
        assertEquals(expected, actual);
    }

    @Test
    public void testRequiredContains() throws IOException {
        var schema = v.string();

        var expected = true;
        var actual = schema.required().contains("owe").isValid("Hower");
        assertEquals(expected, actual);
    }

    @Test
    public void testMinLength() throws IOException {
        var schema = v.string();

        var expected = true;
        var actual = schema.minLength(4).isValid("Hower");
        assertEquals(expected, actual);
    }

    @Test
    public void testMinLengthContains() throws IOException {
        var schema = v.string();

        var expected = true;
        var actual = schema.minLength(4).contains("owe").isValid("Hower");
        assertEquals(expected, actual);
    }

}






//package hexlet.code;
//
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.Test;
//
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//
//import static hexlet.code.Differ.generate;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//public final class DifferTest {
//
//    private static String expectedStylish;
//    private static String expectedPlain;
//    private static String expectedJson;
//
//    private static String file1NestedJson;
//    private static String file2NestedJson;
//    private static String file1NestedYaml;
//    private static String file2NestedYaml;
//
//    private static Path getFixturePath(String fileName) {
//        return Paths.get("src", "test", "resources", "fixtures", "DifferTestDirect", fileName)
//                .toAbsolutePath()
//                .normalize();
//    }
//
//
//
//    private static String readFixture(String fileName) throws IOException {
//        var result = Files.readString(getFixturePath(fileName));
//        return result.trim();
//    }
//
//    @BeforeAll
//    public static void setUp() throws IOException {
//        expectedPlain = readFixture("DifferTestPlain.txt");
//        expectedStylish = readFixture("DifferTestStylish.txt");
//        expectedJson = readFixture("DifferTestJson.txt");
//
//        file1NestedJson = getFixturePath("file1TestNesting.json").toString();
//        file2NestedJson = getFixturePath("file2TestNesting.json").toString();
//
//        file1NestedYaml = getFixturePath("file1TestNesting.yaml").toString();
//        file2NestedYaml = getFixturePath("file2TestNesting.yaml").toString();
//    }
//
//    @Test
//    public void testStylishYaml() throws IOException {
//        var actual = generate(file1NestedYaml, file2NestedYaml, "stylish");
//        assertEquals(expectedStylish, actual);
//    }
//
//    @Test
//    public void testJsonYaml() throws IOException {
//        var actual = generate(file1NestedYaml, file2NestedYaml, "json");
//        assertEquals(expectedJson, actual);
//    }
//
//    @Test
//    public void testStylishJson() throws IOException {
//        var actual = generate(file1NestedJson, file2NestedJson, "stylish");
//        assertEquals(expectedStylish, actual);
//    }
//
//    @Test
//    public void testPlainYaml() throws IOException {
//        var actual = generate(file1NestedYaml, file2NestedYaml, "plain");
//        assertEquals(expectedPlain, actual);
//    }
//
//    @Test
//    public void testJsonFormatJson() throws IOException {
//        var actual = generate(file1NestedJson, file2NestedJson, "json");
//        assertEquals(expectedJson, actual);
//    }
//    @Test
//    public void testDefaultFormatJson() throws IOException {
//        var actual = generate(file1NestedJson, file2NestedJson);
//        assertEquals(expectedStylish, actual);
//    }
//    @Test
//    public void testDefaultFormatYaml() throws IOException {
//        var actual = generate(file1NestedYaml, file2NestedYaml);
//        assertEquals(expectedStylish, actual);
//    }
//}

