package com.bianca.ejercicios.model;

import com.bianca.ejercicios.model.enums.TypeBenefit;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
@Table(name = "benefits")
public class Benefit {

    @Id
    private Long id;

    @Enumerated(EnumType.STRING)
    private TypeBenefit type;

    @Column(name = "discount_amount")
    @JsonProperty("discount_amount")
    private double discountAmount;

    @Column(name = "foreign_key")
    @JsonProperty("foreign_key")
    private Long foreignKey;
}
