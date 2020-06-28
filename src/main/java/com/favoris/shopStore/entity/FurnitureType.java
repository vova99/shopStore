package com.favoris.shopStore.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//@Entity
public class FurnitureType {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nameOfType;
    private String description;


}
