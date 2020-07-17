package com.favoris.shopStore.serviceImpl;

import com.favoris.shopStore.dao.FurnitureTypeDao;
import com.favoris.shopStore.entity.FurnitureType;
import com.favoris.shopStore.service.FurnitureTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FurnitureTypeServiceImpl implements FurnitureTypeService {
    @Autowired
    FurnitureTypeDao furnitureTypeDao;

    @Override
    public void save(FurnitureType ft) {
        furnitureTypeDao.save(ft);
    }

    @Override
    public FurnitureType findById(int id) {
        return furnitureTypeDao.getOne(id);
    }

    @Override
    public List<FurnitureType> findAll() {
        return furnitureTypeDao.findAll();
    }

    @Override
    public void deleteByID(int id) {
        furnitureTypeDao.deleteById(id);
    }
}
