package com.bianca.ejercicios.model;

import com.bianca.ejercicios.model.enums.TypeBenefit;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Benefit {

    private Long id;

    @Enumerated(EnumType.STRING)
    private TypeBenefit type;

    private double discountAmount;
    private Long foreignKey;
}
