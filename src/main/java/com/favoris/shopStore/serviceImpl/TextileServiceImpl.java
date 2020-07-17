package com.favoris.shopStore.serviceImpl;

import com.favoris.shopStore.dao.TextileDao;
import com.favoris.shopStore.entity.Textile;
import com.favoris.shopStore.service.TextileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TextileServiceImpl implements TextileService {
    @Autowired
    TextileDao textileDao;

    @Override
    public void save(Textile tx) {
        textileDao.save(tx);
    }

    @Override
    public Textile findById(int id) {
        return textileDao.getOne(id);
    }

    @Override
    public List<Textile> findAll() {
        return textileDao.findAll();
    }

    @Override
    public void deleteByID(int id) {
        textileDao.deleteById(id);
    }
}
