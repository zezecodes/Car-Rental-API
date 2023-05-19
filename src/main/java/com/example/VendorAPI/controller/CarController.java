package com.example.VendorAPI.controller;


import com.example.VendorAPI.model.CarCredentials;
import com.example.VendorAPI.service.CarService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cars")
public class CarController {
    private final CarService CarService;

    public CarController(CarService CarService) {
        this.CarService = CarService;
    }

    // Create Car REST API
    @PostMapping()
    public ResponseEntity<CarCredentials> createCar(@RequestBody CarCredentials CarCredentials){
        return new ResponseEntity<>(CarService.createCar(CarCredentials), HttpStatus.CREATED);
    }

    // GET Car REST API
    @GetMapping
    public List<CarCredentials> getCar(){

        // Gets list of all vendors
        return CarService.getCar();
    }

    // Updates Car
    @PutMapping("{id}")
    public ResponseEntity<CarCredentials> updateCar(@PathVariable ("id") long car_ID,
                                                            @RequestBody CarCredentials CarCredentials){

        //Updates data and id in vendorCredentials and returns a http response
        return new ResponseEntity<>(CarService.updateCar(CarCredentials, car_ID), HttpStatus.CREATED);
    }

    // Delete Car REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteCar(@PathVariable("id") long car_ID){
        // deletes Car from database
        CarService.deleteCar(car_ID);

        //Http response
        return new ResponseEntity<>("Car deleted successfully!", HttpStatus.CREATED);

    }
}
