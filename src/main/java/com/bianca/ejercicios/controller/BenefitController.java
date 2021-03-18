package com.bianca.ejercicios.controller;

import com.bianca.ejercicios.model.Benefit;
import com.bianca.ejercicios.service.BenefitService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/ejercicio")
public class BenefitController {

    private BenefitService benefitService;

    public BenefitController(BenefitService benefitService) {
        this.benefitService = benefitService;
    }

    @GetMapping("/1")
    public void exerciseOne() throws IOException {
        benefitService.saveFromList();
    }

    @GetMapping("/1a")
    public void exerciseOneA() throws IOException
    {
        benefitService.saveAll(benefitService.filterVariable());
    }

    @GetMapping("/1b")
    public void exerciseOneB() throws IOException {
        System.out.println(benefitService.orderByDiscountAmountHighestToLowest());
    }
}
