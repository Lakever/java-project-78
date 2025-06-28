package hexlet.code.schemas;

import java.util.Map;

public class MapSchema extends BaseSchema<Map<String, String>>{

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

}
