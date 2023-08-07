package com.qy.mapper;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qy.pojo.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
@SuppressWarnings("all")
@SpringBootTest
public class DaoTest {
    @Autowired
    private BookMapper bookMapper;

    @Test
    public void test1(){
        System.out.println(bookMapper.selectById(1));
    }



    @Test
    public void test2(){
        Book book = new Book();
        book.setType("测试数据");
        book.setName("测试数据 ");
        book.setDescription("sss");
        bookMapper.insert(book);
    }

    @Test
    public void test3(){
        Book book = new Book();
        book.setId(1);
        book.setType("测试数据");
        book.setName("测试数据 ");
        book.setDescription("aaa");
        bookMapper.updateById(book);
    }

    @Test
    public void test4(){
        IPage page =new Page(0,5);
        bookMapper.selectPage(page,null);
    }

    @Test
    public void test5(){
        QueryWrapper<Book > qw = new QueryWrapper<>();
        qw.like("name"," 知音");
        bookMapper.selectList(qw);
    }
}
