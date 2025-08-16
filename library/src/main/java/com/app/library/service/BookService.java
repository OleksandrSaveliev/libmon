package com.app.library.service;

import com.app.library.entity.Book;
import com.app.library.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    public boolean rentBook(int bookId) {
        Optional<Book> optionalBook = bookRepository.findById(bookId);

        if (optionalBook.isPresent()) {
            Book bookFromOptional = optionalBook.get();

            if (bookFromOptional.isAvailable()) {
                bookFromOptional.setAvailable(false);
                bookRepository.save(bookFromOptional);
                return true;
            }
        }

        return false;
    }
}
