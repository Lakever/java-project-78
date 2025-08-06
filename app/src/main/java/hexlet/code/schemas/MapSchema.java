package hexlet.code.schemas;

import java.util.Map;
import java.util.function.Predicate;

public final class MapSchema extends BaseSchema<Map<String, String>> {

    public MapSchema() {

    }

    public MapSchema required() {
        isRequired = true;
        Predicate<Map<String, String>> rule = map -> map != null && !map.isEmpty();
        rules.put("required", rule);
        return this;
    }
    public MapSchema sizeof(int size) {
        Predicate<Map<String, String>> rule = map -> map != null
                && !map.isEmpty()
                && map.size() <= size;
        rules.put("sizeof", rule);
        return this;
    }

    public <T extends String> MapSchema shape(Map<String, BaseSchema<T>> schemas) {
        Predicate<Map<String, String>> ruleShaped = map ->
                schemas.entrySet().stream().allMatch(entry -> {
                    var v = map.get(entry.getKey());
                    var schema = entry.getValue();
                    return schema.isValid((T) v);
                });
        rules.put("shape", ruleShaped);
        return this;
    }
}
