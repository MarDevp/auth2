package com.example.auth2.controllers;
import com.example.auth2.models.IndicateurDP;
import com.example.auth2.models.Notification;
import com.example.auth2.repository.IndicateurDPRepository;
import com.example.auth2.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@CrossOrigin(origins = "http://localhost:8081", maxAge = 3600,  allowCredentials="true")
@RestController
@RequestMapping("/api")
public class NotificationController {

    @Autowired
    NotificationRepository notificationRepository;


    //liste
    @GetMapping("/notifications")
    public List<Notification> getAllNotifications() {

        return notificationRepository.findAll();
    }

    //creation
    @PostMapping("/createNotification")
    public Notification createNotification(@RequestBody Notification notification) {
        return  notificationRepository.save(notification);

    }

    //suppression
    @DeleteMapping("/deleteNotification/{id}")
    public ResponseEntity<HttpStatus> deleteNotification(@PathVariable("id") int id) {
        try {
            notificationRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //  modification
    @PutMapping("/updateNotification/{id}")
    public ResponseEntity<Notification> updateNotification(@PathVariable("id") int id, @RequestBody Notification notification) {

        Optional<Notification> notificationData = notificationRepository.findById(id);

        if (notificationData.isPresent()) {
            Notification _notification = notificationData.get();

            _notification.setId_date_prevue(notification.getId_date_prevue());
            _notification.setStatut_notification(notification.getStatut_notification());

            return new ResponseEntity<>(notificationRepository.save(_notification), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
