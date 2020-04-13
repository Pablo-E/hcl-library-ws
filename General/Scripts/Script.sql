CREATE DATABASE library;
USE library(
CREATE TABLE person (
id_person INT NOT NULL,
id_address INT NOT NULL,
name VARCHAR(15) NOT NULL,
las_name VARCHAR(15) NOT NULL,
birthdate DATE,
gender CHAR(1),
email VARCHAR(35),
phone VARCHAR(10),
user VARCHAR(8),
password VARCHAR(8),
status TINYINT(1),
rol VARCHAR(8)
)
CREATE TABLE loan(
id_loan INT NOT NULL,
id_staff INT,
id_client INT,
date DATE,
is_returned TINYINT(1)
)
CREATE TABLE book(
isbn VARCHAR (17),
id_author INT,
id_genre INT,
title VARCHAR(30),
pages INT,
publisher VARCHAR(30)
)
CREATE TABLE author(
id_author INT,
genre VARCHAR(15),
last_name VARCHAR(15),
nationality VARCHAR(15)
)
CREATE TABLE genre(
id_genre INT,
genre VARCHAR(20)
)
CREATE TABLE detail_loan (
id_detail_loan INT,
id_loan INT,
isbn VARCHAR(17)
)
CREATE TABLE address(
id_address INT,
street VARCHAR(20),
number INT,
neighborhood VARCHAR(25)
)
)





