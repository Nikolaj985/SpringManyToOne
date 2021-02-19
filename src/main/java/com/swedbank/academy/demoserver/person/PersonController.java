package com.swedbank.academy.demoserver.person;

import com.swedbank.academy.demoserver.country.Country;
import com.swedbank.academy.demoserver.country.CountryService;
import com.swedbank.academy.demoserver.group.Group;
import com.swedbank.academy.demoserver.group.GroupService;
import com.swedbank.academy.demoserver.group.exception.GroupNotFoundException;
import com.swedbank.academy.demoserver.person.exception.PersonNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("api/persons")
public class PersonController {

    private PersonService personService;
    private GroupService groupService;
    private CountryService countryService;

    @Autowired
    public PersonController(PersonService personService, GroupService groupService, CountryService countryService) {
        this.personService = personService;
        this.groupService = groupService;
        this.countryService = countryService;
    }


    @GetMapping(produces = "application/json")
    public ResponseEntity<List<Person>> getPersons() {
        List<Person> list = personService.getAll();
        return new ResponseEntity<List<Person>>(list, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> addPerson(@RequestBody Person person, UriComponentsBuilder builder) {
        boolean success = personService.save(person);
        if (!success) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/person/{id}").buildAndExpand(person.getPid()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    //** READ */
    @GetMapping("{pid}")
    public ResponseEntity<Person> getPersonByPid(@PathVariable("pid") Long pid) {

        Person person = personService.getById(pid);
        return new ResponseEntity<Person>(person, HttpStatus.OK);
    }

    //** UPDATE */
    @PutMapping
    public ResponseEntity<Person> updatePerson(@RequestBody Person person) {
        personService.update(person);
        return new ResponseEntity<Person>(person, HttpStatus.OK);
    }

    //** DELETE */
    @DeleteMapping("{pid}")
    public ResponseEntity<Void> deletePerson(@PathVariable("pid") Long pid) {

        personService.delete(pid);
        return ResponseEntity.ok().build();
    }

    //New code
    @GetMapping("{pid}/groups")
    public ResponseEntity<Collection<Group>> getPersonGroups(@PathVariable("pid") Long pid) {

        Person person = personService.getById(pid);
        return new ResponseEntity<Collection<Group>>(person.getGroups(), HttpStatus.OK);

    }

    @PatchMapping("{pid}/groups/{id}")
    public ResponseEntity<?> setGroup(@PathVariable("pid") long pid, @PathVariable("id") long id) {

        try {
            Person person = personService.getById(pid);
            Group group = groupService.findById(id);
            Set<Group> groups = person.getGroups();
            groups.add(group);
            person.setGroups(groups);
            personService.saveAndFlush(person);
            return ResponseEntity.ok().build();
        } catch (GroupNotFoundException | PersonNotFoundException ex) {
            //log.error("setGroup", ex);
            return ResponseEntity.notFound().build();
        }

    }

    @DeleteMapping("{pid}/groups/{id}")
    public ResponseEntity<?> removeFromGroup(@PathVariable("pid") long pid, @PathVariable("id") long id) {
        Person person = personService.getById(pid);
        Group group = groupService.findById(id);
        Set<Group> groups = person.getGroups();
        if (groups.contains(group)) {
            groups.remove(group);
            person.setGroups(groups);
            personService.saveAndFlush(person);
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();


    }

    //Home work ManyToOne


    @GetMapping("{pid}/country")
    public ResponseEntity<Country> getNationality(@PathVariable("pid") long pid) {
        Person person = personService.getById(pid);
        return new ResponseEntity<Country>(person.getCountry(), HttpStatus.OK);
    }


    @PatchMapping("{pid}/country/{id}")
    public ResponseEntity<?> setCountry(@PathVariable("pid") long pid, @PathVariable("id") long id) {
        Person person = personService.getById(pid);
        Country country = countryService.getById(id);
        person.setCountry(country);
        personService.saveAndFlush(person);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("{pid}/country")
    public ResponseEntity<?> removeCountry(@PathVariable("pid") long pid) {
        Person person = personService.getById(pid);
        if (person.getCountry() != null) {
            person.setCountry(null);
            personService.saveAndFlush(person);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }


}




