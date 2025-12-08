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
('AGENDADO'),
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


SELECT * FROM mae;

SELECT e.id, e.data, m.nome AS mae, s.nome AS status
FROM encontro e
JOIN mae m ON e.mae_id = m.id
JOIN status s ON e.status_id = s.id;




CREATE TABLE servico_tipo (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL UNIQUE
);

INSERT INTO servico_tipo (nome) VALUES
('MÚSICA'),
('RECEPÇÃO DE MÃES'),
('ACOLHIDA'),
('TERÇO'),
('FORMAÇÃO'),
('MOMENTO ORACIONAL'),
('PROCLAMAÇÃO DA VITÓRIA'),
('SORTEIO DAS FLORES'),
('ENCERRAMENTO'),
('ARRUMAÇÃO CAPELA'),
('QUEIMA DOS PEDIDOS'),
('COMPRA DAS FLORES');


CREATE TABLE encontro_servico (
    id INT PRIMARY KEY AUTO_INCREMENT,
    encontro_id INT NOT NULL,
    servico_tipo_id INT NOT NULL,
    mae_id INT,
    descricao VARCHAR(500),
    FOREIGN KEY (encontro_id) REFERENCES encontro(id) ON DELETE CASCADE,
    FOREIGN KEY (servico_tipo_id) REFERENCES servico_tipo(id),
    FOREIGN KEY (mae_id) REFERENCES mae(id)
);

SELECT st.nome AS servico,
       m.nome AS mae_responsavel,
       es.descricao
FROM encontro_servico es
JOIN servico_tipo st ON es.servico_tipo_id = st.id
LEFT JOIN mae m ON es.mae_id = m.id
WHERE es.encontro_id = 1
ORDER BY st.id;

SELECT * FROM mae
WHERE MONTH(data_aniversario) = MONTH(CURRENT_DATE());
