package hexlet.code;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

        var v = new Validator();
        var schemaString = v.string();
        var schemaNumber = v.number();
        var schemaMap = v.map();
        var data = new HashMap<String, String>();
        data.put("1", "value1");
        data.put("2", "value2");

//        schemaMap.isValid(new HashMap<>()); // true

        System.out.println(schemaString.isValid("Hower"));
        System.out.println(schemaNumber.positive().isValid(10));
        System.out.println(schemaMap.isValid(data));
//        System.out.println(schema.required().minLength(3).contains("zzz").isValid("zz"));
    }
}