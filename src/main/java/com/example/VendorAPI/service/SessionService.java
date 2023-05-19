package com.example.VendorAPI.service;

import com.example.VendorAPI.model.SessionCredentials;

import java.util.List;

public interface SessionService {
    SessionCredentials createSession(SessionCredentials sessionCredentials);
    List<SessionCredentials> getSession();
    //    VendorCredentials getVendorByCarBrand(String carBrand);
    SessionCredentials updateSession(SessionCredentials sessionCredentials, long session_ID);
    void deleteSession(long session_ID);
}
