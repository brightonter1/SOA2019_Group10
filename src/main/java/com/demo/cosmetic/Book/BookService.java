package com.demo.cosmetic.Book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    List<Book> books = new ArrayList<>(Arrays.asList(
            new Book("1234", "Java A", "WEWE"),
            new Book("4324", "C Program", "ewfwf")
    ));

    public List<Book> getAll(){
        List<Book> books = new ArrayList<>();
        bookRepository.findAll().forEach(books::add);
        return books;
    }

    public void addBook(Book book){
        bookRepository.save(book);
    }

    public void removeBook(Book book){
        bookRepository.delete(book);
    }

    public String welcome(){
        return "Welcome dude.";
    }







}
