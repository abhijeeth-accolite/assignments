INSERT INTO LOCATION
(latitude, longitude, house_no, street_1, street_2, city, state, zip)
VALUES
(1, 1, "#001", "street 1", "cross 1, main 1", "Bangalore", "Karnataka", 560001),
(2, 2, "#002", "street 2", "cross 2, main 2", "Bangalore", "Karnataka", 560002),
(3, 3, "#003", "street 3", "cross 3, main 3", "Bangalore", "Karnataka", 560003),
(4, 4, "#004", "street 4", "cross 4, main 4", "Bangalore", "Karnataka", 560004),
(5, 5, "#005", "street 5", "cross 5, main 5", "Bangalore", "Karnataka", 560005),
(6, 6, "#006", "street 6", "cross 6, main 6", "Bangalore", "Karnataka", 560006),
(7, 7, "#007", "street 7", "cross 7, main 7", "Bangalore", "Karnataka", 560007),
(8, 8, "#008", "street 8", "cross 8, main 8", "Bangalore", "Karnataka", 560008),
(9, 9, NULL, NULL, NULL, NULL, NULL, NULL),
(10, 10, NULL, NULL, NULL, NULL, NULL, NULL),
(11, 11, NULL, NULL, NULL, NULL, NULL, NULL),
(12, 12, NULL, NULL, NULL, NULL, NULL, NULL),
(13, 13, NULL, NULL, NULL, NULL, NULL, NULL),
(14, 14, NULL, NULL, NULL, NULL, NULL, NULL);

INSERT INTO TAXI
(type, max_size, reg_no, mileage, current_location_id)
VALUES
("Sedan", 4, "KA51EP3001", 50, 9),
("XUV", 6, "KA51XUV3413", 42, 10),
("auto", 3, "KA74AUTO14276", 71, 13),
("Sedan", 4, "KA51EP3002", 35, 10);

INSERT INTO DRIVER
(name, mobile, email, driving_licence)
VALUES
("driver001", 999001, "driver001@gmail.com", "KA51001"),
("driver002", 999002, "driver002@gmail.com", "KA51002"),
("driver003", 999003, "driver003@gmail.com", "KA51003"),
("driver004", 999004, "driver004@gmail.com", "KA51004"),
("driver005", 999005, "driver005@gmail.com", "KA51005"),
("driver006", 999006, "driver006@gmail.com", "KA51006"),
("driver007", 999007, "driver007@gmail.com", "KA51007"),
("driver008", 999008, "driver008@gmail.com", "KA51008"),
("driver009", 999009, "driver009@gmail.com", "KA51009");

INSERT INTO CUSTOMER
(name, email, mobile, gender, home_address_id)
VALUES
("customer001", "cust001@gmail.com", 999001, FALSE, 1),
("customer002", "cust002@gmail.com", 999002, FALSE, 2),
("customer003", "cust003@gmail.com", 999003, FALSE, 3),
("customer004", "cust004@gmail.com", 999004, FALSE, 4),
("customer005", "cust005@gmail.com", 999005, TRUE, 5),
("customer006", "cust006@gmail.com", 999006, TRUE, 6),
("customer007", "cust007@gmail.com", 999007, TRUE, 7),
("customer008", "cust008@gmail.com", 999008, TRUE, 8);

INSERT INTO REVIEW
(comment, rating, review_time, customer_id, driver_id)
VALUES
("nice", 0, NOW(), 1, 1),
("very nice", 0, NOW(), 2, 2),
("very very nice", 0, NOW(), 3, 3),
("very very very nice", 0, NOW(), 3, 4),
("very very very very nice", 0, NOW(), 3, 5),
("very very very very very nice", 0, NOW(), 4, 1);

INSERT INTO TRIP
(customer_id, driver_id, start_time, end_time, start_location_id, end_location_id)
VALUES
(1, 1, NOW(), NOW()+30, 1, 4),
(2, 2, NOW(), NOW()+30, 3, 2),
(3, 3, NOW(), NULL, 5, NULL),
(4, 4, NOW(), NULL, 11, NULL);

UPDATE REVIEW
SET rating = 4
WHERE customer_id = 1 AND driver_id = 1;

UPDATE REVIEW
SET rating = 2
WHERE customer_id = 4 AND driver_id = 1;

UPDATE REVIEW
SET rating = 2
WHERE customer_id = 3 AND driver_id = 4;


