package com.bianca.ejercicios.message;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@AllArgsConstructor
@Data
@Builder
public class ErrorResponse {

    private int statusCode;
    private Date timestamp;
    private String message;
}
