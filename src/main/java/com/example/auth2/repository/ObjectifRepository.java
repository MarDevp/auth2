package com.example.auth2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.auth2.models.Objectif;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ObjectifRepository extends JpaRepository<Objectif,Integer>{


    @Query("SELECT o FROM Objectif o WHERE o.id_projet = :id_projet")
    List<Objectif> findByProjetId(@Param("id_projet") int id_projet);
}
