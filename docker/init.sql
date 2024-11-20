CREATE SCHEMA IF EXISTS hotel_booking_schema;

CREATE TABLE IF EXISTS hotel_booking_schema.hotel
(
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    title VARCHAR(255),
    town VARCHAR(255) NOT NULL,
    address TEXT NOT NULL,
    distance_center DOUBLE PRECISION,
    rating DOUBLE PRECISION,
    count_ratings INTEGER,
    create_time TIMESTAMP,
    update_time TIMESTAMP
);

CREATE TABLE IF EXISTS hotel_booking_schema.room
(
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NUll,
    description TEXT,
    number INTEGER NOT NULL,
    price DOUBLE PRECISION NOT NULL,
    max_count_people INTEGER NOT NULL,
    booking_now TIMESTAMP,
    hotel_id BIGINT REFERENCES hotel_booking_schema.hotel(id),
    create_time TIMESTAMP,
    update_time TIMESTAMP
);

CREATE table IF EXISTS hotel_booking_schema.user
(
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    role ENUM NOT NULL,
    create_time TIMESTAMP,
    update_time TIMESTAMP
):
