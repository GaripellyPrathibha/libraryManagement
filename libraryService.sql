
CREATE TABLE library.book (
  book_id INT PRIMARY KEY,
  title VARCHAR(45),
  author_name VARCHAR(50),
  year_published INT,
  quantity INT
);
CREATE TABLE library.isbn (
  isbn BIGINT PRIMARY KEY,
  book_id INT,
  FOREIGN KEY (book_id) REFERENCES book(book_id)
);
CREATE TABLE address (
  address_id INT PRIMARY KEY,
  line1 VARCHAR(30),
  line2 VARCHAR(30),
  city VARCHAR(20),
  state CHAR(2),
  zip INT
);
CREATE TABLE member (
  member_id INT PRIMARY KEY,
  first_name VARCHAR(25), 
  last_name VARCHAR(25),
  email_address VARCHAR(35),
  phone_number BIGINT,
  membership_level VARCHAR(10),
  address_id INT,
  FOREIGN KEY (address_id) REFERENCES address(address_id)
);
CREATE TABLE checkout (
  id INT PRIMARY KEY,
  isbn BIGINT,
  member_id INT,
  checkout_date DATETIME,
  due_date DATETIME,
  is_returned BOOLEAN,
  FOREIGN KEY (isbn) REFERENCES isbn(isbn),
  FOREIGN KEY (member_id) REFERENCES member(member_id)
);
INSERT INTO book (book_id, title, author_name, year_published, quantity)
VALUES 
(1, 'Wildest dreams', 'Talyor Swift', 1978, 5),
(2, 'Love story', 'Harper ', 1960, 3), 
(3, '1989', 'George Orwell', 1997, 2),
(4, 'Shake it off', 'Salinger', 1981, 4),
(5, 'Blank space', 'Austen', 1893, 6),
(6, 'Delicate', ' Tolkien', 1884, 5);
INSERT INTO isbn (isbn, book_id)
VALUES
(9780743273565, 1),
(9780446310789, 2),
(9780451524935, 3),
(9780316769174, 4),
(9780141439518, 5), 
(9780547928210, 6),
(9780743273566, 1),
(9780446310788, 2),
(9780451524936, 3),
(9780316769175, 4),
(9780141439519, 5),
(9780547928211, 6),
(9780743273567, 1), 
(9780446310787, 2),
(9780451524937, 3),
(9780316769176, 4),
(9780141439520, 5),
(9780547928212, 6);
INSERT INTO member (member_id, first_name, last_name, email_address, phone_number, membership_level)
VALUES
(1, 'John', 'Doe', 'johndoe@example.com', 1234567890, 'basic'),
(2, 'Jane', 'Doe', 'janedoe@example.com', 0987654321, 'premium'),
(3, 'Bob', 'Smith', 'bobsmith@example.com', 1231231234, 'basic'),
(4, 'Sara', 'Lee', 'saralee@example.com', 3213213213, 'premium'),
(5, 'Chris', 'Martin', 'chrismartin@example.com', 4445556666, 'basic'),
(6, 'Emily', 'Chen', 'emilychen@example.com', 1112223333, 'premium'),
(7, 'Michael', 'Jones', 'michaeljones@example.com', 8889990000, 'basic'), 
(8, 'Jessica', 'Brown', 'jessicabrown@example.com', 1212121212, 'premium'),
(9, 'David', 'Taylor', 'davidtaylor@example.com', 9991119991, 'basic'),
(10, 'Ashley', 'Williams', 'ashleywilliams@example.com', 3331113131, 'premium');
INSERT INTO address (address_id, line1, line2, city, state, zip)
VALUES
(1, '123 Main St', 'Apt 1', 'New York', 'NY', 10001),
(2, '456 Oak Rd', NULL, 'Los Angeles', 'CA', 90001),
(3, '789 Elm St', 'Unit 5', 'Chicago', 'IL', 60601),
(4, '321 Pine Ave', NULL, 'Houston', 'TX', 77001),
(5, '654 Maple Ln', NULL, 'Philadelphia', 'PA', 19101),
(6, '987 Cedar St', 'Apt 3B', 'Phoenix', 'AZ', 85001);

INSERT INTO checkout (id, isbn, member_id, checkout_date, due_date, is_returned)
VALUES
(1, 9780743273565, 1, '2023-02-15 10:30:00', '2023-03-01 10:30:00', TRUE), 
(2, 9780446310789, 2, '2023-02-20 13:45:00', '2023-03-08 13:45:00', FALSE),
(3, 9780451524937, 5, '2023-02-12 16:15:00', '2023-02-26 16:15:00', TRUE),
(4, 9780141439520, 8, '2023-02-25 09:00:00', '2023-03-11 09:00:00', FALSE),
(5, 9780547928212, 9, '2023-02-18 11:00:00', '2023-03-04 11:00:00', TRUE),
(6, 9780743273567, 10, '2023-02-16 14:30:00', '2023-03-02 14:30:00', FALSE);
Select * from address;