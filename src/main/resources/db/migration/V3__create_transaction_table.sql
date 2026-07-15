CREATE TABLE transaction (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255),
    type VARCHAR(255),
    value NUMERIC(10,2),
    date TIMESTAMP
 );