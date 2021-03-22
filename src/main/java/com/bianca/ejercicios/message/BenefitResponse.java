package com.bianca.ejercicios.message;

import com.bianca.ejercicios.enums.TypeBenefit;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class BenefitResponse {

    private TypeBenefit type;

    private double discountAmount;
}
