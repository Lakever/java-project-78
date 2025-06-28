package hexlet.code.schemas;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;



public class NumberSchema extends BaseSchema<Integer> {
    private final List<Predicate<Integer>> rules = new ArrayList<>();
//    private boolean isRequired = false;

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

//    public boolean isValid(Integer value) {
//        if (!isRequired && value == null) {
//            return true;
//        }
//        for (Predicate<Integer> rule : rules) {
//            //У Predicate есть абстрактный метод test, который использую здесь
//            if (!rule.test(value)) {
//                return false;
//            }
//        }
//        return true;
//    }


}
