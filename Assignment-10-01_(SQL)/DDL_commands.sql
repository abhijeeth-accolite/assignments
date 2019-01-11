DROP DATABASE FAKE_UBER;
CREATE DATABASE FAKE_UBER;
USE FAKE_UBER;

CREATE TABLE LOCATION (
    id INT AUTO_INCREMENT PRIMARY KEY,
    latitude INT NOT NULL,
    longitude INT NOT NULL,
    house_no VARCHAR(255),
    street_1 VARCHAR(255),
    street_2 VARCHAR(255),
    city VARCHAR(255),
    state VARCHAR(255),
    zip INT
);

CREATE TABLE TAXI(
    id INT AUTO_INCREMENT PRIMARY KEY,
    type VARCHAR(255) NOT NULL,
    max_size INT NOT NULL,
    reg_no VARCHAR(255) NOT NULL,
    mileage INT NOT NULL,
    current_location_id INT NOt NULL,
    FOREIGN KEY(current_location_id) REFERENCES LOCATION(id)
);

CREATE TABLE DRIVER(
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    mobile INT NOT NULL,
    email VARCHAR(255) NOT NULL,
    driving_licence VARCHAR(255) NOT NULL,
    taxi_id INT,
    UNIQUE(mobile),
    UNIQUE(email),
    UNIQUE(driving_licence),
    FOREIGN KEY(taxi_id) REFERENCES TAXI(id)
);


CREATE TABLE CUSTOMER(
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    mobile INT not null,
    gender BOOLEAN NOT NULL,
    home_address_id INT,
    UNIQUE(mobile),
    UNIQUE(email), 
    FOREIGN KEY(home_address_id) REFERENCES LOCATION(id)
);

CREATE TABLE REVIEW(
    id INT AUTO_INCREMENT PRIMARY KEY,
    comment VARCHAR(255),
    rating INT NOT NULL,
    review_time DATETIME NOT NULL,
    customer_id INT NOT NULL,
    driver_id INT NOT NULL,
    FOREIGN KEY(customer_id) REFERENCES CUSTOMER(id),
    FOREIGN KEY(driver_id) REFERENCES DRIVER(id),
    UNIQUE(customer_id, driver_id)
);


CREATE TABLE TRIP (
    id INT AUTO_INCREMENT PRIMARY KEY,
    customer_id INT NOT NULL,
    driver_id INT NOT NULL,
    start_time DATETIME NOT NULL,
    end_time DATETIME,
    start_location_id INT NOT NULL,
    end_location_id INT,
    FOREIGN KEY(customer_id) REFERENCES CUSTOMER(id),
    FOREIGN KEY(driver_id) REFERENCES DRIVER(id),
    FOREIGN KEY(start_location_id) REFERENCES LOCATION(id),
    FOREIGN KEY(end_location_id) REFERENCES LOCATION(id)
);

CREATE VIEW LIVE_TRIP_DETAILS AS (
    SELECT * FROM TRIP
    WHERE end_location_id IS NULL
);

CREATE VIEW DRIVER_RATINGS AS (
    SELECT d.name, AVG(r.rating) 
    FROM DRIVER d JOIN REVIEW r ON d.id = r.driver_id
    GROUP BY d.id
);

