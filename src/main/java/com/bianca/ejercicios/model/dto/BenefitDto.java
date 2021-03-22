package com.bianca.ejercicios.model.dto;

import com.bianca.ejercicios.enums.TypeBenefit;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "benefits")
public class BenefitDto {

    @Id
    @GeneratedValue
    private Long id;

    @Enumerated(EnumType.STRING)
    private TypeBenefit type;

    @Column(name ="discount_amount")
    private double discountAmount;

    @Column(name = "foreign_key")
    private Long foreignKey;
}
