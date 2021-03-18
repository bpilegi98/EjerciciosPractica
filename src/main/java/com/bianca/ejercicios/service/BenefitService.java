package com.bianca.ejercicios.service;

import com.bianca.ejercicios.model.Benefit;
import com.bianca.ejercicios.repository.BenefitRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class BenefitService {

    private final String PATH_FILE = "src/main/resources/example.json";

    private BenefitRepository benefitRepository;
    private ObjectMapper objectMapper = new ObjectMapper();

    public BenefitService(BenefitRepository benefitRepository) {
        this.benefitRepository = benefitRepository;
    }

    public void convert() throws IOException {
        List<Benefit> aux = objectMapper.readValue(new File(PATH_FILE),
                objectMapper.getTypeFactory().constructCollectionType(List.class, Benefit.class));

        for(Benefit benefit : aux)
        {
            benefitRepository.save(benefit);
        }
    }
}
