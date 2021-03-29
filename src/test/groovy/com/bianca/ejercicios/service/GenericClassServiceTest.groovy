package com.bianca.ejercicios.service

import com.bianca.ejercicios.model.GenericClass
import com.bianca.ejercicios.repository.GenericClassRepository
import spock.lang.Specification

class GenericClassServiceTest extends Specification {

    def genericRepository = Mock(GenericClassRepository)
    def genericService = new GenericClassService(genericRepository)

    def "testCase"()
    {
        declaration:
        def generic = Mock(GenericClass)
        usage:
        generic as GenericClass<String>
    }

    def "GetAll"() {
        given:
        def generics = [Stub(GenericClass), Stub(GenericClass)]
        genericRepository.findAll() >> [new GenericClass(new String()), new GenericClass(new Integer())]
        when:
        Iterable<GenericClass> result = genericRepository.findAll()
        then:
        result.toString() == generics.toString()
    }
}
