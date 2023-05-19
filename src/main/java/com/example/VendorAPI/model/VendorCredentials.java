package com.example.VendorAPI.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.Set;


@Entity
@Data
@Table(name="Vendor")

public class VendorCredentials {

    //properties
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long  vendor_ID;

    @Column(name = "First_Name")
    private String firstName;
    @Column(name = "Last_Name")
    private String lastName;
    @Column(name = "Phone_Number")
    private String phoneNumber;
    @Column(name = "Email")
    private String email;
    @Column(name = "Ghana_Card_Number")
    private String ghanaCard;
    @Column(name = "Passport_Image")
    private String passport;
    @Column(name = "Business_Registration_Documents")
    private String businessRegistrationDocs;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_vendor_ID", referencedColumnName = "vendor_ID")
    private List<CarCredentials> cars;

}

