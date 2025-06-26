package org.example;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookRepositoryImpl implements BookRepository {

    private final List<Book> AVAILABLE_BOOKS = List.of(
            new Book("Abay Zholi I", "Muktar Auezov", 1000),
            new Book("Abay Zholi II", "Muktar Auezov", 1500),
            new Book("Abay Zholi III", "Muktar Auezov", 1700)
    );

    @Override
    public List<Book> getAllBooks() {
        return AVAILABLE_BOOKS;
    }

}
