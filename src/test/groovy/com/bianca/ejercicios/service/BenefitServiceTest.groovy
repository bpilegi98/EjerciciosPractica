package com.bianca.ejercicios.service

import com.bianca.ejercicios.repository.BenefitRepository
import spock.lang.Specification

class BenefitServiceTest extends Specification {

    def benefitRepository = Mock(BenefitRepository)
    def benefitService = new BenefitService(benefitRepository)

    def "SaveAll"() {
        given:
        def benefits = Collections.emptyList()
        when:
        benefitService.saveAll(benefits)
        then:
        1*benefitRepository.saveAll(_ as List)
    }

    def "FindById"()
    {
        given:
        def num = 8
        when:
        def result = benefitService.findById(num)
        then:
        result == num + 5
    }

}
