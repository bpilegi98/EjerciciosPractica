package com.bianca.ejercicios.service;

import com.bianca.ejercicios.model.Benefit;
import com.bianca.ejercicios.model.enums.TypeBenefit;
import com.bianca.ejercicios.repository.BenefitRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
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

    //Método que deserealiza el json y lo convierte a una lista de beneficios con sus
    //respectivos datos seteados
    public List<Benefit> convert() throws IOException {
        return objectMapper.readValue(new File(PATH_FILE),
                objectMapper.getTypeFactory().constructCollectionType(List.class, Benefit.class));
    }

    //Método que realiza persistencia de la lista de beneficios
    public void saveFromList() throws IOException {
        benefitRepository.saveAll(convert());
    }

    public void filterVariable() throws IOException {
        List<Benefit> benefitsVariable = convert().stream()
                .filter(b -> b.getType().equals(TypeBenefit.VARIABLE))
                .collect(Collectors.toList());
        benefitRepository.saveAll(benefitsVariable);
    }
}
