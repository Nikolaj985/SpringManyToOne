package com.swedbank.academy.demoserver.country;

import com.swedbank.academy.demoserver.country.exception.CountryNotFoundException;
import com.swedbank.academy.demoserver.group.exception.GroupNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class CountryExceptionController {
    @ExceptionHandler(value = CountryNotFoundException.class)
    public ResponseEntity<Object> exception(CountryNotFoundException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }
}
