package com.app.statistic.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "statistics")
public class Stat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "s_id")
    private int id;

    @Column(name = "total_users")
    private int totalUsers;

    @Column(name = "total_books")
    private int totalBooks;

    @Column(name = "total_available_books")
    private int totalAvailableBooks;

    @Column(name = "total_issued_books")
    private int totalIssuedBooks;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Stat stat = (Stat) o;
        return id == stat.id
                && totalUsers == stat.totalUsers
                && totalBooks == stat.totalBooks
                && totalAvailableBooks == stat.totalAvailableBooks
                && totalIssuedBooks == stat.totalIssuedBooks;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, totalUsers, totalBooks, totalAvailableBooks, totalIssuedBooks);
    }
}
