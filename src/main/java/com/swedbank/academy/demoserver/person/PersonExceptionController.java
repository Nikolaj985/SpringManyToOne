package com.swedbank.academy.demoserver.person;

import com.swedbank.academy.demoserver.country.exception.CountryNotFoundException;
import com.swedbank.academy.demoserver.group.exception.GroupNotFoundException;
import com.swedbank.academy.demoserver.person.exception.PersonNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class PersonExceptionController {
    @ExceptionHandler(value = PersonNotFoundException.class)
    public ResponseEntity<Object> exception(PersonNotFoundException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = CountryNotFoundException.class)
    public ResponseEntity<Object> exception(CountryNotFoundException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = GroupNotFoundException.class)
    public ResponseEntity<Object> exception(GroupNotFoundException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }


}

