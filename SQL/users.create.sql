CREATE TABLE users (
    user_id SERIAL PRIMARY KEY,
    address_id INT NOT NULL,
    company_id INT NOT NULL,
    user_name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    user_phone VARCHAR(255) NOT NULL,
    is_admin BOOLEAN NOT NULL,
    FOREIGN KEY (address_id) REFERENCES address(address_id),
    FOREIGN KEY (company_id) REFERENCES company(company_id)
);