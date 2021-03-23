package com.bianca.ejercicios.exception;

import com.bianca.ejercicios.exception.custom.BadRequestException;
import com.bianca.ejercicios.message.ErrorResponse;
import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.io.FileNotFoundException;
import java.io.IOException;
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

    @ExceptionHandler(FileNotFoundException.class)
    ResponseEntity<ErrorResponse> handleFileNotFound(FileNotFoundException exception)
    {
        ErrorResponse errorResponse = ErrorResponse.builder()
                .statusCode(HttpStatus.NOT_FOUND.value())
                .timestamp(new Date())
                .message("El archivo del cual se está queriendo obtener los beneficios no existe.")
                .build();

        log.log(Level.WARNING, "El archivo JSON especificado no existe.");

        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(IOException.class)
    ResponseEntity<ErrorResponse> handleIO(IOException exception)
    {
        ErrorResponse errorResponse = ErrorResponse.builder()
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .timestamp(new Date())
                .message("Ha ocurrido un error en la integridad de datos.")
                .build();

        log.log(Level.WARNING, "Hubo un problema con la integridad de datos.");

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
