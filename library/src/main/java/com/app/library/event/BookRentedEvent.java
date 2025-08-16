package com.app.library.event;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BookRentedEvent {
    private int userId;
    private int bookId;
    private boolean isAvailable;
}
