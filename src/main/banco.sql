CREATE DATABASE maesdb;
USE maesdb;
CREATE TABLE mae (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    telefone VARCHAR(20),
    endereco VARCHAR(200),
    data_aniversario DATE
);