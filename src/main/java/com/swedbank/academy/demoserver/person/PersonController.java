package com.swedbank.academy.demoserver.person;

import com.swedbank.academy.demoserver.person.exception.PersonAlreadyExistException;
import com.swedbank.academy.demoserver.person.exception.PersonNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/persons")
public class PersonController {

    PersonService personService;
    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping(produces = "application/json")
    public ResponseEntity<List<Person>> getPersons(){
        List<Person> list = personService.getAll();
        return new ResponseEntity<List<Person>>(list, HttpStatus.OK);
    }

    @GetMapping("{pid}")
    public ResponseEntity<Person> getPersonByPid(@PathVariable("pid") Long pid) {
        try {
            Person person = personService.getById(pid);
            return new ResponseEntity<Person>(person, HttpStatus.OK);
        } catch (PersonNotFoundException ex) {

            //log.error("getPersonByPid", ex);
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("{pid}")
    public ResponseEntity<Void> deletePerson(@PathVariable("pid") Long pid) {
        try {
            personService.delete(pid);
            return ResponseEntity.ok().build();
        } catch (PersonNotFoundException e) {
            //log.error("deletePerson", e);
            return ResponseEntity.notFound().build();
        }

    }
  @PostMapping("insert")
    public ResponseEntity<Void> addNewPerson(@Valid @RequestBody Person person){
      try {
          personService.addPerson(person);
          return ResponseEntity.ok().build();
      } catch (PersonAlreadyExistException e) {
          //log.error("deletePerson", e);
          return ResponseEntity.notFound().build();
      }
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Void> editPerson(@PathVariable(value = "pid") long pid, @Valid @RequestBody Person person){
        try {
            personService.editPerson(pid, person);
            return ResponseEntity.ok().build();
        } catch (PersonNotFoundException e) {
            //log.error("deletePerson", e);
            return ResponseEntity.notFound().build();
        }
    }
}




