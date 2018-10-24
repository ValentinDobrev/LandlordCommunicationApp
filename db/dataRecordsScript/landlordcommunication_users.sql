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
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) NOT NULL,
  `surname` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `password` varchar(200) NOT NULL,
  `budget` decimal(10,0) DEFAULT NULL,
  `is_tenant` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `IdUser_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (13,'Angel','Tonev','Tonev856@gmail.com','06d80eb0c50b49a509b49f2424e8c805',5000,1),(14,'Angelarii','Kordev','ankordev@gmail.com','a384b6463fc216a5f8ecb6670f86456a',10000,1),(15,'Georgi','Toshev','getoshev@gmail.com','7815696ecbf1c96e6894b779456d330e',30000,0),(16,'Boris','Vinelov','bovinelov@gmail.com','29fcb8d63a61a530dd916e461c9de8e9',7000,1),(17,'Toshko','Afrikanski','ToshekaWeeee@gmail.com','5fa72358f0b4fb4f2c5d7de8c9a41846',7000,1),(18,'Vladimir','Bonev','vlbonev@gmail.com','6fa530835802876b9e1f040f0a3c484d',147000,0),(19,'Gergana','Rivova','gerivova@gmail.com','2c6e59589f4e40ffa0c72d2a2ff6cec8',50000,0),(20,'Victoria','Grozeva','vigrozeva@abv.bg','acc4cfc0773695795955f187d86342c3',50000,1),(21,'Hitar','Petar','PeshoHitriq@gmail.com','7e437f713c9ea3aff16a2ed96a11d0a0',2000,1),(22,'Milena','Yordanova','miqordanova@outlook.com','ef43112119e97a43507a17623075b999',6000,1),(23,'Kristina','Lazarova','krlazarova@outlook.com','f3609badce37435ec0fed38895890c58',18000,0);
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

-- Dump completed on 2018-10-24 12:15:07
