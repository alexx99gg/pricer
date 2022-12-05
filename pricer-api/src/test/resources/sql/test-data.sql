INSERT INTO brands (id, name) VALUES (1, 'ZARA');
INSERT INTO brands (id, name) VALUES (2, 'MANGO');

INSERT INTO prices (brand_id, product_id, start_date, end_date, priority, curr, price)
    VALUES (1, 35455, '2020-06-14T00:00:00+00:00', '2020-12-31T23:59:59+00:00', 0, 'EUR', 35.50);
INSERT INTO prices (brand_id, product_id, start_date, end_date, priority, curr, price)
    VALUES (1, 35455, '2020-06-14T15:00:00+00:00', '2020-06-14T18:30:00+00:00', 1, 'EUR', 25.45);
INSERT INTO prices (brand_id, product_id, start_date, end_date, priority, curr, price)
    VALUES (1, 35455, '2020-06-15T00:00:00+00:00', '2020-06-15T11:00:00+00:00', 1, 'EUR', 30.50);
INSERT INTO prices (brand_id, product_id, start_date, end_date, priority, curr, price)
    VALUES (1, 35455, '2020-06-15T16:00:00+00:00', '2020-12-31T23:59:59+00:00', 1, 'EUR', 38.95);