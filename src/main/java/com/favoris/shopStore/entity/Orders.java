package com.favoris.shopStore.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int order_id;

    private String dateOfOrder;
    @ManyToOne
    @JoinColumn(name="id")
    private User user;
    @ManyToMany
    private List<Furnitures>  furnituresList;
}
