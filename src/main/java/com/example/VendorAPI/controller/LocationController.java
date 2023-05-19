package com.example.VendorAPI.controller;


import com.example.VendorAPI.model.LocationCredentials;
import com.example.VendorAPI.service.LocationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/location")
public class LocationController {
    private final LocationService locationService;

    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }


    // Set Location REST API
    @PostMapping()
    public ResponseEntity<LocationCredentials> setLocation(@RequestBody LocationCredentials locationCredentials){
        return new ResponseEntity<>(locationService.setLocation(locationCredentials), HttpStatus.CREATED);
    }

    // GET Location REST API
    @GetMapping
    public List<LocationCredentials> getLocation(){

        // Gets list of all vendors
        return locationService.getLocation();
    }


    // Update employee REST API
    @PutMapping("{id}")
    public ResponseEntity<LocationCredentials> updateLocation(@PathVariable ("id") long carID,
                                                          @RequestBody LocationCredentials locationCredentials){

        //Updates data and id in vendorCredentials and returns a http response
        return new ResponseEntity<>(locationService.updateLocation(locationCredentials, carID), HttpStatus.CREATED);
    }

    // Delete employee REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteLocation(@PathVariable("id") long carID){
        // deletes vendor from database
        locationService.deleteLocation(carID);

        //Http response
        return new ResponseEntity<>("Location deleted successfully!", HttpStatus.CREATED);

    }
}
