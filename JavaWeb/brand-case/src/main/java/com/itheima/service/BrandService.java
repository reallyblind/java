package com.itheima.service;

import com.itheima.pojo.Brand;

import java.util.List;

/**
 * @author blind
 * @create 2022-11-28-14:43
 */
public interface BrandService {
    /**
     * 查询所有
     * @return
     */
    List<Brand> selectAll();

    /**
     * 添加数据
     * @param brand
     */
    void add(Brand brand);
}
