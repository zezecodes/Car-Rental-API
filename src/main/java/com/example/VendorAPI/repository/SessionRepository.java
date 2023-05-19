package com.example.VendorAPI.repository;

import com.example.VendorAPI.model.SessionCredentials;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionRepository extends JpaRepository<SessionCredentials, Long>{

}
