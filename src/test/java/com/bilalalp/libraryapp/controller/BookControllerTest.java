package com.bilalalp.libraryapp.controller;

import com.bilalalp.libraryapp.model.Book;
import com.bilalalp.libraryapp.service.BookService;
import com.bilalalp.libraryapp.stub.BookStub;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BookControllerTest {

    @InjectMocks
    private BookController bookController;

    @Mock
    private BookService bookService;

    @Test
    public void getBookList() throws Exception {
        bookController.getBookList();
        Mockito.verify(bookService).getBooks();
    }

    @Test
    public void updateBook() throws Exception {

        final Book firstBook = BookStub.getFirstBook();
        bookController.updateBook(firstBook);
        Mockito.verify(bookService).save(firstBook);
    }

    @Test
    public void deleteBook() throws Exception {

        final String bookId = BookStub.getFirstBook().getId();
        bookController.deleteBook(bookId);
        Mockito.verify(bookService).delete(bookId);
    }

    @Test
    public void createBook() throws Exception {
        final Book firstBook = BookStub.getFirstBook();
        bookController.createBook(firstBook);
        Mockito.verify(bookService).save(firstBook);
    }
}