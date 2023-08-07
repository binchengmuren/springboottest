package com.qy.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.qy.pojo.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookServiceTest {

    @Autowired
    private BookService bookService;

   @Test
   void testGetById(){
       System.out.println(bookService.getById(2));
   }

   @Test
   void testGetPage(){
       IPage<Book> page = bookService.getPage(0,5);
       System.out.println(page.getCurrent());
       System.out.println(page.getSize());
       System.out.println(page.getTotal());
       System.out.println(page.getPages());
       System.out.println(page.getRecords());
   }
}
