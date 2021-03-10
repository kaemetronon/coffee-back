package ru.coffee.nostresso.controller.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.coffee.nostresso.model.response.FailResponce;

import java.util.Arrays;

@RestControllerAdvice
public class ControllerAdvice {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<FailResponce> handle(Exception e) {
        e.printStackTrace();
        return new ResponseEntity<>(
                new FailResponce(e.getMessage() +  Arrays.toString(e.getStackTrace())),
                HttpStatus.valueOf(501));
    }
}
