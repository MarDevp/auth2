package com.example.auth2.controllers;

import com.example.auth2.models.Indicateur;
import com.example.auth2.models.Indicateurvaleur;


import com.example.auth2.repository.IndicateurvaleurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@CrossOrigin(origins = "http://localhost:8081", maxAge = 3600,  allowCredentials="true")
@RestController
@RequestMapping("/api")
public class IndicateurvaleurController {


    @Autowired
    IndicateurvaleurRepository indicateurvaleurRepository;


    //liste des valeurs indicateurs
    @GetMapping("/indicateursValeurs")
    public List<Indicateurvaleur> getAllindicateursValeurs() {

        return indicateurvaleurRepository.findAll();
    }


    //creation d'une valeur indicateur
    @PostMapping("/createIndicateurValeur")
    public Indicateurvaleur createIndicateurValeur(@RequestBody Indicateurvaleur indicateurvaleur) {
        return  indicateurvaleurRepository.save(indicateurvaleur);

    }

    //suppression d'une valeur indicateur
    @DeleteMapping("/deleteIndicateurvaleur/{id}")
    public ResponseEntity<HttpStatus> deleteIndicateurvaleur(@PathVariable("id") int id) {
        try {
            indicateurvaleurRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //  modification d'une valeur indicateur
    @PutMapping("/updateIndicateurValeur/{id}")
    public ResponseEntity<Indicateurvaleur> updateIndicateurvaleur(@PathVariable("id") int id, @RequestBody Indicateurvaleur indicateurvaleur) {

        Optional<Indicateurvaleur> indicateurvaleurData = indicateurvaleurRepository.findById(id);

        if (indicateurvaleurData.isPresent()) {
            Indicateurvaleur _indicateurvaleur = indicateurvaleurData.get();


            _indicateurvaleur.setId_indicateur(indicateurvaleur.getId_indicateur());
            _indicateurvaleur.setValeur_indicateur(indicateurvaleur.getValeur_indicateur());
            _indicateurvaleur.setDate_saisie(indicateurvaleur.getDate_saisie());


            return new ResponseEntity<>(indicateurvaleurRepository.save(_indicateurvaleur), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }




}
