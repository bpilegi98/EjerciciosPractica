package com.bianca.ejercicios.controller;

import com.bianca.ejercicios.exception.custom.BadRequestException;
import com.bianca.ejercicios.message.BenefitResponse;
import com.bianca.ejercicios.model.Benefit;
import com.bianca.ejercicios.service.BenefitService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/benefit")
public class BenefitController {

    private final BenefitService benefitService;

    public BenefitController(BenefitService benefitService) {
        this.benefitService = benefitService;
    }

    @GetMapping("/save")
    public void saveFromList() throws IOException {
        benefitService.saveFromList();
    }

    @GetMapping("/variable/save")
    public void saveAllVariableBenefits() throws Exception
    {
        benefitService.saveAll(benefitService.filterVariable());
    }

    @GetMapping("/variable/order")
    public void orderBenefitsByDiscoutAmount() throws Exception {
        System.out.println(benefitService.orderByDiscountAmountHighestToLowest());
    }

    @GetMapping("/variable/getAll")
    public List<Benefit> getVariableBenefits() throws Exception {
        return benefitService.filterVariable();
    }

    @GetMapping("/variable/optional")
    public void getOptionalVariableBenefits() throws IOException, BadRequestException {
        System.out.println("BENEFICIOS = " + benefitService.checkIfOptionalEmpty());
    }

    @GetMapping("/client/getAll")
    public List<BenefitResponse> getAllClientInterface() throws IOException {
        return benefitService.changeBenefitDataShown();
    }

    @PostMapping("/guardar")
    public void guardar(@Valid @RequestBody Benefit benefit)
    {
        log.info(benefit.toString());
        benefitService.saveAll(Collections.singletonList(benefit));
    }
}
