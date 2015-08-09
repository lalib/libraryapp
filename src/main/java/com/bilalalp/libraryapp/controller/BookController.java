package com.bilalalp.libraryapp.controller;

import com.bilalalp.libraryapp.model.Book;
import com.bilalalp.libraryapp.service.BookService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Setter
@RestController
@RequestMapping("/library")
public class BookController {

    @Autowired
    private BookService bookService;

    @ResponseBody
    @RequestMapping
    public List<Book> getBookList() {
        return bookService.getBooks();
    }

    @ResponseBody
    @RequestMapping(value = "/updateBook", method = RequestMethod.PUT)
    public void updateBook(@RequestBody Book book) {
        bookService.save(book);
    }

    @ResponseBody
    @RequestMapping(value = "/deleteBook/{id}", method = RequestMethod.DELETE)
    public void deleteBook(@PathVariable("id") final String bookId) {
        bookService.delete(bookId);
    }

    @ResponseBody
    @RequestMapping(value = "/createBook", method = RequestMethod.POST)
    public void createBook(@RequestBody final Book book) {
        bookService.save(book);
    }
}