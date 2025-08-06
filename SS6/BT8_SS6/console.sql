CREATE DATABASE bt8_ss6;
USE bt8_ss6;

CREATE TABLE users
(
    id       INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(100) UNIQUE NOT NULL,
    password VARCHAR(100)        NOT NULL,
    email    VARCHAR(100),
    balance  DOUBLE DEFAULT 10000
);

CREATE TABLE seeds
(
    id         INT AUTO_INCREMENT PRIMARY KEY,
    seeds_name VARCHAR(100),
    price      DOUBLE,
    image_url  VARCHAR(255)
);