CREATE DATABASE maesdb;
USE maesdb;

CREATE TABLE mae (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    telefone VARCHAR(20),
    endereco VARCHAR(200),
    data_aniversario DATE
);

CREATE TABLE status (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(50) NOT NULL
);

INSERT INTO status (nome) VALUES
('FUTURO'),
('REALIZADO'),
('CANCELADO');

CREATE TABLE encontro (
    id INT PRIMARY KEY AUTO_INCREMENT,
    data DATE NOT NULL,
    mae_id INT NOT NULL,
    status_id INT NOT NULL,
    FOREIGN KEY (mae_id) REFERENCES mae(id),
    FOREIGN KEY (status_id) REFERENCES status(id)
);
-- mãe
INSERT INTO mae (nome, telefone, endereco, data_aniversario)
VALUES ('Maria Silva', '99999-9999', 'Rua A, 123', '1980-05-12');

-- encontro
INSERT INTO encontro (data, mae_id, status_id)
VALUES ('2025-01-10', 1, 1);
