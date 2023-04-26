package com.example.auth2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.auth2.models.Indicateurvaleur;
import org.springframework.stereotype.Repository;


@Repository
public interface IndicateurvaleurRepository extends JpaRepository<Indicateurvaleur,Integer> {
}
