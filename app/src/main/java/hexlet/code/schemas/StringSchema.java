package hexlet.code.schemas;

public class StringSchema extends BaseSchema<String> {

    public StringSchema() {
    }

    public StringSchema required() {
        isRequired = true;
        rules.add(value -> value != null && !value.isEmpty());
        return this;
    }

    public StringSchema minLength(int size) {
        rules.add(value -> value != null && value.length() >= size);
        return this;
    }

    public StringSchema contains(String substr) {
        rules.add(value -> value != null && value.contains(substr));
        return this;
    }
}
