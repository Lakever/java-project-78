package hexlet.code.schemas;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class StringSchema {

    private final List<Predicate<String>> rules = new ArrayList<>();
    private boolean isRequired = false;

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

    public boolean isValid(String value) {
        // Если required не вызывался, то null и пустая строка — допустимы
        if (!isRequired && (value == null || value.isEmpty())) {
            return true;
        }
        // Применяем все правила
        for (Predicate<String> rule : rules) {
            if (!rule.test(value)) {
                return false;
            }
        }
        return true;
    }
}
