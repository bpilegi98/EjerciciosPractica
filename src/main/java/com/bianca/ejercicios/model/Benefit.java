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
import javax.validation.constraints.Pattern;

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

    //^[A-Za-z0-9+_.-]+@(.+)$
    //\b[a-zA-Z0-9._-]+@[A-Za-z]+\'.com'\b
    //[a-zA-Z0-9_-]+@[A-Za-z]'.com'
    @Pattern(regexp = "[a-zA-Z0-9_-]+@[A-Za-z]'.com'", message = "Debe respetar las normas")
    private String mail;
}
