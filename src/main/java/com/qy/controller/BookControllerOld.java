package com.qy.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.qy.pojo.Book;
import com.qy.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*@RestController*/
@RequestMapping("/books")
@SuppressWarnings("ALL")
public class BookControllerOld {

    @Autowired
    private IBookService bookService;

    @GetMapping
    public List<Book> getAll(){
        return bookService.list();
    }
    @PostMapping
    public Boolean save(@RequestBody Book book){
        return bookService.save(book);
    }

    @PutMapping
    public Boolean update(@RequestBody Book book){
        return bookService.modify(book);
    }
    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable Integer id){
        return bookService.delete(id);
    }
    @GetMapping("/{id}")
    public Book getBookService(@PathVariable Integer id) {
        return bookService.getById(id);
    }
    @GetMapping("/{currentPage}/{pageSize}")
    public IPage<Book> getPage(@PathVariable int currentPage,@PathVariable int pageSize){
        return bookService.getPage(currentPage,pageSize);
    }

}
