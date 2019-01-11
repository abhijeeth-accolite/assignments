INSERT INTO DRIVER
(name, mobile, email, rating, driving_licence)
VALUES
("driver001", 999001, "driver001@gmail.com", 0, "KA51001"),
("driver002", 999002, "driver002@gmail.com", 0, "KA51002"),
("driver003", 999003, "driver003@gmail.com", 0, "KA51003"),
("driver004", 999004, "driver004@gmail.com", 0, "KA51004"),
("driver005", 999005, "driver005@gmail.com", 0, "KA51005"),
("driver006", 999006, "driver006@gmail.com", 0, "KA51006"),
("driver007", 999007, "driver007@gmail.com", 0, "KA51007"),
("driver008", 999008, "driver008@gmail.com", 0, "KA51008"),
("driver009", 999009, "driver009@gmail.com", 0, "KA51009");

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

INSERT INTO CUSTOMER
(name, email, mobile, gender, home_address_id)
VALUES
("customer001", "cust001@gmail.com", 999001, )