-- Inserts para percentages_buy
INSERT INTO percentages_buy (minimum, medium, maximum) VALUES
(0.85, 0.90, 0.95);

-- Inserts para percentages_buy_caratage
INSERT INTO percentages_buy_caratage (minimum, medium, maximum) VALUES
(0.70, 0.78, 0.85);

-- Inserts para currency_prices
INSERT INTO currency_prices (mxn_value) VALUES
(18.25);

-- Inserts para metal_prices (referenciando IDs válidos de currency_prices)
INSERT INTO metal_prices (metal, price_onz, price_gr, currency_prices_id) VALUES
('Oro', 2300.50, 74.00, 1);
-- Insert de valores en la tabla constants
INSERT INTO constants (conversion_factor, security_value, revenue_gr) VALUES
(31.1, 100, 100);