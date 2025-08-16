package com.app.library.controller;

import com.app.library.event.BookRentedEvent;
import com.app.library.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/books")
public class BookController {
    private final BookService bookService;
    private final ApplicationEventPublisher publisher;

    @PostMapping("/rent")
    public String rentBook(@RequestParam int bookId, @RequestParam int userId) {
        boolean isRented = bookService.rentBook(bookId);

        if (isRented) {
            publisher.publishEvent(new BookRentedEvent(bookId, userId, true));
        }

        return isRented ? "Book rented successfully" : "Book is not available";
    }
}
