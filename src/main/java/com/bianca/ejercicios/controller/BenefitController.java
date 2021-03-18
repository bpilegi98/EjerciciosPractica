package com.bianca.ejercicios.controller;

import com.bianca.ejercicios.model.Benefit;
import com.bianca.ejercicios.service.BenefitService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ejercicio")
public class BenefitController {

    private BenefitService benefitService;

    public BenefitController(BenefitService benefitService) {
        this.benefitService = benefitService;
    }

    @GetMapping("/1")
    public List<Benefit> exerciseOne() throws JsonProcessingException {
        return benefitService.convert();
    }
}
