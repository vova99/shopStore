package com.favoris.shopStore.service;


import com.favoris.shopStore.entity.FurnitureType;

import java.util.List;

public interface FurnitureTypeService {
    void save(FurnitureType ft);
    FurnitureType findById(int id);
    List<FurnitureType> findAll();
    void deleteByID(int id);
}
