package com.example.auth2.repository;

import com.example.auth2.models.Objectif;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.auth2.models.Indicateur;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IndicateurRepository  extends JpaRepository<Indicateur,Integer> {

    @Query("SELECT i FROM Indicateur i WHERE i.id_objectif = :id_objectif")
    List<Indicateur> findIndicateurByProjetId(@Param("id_objectif") int id_objectif);
}


