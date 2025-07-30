DROP DATABASE IF EXISTS prestimo;
CREATE DATABASE prestimo;
DROP TABLE IF EXISTS metal_prices CASCADE;
DROP TABLE IF EXISTS currency_prices CASCADE;
DROP TABLE IF EXISTS percentages_buy_caratage CASCADE;
DROP TABLE IF EXISTS percentages_buy CASCADE;
DROP TABLE IF EXISTS buy_percentages_jewelries CASCADE;
DROP TABLE IF EXISTS jewelries CASCADE;
DROP TABLE IF EXISTS constants CASCADE;
DROP TABLE IF EXISTS buys_jewelry CASCADE;
DROP TABLE IF EXISTS percentages_loan_one CASCADE;
DROP TABLE IF EXISTS percentages_loan_two CASCADE;
DROP TABLE IF EXISTS loans_jewelry CASCADE;




-- Crear la tabla jewelries
CREATE TABLE jewelries (
    id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY, -- 'unsigned int' as auto-incrementing PK
    metal VARCHAR(10),
    weight DOUBLE PRECISION, -- 'float' is typically mapped to DOUBLE PRECISION in PostgreSQL for general numeric data
    caratage VARCHAR(3),
    description TEXT,
    image TEXT
);


CREATE TABLE percentages_buy (
    id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    minimum DOUBLE PRECISION,
    medium DOUBLE PRECISION,
    maximum DOUBLE PRECISION
);

CREATE TABLE percentages_buy_caratage (
    id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    minimum DOUBLE PRECISION,
    medium DOUBLE PRECISION,
    maximum DOUBLE PRECISION
);

CREATE TABLE currency_prices (
    id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY, -- Cambiado a INT GENERATED ALWAYS AS IDENTITY
    mxn_value DOUBLE PRECISION
);

CREATE TABLE metal_prices (
    id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY, -- Cambiado a INT GENERATED ALWAYS AS IDENTITY
    metal VARCHAR(255),
    price_onz DOUBLE PRECISION,
    price_gr DOUBLE PRECISION,
    currency_prices_id INT, -- El tipo de la FK debe coincidir con la PK referenciada
    CONSTRAINT fk_currency_prices
        FOREIGN KEY (currency_prices_id)
        REFERENCES currency_prices (id)
);
CREATE TABLE constants (
    id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY, -- Cambiado a INT GENERATED ALWAYS AS IDENTITY
    conversion_factor DOUBLE PRECISION,
    security_value DOUBLE PRECISION,
    revenue_gr DOUBLE PRECISION
);


CREATE TABLE buys_jewelry (
    id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    price_gr_inter DOUBLE PRECISION,
    revenue_extern_sale DOUBLE PRECISION,
    price_local_gr DOUBLE PRECISION,
    caratage_price DOUBLE PRECISION,
    caratage_price_final DOUBLE PRECISION,
    caratage_price_final_pa DOUBLE PRECISION,
    price_gr_final DOUBLE PRECISION,
    max_purchase_amount DOUBLE PRECISION,
    percentage_buy_applied DOUBLE PRECISION,
    percentage_buy_caratage_applied DOUBLE PRECISION,
    contants_id INT, -- Foreign Key to a 'Contants' table (not defined in previous requests)
    metal_price_id INT, -- Foreign Key to MetalPrices table
    percentages_buy_id INT, -- Foreign Key to PercentagesBuy table
    percentages_caratage_id INT, -- Foreign Key to PercentagesBuyCaratage table
    jewelry_id INT, -- Foreign Key to a 'Jewelry' table (not defined in previous requests)

    -- Foreign Key Constraints
    CONSTRAINT fk_buyjewelry_contants
        FOREIGN KEY (contants_id)
        REFERENCES constants (id), -- This table 'Contants' needs to exist with an 'id' column
    CONSTRAINT fk_buyjewelry_metal_prices
        FOREIGN KEY (metal_price_id)
        REFERENCES metal_prices (id),
    CONSTRAINT fk_buyjewelry_percentages_buy
        FOREIGN KEY (percentages_buy_id)
        REFERENCES percentages_buy (id),
    CONSTRAINT fk_buyjewelry_percentages_caratage
        FOREIGN KEY (percentages_caratage_id)
        REFERENCES percentages_buy_caratage (id),
    CONSTRAINT fk_buyjewelry_jewelry
        FOREIGN KEY (jewelry_id)
        REFERENCES jewelries (id) -- This table 'Jewelry' needs to exist with an 'id' column
);

CREATE TABLE percentages_loan_one (
    id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    minimum DOUBLE PRECISION,
    medium DOUBLE PRECISION,
    maximum DOUBLE PRECISION
);

CREATE TABLE percentages_loan_two (
    id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    minimum DOUBLE PRECISION,
    medium DOUBLE PRECISION,
    maximum DOUBLE PRECISION
);


CREATE TABLE loans_jewelry (
    id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    price_gr_inter DOUBLE PRECISION,
    revenue_extern_sale DOUBLE PRECISION,
    price_local_gr DOUBLE PRECISION,
    pre_loan_amount DOUBLE PRECISION,
    loan_amount DOUBLE PRECISION,
    final_loan DOUBLE PRECISION,
    percentage_loan_one_applied DOUBLE PRECISION,
    percentage_loan_two_applied DOUBLE PRECISION,
    contants_id INT, -- Foreign Key to a 'Contants' table (not defined in previous requests)
    metal_price_id INT, -- Foreign Key to MetalPrices table
   percentages_loan_one_id INT, -- Foreign Key to PercentagesBuy table
   percentages_loan_two_id INT, -- Foreign Key to PercentagesBuyCaratage table
    jewelry_id INT, -- Foreign Key to a 'Jewelry' table (not defined in previous requests)

    -- Foreign Key Constraints
    CONSTRAINT fk_loanjewelry_contants
        FOREIGN KEY (contants_id)
        REFERENCES constants (id), -- This table 'Contants' needs to exist with an 'id' column
    CONSTRAINT fk_loanjewelry_metal_prices
        FOREIGN KEY (metal_price_id)
        REFERENCES metal_prices (id),
    CONSTRAINT fk_loanjewelry_percentages_loan_one
        FOREIGN KEY (percentages_loan_one_id)
        REFERENCES percentages_loan_one (id),
    CONSTRAINT fk_loanjewelry_percentages_loan_two
        FOREIGN KEY (percentages_loan_two_id)
        REFERENCES percentages_loan_two (id),
    CONSTRAINT fk_loanjewelry_jewelry
        FOREIGN KEY (jewelry_id)
        REFERENCES jewelries (id) -- This table 'Jewelry' needs to exist with an 'id' column
);

CREATE TABLE clients (
    id SERIAL PRIMARY KEY,
    name TEXT,
    address TEXT,
    city TEXT,
    state TEXT
);