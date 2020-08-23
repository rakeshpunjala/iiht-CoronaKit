DROP DATABASE coronakit;

CREATE DATABASE coronakit;

USE coronakit;

CREATE TABLE items(
name varchar(20) primary key,
price int not null,
quantity int
);

INSERT INTO items VALUES
("FaceMask", 100, 50),
("Sanitizer", 50, 90),
("Medicines", 200, 70);	