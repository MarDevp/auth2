package com.example.auth2.controllers;

import com.example.auth2.models.Indicateur;

import com.example.auth2.models.Objectif;
import com.example.auth2.repository.IndicateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.auth2.controllers.ObjectifController;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@CrossOrigin(origins = "http://localhost:8081", maxAge = 3600,  allowCredentials="true")
@RestController
@RequestMapping("/api")
public class IndicateurController {

    @Autowired
    IndicateurRepository indicateurRepository;

    @Autowired
    private ObjectifController objectifController;


    //liste des indicateurs
    @GetMapping("/indicateurs")
    public List<Indicateur> getAllindicateurs() {

        return indicateurRepository.findAll();
    }



    //creation d'un indicateur
    @PostMapping("/createIndicateur")
    public Indicateur createIndicateur(@RequestBody Indicateur indicateur) {
        return  indicateurRepository.save(indicateur);

    }


    //suppression d'un indicateur
    @DeleteMapping("/deleteIndicateur/{id}")
    public ResponseEntity<HttpStatus> deleteIndicateur(@PathVariable("id") int id) {
        try {
            indicateurRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    //  modification d'un indicateur
    @PutMapping("/updateIndicateur/{id}")
    public ResponseEntity<Indicateur> updateIndicateur(@PathVariable("id") int id, @RequestBody Indicateur indicateur) {

        Optional<Indicateur> indicateurData = indicateurRepository.findById(id);

        if (indicateurData.isPresent()) {
            Indicateur _indicateur = indicateurData.get();


            _indicateur.setLibele_indicateur(indicateur.getLibele_indicateur());
            _indicateur.setDescription_indicateur(indicateur.getDescription_indicateur());
            _indicateur.setFormat_indicateur(indicateur.getFormat_indicateur());
            _indicateur.setUnite_mes_indicateur(indicateur.getUnite_mes_indicateur());
            _indicateur.setValeur_initiale_indicateur(indicateur.getValeur_initiale_indicateur());
            _indicateur.setValeur_cible_indicateur(indicateur.getValeur_cible_indicateur());
            _indicateur.setDate_prevu_realisation_indicateur(indicateur.getDate_prevu_realisation_indicateur());
            _indicateur.setTendance_souhaite_hausse(indicateur.getTendance_souhaite_hausse());
            _indicateur.setMoyen_verification_indicateur(indicateur.getMoyen_verification_indicateur());
            _indicateur.setObjres(indicateur.getObjres());
            _indicateur.setId_objres(indicateur.getId_objres());

            return new ResponseEntity<>(indicateurRepository.save(_indicateur), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    // get indicateur by project id
    @GetMapping("/indicateur_projet/{id}")
    public List<Indicateur> getIndicateursByProjetId(@PathVariable int id) {

        List<Indicateur> resIndicateurs;
        List<Indicateur> listeIndicateurs = new ArrayList<>();;
        Indicateur ind;
        List<Objectif> listeObjectifs = objectifController.getObjectifsByProjetId(id);

        for (Objectif objectif : listeObjectifs) {

            resIndicateurs=indicateurRepository.findIndicateurByProjetId(id);

            for(Indicateur indi : resIndicateurs)
            {
                listeIndicateurs.add(indi);

            }


        }

        return listeIndicateurs;


    }


}
