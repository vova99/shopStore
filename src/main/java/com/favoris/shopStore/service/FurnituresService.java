package com.favoris.shopStore.service;

import com.favoris.shopStore.entity.Furnitures;

import java.util.List;

public interface FurnituresService {
    void save(Furnitures ft);
    Furnitures findById(int id);
    List<Furnitures> findAll();
    void deleteByID(int id);
}
