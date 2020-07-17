package com.favoris.shopStore.service;


import com.favoris.shopStore.entity.Textile;
import org.springframework.stereotype.Service;

import java.util.List;


public interface TextileService {
    void save(Textile tx);
    Textile findById(int id);
    List<Textile> findAll();
    void deleteByID(int id);
}
