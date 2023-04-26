package com.example.auth2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.auth2.models.Notification;
import org.springframework.stereotype.Repository;


@Repository
public interface NotificationRepository extends JpaRepository<Notification,Integer> {
}
