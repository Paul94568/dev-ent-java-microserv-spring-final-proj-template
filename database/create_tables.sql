CREATE TABLE products
(
    product_id integer auto_increment primary key,
    product_name varchar(255) NOT NULL,
    product_description varchar(1024) NOT NULL
);

CREATE TABLE stocks
(
    stock_id integer auto_increment primary key,
    store_name varchar(255) NOT NULL,
    price decimal(13,2) NOT NULL
);

CREATE TABLE product_stocks
(
    product_id integer NOT NULL REFERENCES products (product_id),
    stock_id integer NOT NULL REFERENCES stocks (stock_id)
);
