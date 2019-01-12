CREATE DATABASE  IF NOT EXISTS `fake_uber` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */;
USE `fake_uber`;
-- MySQL dump 10.13  Distrib 8.0.13, for Win64 (x86_64)
--
-- Host: localhost    Database: fake_uber
-- ------------------------------------------------------
-- Server version	8.0.13

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `customer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `mobile` int(11) NOT NULL,
  `gender` tinyint(1) NOT NULL,
  `home_address_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `mobile` (`mobile`),
  UNIQUE KEY `email` (`email`),
  KEY `home_address_id` (`home_address_id`),
  CONSTRAINT `customer_ibfk_1` FOREIGN KEY (`home_address_id`) REFERENCES `location` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (1,'customer001','cust001@gmail.com',999001,0,1),(2,'customer002','cust002@gmail.com',999002,0,2),(3,'customer003','cust003@gmail.com',999003,0,15),(4,'customer004','cust004@gmail.com',999004,0,4),(5,'customer005','cust005@gmail.com',999005,1,5),(6,'customer006','cust006@gmail.com',999006,1,6),(7,'customer007','cust007@gmail.com',999007,1,7),(8,'customer008','cust008@gmail.com',999008,1,3);
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `driver`
--

DROP TABLE IF EXISTS `driver`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `driver` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `mobile` int(11) NOT NULL,
  `email` varchar(255) NOT NULL,
  `driving_licence` varchar(255) NOT NULL,
  `taxi_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `mobile` (`mobile`),
  UNIQUE KEY `email` (`email`),
  UNIQUE KEY `driving_licence` (`driving_licence`),
  KEY `taxi_id` (`taxi_id`),
  CONSTRAINT `driver_ibfk_1` FOREIGN KEY (`taxi_id`) REFERENCES `taxi` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `driver`
--

LOCK TABLES `driver` WRITE;
/*!40000 ALTER TABLE `driver` DISABLE KEYS */;
INSERT INTO `driver` VALUES (1,'driver001',999001,'driver001@gmail.com','KA51001',NULL),(2,'driver002',999002,'driver002@gmail.com','KA51002',NULL),(3,'driver003',999003,'driver003@gmail.com','KA51003',NULL),(4,'driver004',999004,'driver004@gmail.com','KA51004',NULL),(5,'driver005',999005,'driver005@gmail.com','KA51005',NULL),(6,'driver006',999006,'driver006@gmail.com','KA51006',NULL),(7,'driver007',999007,'driver007@gmail.com','KA51007',NULL),(8,'driver008',999008,'driver008@gmail.com','KA51008',NULL),(9,'driver009',999009,'driver009@gmail.com','KA51009',NULL);
/*!40000 ALTER TABLE `driver` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `driver_ratings`
--

DROP TABLE IF EXISTS `driver_ratings`;
/*!50001 DROP VIEW IF EXISTS `driver_ratings`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8mb4;
/*!50001 CREATE VIEW `driver_ratings` AS SELECT 
 1 AS `name`,
 1 AS `AVG(r.rating)`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `live_trip_details`
--

DROP TABLE IF EXISTS `live_trip_details`;
/*!50001 DROP VIEW IF EXISTS `live_trip_details`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8mb4;
/*!50001 CREATE VIEW `live_trip_details` AS SELECT 
 1 AS `id`,
 1 AS `customer_id`,
 1 AS `driver_id`,
 1 AS `start_time`,
 1 AS `end_time`,
 1 AS `start_location_id`,
 1 AS `end_location_id`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `location`
--

DROP TABLE IF EXISTS `location`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `location` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `latitude` int(11) NOT NULL,
  `longitude` int(11) NOT NULL,
  `house_no` varchar(255) DEFAULT NULL,
  `street_1` varchar(255) DEFAULT NULL,
  `street_2` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `zip` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `location`
--

LOCK TABLES `location` WRITE;
/*!40000 ALTER TABLE `location` DISABLE KEYS */;
INSERT INTO `location` VALUES (1,1,1,'#001','street 1','cross 1, main 1','Bangalore','Karnataka',560001),(2,2,2,'#002','street 2','cross 2, main 2','Bangalore','Karnataka',560002),(3,3,3,'#003','street 3','cross 3, main 3','Bangalore','Karnataka',560003),(4,4,4,'#004','street 4','cross 4, main 4','Bangalore','Karnataka',560004),(5,5,5,'#005','street 5','cross 5, main 5','Bangalore','Karnataka',560005),(6,6,6,'#006','street 6','cross 6, main 6','Bangalore','Karnataka',560006),(7,7,7,'#007','street 7','cross 7, main 7','Bangalore','Karnataka',560007),(8,8,8,'#008','street 8','cross 8, main 8','Bangalore','Karnataka',560008),(9,9,9,NULL,NULL,NULL,NULL,NULL,NULL),(10,10,10,NULL,NULL,NULL,NULL,NULL,NULL),(11,11,11,NULL,NULL,NULL,NULL,NULL,NULL),(12,12,12,NULL,NULL,NULL,NULL,NULL,NULL),(13,13,13,NULL,NULL,NULL,NULL,NULL,NULL),(14,14,14,NULL,NULL,NULL,NULL,NULL,NULL),(15,15,15,'#0015','street 15','cross 15, main 15','Bangalore','Karnataka',5600015),(16,1,1,'#001','street 1','cross 1, main 1','Bangalore','Karnataka',560001),(17,2,2,'#002','street 2','cross 2, main 2','Bangalore','Karnataka',560002),(18,3,3,'#003','street 3','cross 3, main 3','Bangalore','Karnataka',560003),(19,4,4,'#004','street 4','cross 4, main 4','Bangalore','Karnataka',560004),(20,5,5,'#005','street 5','cross 5, main 5','Bangalore','Karnataka',560005),(21,6,6,'#006','street 6','cross 6, main 6','Bangalore','Karnataka',560006),(22,7,7,'#007','street 7','cross 7, main 7','Bangalore','Karnataka',560007),(23,8,8,'#008','street 8','cross 8, main 8','Bangalore','Karnataka',560008),(24,9,9,NULL,NULL,NULL,NULL,NULL,NULL),(25,10,10,NULL,NULL,NULL,NULL,NULL,NULL),(26,11,11,NULL,NULL,NULL,NULL,NULL,NULL),(27,12,12,NULL,NULL,NULL,NULL,NULL,NULL),(28,13,13,NULL,NULL,NULL,NULL,NULL,NULL),(29,14,14,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `location` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `review`
--

DROP TABLE IF EXISTS `review`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `review` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `comment` varchar(255) DEFAULT NULL,
  `rating` int(11) NOT NULL,
  `review_time` datetime NOT NULL,
  `customer_id` int(11) NOT NULL,
  `driver_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `customer_id` (`customer_id`,`driver_id`),
  KEY `driver_id` (`driver_id`),
  CONSTRAINT `review_ibfk_1` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`),
  CONSTRAINT `review_ibfk_2` FOREIGN KEY (`driver_id`) REFERENCES `driver` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `review`
--

LOCK TABLES `review` WRITE;
/*!40000 ALTER TABLE `review` DISABLE KEYS */;
INSERT INTO `review` VALUES (1,'nice',4,'2019-01-11 22:37:08',1,1),(2,'very nice',0,'2019-01-11 22:37:08',2,2),(3,'very very nice',0,'2019-01-11 22:37:08',3,3),(4,'very very very nice',2,'2019-01-11 22:37:08',3,4),(5,'very very very very nice',0,'2019-01-11 22:37:08',3,5),(6,'very very very very very nice',2,'2019-01-11 22:37:08',4,1);
/*!40000 ALTER TABLE `review` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `taxi`
--

DROP TABLE IF EXISTS `taxi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `taxi` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(255) NOT NULL,
  `max_size` int(11) NOT NULL,
  `reg_no` varchar(255) NOT NULL,
  `mileage` int(11) NOT NULL,
  `current_location_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `current_location_id` (`current_location_id`),
  CONSTRAINT `taxi_ibfk_1` FOREIGN KEY (`current_location_id`) REFERENCES `location` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `taxi`
--

LOCK TABLES `taxi` WRITE;
/*!40000 ALTER TABLE `taxi` DISABLE KEYS */;
INSERT INTO `taxi` VALUES (1,'Sedan',4,'KA51EP3001',50,9),(2,'XUV',6,'KA51XUV3413',42,10),(3,'auto',3,'KA74AUTO14276',71,13),(4,'Sedan',4,'KA51EP3002',35,10),(5,'Sedan',4,'KA51EP3001',50,9),(6,'XUV',6,'KA51XUV3413',42,10),(7,'auto',3,'KA74AUTO14276',71,13),(8,'Sedan',4,'KA51EP3002',35,10);
/*!40000 ALTER TABLE `taxi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trip`
--

DROP TABLE IF EXISTS `trip`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `trip` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `customer_id` int(11) NOT NULL,
  `driver_id` int(11) NOT NULL,
  `start_time` datetime NOT NULL,
  `end_time` datetime DEFAULT NULL,
  `start_location_id` int(11) NOT NULL,
  `end_location_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `customer_id` (`customer_id`),
  KEY `driver_id` (`driver_id`),
  KEY `start_location_id` (`start_location_id`),
  KEY `end_location_id` (`end_location_id`),
  CONSTRAINT `trip_ibfk_1` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`),
  CONSTRAINT `trip_ibfk_2` FOREIGN KEY (`driver_id`) REFERENCES `driver` (`id`),
  CONSTRAINT `trip_ibfk_3` FOREIGN KEY (`start_location_id`) REFERENCES `location` (`id`),
  CONSTRAINT `trip_ibfk_4` FOREIGN KEY (`end_location_id`) REFERENCES `location` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trip`
