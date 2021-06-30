CREATE TABLE users(
    id SERIAL PRIMARY KEY,
    first_name VARCHAR NOT NULL,
    last_name VARCHAR NOT NULL,
    email VARCHAR NOT NULL
);

CREATE TABLE todos(
    id SERIAL PRIMARY KEY,
    toDo VARCHAR NOT NULL,
    done boolean NOT NULL,
    user_id INTEGER REFERENCES users(id),
    created_at TIMESTAMP
);