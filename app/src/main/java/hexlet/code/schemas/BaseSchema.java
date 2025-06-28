package hexlet.code.schemas;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public abstract class BaseSchema<T> {
    protected final List<Predicate<T>> rules = new ArrayList<>();
    protected boolean isRequired = false;

    public boolean isValid(T value) {
        if (!isRequired && (value == null || value.equals(""))) {
            return true;
        }
        for (Predicate<T> rule : rules) {
            if (!rule.test(value)) {
                return false;
            }
        }
        return true;
    }
}
