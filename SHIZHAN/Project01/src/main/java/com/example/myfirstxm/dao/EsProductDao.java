package com.example.myfirstxm.dao;

import com.example.myfirstxm.nosql.elasticsearch.document.EsProduct;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 搜索系统中的商品管理自定义DAO
 * @author blind
 * @create 2023-03-04-16:52
 */
public interface EsProductDao {
    List<EsProduct> getAllEsProductList(@Param("id") Long id);

}
