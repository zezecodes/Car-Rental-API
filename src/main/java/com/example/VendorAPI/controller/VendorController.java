package com.example.VendorAPI.controller;

import com.example.VendorAPI.model.VendorCredentials;
import com.example.VendorAPI.service.VendorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/vendor")
public class VendorController {
    private final VendorService vendorService;

    // Class Constructor
    public VendorController(VendorService vendorService) {
        this.vendorService = vendorService;
    }

    // Create Vendor REST API
    @PostMapping()
    public ResponseEntity<VendorCredentials> createVendor(@RequestBody VendorCredentials vendorCredentials){
        return new ResponseEntity<>(vendorService.createVendor(vendorCredentials), HttpStatus.CREATED);
    }

    // GET Vendor REST API
    @GetMapping
    public List<VendorCredentials> getVendor(){

        // Gets list of all vendors
        return vendorService.getVendor();
    }

//    // GET by Car Name REST API
//    @GetMapping
//    public ResponseEntity<VendorCredentials> getVendorById(long id){
//        return new ResponseEntity<>()
//    }


    // Update employee REST API
    @PutMapping("{id}")
    public ResponseEntity<VendorCredentials> updateVendor(@PathVariable ("id") long vendorID,
                                                          @RequestBody VendorCredentials vendorCredentials){

        //Updates data and id in vendorCredentials and returns a http response
        return new ResponseEntity<>(vendorService.updateVendor(vendorCredentials, vendorID), HttpStatus.CREATED);
    }

    // Delete employee REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteVendor(@PathVariable("id") long vendorID){
        // deletes vendor from database
        vendorService.deleteVendor(vendorID);

        //Http response
       return new ResponseEntity<>("Vendor deleted successfully!", HttpStatus.CREATED);

    }
}
