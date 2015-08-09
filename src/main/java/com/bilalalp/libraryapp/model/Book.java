package com.bilalalp.libraryapp.model;

import lombok.*;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Book {

    /**
     * id for Book
     */
    @Id
    private String id;

    /**
     * Book Name
     */
    private String name;

    /**
     * Author of the book
     */
    private String author;
}
