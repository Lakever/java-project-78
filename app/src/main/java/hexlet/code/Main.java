package hexlet.code;

import hexlet.code.schemas.BaseSchema;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        var v = new Validator();
        var schemaString = v.string();
        var schemaNumber = v.number();
        var schema = v.map();

        Map<String, BaseSchema<String>> schemas = new HashMap<>();

// Определяем схемы валидации для значений свойств "firstName" и "lastName"
// Имя должно быть строкой, обязательно для заполнения
        schemas.put("firstName", v.string().required());
// Фамилия обязательна для заполнения и должна содержать не менее 2 символов
        schemas.put("lastName", v.string().required().minLength(2));

// Настраиваем схему `MapSchema`
// Передаем созданный набор схем в метод shape()
        schema.shape(schemas);

// Проверяем объекты
        Map<String, String> human1 = new HashMap<>();
        human1.put("firstName", "John");
        human1.put("lastName", "Smith");
        System.out.println(schema.isValid(human1)); // true

        Map<String, String> human2 = new HashMap<>();
        human2.put("firstName", "John");
        human2.put("lastName", null);
        System.out.println(schema.isValid(human2)); // false

        Map<String, String> human3 = new HashMap<>();
        human3.put("firstName", "Anna");
        human3.put("lastName", "B");
        System.out.println(schema.isValid(human3)); // false

//        var data = new HashMap<String, String>();
//        Map<String, BaseSchema<String>> data = new HashMap<>();
//        data.put("1", "value1");
//        data.put("2", "value2");
//        data.put("firstname", schemaString.minLength(2));
//        schemaMap.isValid(new HashMap<>()); // true
//
//        System.out.println(schemaString.isValid("Hower"));
//        System.out.println(schemaNumber.positive().isValid(10));
//        System.out.println(schemaMap.isValid(data));
//        System.out.println(schema.required().minLength(3).contains("zzz").isValid("zz"));
    }
}