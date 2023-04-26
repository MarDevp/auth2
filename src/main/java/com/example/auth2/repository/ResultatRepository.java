package com.example.auth2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.auth2.models.Resultat;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResultatRepository extends JpaRepository<Resultat,Integer> {


    @Query("SELECT r FROM Resultat r WHERE r.id_objectif = :id_objectif")
    List<Resultat> findByObjectifId(@Param("id_objectif") int id_objectif);

}
