package hexlet.code.schemas;

import java.util.function.Predicate;

public final class StringSchema extends BaseSchema<String> {

    public StringSchema() {
    }

    public StringSchema required() {
        isRequired = true;
        Predicate<String> rule = value -> value != null && value != "" && value != " ";
        rules.put("required", rule);
        return this;
    }

    public StringSchema minLength(int size) {
        Predicate<String> rule = value ->  value != null && value.length() >= size;
        rules.put("minLength", rule);
        return this;
    }

    public StringSchema contains(String substr) {
        Predicate<String> rule = value -> value != null && value.contains(substr);
        rules.put("contains", rule);
        return this;
    }
}
