package com.example.auth2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.auth2.models.Objectif;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ObjectifRepository extends JpaRepository<Objectif,Integer>{



 //pour les objectifs
List<Objectif>  findByIdProjetAndIsObjectifIsTrue(int idPojet);

//pour les resultats
List<Objectif>  findByIdProjetAndIsObjectifIsFalse(int idPojet);

 //pour les resultats par objectif
 List<Objectif>  findByResIdObjectifAndIsObjectifIsFalse(int idObjectif);
}





