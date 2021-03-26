
INSERT INTO products (product_name,product_description)
VALUES ('Campbell''s Chicken Noodle Soup', '10.75 oz (Pack of 12)'),
       ('Ben & Jerry''s Ice Cream Chunky Money', 'Non-GMO 16 oz'),
       ('Coca-Cola Soda Pop Cherry Vanilla', '6-16.9 fl oz');

INSERT INTO stocks (store_name, price)
VALUES ('Safeway', 15.49),
       ('Target', 13.13),
       ('Walmart', 12.49),
       ('7-Eleven', 7.99),
       ('Lucky', 4.67),
       ('Walmart', 4.38),
       ('Safeway', 4.99);

INSERT INTO product_stocks (product_id, stock_id)
VALUES (1,1),
       (1,2),
       (1,3),
       (2,4),
       (2,5),
       (2,6),
       (3,7);