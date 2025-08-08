package hexlet.code.schemas;


import java.util.function.Predicate;

public final class NumberSchema extends BaseSchema<Integer> {

    public NumberSchema() {
    }

    public NumberSchema required() {
        isRequired = true;
        Predicate<Integer> rule = num -> num != null;
        rules.put("required", rule);
        return this;
    }

    public NumberSchema positive() {
        Predicate<Integer> rule = num -> num != null && num > 0;
        rules.put("positive", rule);
        return this;
    }

    public NumberSchema range(int start, int end) {
        Predicate<Integer> rule = num -> num != null && num >= start && num <= end;
        rules.put("range", rule);
        return this;
    }
}
