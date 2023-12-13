-- create the databases
CREATE TABLE warehouse (
    id INT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    amount INT NOT NULL,
    expiration_date DATE NOT NULL
);

INSERT INTO warehouse (id, name, amount, expiration_date) values (1, 'chicken', 18, '2025-02-18');
INSERT INTO warehouse (id, name, amount, expiration_date) values (2, 'pig', 3, '2023-11-20');
INSERT INTO warehouse (id, name, amount, expiration_date) values (3, 'watermelon', 8, '2024-05-01');

