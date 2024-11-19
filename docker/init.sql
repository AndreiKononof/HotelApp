CREATE SCHEMA IF EXISTS hotel_booking;

CREATE TABLE IF EXISTS hotel_booking.hotel
(
    id BIGSERIAL PRIMARY KEY;
    name VARCHAR(255) NOT NULL;
    title VARCHAR(255);
    town VARCHAR(255) NOT NULL;
    address TEXT NOT NULL;
    distance_center double precision;
    rating double precision;
    count_ratings BIGINT;
);