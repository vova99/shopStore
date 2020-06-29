package com.favoris.shopStore.serviceImpl;

import com.favoris.shopStore.dao.FurnitureDao;
import com.favoris.shopStore.entity.Furnitures;
import com.favoris.shopStore.service.FurnituresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FurnituresServiceImpl implements FurnituresService{
    @Autowired
    FurnitureDao furnitureDao;

    @Override
    public void save(Furnitures ft) {
        furnitureDao.save(ft);
    }

    @Override
    public Furnitures findById(int id) {
        return furnitureDao.getOne(id);
    }

    @Override
    public List<Furnitures> findAll() {
        return furnitureDao.findAll();
    }

    @Override
    public void deleteByID(int id) {
        furnitureDao.deleteById(id);
    }
}
