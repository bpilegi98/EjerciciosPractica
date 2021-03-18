package com.bianca.ejercicios.repository;

import com.bianca.ejercicios.model.Benefit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BenefitRepository extends JpaRepository<Benefit, Long> {
}
