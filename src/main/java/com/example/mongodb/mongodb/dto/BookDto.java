package com.example.mongodb.mongodb.dto;

import com.example.mongodb.mongodb.model.Book;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookDto {
    private String id;
    private String name;
    private String author;

    public BookDto(Book book) {
        this.id = book.getId();
        this.name = book.getName();
        this.author = book.getAuthor();
    }
}
