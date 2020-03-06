package com.java.servlet;

import org.springframework.beans.factory.annotation.Autowired;

public class BooksRepositoryImpl {

    @Autowired
    private BooksRepository repository;

    public Book getBooks(String title){
        Book book = repository.findByTitle(title);
        return book;
    }
}
