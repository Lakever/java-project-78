package hexlet.code.schemas;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;


public abstract class BaseSchema<T> {
    protected final List<Predicate<T>> rules = new ArrayList<>();
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
        if (!isRequired && (value == null || value.equals(""))) {
            return true;
        }
        for (Predicate<T> rule : rules) {
            if (!rule.test(value)) {
                return false;
            }
        }
        return true;
    }
}
