package com.app.Testing.Exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = RuntimeException.class)
    ResponseEntity<String>handlingRuntimeException(RuntimeException runtimeException){
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(runtimeException.getMessage());
    }
}
