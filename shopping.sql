-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: localhost    Database: shoppingdb
-- ------------------------------------------------------
-- Server version	8.0.31

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category` (
  `c_id` int unsigned NOT NULL AUTO_INCREMENT,
  `c_name` varchar(45) NOT NULL,
  `c_description` varchar(45) NOT NULL,
  PRIMARY KEY (`c_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,'books','books beloging to any language and any topic.'),(2,'electronics','Electronic appliences.'),(3,'cosmetics','Products belong to cosmetics.');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `p_id` int unsigned NOT NULL AUTO_INCREMENT,
  `p_name` varchar(45) NOT NULL,
  `p_description` varchar(45) NOT NULL,
  `p_price` varchar(45) NOT NULL,
  `cat_id` int unsigned NOT NULL,
  PRIMARY KEY (`p_id`),
  KEY `FK_product_1` (`cat_id`),
  CONSTRAINT `FK_product_1` FOREIGN KEY (`cat_id`) REFERENCES `category` (`c_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,'Let us C','Best reference book for c language','200',1),(2,'Thinking in java','Rrfernce book for Java programing language.','500',1),(3,'Samsung mobile','Mobile phone.','5000',2),(4,'LG washing machine','Home applience of LG company','10000',2),(5,'Santoor face wash','Fame wash for all.','50',3),(6,'Lux soap','best quality soap.','30',3);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shopping`
--

DROP TABLE IF EXISTS `shopping`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shopping` (
  `s_id` int unsigned NOT NULL AUTO_INCREMENT,
  `user_id` varchar(45) NOT NULL,
  `shoppingDate` datetime NOT NULL,
  `totalprice` float NOT NULL,
  PRIMARY KEY (`s_id`),
  KEY `FK_shopping_1` (`user_id`),
  CONSTRAINT `FK_shopping_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`u_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shopping`
--

LOCK TABLES `shopping` WRITE;
/*!40000 ALTER TABLE `shopping` DISABLE KEYS */;
INSERT INTO `shopping` VALUES (1,'Neha','2019-10-04 00:00:00',530),(2,'Neha','0000-00-00 00:00:00',560),(3,'Neha','2019-10-07 00:00:00',10560),(4,'akak','2023-01-02 00:00:00',50),(5,'vaibhavi','2023-01-02 00:00:00',500),(6,'vaibhavi','2023-01-03 00:00:00',50),(7,'vaibhavi','2023-01-03 00:00:00',5250),(8,'vaibhavi','2023-01-03 00:00:00',5000),(9,'vaibhavi','2023-01-03 00:00:00',5200),(10,'akak','2023-01-03 00:00:00',10000),(11,'akak','2023-01-03 00:00:00',20030),(12,'vaibhavi','2023-01-03 00:00:00',500),(13,'akak','2023-01-03 00:00:00',10500),(14,'akak','2023-01-03 00:00:00',20500),(15,'akak','2023-01-03 00:00:00',50);
/*!40000 ALTER TABLE `shopping` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `u_id` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `fname` varchar(45) NOT NULL,
  `mname` varchar(45) NOT NULL,
  `lname` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `contact` varchar(45) NOT NULL,
  PRIMARY KEY (`u_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES ('akak','1234','aaa','vvvv','kkk','ak@gmail.com','1234569870'),('Ashwa','gggf@123','hbsyg','gaswgas','gagga','gjfdtf@gmail.com','9640600131'),('Ashwfa','dg@123','gatgta','gast','gats','gtaf@gmail.com','9540600121'),('Ashwini','ashwini@123','Ashwini','Rajesh','More','ashwini@gmail.com','6510954826'),('Ashwinm','ashwini@124','Ashwie','afajkl','Moghj','ashwii@gmail.com','9730600133'),('Neha','neha@123','Neha','Arun','Kulkarni','neha@yahoo.com','7654321098'),('Ramesh','ramesh@123','Ramesh','Gopal','Sharma','ramesh@gmail.com','9876543210'),('Sam','1234','Sammm','xxxx','chavan','sam@gmail.com','1234567890'),('sayalic','sss','Sayali','G','Chougule','sayali@object.com','876876867'),('skg','1234','sss','kkk','ggg','Skg@gmail.com','9876543210'),('Vaibhav','vaibhav@123','Vaibhav','Lokesh','Arora','vaibhav@yahoo.com','9812376401'),('vaibhavi','vvv','Vaibhav','P','Inamdar','vaibhav@know-it.co.in','9823434616');
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

-- Dump completed on 2023-07-05 12:16:03
