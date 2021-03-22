package com.bianca.ejercicios.exception;

import com.bianca.ejercicios.exception.custom.BadRequestException;
import com.bianca.ejercicios.message.ErrorResponse;
import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;
import java.util.logging.Level;

@Log
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(BadRequestException.class)
    ResponseEntity<ErrorResponse> handleBadRequest(BadRequestException exception)
    {
        ErrorResponse errorResponse = ErrorResponse.builder()
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .timestamp(new Date())
                .message(exception.getMessage())
                .build();

        log.log(Level.WARNING, "Ha ocurrido un error al querer realizar esa acción.");

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
