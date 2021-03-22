package com.bianca.ejercicios.message;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class OptionalEmptyResponseImpl implements OptionalEmptyResponse{


    @Override
    public String getMessage() {
        return "Ha ocurrido un error al momento de deserealizar los datos del JSON.";
    }
}
