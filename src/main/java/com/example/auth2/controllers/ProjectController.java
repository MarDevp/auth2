package com.example.auth2.controllers;

import com.example.auth2.models.Project;
import com.example.auth2.repository.ProjectRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.auth2.repository.ProjectRepository;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:8081", maxAge = 3600,  allowCredentials="true")
@RestController
@RequestMapping("/api")
public class ProjectController {

    @Autowired
    ProjectRepository projectRepository;

    @GetMapping("/projects")
    public List<Project> getAllProjects() {

        return projectRepository.findAll();
    }

    @GetMapping("/projectById/{id}")
    public ResponseEntity<Project> getProjectById(@PathVariable("id") int id) {
        Optional<Project> projectData = projectRepository.findById(id);

        if (projectData.isPresent()) {
            return new ResponseEntity<>(projectData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //creation d'un projet
    @PostMapping("/createProject")
    public Project createProject(@RequestBody Project project) {
       return  projectRepository.save(project);

    }

    //mise à jour d'un projet
    @PutMapping("/updateProject/{id}")
    public ResponseEntity<Project> updateProject(@PathVariable("id") int id, @RequestBody Project project) {

        Optional<Project> projectData = projectRepository.findById(id);

        if (projectData.isPresent()) {
            Project _project = projectData.get();
           // _project.setCode_projet(project.getCode_projet());
            _project.setIntitule_projet(project.getIntitule_projet());
            _project.setDescription_projet(project.getDescription_projet());

            _project.setDateDeb_projet(project.getDateDeb_projet());
            _project.setDateFin_projet(project.getDateFin_projet());

            _project.setStatut_projet(project.getStatut_projet());
            _project.setId_theme_projet(project.getId_theme_projet());
            _project.setMaitre_oeuvre(project.getMaitre_oeuvre());
            _project.setMaitre_ouvrage(project.getMaitre_ouvrage());
            _project.setMonnaie_projet(project.getMonnaie_projet());

            _project.setTaux_rent_eco(project.getTaux_rent_eco());
            _project.setCout_total(project.getCout_total());
            _project.setTaux_rent_interneInit(project.getTaux_rent_interneInit());

            _project.setObservations(project.getObservations());
            _project.setSecteur(project.getSecteur());
            _project.setStade(project.getStade());

            return new ResponseEntity<>(projectRepository.save(_project), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/deleteProject/{id}")
    public ResponseEntity<HttpStatus> deleteProject(@PathVariable("id") int id) {
        try {
            projectRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    /*
    @DeleteMapping("/projects")
    public ResponseEntity<HttpStatus> deleteAllProjects() {

    }*/

    /*
    @GetMapping("/projects/statut")
    public ResponseEntity<List<Project>> findByStatut() {

    }

     */
}


