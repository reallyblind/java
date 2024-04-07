package com.atguigu.spring.dao;

/**
 * @author blind
 * @create 2023-02-01-20:41
 */
public interface BookDao {
    //根据图书Id查询图书价格
    Integer getPriceByBookId(Integer bookId);

    //更新图书库存
    void updateStock(Integer bookId);

    //更新用户余额
    void updateBalance(Integer userId, Integer price);
}
