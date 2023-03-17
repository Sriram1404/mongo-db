package com.example.mongodb.mongodb.dao;

import com.example.mongodb.mongodb.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookDao extends MongoRepository<Book, Long> {

    public Book findById(String id);
}
