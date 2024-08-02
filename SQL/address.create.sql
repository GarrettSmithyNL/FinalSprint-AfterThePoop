CREATE TABLE address (
    address_id SERIAL PRIMARY KEY,
    street varchar(255) NOT NULL,
    city varchar(255) NOT NULL,
    province varchar(255) NOT NULL,
    postal_code varchar(255) NOT NULL
);