package com.demo.cosmetic.Book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/book")
    public List getAll(){
        return bookService.getAll();
    }

    @RequestMapping(value = "/book", method = RequestMethod.POST)
    public void addBook(@RequestBody Book book){
        bookService.addBook(book);
    }

    @RequestMapping(value = "/book", method = RequestMethod.DELETE)
    public void removeBook(@RequestBody Book book){
        bookService.removeBook(book);
    }

    @GetMapping("book/welcome")
    public String welcome(){
        return bookService.welcome();
    }

}
