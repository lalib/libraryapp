package com.bilalalp.libraryapp.repository;

import com.bilalalp.libraryapp.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, String>, MongoRepository<Book, String> {

}