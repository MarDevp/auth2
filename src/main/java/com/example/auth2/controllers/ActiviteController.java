package com.example.auth2.controllers;

import com.example.auth2.models.Activite;
import com.example.auth2.models.Objectif;
import com.example.auth2.repository.ActiviteRepository;
import com.example.auth2.repository.ObjectifRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@CrossOrigin(origins = "http://localhost:8081", maxAge = 3600,  allowCredentials="true")
@RestController
@RequestMapping("/api")
public class ActiviteController {

    @Autowired
    ActiviteRepository activiteRepository;


    //liste des activites
    @GetMapping("/activites")
    public List<Activite> getAllActivites() {

        return activiteRepository.findAll();
    }

    //creation
    @PostMapping("/createActivite")
    public Activite createActivite(@RequestBody Activite activite) {
        return  activiteRepository.save(activite);
    }

    //suppression
    @DeleteMapping("/deleteActivite/{id}")
    public ResponseEntity<HttpStatus> deleteActivite(@PathVariable("id") int id) {
        try {
            activiteRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //  modification
    @PutMapping("/updateActivite/{id}")
    public ResponseEntity<Activite> updateActivite(@PathVariable("id") int id, @RequestBody Activite activite) {

        Optional<Activite> activiteData = activiteRepository.findById(id);

        if (activiteData.isPresent()) {
            Activite _activite = activiteData.get();


            _activite.setLibele_activite(activite.getLibele_activite());
            _activite.setDescription_activite(activite.getDescription_activite());

            _activite.setId_resultat(activite.getId_resultat());


            return new ResponseEntity<>(activiteRepository.save(_activite), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }





}
