package hexlet.code.schemas;



public class NumberSchema extends BaseSchema<Integer> {

    public NumberSchema() {
    }

    public NumberSchema required() {
        isRequired = true;
        rules.add(value -> value != null);
        return this;
    }

    public NumberSchema positive() {
        rules.add(value -> value != null && value >= 0);
        return this;
    }

    public NumberSchema range(int start, int end) {
        rules.add(value -> value != null && value >= start && value <= end);
        return this;
    }
}
