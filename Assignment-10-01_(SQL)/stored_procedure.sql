-- PROCEDURE TO TO UPDATE CUSTOMER'S HOME ADDRESS LOCATION 
-- WHEN COMMUTE IS LIVE AND SET TO GO TO CUSTOMER'S HOME ADDRESS

DELIMITER //
CREATE PROCEDURE updateHomeWhileLive
(
    IN latitude INT, IN longitude INT, IN house_no VARCHAR(255), 
    IN street_1 VARCHAR(255), IN street_2 VARCHAR(255), 
    IN city VARCHAR(255), IN state VARCHAR(255), IN zip INT,
    IN customer_id INT
)
BEGIN
    INSERT INTO LOCATION (latitude, longitude, house_no, street_1, street_2, city, state, zip)
    VALUES (latitude, longitude, house_no, street_1, street_2, city, state, zip);

    UPDATE TRIP t, CUSTOMER c SET t.end_location_id = LAST_INSERT_ID() 
    WHERE t.customer_id = customer_id AND c.id = customer_id AND t.end_location_id = c.home_address_id; 

    UPDATE CUSTOMER c SET home_address_id = LAST_INSERT_ID() WHERE c.id = customer_id;
END //
DELIMITER ;

CALL updateHomeWhileLive(15, 15, "#0015", "street 15", "cross 15, main 15", "Bangalore", "Karnataka", 5600015, 3);

