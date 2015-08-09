package com.bilalalp.libraryapp.service;

import com.bilalalp.libraryapp.model.Book;

import java.util.List;

public interface BookService {

    void save(Book book);

    void delete(String bookId);

    Book getBook(String bookId);

    List<Book> getBooks();
}