package com.example.VendorAPI.repository;

import com.example.VendorAPI.model.LocationCredentials;
import org.springframework.data.jpa.repository.JpaRepository;
public interface LocationRepository extends JpaRepository<LocationCredentials, Long>{


}
