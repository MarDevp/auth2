package com.example.auth2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.auth2.models.Activite;
import org.springframework.stereotype.Repository;


@Repository
public interface ActiviteRepository extends JpaRepository<Activite,Integer> {
}
