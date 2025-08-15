package com.app.library.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "b_id")
    private int id;

    @Column(name = "b_title")
    private String title;

    @Column(name = "b_author")
    private String author;

    @Column(name = "b_issue_date")
    private String issueDate;

    @Column(name = "b_is_Available")
    private boolean isAvailable;

    @ManyToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    @JsonBackReference
    private User user;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return id == book.id
                && isAvailable == book.isAvailable
                && Objects.equals(title, book.title)
                && Objects.equals(author, book.author)
                && Objects.equals(issueDate, book.issueDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, author, issueDate, isAvailable);
    }
}
