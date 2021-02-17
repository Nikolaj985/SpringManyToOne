package com.swedbank.academy.demoserver.person.exception;

public class PersonNotFoundException extends RuntimeException {
    public PersonNotFoundException(long pid) {
        super("Can't find person: " + pid);
    }
}
