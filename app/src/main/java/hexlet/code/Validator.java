package hexlet.code;

import hexlet.code.schemas.StringSchema;


public class Validator {
    public Validator(String value) {

    }

    public static StringSchema string() {
        return new StringSchema();
    }
}
