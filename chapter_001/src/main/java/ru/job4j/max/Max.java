package ru.job4j.max;

/**
 * @author tumen.garmazhapov (gtb-85@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class Max {
    
	/**
     * Возвращает максимальное число.
     * @param first, second два числа.
     * @return максимальное значение.
	 */
	 public int max(int first, int second) {
		 return first > second ? first : second;
	 }

	/**
	 * Возвращает максимальное число из трех.
	 * @param first, первое число.
	 * @param second, второе число.
	 * @param third, третье число.
	 * @return temp - максимальное значение.
	 */
	public int maxofthree(int first, int second, int third) {
		return this.max(this.max(first, second), third);
	}
}