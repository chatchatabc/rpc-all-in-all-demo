package com.chatchatabc.rpc.impl.domain.repository;

import com.chatchatabc.rpc.domain.model.Author;
import com.chatchatabc.rpc.domain.model.Book;
import com.chatchatabc.rpc.domain.repository.BookRepository;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Repository
public class BookRepositoryImpl implements BookRepository {
    public static Map<String, Book> BOOKS = Stream.of(
            new Book("book-1", "Harry Potter and the Philosopher's Stone", 223, "author-1"),
            new Book("book-2", "Moby Dick", 221, "author-2"),
            new Book("book-3", "Interview with the vampire", 224, "author-3")
    ).collect(Collectors.toMap(Book::getId, Function.identity()));

    public static Map<String, Author> AUTHORS = Stream.of(
            new Author("author-1", "Anastasia", "Mccubbin"),
            new Author("author-2", "Jolanda", "Prevatte"),
            new Author("author-3", "Dawayne", "Kent")
    ).collect(Collectors.toMap(Author::getId, Function.identity()));

    @Override
    public Book findBookById(String id) {
        return BOOKS.get(id);
    }

    @Override
    public Author findAuthorById(String id) {
        return AUTHORS.get(id);
    }
}
