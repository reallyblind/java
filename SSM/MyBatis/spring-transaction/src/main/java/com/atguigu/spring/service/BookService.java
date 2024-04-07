package com.atguigu.spring.service;



/**
 * @author blind
 * @create 2023-02-01-20:40
 */
public interface BookService {

    /**
     * 买书
     * @param userId
     * @param bookId
     */
    void buyBook(Integer userId, Integer bookId);
}
