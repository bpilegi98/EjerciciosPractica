package com.bianca.ejercicios.service;

import com.bianca.ejercicios.model.Benefit;
import com.bianca.ejercicios.enums.TypeBenefit;
import com.bianca.ejercicios.repository.BenefitRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BenefitService {

    private final String PATH_FILE = "src/main/resources/example.json";

    private final BenefitRepository benefitRepository;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public BenefitService(BenefitRepository benefitRepository) {
        this.benefitRepository = benefitRepository;
    }

    public void saveAll(List<Benefit> benefits)
    {
        benefitRepository.saveAll(benefits);
    }

    //Método que deserealiza el json y lo convierte a una lista de beneficios con sus
    //respectivos datos seteados
    public List<Benefit> convertFromJsonToList() throws IOException {
        return objectMapper.readValue(new File(PATH_FILE),
                objectMapper.getTypeFactory()
                            .constructCollectionType(List.class, Benefit.class));
    }

    //Método que realiza persistencia de la lista de beneficios
    public void saveFromList() throws IOException {
        benefitRepository.saveAll(convertFromJsonToList());
    }

    //Método que filtra los beneficios que son variables
    public List<Benefit> filterVariable() throws Exception {
        List<Benefit> benefits = convertFromJsonToList().stream()
                .filter(b -> b.getType().equals(TypeBenefit.VARIABLE))
                .collect(Collectors.toList());

        return Optional.of(benefits)
                .orElseThrow(() -> new Exception("No existen beneficios que coincidan con el tipo variable."));
    }

    //Método que ordena el array devuelvo en el método filterVariable
    //de mayor a menor por el valor de discount_amount
    public List<Benefit> orderByDiscountAmountHighestToLowest() throws Exception {
        List<Benefit> benefitsVariable = filterVariable();

        return benefitsVariable.stream()
                .sorted(Comparator.comparingDouble(Benefit::getDiscountAmount).reversed())
                .collect(Collectors.toList());
    }

    //Método que deserealiza el json y lo convierte a una lista de beneficios con sus
    //respectivos datos seteados. Devuelve un optional o un empty optional sino se pudo
    //realizar correctamente
    public Optional<List<Benefit>> convertWithOptional() throws IOException {
        List<Benefit> benefits = convertFromJsonToList();
        return (benefits.isEmpty()) ? Optional.empty() : Optional.of(benefits);
    }
}
