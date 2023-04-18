package com.example.auth2.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:8081", maxAge = 3600, allowCredentials="true")
@RestController
@RequestMapping("/api/test")
public class TestController {
    @GetMapping("/all")
    public String allAccess() {
        return "Public Content.";
    }
/*
    @GetMapping("/observateur")
    @PreAuthorize("hasRole('GESTIONNAIRE') or hasRole('EVALUATEUR') or hasRole('ADMIN') or hasRole('OBSERVATEUR')")
    public String observateurAccess() {
        return "Observateur Content.";
    }
    */

    @GetMapping("/dirigeant")
    @PreAuthorize("hasRole('DIRIGEANT')")
    public String dirigeantAccess() {
        return "Dirigeant Board.";
    }

    @GetMapping("/membre")
    @PreAuthorize("hasRole('MEMBRE')")
    public String membreAccess() {
        return "Membre Board.";
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String adminAccess() {
        return "Admin Board.";
    }
}