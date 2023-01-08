package com.chatchatabc.rpc.impl.domain.repository;

import com.chatchatabc.rpc.SpringBootBaseTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class BookRepositoryImplTest extends SpringBootBaseTest {
    @Autowired
    private BookRepositoryImpl bookRepository;

    @Test
    public void findBookById() {
        System.out.println(bookRepository.findBookById("book-1"));
    }
}
