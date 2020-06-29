package com.favoris.shopStore.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Textile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int textile_id;

    private String name;
    private String provider;
    private String type;
    private String category;
    private String color;
    private String photoPath;

}
