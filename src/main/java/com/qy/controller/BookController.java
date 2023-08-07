package com.qy.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.qy.config.R;
import com.qy.pojo.Book;
import com.qy.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
@SuppressWarnings("ALL")
public class BookController {

    @Autowired
    private IBookService bookService;

    @GetMapping
    public R getAll(){
        return new R(true,bookService.list());
    }
    @PostMapping
    public R save(@RequestBody Book book){
        boolean flag = bookService.save(book);
        /*return new R(flag,flag ?"保存成功":"保存失败");*/
        return new R(flag, flag ? "添加成功^_^" : "添加失败-_-!");
    }

    @PutMapping
    public R update(@RequestBody Book book){
        return new R(bookService.modify(book));
    }
    @DeleteMapping("/{id}")
    public R delete(@PathVariable Integer id){
        return new R(bookService.delete(id));
    }
    @GetMapping("/{id}")
    public R getBookService(@PathVariable Integer id) {
        System.out.println("hahahaahahaha");
        return new R(true,bookService.getById(id));
    }
    /*@GetMapping("/{currentPage}/{pageSize}")
    public R getPage(@PathVariable int currentPage,@PathVariable int pageSize){
        IPage<Book> page = bookService.getPage(currentPage, pageSize);
        if(currentPage>page.getPages()){
            page=bookService.getPage((int)page.getPages(), pageSize);
        }
        return new R(true,page);
    }*/
    @GetMapping("/{currentPage}/{pageSize}")
    public R getPage(@PathVariable int currentPage,@PathVariable int pageSize,Book book){
        IPage<Book> page = bookService.getPage(currentPage, pageSize,book);
        if(currentPage>page.getPages()){
            page=bookService.getPage((int)page.getPages(), pageSize,book);
        }
        return new R(true,page);
    }

}
