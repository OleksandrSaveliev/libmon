INSERT INTO users (u_name, u_surname, u_email, u_password)
VALUES ('John', 'Doe', 'john.doe@example.com', 'password123'),
       ('Jane', 'Doe', 'jane.doe@example.com', 'password456'),
       ('Alex', 'Smith', 'alex.smith@example.com', 'password789');

INSERT INTO books (b_title, b_author, b_issue_date, b_is_available, user_id)
VALUES ('Java Programming', 'James Gosling', '2023-01-01', true, 1),
       ('Spring Boot in Action', 'Craig Walls', '2023-05-15', false, 2),
       ('Effective Java', 'Joshua Bloch', '2023-03-20', true, 3),
       ('Clean Code', 'Robert C. Martin', '2023-06-10', true, null);

INSERT INTO statistics (total_users, total_books, total_issued_books, total_available_books)
VALUES (3, 4, 1, 3);