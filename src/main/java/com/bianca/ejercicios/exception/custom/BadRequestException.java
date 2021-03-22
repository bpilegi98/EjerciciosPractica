package com.bianca.ejercicios.exception.custom;

public class BadRequestException extends Exception{

    public BadRequestException(String message)
    {
        super(message);
    }
}
