package com.qy.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qy.pojo.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class IBookServiceTest {

    @Autowired
    private IBookService iBookService;

   @Test
   void testGetById(){
       System.out.println(iBookService.getById(2));
   }

   @Test
   void testGetPage(){
       IPage<Book> page =new Page<Book>(1,5);
       iBookService.page(page);
       System.out.println(page.getCurrent());
       System.out.println(page.getSize());
       System.out.println(page.getTotal());
       System.out.println(page.getPages());
       System.out.println(page.getRecords());
   }
}
