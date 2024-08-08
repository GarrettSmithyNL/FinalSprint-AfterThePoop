CREATE TABLE products (
    product_id SERIAL PRIMARY KEY,
    product_name varchar(255) NOT NULL,
    product_description varchar(255) NOT NULL,
    k_percent int NOT NULL,
    p_percent int NOT NULL,
    n_percent int NOT NULL
);