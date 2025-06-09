CREATE DATABASE prestimo;


-- Crear la tabla jewelries
CREATE TABLE jewelries (
    id SERIAL PRIMARY KEY,
    metal VARCHAR(10),
    weight FLOAT,
    caratage VARCHAR(3),
    description VARCHAR(1000)
);

CREATE TABLE buy_percentages_jewelries (
    id INT AUTO_INCREMENT PRIMARY KEY,
    min DOUBLE PRECISION,
    mid DOUBLE PRECISION,
    max DOUBLE PRECISION
);