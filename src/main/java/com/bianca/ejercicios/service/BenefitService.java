package com.bianca.ejercicios.service;

import com.bianca.ejercicios.model.Benefit;
import com.bianca.ejercicios.model.enums.TypeBenefit;
import com.bianca.ejercicios.repository.BenefitRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BenefitService {

    private final String PATH_FILE = "src/main/resources/example.json";

    private BenefitRepository benefitRepository;
    private ObjectMapper objectMapper = new ObjectMapper();

    public BenefitService(BenefitRepository benefitRepository) {
        this.benefitRepository = benefitRepository;
    }

    public void saveAll(List<Benefit> benefits)
    {
        benefitRepository.saveAll(benefits);
    }

    //Método que deserealiza el json y lo convierte a una lista de beneficios con sus
    //respectivos datos seteados
    public ArrayList<Benefit> convert() throws IOException {
        return objectMapper.readValue(new File(PATH_FILE),
                objectMapper.getTypeFactory().constructCollectionType(ArrayList.class, Benefit.class));
    }

    //Método que realiza persistencia de la lista de beneficios
    public void saveFromList() throws IOException {
        benefitRepository.saveAll(convert());
    }

    //Método que filtra los beneficios que son variables
    public ArrayList<Benefit> filterVariable() throws IOException {
        return convert().stream()
                .filter(b -> b.getType().equals(TypeBenefit.VARIABLE))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    //Método que ordena el array devuelvo en el método filterVariable
    //de mayor a menor por el valor de discount_amount
    public ArrayList<Benefit> orderByDiscountAmountHighestToLowest() throws IOException {
        ArrayList<Benefit> benefitsVariable = filterVariable();
        Collections.sort(benefitsVariable, Comparator.comparingDouble(Benefit::getDiscountAmount).reversed());
        return benefitsVariable;
    }

}
