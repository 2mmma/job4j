package  ru.job4j.loop;

/**
 *Программа подсчета суммы чётных чисел в диапазоне.
 */
public class Counter {

    /**
     * @author tumen.garmazhapov (gtb-85@mail.ru).
     * @param start, начало диапазона.
     * @param finish, конец диапазона
     * @return result.
     */
    public int add(int start, int finish) {
        int result = 0;
        for (int i = start; i <= finish; i++) {
            if (i % 2 == 0) {
                result += i;
            }
        }
        return result;
    }

}