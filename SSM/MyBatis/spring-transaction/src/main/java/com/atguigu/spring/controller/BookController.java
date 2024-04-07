package com.atguigu.spring.controller;

import com.atguigu.spring.service.BookService;
import org.springframework.stereotype.Controller;

/**
 * @author blind
 * @create 2023-02-01-20:39
 */
@Controller
public class BookController {

    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    public void buyBook(Integer userId,Integer bookId){
        bookService.buyBook(userId,bookId);

    }

}
