package com.bianca.ejercicios.repository;

import com.bianca.ejercicios.model.GenericClass;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenericClassRepository extends CrudRepository<GenericClass, Long> {
}
