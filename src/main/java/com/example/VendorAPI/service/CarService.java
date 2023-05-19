package com.example.VendorAPI.service;

import com.example.VendorAPI.model.CarCredentials;

import java.util.List;

public interface CarService {
    CarCredentials createCar(CarCredentials carCredentials);
    List<CarCredentials> getCar();
    //    VendorCredentials getVendorByCarBrand(String carBrand);
    CarCredentials updateCar(CarCredentials carCredentials, long carID);
    void deleteCar(long carID);

}
