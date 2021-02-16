package com.swedbank.academy.demoserver.person.exception;

import com.swedbank.academy.demoserver.person.Person;

public class PersonAlreadyExistException extends Exception{
    public PersonAlreadyExistException(Person person) {
        super("Person with id :"+ person.getPid() +" already exist");
    }
}
