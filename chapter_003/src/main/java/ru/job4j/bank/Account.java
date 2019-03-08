package ru.job4j.bank;

/**
 * @author tumen.garmazhapov
 * @since 03.2019
 */
public class Account {

    private double value;
    private String requisites;

    public Account(double value, String requisites) {
        this.value = value;
        this.requisites = requisites;
    }

    public double getValue() {
        return this.value;
    }

    public String getRequisites() {
        return this.requisites;
    }

    /**
     * переводит сумму на счет получателя
     * @param destination - счет пользователя(получатель)
     * @param amount - сумма перевода
     * @return true - при успешной транзакции, false - если транзакция не прошла
     */
    boolean transfer(Account destination, double amount) {
        boolean success = false;
        if (amount > 0 && amount < this.value && destination != null) {
            success = true;
            this.value -= amount;
            destination.value += amount;
        }
        return success;
    }
}
