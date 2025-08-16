package com.app.statistic.service;

import com.app.library.event.BookRentedEvent;
import com.app.statistic.entity.Stat;
import com.app.statistic.repository.StatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StatisticEventService {
    private final StatRepository statRepository;

    @EventListener
    public void handleBookRentedEvent(BookRentedEvent bookRentedEvent) {
        Stat statistic = statRepository.findById(1).orElse(new Stat());
        statistic.setTotalIssuedBooks(statistic.getTotalIssuedBooks() + 1);
        statistic.setTotalAvailableBooks(statistic.getTotalAvailableBooks() - 1);
        statRepository.save(statistic);
    }
}
