package com.example.VendorAPI.service.impl;

import com.example.VendorAPI.exception.ResourceNotFoundException;
import com.example.VendorAPI.model.SessionCredentials;
import com.example.VendorAPI.repository.SessionRepository;
import com.example.VendorAPI.service.SessionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SessionServiceImpl implements SessionService {
    private final SessionRepository sessionRepository;

    public SessionServiceImpl(SessionRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
    }


    @Override
    public SessionCredentials createSession(SessionCredentials sessionCredentials) {
        return sessionRepository.save(sessionCredentials);
    }

    @Override
    public List<SessionCredentials> getSession() {
        return sessionRepository.findAll();
    }

    @Override
    public SessionCredentials updateSession(SessionCredentials sessionCredentials, long session_ID) {
        SessionCredentials existingSession = sessionRepository.findById(session_ID).orElseThrow( () -> new ResourceNotFoundException("SessionCredentials", "Status", session_ID));

        existingSession.setStart(sessionCredentials.getStart());
        existingSession.setEnd(sessionCredentials.getEnd());
        existingSession.setPrice(sessionCredentials.getPrice());

        //Save to database
        sessionRepository.save(existingSession);


        return existingSession;
    }

    @Override
    public void deleteSession(long session_ID) {

        sessionRepository.findById(session_ID).orElseThrow(() -> new ResourceNotFoundException("SessionCredentials","Status",session_ID));

        sessionRepository.deleteById(session_ID);

    }

}
