package com.atguigu.spring.service.impl;

import com.atguigu.spring.dao.UserDao;
import com.atguigu.spring.service.UserService;

/**
 * @author blind
 * @create 2023-01-30-14:29
 */
public class UserServiceImpl implements UserService {
    private UserDao userDao;

    public UserDao getUserDao() {
        return userDao;
    }

    @Override
    public void saveUser() {
        userDao.saveUser();
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
