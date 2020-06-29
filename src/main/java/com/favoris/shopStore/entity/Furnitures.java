package com.favoris.shopStore.entity;

import lombok.Data;
import org.springframework.web.bind.annotation.Mapping;

import javax.persistence.*;

@Entity
@Data
public class Furnitures {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "furnitureType_id")
    private FurnitureType furnitureType;

    private String photoPath;
    private String size_width;
    private String size_height;
    private String size_long;


}
