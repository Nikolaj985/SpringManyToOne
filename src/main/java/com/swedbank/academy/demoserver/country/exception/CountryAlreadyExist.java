package com.swedbank.academy.demoserver.country.exception;

import org.springframework.dao.DataIntegrityViolationException;

public class CountryAlreadyExist extends DataIntegrityViolationException {
    public CountryAlreadyExist() {
        super("Country already exist!");
    }
}
