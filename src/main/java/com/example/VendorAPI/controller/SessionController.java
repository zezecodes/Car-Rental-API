package com.example.VendorAPI.controller;

import com.example.VendorAPI.model.SessionCredentials;
import com.example.VendorAPI.service.SessionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/session")
public class SessionController {
    private final SessionService sessionService;

    public SessionController(SessionService sessionService) {
        this.sessionService = sessionService;
    }

    // Create Session REST API
    @PostMapping()
    public ResponseEntity<SessionCredentials> createSession(@RequestBody SessionCredentials sessionCredentials){
        return new ResponseEntity<>(sessionService.createSession(sessionCredentials), HttpStatus.CREATED);
    }

    // GET Session REST API
    @GetMapping
    public List<SessionCredentials> getSession(){

        // Gets list of all vendors
        return sessionService.getSession();
    }

    // Updates session
    @PutMapping("{id}")
    public ResponseEntity<SessionCredentials> updateSession(@PathVariable ("id") long session_ID,
                                                          @RequestBody SessionCredentials sessionCredentials){

        //Updates data and id in vendorCredentials and returns a http response
        return new ResponseEntity<>(sessionService.updateSession(sessionCredentials, session_ID), HttpStatus.CREATED);
    }

    // Delete session REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteSession(@PathVariable("id") long session_ID){
        // deletes session from database
        sessionService.deleteSession(session_ID);

        //Http response
        return new ResponseEntity<>("Session deleted successfully!", HttpStatus.CREATED);

    }
}
