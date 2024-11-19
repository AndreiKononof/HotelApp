CREATE SCHEMA IF EXISTS hotel_booking;

CREATE TABLE IF EXISTS hotel_booking.hotel
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