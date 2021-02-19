package com.swedbank.academy.demoserver.country.exception;

public class CountryIsUsedException extends RuntimeException {
    public CountryIsUsedException() {
        super("Country can't be deleted while used in other tables!!!");
    }
}
