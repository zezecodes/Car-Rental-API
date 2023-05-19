package com.example.VendorAPI.service;

import com.example.VendorAPI.model.VendorCredentials;

import java.util.List;

public interface VendorService{
    VendorCredentials createVendor(VendorCredentials vendorCredentials);
    List<VendorCredentials> getVendor();
//    VendorCredentials getVendorByCarBrand(String carBrand);
    VendorCredentials updateVendor(VendorCredentials vendorCredentials, long vendorID);
    void deleteVendor(long vendorID);


}
