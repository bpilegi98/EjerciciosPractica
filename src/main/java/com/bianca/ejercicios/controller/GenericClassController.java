package com.bianca.ejercicios.controller;

import com.bianca.ejercicios.model.GenericClass;
import com.bianca.ejercicios.service.GenericClassService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/generic")
public class GenericClassController {

    private final GenericClassService genericClassService;

    public GenericClassController(GenericClassService genericClassService) {
        this.genericClassService = genericClassService;
    }

    @PostMapping("/create")
    public void create(@RequestBody GenericClass object)
    {
        genericClassService.save(object);
    }

    @GetMapping("/display")
    public void display()
    {
        genericClassService.displayAll();
    }
}
