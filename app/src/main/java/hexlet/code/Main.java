package hexlet.code;

public class Main {
    public static void main(String[] args) {

        var v = new Validator();
        var schemaString = v.string();
        var schemaNumber = v.number();

        System.out.println(schemaString.isValid("Hower"));
        System.out.println(schemaNumber.positive().isValid(10));
//        System.out.println(schema.required().minLength(3).contains("zzz").isValid("zz"));
    }
}