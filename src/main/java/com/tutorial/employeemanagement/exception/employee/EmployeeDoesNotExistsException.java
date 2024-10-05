package com.tutorial.employeemanagement.exception.employee;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EmployeeDoesNotExistsException extends RuntimeException{
    public EmployeeDoesNotExistsException(Long id) {
        super("Employee with id " + id + " does not exist");
    }
}
