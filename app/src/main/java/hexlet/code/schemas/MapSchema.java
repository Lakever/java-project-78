package hexlet.code.schemas;

import java.util.Map;
import java.util.function.Predicate;

public class MapSchema extends BaseSchema<Map<String, String>> {

    public MapSchema() {

    }

    public MapSchema required() {
        isRequired = true;
        rules.add(value -> value != null && !value.isEmpty());
        return this;
    }
    public MapSchema sizeof(int size) {
        rules.add(value -> value.size() == size);
        return this;
    }

    public <T> MapSchema shape(Map<String, BaseSchema<T>> schemas) {
        Predicate<Map<String, String>> ruleShaped = map ->
                schemas.entrySet().stream().allMatch(entry -> {
                    var v = map.get(entry.getKey());
                    var schema = entry.getValue();
                    return schema.isValid((T) v);
                });
        rules.add(ruleShaped);
        return this;
    }
}
