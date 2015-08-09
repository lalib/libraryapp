package com.bilalalp.libraryapp.service;

import com.bilalalp.libraryapp.model.Book;
import com.bilalalp.libraryapp.repository.BookRepository;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Setter
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public void save(final Book book) {
        bookRepository.save(book);
    }

    @Override
    public void delete(final String bookId) {

        final Book existBook = getBook(bookId);

        if (existBook != null) {
            bookRepository.delete(existBook);
        } else {
            throw new RuntimeException("You can not delete something that are not exist!");
        }
    }

    @Override
    public Book getBook(final String bookId) {
        return bookRepository.findOne(bookId);
    }

    @Override
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }
}