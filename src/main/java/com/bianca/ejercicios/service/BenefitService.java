package com.bianca.ejercicios.service;

import com.bianca.ejercicios.model.Benefit;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BenefitService {

    private final String PATH_FILE = "src/main/resources/example.json";

    ObjectMapper objectMapper = new ObjectMapper();

    public List<Benefit> convert() throws JsonProcessingException {
        return objectMapper.readValue(PATH_FILE, new TypeReference<List<Benefit>>() {});
    }
}
