package com.favoris.shopStore.dao;

import com.favoris.shopStore.entity.Furnitures;
import org.springframework.data.jpa.repository.JpaRepository;


public interface FurnitureDao extends JpaRepository<Furnitures,Integer>{
}
