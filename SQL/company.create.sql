CREATE TABLE company (
    company_id SERIAL PRIMARY KEY,
    address_id int,
    company_name varchar(255),
    company_phone varchar(255),
    FOREIGN KEY (address_id) REFERENCES address(address_id)
);