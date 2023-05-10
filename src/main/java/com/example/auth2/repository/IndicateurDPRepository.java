package com.example.auth2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.auth2.models.IndicateurDP;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IndicateurDPRepository extends JpaRepository<IndicateurDP,Integer>
{
    List<IndicateurDP> findByIdIndicateur(int id_indicateur);




}
