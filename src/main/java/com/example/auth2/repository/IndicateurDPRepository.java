package com.example.auth2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.auth2.models.IndicateurDP;
import org.springframework.stereotype.Repository;

@Repository
public interface IndicateurDPRepository extends JpaRepository<IndicateurDP,Integer>

{
}
