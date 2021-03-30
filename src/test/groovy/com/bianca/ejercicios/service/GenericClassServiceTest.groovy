package com.bianca.ejercicios.service

import com.bianca.ejercicios.model.GenericClass
import com.bianca.ejercicios.repository.GenericClassRepository
import spock.lang.Specification

class GenericClassServiceTest extends Specification {

    def genericRepository = Mock(GenericClassRepository)
    def genericService = new GenericClassService(genericRepository)


    def "GetAll"() {
        given:
        def genericString = (GenericClass<String>) Mock(GenericClass){
            getObject() >> "Hola"
        }
        def generics = [genericString]
        genericRepository.findAll() >> generics
        when:
        Iterable<GenericClass<String>> result = genericService.getAll()
        then:
        result.getAt(0).getObject().equals(generics.get(0).getObject())
    }

    def "Test display"()
    {
        given:
        def genericString = (GenericClass<String>) Mock(GenericClass){
            getObject() >> "Hola"
        }
        when:
        genericService.displayString(genericString)
        then:
        true
    }
}
