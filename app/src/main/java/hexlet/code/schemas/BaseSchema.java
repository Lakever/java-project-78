package hexlet.code.schemas;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;


public abstract class BaseSchema<T> {
    protected final Map<String, Predicate<T>> rules = new HashMap<String, Predicate<T>>();
    protected boolean isRequired = false;

//    /**
//     * Проверяет, соответствует ли значение заданным правилам валидации.
//     * Если значение равно null или пустое (для строк), и требование isRequired не установлено,
//     * метод возвращает true. Иначе применяются все правила из списка rules.
//     *
//     * @param value значение для проверки
//     * @return true, если значение проходит валидацию, иначе false
//     * @implSpec Подклассы могут переопределять этот метод для кастомной логики,
//     *           но должны учитывать состояние isRequired и список rules.
//     */

    public final boolean isValid(T value) {
        if (!isRequired) {
            // Если не required, то null или "" или пустая мапа — валидно
            if (value == null) {
                return true;
            }
        }
        for (Predicate<T> rule : rules.values()) {
            if (!rule.test(value)) {
                return false;
            }
        }
        return true;
    }
}
