package com.chatchatabc.demo;

import com.chatchatabc.rpc.domain.model.Author;
import com.chatchatabc.rpc.domain.model.Book;
import com.chatchatabc.rpc.domain.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * testing only, and not recommended
 *
 * @author linux_china
 */
@RestController
public class CombinedController {

    @Autowired
    private BookRepository bookRepository;

    @RequestMapping("/book/{id}")
    @QueryMapping("findBook")
    @MessageMapping("findBook")
    public Mono<Book> findBook(@PathVariable("id") @Argument String id) {
        return Mono.justOrEmpty(bookRepository.findBookById(id));
    }

    @RequestMapping(path = "/author/{id}")
    @QueryMapping("findAuthor")
    @MessageMapping("findAuthor")
    public Mono<Author> findAuthor(@PathVariable("id") @Argument String id) {
        return Mono.justOrEmpty(bookRepository.findAuthorById(id));
    }

    @SchemaMapping(typeName = "Book", field = "author")
    public Mono<Author> authorForBook(Book book) {
        return findAuthor(book.getAuthorId());
    }


}
