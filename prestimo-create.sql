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
    id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    min DOUBLE PRECISION,
    mid DOUBLE PRECISION,
    max DOUBLE PRECISION
);

CREATE TABLE percentages_buy (
    id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    min DOUBLE PRECISION,
    mid DOUBLE PRECISION,
    max DOUBLE PRECISION
);

CREATE TABLE percentages_buy_caratage (
    id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    min DOUBLE PRECISION,
    mid DOUBLE PRECISION,
    max DOUBLE PRECISION
);

CREATE TABLE CurrencyPrices (
    id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY, -- Cambiado a INT GENERATED ALWAYS AS IDENTITY
    mxn_value DOUBLE PRECISION
);

CREATE TABLE MetalPrices (
    id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY, -- Cambiado a INT GENERATED ALWAYS AS IDENTITY
    metal VARCHAR(255),
    price_onz DOUBLE PRECISION,
    price_gr DOUBLE PRECISION,
    currency_prices_id INT, -- El tipo de la FK debe coincidir con la PK referenciada
    CONSTRAINT fk_currency_prices
        FOREIGN KEY (currency_prices_id)
        REFERENCES CurrencyPrices (id)
);