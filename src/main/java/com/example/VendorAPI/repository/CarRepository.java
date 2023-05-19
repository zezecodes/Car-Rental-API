package com.example.VendorAPI.repository;

import com.example.VendorAPI.model.CarCredentials;
import org.springframework.data.jpa.repository.JpaRepository;
public interface CarRepository extends JpaRepository<CarCredentials, Long>{
}
