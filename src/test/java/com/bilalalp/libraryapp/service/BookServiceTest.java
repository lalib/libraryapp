package com.bilalalp.libraryapp.service;

import com.bilalalp.libraryapp.model.Book;
import com.bilalalp.libraryapp.repository.BookRepository;
import com.bilalalp.libraryapp.stub.BookStub;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class BookServiceTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookServiceImpl bookService;

    @Test
    public void save() {
        final Book firstBook = BookStub.getFirstBook();
        bookService.save(firstBook);
        Mockito.verify(bookRepository).save(firstBook);
    }

    @Test
    public void delete() {
        final Book firstBook = BookStub.getFirstBook();
        Mockito.when(bookRepository.findOne(Mockito.anyString())).thenReturn(firstBook);
        bookService.delete(firstBook.getId());
        Mockito.verify(bookRepository).delete(firstBook);
    }

    @Test(expected = RuntimeException.class)
    public void deleteThrowsRuntimeException() {
        final Book firstBook = BookStub.getFirstBook();
        Mockito.when(bookRepository.findOne(Mockito.anyString())).thenReturn(null);
        bookService.delete(firstBook.getId());
    }

    @Test
    public void getBook() {
        final Book expectedBook = BookStub.getFirstBook();
        Mockito.when(bookRepository.findOne(expectedBook.getId())).thenReturn(expectedBook);
        final Book actualBook = bookService.getBook(expectedBook.getId());

        Mockito.verify(bookRepository).findOne(expectedBook.getId());
        Assert.assertNotNull(actualBook);
        Assert.assertEquals(expectedBook, actualBook);
    }

    @Test
    public void getBooks() {

        final List<Book> expectedBookList = BookStub.getBooks();
        Mockito.when(bookRepository.findAll()).thenReturn(expectedBookList);

        final List<Book> actualBookList = bookService.getBooks();
        Mockito.verify(bookRepository).findAll();

        Assert.assertNotNull(actualBookList);
        Assert.assertEquals(expectedBookList, actualBookList);
    }
}