package com.example.VendorAPI.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="Sessions")
public class SessionCredentials {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long session_ID;

    @Column(name = "Status")
    private String status;
    @Column(name = "Start")
    private String start;

    @Column(name = "End")
    private String end;

    @Column(name = "Price")
    private String price;

}
