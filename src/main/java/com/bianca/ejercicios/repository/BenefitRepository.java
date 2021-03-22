package com.bianca.ejercicios.repository;

import com.bianca.ejercicios.model.Benefit;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BenefitRepository extends CrudRepository<Benefit, Long> {
}
