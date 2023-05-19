package com.example.VendorAPI.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="Cars")
public class CarCredentials {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int car_ID;

    @Column(name = "Car_Brand")
    private String carBrand;

    @Column(name = "Car_Model")
    private String carModel;

    @Column(name = "Car_Photos")
    private String carPhotos;

    @Column(name = "Car_Type")
    private String carType;

    @Column(name = "Car_Year")
    private int carYear;

    @Column(name = "Engine_Size(In Liters)")
    private int engineSize;

    @Column(name = "Engine_Type")
    private String engineType;

    @Column(name = "Mileage")
    private long mileage;

    @Column(name = "Seat_Number")
    private int seatNumber;

    @Column(name = "Transmission")
    private String transmission;

    @Column(name = "Vehicle_Identification_Number")
    private long vin;

}
