package hexlet.code;

public class Main {
    public static void main(String[] args) {

        var v = new Validator();
        var schema = v.string();

        System.out.println(schema.isValid("Hower"));
        System.out.println();
//        System.out.println(schema.required().minLength(3).contains("zzz").isValid("zz"));
    }
}