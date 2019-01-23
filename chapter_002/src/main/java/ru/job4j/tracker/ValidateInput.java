package ru.job4j.tracker;

/** @since 01.2018
  * @author tumen.garmazhapov (gtb-85@yandex.ru)
  */
public class ValidateInput implements Input {

    private final Input input;

    public ValidateInput(final Input input) {
        this.input = input;
    }

    @Override
    public String ask(String question) {
        return this.input.ask(question);
    }

    public int ask(String question, int[] range) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = this.input.ask(question, range);
                invalid = false;
            } catch (MenuOutException moe) {
                System.out.println("Некорректный ввод! Введите число из диапазона меню.");
            } catch (NumberFormatException nfe) {
                System.out.println("Некорректный ввод! Введите в числовом формате.");
            }
        } while (invalid);
        return value;
    }
}
