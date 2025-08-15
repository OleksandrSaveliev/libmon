DROP TABLE IF EXISTS books;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS statistics;

CREATE TABLE users
(
    u_id       INT AUTO_INCREMENT PRIMARY KEY,
    u_name     VARCHAR(255) NOT NULL,
    u_surname  VARCHAR(255) NOT NULL,
    u_email    VARCHAR(255) NOT NULL UNIQUE,
    u_password VARCHAR(255) NOT NULL
);

CREATE TABLE books
(
    b_id           INT AUTO_INCREMENT PRIMARY KEY,
    b_title        VARCHAR(255) NOT NULL,
    b_author       VARCHAR(255) NOT NULL,
    b_issue_date   DATE,
    b_is_available BOOLEAN      NOT NULL,
    user_id        INT,
    CONSTRAINT fk_user FOREIGN KEY (user_id) REFERENCES users (u_id)
);

CREATE TABLE statistics
(
    s_id                  INT AUTO_INCREMENT PRIMARY KEY,
    total_users           INT NOT NULL,
    total_books           INT NOT NULL,
    total_issued_books    INT NOT NULL,
    total_available_books INT NOT NULL
);