package com.example.VendorAPI.repository;

import com.example.VendorAPI.model.VendorCredentials;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VendorRepository extends JpaRepository<VendorCredentials, Long>{

}
