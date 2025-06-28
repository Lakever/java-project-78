package hexlet.code.schemas;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.SimpleTimeZone;
import java.util.function.Predicate;

public class MapSchema extends BaseSchema<Map<String, String>>{
//    private Map<String, BaseSchema<?>> shapeSchemas = new HashMap<>();

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

    public MapSchema shape(Map<String, BaseSchema<String>> schemas) {
        Predicate<Map<String, String>> ruleShaped = map ->
                schemas.entrySet().stream().allMatch(entry -> {
                    String key = entry.getKey();
                    BaseSchema<String> schema = entry.getValue();
                    String value = map.get(key);
                    return schema.isValid(value);
                });
        rules.add(ruleShaped);
        return this;
    }






//    public MapSchema shape(Map<String, BaseSchema<String>> schemas) {
//        Predicate<Map<String, String>> ruleShaped = val ->
//                schemas.entrySet().stream().allMatch(entry -> {
//                    String key = entry.getKey();
//                    BaseSchema<String> schema = entry.getValue();
//                    Object res = val.get(key);
//                    return schema.isValid((String)res);
//                });
//
//        rules.add(ruleShaped); // должно работать
//        return this;
//    }

}
