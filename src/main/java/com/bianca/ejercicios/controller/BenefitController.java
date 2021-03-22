package com.bianca.ejercicios.controller;

import com.bianca.ejercicios.message.BenefitResponse;
import com.bianca.ejercicios.model.Benefit;
import com.bianca.ejercicios.service.BenefitService;
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
    public void exerciseOneA() throws Exception
    {
        benefitService.saveAll(benefitService.filterVariable());
    }

    @GetMapping("/1b")
    public void exerciseOneB() throws Exception {
        System.out.println(benefitService.orderByDiscountAmountHighestToLowest());
    }

    @GetMapping("/1c")
    public List<Benefit> exerciseOneC() throws Exception {
        return benefitService.filterVariable();
    }

    @GetMapping("/2")
    public void exerciseTwo() throws IOException {
        System.out.println("BENEFICIOS = " + benefitService.checkIfOptionalEmpty());
    }

    @GetMapping("/4")
    public List<BenefitResponse> exerciseFour() throws IOException {
        return benefitService.changeBenefitDataShown();
    }
}
