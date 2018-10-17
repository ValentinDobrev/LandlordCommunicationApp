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
-- Table structure for table `usertoresidence`
--

DROP TABLE IF EXISTS `usertoresidence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usertoresidence` (
  `IdTenant` int(11) NOT NULL,
  `IdLandlord` int(11) NOT NULL,
  `IdResidence` int(11) NOT NULL,
  PRIMARY KEY (`IdTenant`,`IdLandlord`,`IdResidence`),
  KEY `IdResidence_idx` (`IdResidence`),
  KEY `IdLandlord_idx` (`IdLandlord`),
  KEY `IdTenant_idx` (`IdTenant`),
  CONSTRAINT `IdLandlord` FOREIGN KEY (`IdLandlord`) REFERENCES `users` (`IdUser`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `IdResidence` FOREIGN KEY (`IdResidence`) REFERENCES `residences` (`IdResidence`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `IdTenant` FOREIGN KEY (`IdTenant`) REFERENCES `users` (`IdUser`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usertoresidence`
--

LOCK TABLES `usertoresidence` WRITE;
/*!40000 ALTER TABLE `usertoresidence` DISABLE KEYS */;
INSERT INTO `usertoresidence` VALUES (1,11,6),(2,7,5),(4,7,4),(5,7,4),(8,3,3),(9,6,2),(10,6,1);
/*!40000 ALTER TABLE `usertoresidence` ENABLE KEYS */;
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
