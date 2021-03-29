package com.bianca.ejercicios.service;

import com.bianca.ejercicios.model.GenericClass;
import com.bianca.ejercicios.repository.GenericClassRepository;
import org.springframework.stereotype.Service;

@Service
public class GenericClassService {

    private final GenericClassRepository genericClassRepository;

    public GenericClassService(GenericClassRepository genericClassRepository) {
        this.genericClassRepository = genericClassRepository;
    }


    public Iterable<GenericClass> getAll()
    {
        return genericClassRepository.findAll();
    }

    public static <T> void display(T obj)
    {
        System.out.println(obj.getClass().getSimpleName() + " = " + obj);
    }

    public void save(GenericClass object)
    {
        genericClassRepository.save(object);
    }

    public void displayAll()
    {
        Iterable<GenericClass> list = this.getAll();
        for (GenericClass obj: list)
        {
            this.display(obj);
        }
    }
}
