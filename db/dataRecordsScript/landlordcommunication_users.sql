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
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `IdUser` int(11) NOT NULL AUTO_INCREMENT,
  `FirstName` varchar(45) NOT NULL,
  `Surname` varchar(45) NOT NULL,
  `Email` varchar(45) NOT NULL,
  `Budget` decimal(10,0) DEFAULT NULL,
  `IsTenant` tinyint(1) NOT NULL,
  PRIMARY KEY (`IdUser`),
  UNIQUE KEY `IdUser_UNIQUE` (`IdUser`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'Angel','Tonev','Tonev856@gmail.com',5000,1),(2,'Angelarii','Kordev','ankordev@gmail.com',10000,1),(3,'Georgi','Toshev','getoshev@gmail.com',30000,0),(4,'Boris','Vinelov','bovinelov@gmail.com',7000,1),(5,'Toshko','Afrikanski','ToshekaWeeee@gmail.com',7000,1),(6,'Vladimir','Bonev','vlbonev@gmail.com',147000,0),(7,'Gergana','Rivova','gerivova@gmail.com',50000,0),(8,'Victoria','Grozeva','vigrozeva@abv.bg',50000,1),(9,'Hitar','Petar','PeshoHitriq@gmail.com',2000,1),(10,'Milena','Yordanova','miqordanova@outlook.com',6000,1),(11,'Kristina','Lazarova','krlazarova@outlook.com',18000,0);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
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
