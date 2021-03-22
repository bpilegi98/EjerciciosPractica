package com.bianca.ejercicios.model;

import com.bianca.ejercicios.enums.TypeBenefit;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
@Table(name = "benefits")
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Benefit {

    @Id
    private Long id;

    @Enumerated(EnumType.STRING)
    private TypeBenefit type;

    @Column(name ="discount_amount")
    private double discountAmount;

    @Column(name = "foreign_key")
    private Long foreignKey;
}
