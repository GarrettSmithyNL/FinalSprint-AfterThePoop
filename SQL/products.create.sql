CREATE TABLE products (
    product_id SERIAL PRIMARY KEY,
    product_name varchar(255) NOT NULL,
    product_description varchar(255) NOT NULL,
    k_percent decimal(10,2) NOT NULL,
    p_percent decimal(10,2) NOT NULL,
    n_percent decimal(10,2) NOT NULL
);