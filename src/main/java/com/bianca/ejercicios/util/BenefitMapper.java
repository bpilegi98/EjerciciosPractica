package com.bianca.ejercicios.util;

import com.bianca.ejercicios.message.BenefitResponse;
import com.bianca.ejercicios.model.Benefit;

import java.util.List;
import java.util.stream.Collectors;

public class BenefitMapper {

    public static BenefitResponse toSimpleInterface(Benefit benefit)
    {
        return BenefitResponse.builder()
                .type(benefit.getType())
                .discountAmount(benefit.getDiscountAmount())
                .build();
    }

    public static List<BenefitResponse> toSimpleInterfaceList(List<Benefit> benefits)
    {
        return benefits.stream()
                .map(BenefitMapper::toSimpleInterface)
                .collect(Collectors.toList());
    }
}
