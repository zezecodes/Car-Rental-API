package com.example.VendorAPI.service.impl;

import com.example.VendorAPI.exception.ResourceNotFoundException;
import com.example.VendorAPI.model.CarCredentials;
import com.example.VendorAPI.repository.CarRepository;
import com.example.VendorAPI.service.CarService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService{
    private final CarRepository carRepository;

    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public CarCredentials createCar(CarCredentials carCredentials) {
        return carRepository.save(carCredentials);
    }

    @Override
    public List<CarCredentials> getCar() {
        return carRepository.findAll();
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
    public CarCredentials updateCar(CarCredentials carCredentials, long carID){

        // check whether car id exists in database or not
        CarCredentials existingCar = carRepository.findById(carID).orElseThrow( () -> new ResourceNotFoundException("CarCredentials", "Id", carID));

        existingCar.setCarBrand(carCredentials.getCarBrand());
        existingCar.setCarModel(carCredentials.getCarModel());
        existingCar.setCarYear(carCredentials.getCarYear());
        existingCar.setCarType(carCredentials.getCarType());
        existingCar.setCarPhotos(carCredentials.getCarPhotos());
        existingCar.setEngineSize(carCredentials.getEngineSize());
        existingCar.setEngineType(carCredentials.getEngineType());
        existingCar.setMileage(carCredentials.getMileage());
        existingCar.setSeatNumber(carCredentials.getSeatNumber());
        existingCar.setTransmission(carCredentials.getTransmission());
        existingCar.setVin(carCredentials.getVin());


        //save location to database
        carRepository.save(existingCar);

        return existingCar;
    }

    @Override
    public void deleteCar(long carID) {

        carRepository.findById(carID).orElseThrow(() -> new ResourceNotFoundException("CarCredentials","ID",carID));

        carRepository.deleteById(carID);
    }
}
