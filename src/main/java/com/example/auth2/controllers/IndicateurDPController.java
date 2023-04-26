package com.example.auth2.controllers;
import com.example.auth2.models.IndicateurDP;
import com.example.auth2.repository.IndicateurDPRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8081", maxAge = 3600,  allowCredentials="true")
@RestController
@RequestMapping("/api")
public class IndicateurDPController {

    @Autowired
    IndicateurDPRepository indicateurDPRepository;


    //liste
    @GetMapping("/indicateurPlan")
    public List<IndicateurDP> getAllIndicateurPlan() {

        return indicateurDPRepository.findAll();
    }

    //creation
    @PostMapping("/createIndicateurPlan")
    public IndicateurDP createIndicateurPlan(@RequestBody IndicateurDP indicateurDP) {
        return  indicateurDPRepository.save(indicateurDP);

    }

    //suppression
    @DeleteMapping("/deleteIndicateurPlan/{id}")
    public ResponseEntity<HttpStatus> deleteIndicateurPlan(@PathVariable("id") int id) {
        try {
            indicateurDPRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    //  modification
    @PutMapping("/updateIndicateurDP/{id}")
    public ResponseEntity<IndicateurDP> updateIndicateurDP(@PathVariable("id") int id, @RequestBody IndicateurDP indicateurDP) {

        Optional<IndicateurDP> indicateurDPData = indicateurDPRepository.findById(id);

        if (indicateurDPData.isPresent()) {
            IndicateurDP _indicateurDP = indicateurDPData.get();

            _indicateurDP.setId_indicateur(indicateurDP.getId_indicateur());
            _indicateurDP.setLibele_DP(indicateurDP.getLibele_DP());

            _indicateurDP.setDate_planification(indicateurDP.getDate_planification());
            _indicateurDP.setValeur_cible_date(indicateurDP.getValeur_cible_date());


            return new ResponseEntity<>(indicateurDPRepository.save(_indicateurDP), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
