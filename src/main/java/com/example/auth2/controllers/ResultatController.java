package com.example.auth2.controllers;


import com.example.auth2.models.Objectif;
import com.example.auth2.models.Resultat;
import com.example.auth2.repository.ResultatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;



@CrossOrigin(origins = "http://localhost:8081", maxAge = 3600,  allowCredentials="true")
@RestController
@RequestMapping("/api")
public class ResultatController {

    @Autowired
    ResultatRepository resultatRepository;


    //liste des resultats attendus
    @GetMapping("/resultats")
    public List<Resultat> getAllResultats() {

        return resultatRepository.findAll();

    }


    //creation d'un resultat
    @PostMapping("/createResultat")
    public Resultat createResultat(@RequestBody Resultat resultat) {
        return  resultatRepository.save(resultat);

    }

    //suppression d'un resultat
    @DeleteMapping("/deleteResultat/{id}")
    public ResponseEntity<HttpStatus> deleteResultat(@PathVariable("id") int id) {
        try {
            resultatRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //  modification d'un resultat
    @PutMapping("/updateResultat/{id}")
    public ResponseEntity<Resultat> updateResultat(@PathVariable("id") int id, @RequestBody Resultat resultat) {

        Optional<Resultat> resultatData = resultatRepository.findById(id);

        if (resultatData.isPresent()) {
            Resultat _resultat = resultatData.get();

            _resultat.setLibele_resultat(resultat.getLibele_resultat());
            _resultat.setDescription_resultat(resultat.getDescription_resultat());

            _resultat.setId_objectif(resultat.getId_objectif());


            return new ResponseEntity<>(resultatRepository.save(_resultat), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    // get resultat by objectif id
    @GetMapping("/resultat_objectif/{id}")
    public List<Resultat> getResultatsByObjectifId(@PathVariable int id) {
        return resultatRepository.findByObjectifId(id);
    }

}
