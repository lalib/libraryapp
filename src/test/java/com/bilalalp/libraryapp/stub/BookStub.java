package com.bilalalp.libraryapp.stub;

import com.bilalalp.libraryapp.model.Book;
import com.google.gson.Gson;

import java.util.Arrays;
import java.util.List;

public class BookStub {

    public static String getFirstBookAsJson() {
        final Book book = getFirstBook();
        final Gson gson = new Gson();
        return gson.toJson(book);
    }

    public static Book getSecondBook() {
        return new Book("2", "Reactive Design Patterns", "Jamie Allen");
    }

    public static List<Book> getBooks() {
        return Arrays.asList(getFirstBook(), getSecondBook());
    }

    public static Book getFirstBook() {
        return new Book("1", "NoSQL Distilled", "Martin Fowler");
    }
}