package com.chatchatabc.rpc.application.rsocket;

import com.chatchatabc.rpc.domain.model.Author;
import com.chatchatabc.rpc.domain.model.Book;
import com.chatchatabc.rpc.domain.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Mono;

@Controller
public class BookRSocketController {

    @Autowired
    private BookRepository bookRepository;

    @MessageMapping("findBook")
    public Mono<Book> findBook(String id) {
        return Mono.justOrEmpty(bookRepository.findBookById(id));
    }

    @MessageMapping("findAuthor")
    public Mono<Author> findAuthor(String id) {
        return Mono.justOrEmpty(bookRepository.findAuthorById(id));
    }

}
