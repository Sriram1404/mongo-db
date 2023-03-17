package com.example.mongodb.mongodb.controller;

import com.example.mongodb.mongodb.dao.BookDao;
import com.example.mongodb.mongodb.dto.BookDto;
import com.example.mongodb.mongodb.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class BookController {
    @Autowired
    BookDao bookDao;

    @GetMapping("/books")
    public List<BookDto> getAllBooks() {
        return bookDao.findAll().stream().map(BookDto::new).collect(Collectors.toList());
    }

    @PostMapping("/books")
    public void createBook(@RequestBody BookDto bookDto) {
        Book book = new Book(bookDto);
        bookDao.save(book);
    }

    @GetMapping("/books/{id}")
    public ResponseEntity getBookById(@PathVariable String id) {
        Book book = bookDao.findById(id);
        if (book != null) {
            return ResponseEntity.ok(new BookDto(book));
        }
        return ResponseEntity.status(404).body("Book not found");
    }
}
