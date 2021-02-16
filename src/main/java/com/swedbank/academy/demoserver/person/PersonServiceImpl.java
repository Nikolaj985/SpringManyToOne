package com.swedbank.academy.demoserver.person;

import com.swedbank.academy.demoserver.person.exception.PersonAlreadyExistException;
import com.swedbank.academy.demoserver.person.exception.PersonNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    private PersonRepository personRepository;

    @Autowired
    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public List<Person> getAll() {
        return personRepository.findAll();
    }

    @Override
    public Person getById(long pid) throws PersonNotFoundException {
        Person person = personRepository.findById(pid).orElseThrow(() -> new PersonNotFoundException(pid));

        return person;
    }

    @Override
    public void delete(long pid) throws PersonNotFoundException {
        Person person = personRepository.findById(pid).orElseThrow(() -> new PersonNotFoundException(pid));
        personRepository.deleteById(pid);
    }

    @Override
    public void addPerson(Person person) throws PersonAlreadyExistException {
        if (personRepository.existsById(person.getPid())) {
            throw new PersonAlreadyExistException(person);
        } else {
            personRepository.save(person);
        }
    }

    @Override
    public void editPerson(long pid, Person person) throws PersonNotFoundException {
        Person personToEdit = personRepository.findById(pid).orElseThrow(() -> new PersonNotFoundException(pid));
        personToEdit.setPid(person.getPid());
        personToEdit.setName(person.getName());
        personToEdit.setMiddlename(person.getMiddlename());
        personToEdit.setLastname(person.getLastname());
        personToEdit.setEmail(person.getEmail());
        personToEdit.setPhone(person.getPhone());
        personRepository.save(personToEdit);
    }
}
