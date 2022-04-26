CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    username VARCHAR NOT NULL,
    email VARCHAR NOT NULL UNIQUE,
    phone VARCHAR NOT NULL UNIQUE
);

CREATE TABLE sessions (
    id SERIAL PRIMARY KEY,
    name text
);

CREATE TABLE tickets (
    id SERIAL PRIMARY KEY,
    session_id INT NOT NULL REFERENCES sessions(id),
    row INT NOT NULL,
    cell INT NOT NULL,
    user_id INT NOT NULL REFERENCES users(id),
    CONSTRAINT valid_seat UNIQUE (session _id, row, cell)
);