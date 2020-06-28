package com.favoris.shopStore.service;



import com.favoris.shopStore.entity.User;

import java.util.List;

/**
 * Created by uer on 08.06.20.
 */
public interface UserService {
    void save(User user);
    User findById(int id);
    List<User> findAll();
    User selectByUsername(String phone);
}
