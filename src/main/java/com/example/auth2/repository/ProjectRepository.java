package com.example.auth2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.auth2.models.Project;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Project,Integer>{
    //List<Project> findByStatut(String statut);
}
