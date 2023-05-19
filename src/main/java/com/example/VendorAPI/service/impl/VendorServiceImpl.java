package com.example.VendorAPI.service.impl;

import com.example.VendorAPI.exception.ResourceNotFoundException;
import com.example.VendorAPI.model.VendorCredentials;
import com.example.VendorAPI.repository.VendorRepository;
import com.example.VendorAPI.service.VendorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendorServiceImpl implements VendorService {

    private final VendorRepository vendorRepository;

    public VendorServiceImpl(VendorRepository vendorRepository) {
        this.vendorRepository = vendorRepository;
    }

    @Override
    public VendorCredentials createVendor(VendorCredentials vendorCredentials) {
        return vendorRepository.save(vendorCredentials);
    }

    @Override
    public List<VendorCredentials> getVendor() {
        return vendorRepository.findAll();
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
    public VendorCredentials updateVendor(VendorCredentials vendorCredentials, long vendorID){

        // check whether vendor id exists in database or not
        VendorCredentials existingVendor = vendorRepository.findById(vendorID).orElseThrow( () -> new ResourceNotFoundException("VendorCredentials", "Id", vendorID));

        existingVendor.setFirstName(vendorCredentials.getFirstName());
        existingVendor.setLastName(vendorCredentials.getLastName());
        existingVendor.setPhoneNumber(vendorCredentials.getPhoneNumber());
        existingVendor.setEmail(vendorCredentials.getEmail());
        existingVendor.setGhanaCard(vendorCredentials.getGhanaCard());
        existingVendor.setPassport(vendorCredentials.getPassport());
        existingVendor.setBusinessRegistrationDocs(vendorCredentials.getBusinessRegistrationDocs());

        //save vendor to database
        vendorRepository.save(existingVendor);

        return existingVendor;
    }

    @Override
    public void deleteVendor(long vendorID) {

        vendorRepository.findById(vendorID).orElseThrow(() -> new ResourceNotFoundException("VendorCredentials","ID",vendorID));

        vendorRepository.deleteById(vendorID);
    }
}
