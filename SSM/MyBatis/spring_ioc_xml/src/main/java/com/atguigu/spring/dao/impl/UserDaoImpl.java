package com.atguigu.spring.dao.impl;

import com.atguigu.spring.dao.UserDao;

/**
 * @author blind
 * @create 2023-01-30-14:30
 */
public class UserDaoImpl implements UserDao {
    @Override
    public void saveUser() {
        System.out.println("保存成功");
    }
}
