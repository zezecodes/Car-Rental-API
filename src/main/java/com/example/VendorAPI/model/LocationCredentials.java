package com.example.VendorAPI.model;


import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
@Table(name = "Car_Location")
public class LocationCredentials {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int car_ID;

    @Column(name = "Longitude")
    private long longitude;

    @Column(name = "Latitude")
    private long latitude;
}
