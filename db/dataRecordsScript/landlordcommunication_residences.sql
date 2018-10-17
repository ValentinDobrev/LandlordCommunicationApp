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
  `IdResidence` int(11) NOT NULL AUTO_INCREMENT,
  `Address` varchar(100) NOT NULL,
  `LandlordId` int(11) NOT NULL,
  `Rent` decimal(10,0) NOT NULL,
  PRIMARY KEY (`IdResidence`),
  UNIQUE KEY `IdResidence_UNIQUE` (`IdResidence`),
  KEY `LandlordId_idx` (`LandlordId`),
  CONSTRAINT `LandlordId` FOREIGN KEY (`LandlordId`) REFERENCES `users` (`IdUser`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `residences`
--

LOCK TABLES `residences` WRITE;
/*!40000 ALTER TABLE `residences` DISABLE KEYS */;
INSERT INTO `residences` VALUES (1,'62, Doctor GM Dimitrov blvd., 1172 bc Dianabad, Sofia',6,500),(2,'Block 34, 1700 Studentski Complex, Sofia',6,650),(3,'2, Dimcho Debelyanov Str., 1113 bc East, Sofia',3,400),(4,'18-24 Bacho Kiro Str., 1000 Center, Sofia',7,1200),(5,'15-13 \"Krichim\" str., 1407 bc Lozenets, Sofia',7,800),(6,'\"Ivan Sergiev\" St. 189-185, 1574 bc Hristo Smirnenski, Sofia',11,750),(7,'506th Street 9, 1517 Hristo Botev, Sofia',6,550),(8,'40, Krum Popov str., 1421 bc Lozenets, Sofia',6,600),(9,'bc. Buckston 23, 1618 Buxton, Sofia',3,700);
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

-- Dump completed on 2018-10-17 12:29:05
