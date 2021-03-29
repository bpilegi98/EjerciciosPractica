package com.bianca.ejercicios.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class GenericClass <T>{

    T object;

}
