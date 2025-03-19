package com.example.demo.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.resource.NoResourceFoundException;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler({NoResourceFoundException.class})
    protected ResponseEntity<Object> handleNoResourceFoundException() {
        return ResponseEntity.badRequest().build();
    }

    @ExceptionHandler({MethodArgumentTypeMismatchException.class})
    protected ResponseEntity<Object> handleMethodArgumentTypeMismatchException() {
        return ResponseEntity.badRequest().build();
    }
}
