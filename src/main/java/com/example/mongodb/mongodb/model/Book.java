package com.example.mongodb.mongodb.model;

import com.example.mongodb.mongodb.dto.BookDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("book")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    @Id
    private String id;
    private String name;
    private String author;

    public Book(BookDto bookDto) {
        this.name = bookDto.getName();
        this.author = bookDto.getAuthor();
    }
}
