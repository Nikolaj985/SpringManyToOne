package com.swedbank.academy.demoserver.group;

import com.swedbank.academy.demoserver.group.exception.GroupExistsException;
import com.swedbank.academy.demoserver.group.exception.GroupNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GroupExceptionController {

    @ExceptionHandler(value = GroupNotFoundException.class)
    public ResponseEntity<Object> exception(GroupNotFoundException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = GroupExistsException.class)
    public ResponseEntity<Object> exception(GroupExistsException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.IM_USED);
    }
}
