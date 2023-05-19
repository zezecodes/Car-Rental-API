package com.example.VendorAPI.service;

import com.example.VendorAPI.model.LocationCredentials;

import java.util.List;

public interface LocationService {
    LocationCredentials setLocation(LocationCredentials locationCredentials);
    List<LocationCredentials> getLocation();
    //    VendorCredentials getVendorByCarBrand(String carBrand);
    LocationCredentials updateLocation(LocationCredentials locationCredentials, long vendorID);
    void deleteLocation(long vendorID);
}
