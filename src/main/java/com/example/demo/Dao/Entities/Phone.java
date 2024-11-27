package com.example.demo.Dao.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data

public class Phone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private   int  id_phone ;
    private   String model;
    private String color ;
    private String IMEI;
    private Float price;
}
