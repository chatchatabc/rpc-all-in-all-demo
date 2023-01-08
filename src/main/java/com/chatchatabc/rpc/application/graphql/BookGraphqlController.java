package com.chatchatabc.rpc.application.graphql;

import com.chatchatabc.rpc.domain.model.Author;
import com.chatchatabc.rpc.domain.model.Book;
import com.chatchatabc.rpc.domain.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Mono;

@Controller
public class BookGraphqlController {

    @Autowired
    private BookRepository bookRepository;

    @QueryMapping("findBook")
    public Mono<Book> findBook(@Argument String id) {
        return Mono.justOrEmpty(bookRepository.findBookById(id));
    }

    @QueryMapping("findAuthor")
    public Mono<Author> findAuthor(@Argument String id) {
        return Mono.justOrEmpty(bookRepository.findAuthorById(id));
    }

    @SchemaMapping(typeName = "Book", field = "author")
    public Mono<Author> authorForBook(Book book) {
        return findAuthor(book.getAuthorId());
    }


}
