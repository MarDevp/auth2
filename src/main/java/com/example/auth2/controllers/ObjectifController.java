package com.example.auth2.controllers;
import com.example.auth2.models.Objectif;
import com.example.auth2.models.Project;
import com.example.auth2.repository.ObjectifRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;



@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class ObjectifController {

    @Autowired
    ObjectifRepository objectifRepository;


    //liste des objectifs
    @GetMapping("/objectifs")
    public List<Objectif> getAllObjectifs() {

        return objectifRepository.findAll();
    }


    //creation d'un objectif
    @PostMapping("/createObjectif")
    public Objectif createObjectif(@RequestBody Objectif objectif) {
        return  objectifRepository.save(objectif);

    }

    //suppression d'un objectif
    @DeleteMapping("/deleteObjectif/{id}")
    public ResponseEntity<HttpStatus> deleteObjectif(@PathVariable("id") int id) {
        try {
            objectifRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //  modification d'un objectif
    @PutMapping("/updateObjectif/{id}")
    public ResponseEntity<Objectif> updateObjectif(@PathVariable("id") int id, @RequestBody Objectif objectif) {

        Optional<Objectif> objectifData = objectifRepository.findById(id);

        if (objectifData.isPresent()) {
            Objectif _objectif = objectifData.get();
            // _project.setCode_projet(project.getCode_projet());
            _objectif.setLibele_objectif(objectif.getLibele_objectif());
            _objectif.setDescription_objectif(objectif.getDescription_objectif());

            _objectif.setId_projet(objectif.getId_projet());
            _objectif.setNature_objectif(objectif.getNature_objectif());


            return new ResponseEntity<>(objectifRepository.save(_objectif), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
