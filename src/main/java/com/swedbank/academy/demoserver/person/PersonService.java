package com.swedbank.academy.demoserver.person;

import com.swedbank.academy.demoserver.person.exception.PersonAlreadyExistException;
import com.swedbank.academy.demoserver.person.exception.PersonNotFoundException;

import java.util.List;

public interface PersonService {
    List<Person> getAll();
    /** READ*/
    public Person getById(long pid) throws PersonNotFoundException;
    /** DELETE*/
    public void delete(long pid) throws PersonNotFoundException;
    /** CREATE*/
    public boolean save(Person person);
    /** UPDATE */
    public boolean update(Person person)throws PersonNotFoundException;

    public void saveAndFlush(Person person);





}
