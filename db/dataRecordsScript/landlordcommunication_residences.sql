-- MySQL dump 10.16  Distrib 10.3.9-MariaDB, for Win64 (AMD64)
--
-- Host: 127.0.0.1    Database: landlordcommunication
-- ------------------------------------------------------
-- Server version	10.3.9-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `residences`
--

DROP TABLE IF EXISTS `residences`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `residences` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `address` varchar(100) NOT NULL,
  `rent` decimal(10,0) NOT NULL,
  `due_date` date NOT NULL,
  `notification_date` date NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `IdResidence_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `residences`
--

LOCK TABLES `residences` WRITE;
/*!40000 ALTER TABLE `residences` DISABLE KEYS */;
INSERT INTO `residences` VALUES (20,'62, Doctor GM Dimitrov blvd., 1172 bc Dianabad, Sofia',500,'2018-11-15','2018-11-10'),(21,'Block 34, 1700 Studentski Complex, Sofia',650,'2018-11-16','2018-11-11'),(22,'2, Dimcho Debelyanov Str., 1113 bc East, Sofia',400,'2018-11-13','2018-11-08'),(23,'18-24 Bacho Kiro Str., 1000 Center, Sofia',1200,'2018-11-20','2018-11-15'),(24,'15-13 \"Krichim\" str., 1407 bc Lozenets, Sofia',800,'2018-12-10','2018-11-05'),(25,'\"Ivan Sergiev\" St. 189-185, 1574 bc Hristo Smirnenski, Sofia',750,'2018-12-06','2018-12-01'),(26,'506th Street 9, 1517 Hristo Botev, Sofia',550,'2018-11-16','2018-11-11'),(27,'40, Krum Popov str., 1421 bc Lozenets, Sofia',600,'2018-12-06','2018-12-01'),(28,'bc. Buckston 23, 1618 Buxton, Sofia',700,'2018-12-16','2018-12-11');
/*!40000 ALTER TABLE `residences` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-10-24 12:15:06
