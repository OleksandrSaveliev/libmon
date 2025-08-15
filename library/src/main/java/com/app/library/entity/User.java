package com.app.library.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "u_id")
    private int id;

    @Column(name = "u_name")
    private String name;

    @Column(name = "u_surName")
    private String surName;

    @Column(name = "u_email")
    private String email;

    @Column(name = "u_password")
    private String password;

    @OneToMany(mappedBy = "user")
    @JoinColumn(name = "user_id")
    private List<Book> books;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id
                && Objects.equals(name, user.name)
                && Objects.equals(surName, user.surName)
                && Objects.equals(email, user.email)
                && Objects.equals(password, user.password)
                && Objects.equals(books, user.books);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surName, email, password, books);
    }
}
