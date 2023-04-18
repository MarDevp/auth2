package com.example.auth2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.auth2.models.Objectif;
import org.springframework.stereotype.Repository;


@Repository
public interface ObjectifRepository extends JpaRepository<Objectif,Integer>{
}
