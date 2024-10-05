package com.tutorial.employeemanagement.exception.image;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ImageDoesNotExistException extends RuntimeException {
    public ImageDoesNotExistException(Long id) {
        super("Image with id " + id + " does not exist");
    }
}
