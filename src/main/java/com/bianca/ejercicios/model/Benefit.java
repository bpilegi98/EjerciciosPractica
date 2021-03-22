package com.bianca.ejercicios.model;

import com.bianca.ejercicios.enums.TypeBenefit;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Benefit {

    private Long id;

    private TypeBenefit type;

    private double discountAmount;

    private Long foreignKey;
}
