package com.example.dictionary.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

@ControllerAdvice
public class ControllerAdvisor {


    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleException(WordNotFoundException ex) {

        Map<String, Object> body = new LinkedHashMap<>(); //retains insertion order, literally a linked list
        body.put("timestamp", LocalDateTime.now());
        body.put("message", ex.getMessage());

        return new ResponseEntity<>(body, HttpStatus.SERVICE_UNAVAILABLE);
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleException(Exception ex) {

        Map<String, Object> body = new LinkedHashMap<>(); //retains insertion order, literally a linked list
        body.put("timestamp", LocalDateTime.now());
        body.put("message", "The service is unavailable");

        return new ResponseEntity<>(body, HttpStatus.SERVICE_UNAVAILABLE);
}
}
