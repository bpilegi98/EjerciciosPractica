package com.bianca.ejercicios.controller

import com.bianca.ejercicios.model.Benefit
import com.bianca.ejercicios.repository.BenefitRepository
import com.bianca.ejercicios.service.BenefitService
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.BeforeAll
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.util.ReflectionTestUtils
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import spock.lang.Specification

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@SpringBootTest
class BenefitControllerTest extends Specification {

    BenefitRepository benefitRepository = Mock(BenefitRepository)

    private BenefitService benefitService = new BenefitService(benefitRepository)

    private BenefitController benefitController = new BenefitController(benefitService)

    private MockMvc mockMvc

    private ObjectMapper objectMapper = new ObjectMapper()

    @BeforeAll
    void setup()
    {
        mockMvc = MockMvcBuilders.standaloneSetup(benefitController).build()
        ReflectionTestUtils.setField(benefitService, "objectMapper", objectMapper)
    }

    def "SaveFromList"() {
        given:
        def benefits = new ArrayList()
        def benefit = Mock(Benefit.class)
        benefits.add(benefit)
        objectMapper.readValue(_ as File, _) >> benefits
        expect: "Status is 200 OK"
        mockMvc.perform(get("/benefit/save"))
        .andExpect(status().is(200))
    }
}
