package com.favoris.shopStore.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//@Entity
public class Furnitures {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    private FurnitureType furnitureType;
    private String size_width;
    private String size_height;
    private String size_long;


}
