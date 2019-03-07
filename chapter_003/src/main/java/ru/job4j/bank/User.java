package ru.job4j.bank;

/**
 * @author tumen.garmazhapov
 * @since 03.2019
 */
public class User {

    private String name;
    private String passport;

    public User(String name, String passport) {
        this.name = name;
        this.passport = passport;
    }

    public String getName() { return this.name; }

    public String getPassport() { return this.passport; }
}
