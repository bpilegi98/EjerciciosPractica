package com.bianca.ejercicios.enums;

public enum TypeBenefit {

    VARIABLE("VARIABLE"),
    FIXED("FIXED");

    private final String name;

    TypeBenefit(final String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }
}
