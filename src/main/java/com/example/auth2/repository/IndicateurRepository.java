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

    List<Indicateur> findByObjectifIdProjet(int id);

    // trouver indicateur resultat/objectif by projetid
    List<Indicateur> findByObjectifIdProjetAndObjres(int id,int x);


    // trouver les indicateur d'un objectif donc par objectif_id
    List<Indicateur> findByObjectifIdObjectif(int id);


   /* @Query("SELECT o.libele_objectif, p.intitule_projet, COUNT(i) " +
            "FROM indicateur i " +
            "JOIN i.objectif o " +
            "JOIN o.project p " +
            "WHERE p.idProject = :projectId " +
            "GROUP BY o.id_objectif, o.libele_objectif, p.id_projet, p.intitule_projet")
    List<Indicateur> countIndicateursByObjectifAndProjet(@Param("projectId") int projectId);*/




    @Query(value = "SELECT * FROM indicateur i JOIN objectif o ON i.id_objres = o.id_objectif WHERE o.id_projet = :id_projet and i.objres = 1", nativeQuery = true)
    List<Indicateur> findIndicateurObjectifByProjetId(@Param("id_projet") int id_projet);


    @Query(value = "SELECT * FROM indicateur i JOIN resultat r ON i.id_objres = r.id_resultat JOIN objectif o ON r.id_objectif = o.id_objectif WHERE o.id_projet = :id_projet and i.objres = 2", nativeQuery = true)
    List<Indicateur> findIndicateurResultatByProjetId(@Param("id_projet") int id_projet);
}


