package com.chatchatabc.rpc.domain.repository;

import com.chatchatabc.rpc.domain.model.Author;
import com.chatchatabc.rpc.domain.model.Book;

public interface BookRepository {

    Book findBookById(String id);

    Author findAuthorById(String id);
}
