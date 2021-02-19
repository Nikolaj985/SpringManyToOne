package com.swedbank.academy.demoserver.country.exception;

import java.util.function.Supplier;

public class CountryNotFoundException extends RuntimeException {
    public CountryNotFoundException(long message) {
        super("Country with id: "+  message+" does not exist!");
    }

    public CountryNotFoundException(String message) {
        super(message);
    }
}