--

LOCK TABLES `trip` WRITE;
/*!40000 ALTER TABLE `trip` DISABLE KEYS */;
INSERT INTO `trip` VALUES (1,1,1,'2019-01-11 22:37:09','2019-01-11 22:37:39',1,4),(2,2,2,'2019-01-11 22:37:09','2019-01-11 22:37:39',3,2),(3,3,3,'2019-01-11 22:37:09',NULL,5,15),(4,4,4,'2019-01-11 22:37:09',NULL,11,NULL);
/*!40000 ALTER TABLE `trip` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'fake_uber'
--

--
-- Dumping routines for database 'fake_uber'
--
/*!50003 DROP PROCEDURE IF EXISTS `updateHomeWhileLive` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `updateHomeWhileLive`(
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
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Final view structure for view `driver_ratings`
--

/*!50001 DROP VIEW IF EXISTS `driver_ratings`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `driver_ratings` AS select `d`.`name` AS `name`,avg(`r`.`rating`) AS `AVG(r.rating)` from (`driver` `d` join `review` `r` on((`d`.`id` = `r`.`driver_id`))) group by `d`.`id` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `live_trip_details`
--

/*!50001 DROP VIEW IF EXISTS `live_trip_details`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `live_trip_details` AS select `trip`.`id` AS `id`,`trip`.`customer_id` AS `customer_id`,`trip`.`driver_id` AS `driver_id`,`trip`.`start_time` AS `start_time`,`trip`.`end_time` AS `end_time`,`trip`.`start_location_id` AS `start_location_id`,`trip`.`end_location_id` AS `end_location_id` from `trip` where isnull(`trip`.`end_location_id`) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-01-12 22:58:00
