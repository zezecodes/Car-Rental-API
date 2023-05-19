package com.example.VendorAPI.service.impl;

import com.example.VendorAPI.exception.ResourceNotFoundException;
import com.example.VendorAPI.model.LocationCredentials;
import com.example.VendorAPI.repository.LocationRepository;
import com.example.VendorAPI.service.LocationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationServiceImpl implements LocationService {

    private final LocationRepository locationRepository;

    public LocationServiceImpl(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    @Override
    public LocationCredentials setLocation(LocationCredentials locationCredentials) {
        return locationRepository.save(locationCredentials);
    }

    @Override
    public List<LocationCredentials> getLocation() {
        return locationRepository.findAll();
    }
//
//    @Override
//    public VendorCredentials getVendorByCarBrand(String carBrand) {
//        return vendorRepository.findBy();
//    }

//    @Override
//    public VendorCredentials getVendorByCarBrand(String carBrand) {
//        return vendorRepository.findOne(carBrand).orElseThrow(() -> new ResourceNotFoundException("VendorCredentials", "Id", carBrand));
//    }

    @Override
    public LocationCredentials updateLocation(LocationCredentials locationCredentials, long carID){

        // check whether car id exists in database or not
        LocationCredentials existingLocation = locationRepository.findById(carID).orElseThrow( () -> new ResourceNotFoundException("LocationCredentials", "Id", carID));

        existingLocation.setLongitude(locationCredentials.getLongitude());
        existingLocation.setLatitude(locationCredentials.getLatitude());

        //save location to database
        locationRepository.save(existingLocation);

        return existingLocation;
    }

    @Override
    public void deleteLocation(long carID) {

        locationRepository.findById(carID).orElseThrow(() -> new ResourceNotFoundException("LocationCredentials","ID",carID));

        locationRepository.deleteById(carID);
    }
}
