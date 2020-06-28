package com.favoris.shopStore.serviceImpl;


import com.favoris.shopStore.dao.UserDao;
import com.favoris.shopStore.entity.User;
import com.favoris.shopStore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {
    @Autowired

    UserDao userDao;

    public void save(User user) {
        userDao.save(user);
    }

    public User findById(int id) {
        return userDao.getOne(id);
    }

    public List<User> findAll() {
        return userDao.findAll();
    }

    public User selectByUsername(String phone) {
        return userDao.selectByUsername(phone);
    }
}
