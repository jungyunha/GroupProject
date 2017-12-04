-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: bookstore
-- ------------------------------------------------------
-- Server version	5.7.20-log

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
-- Table structure for table `authorbookdata`
--

DROP TABLE IF EXISTS `authorbookdata`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `authorbookdata` (
  `isbn` bigint(20) NOT NULL,
  `authorid` int(11) NOT NULL,
  `authorname` varchar(255) NOT NULL,
  PRIMARY KEY (`isbn`),
  KEY `f_authorid` (`authorid`),
  CONSTRAINT `f_authorid` FOREIGN KEY (`authorid`) REFERENCES `authordata` (`authorid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `authorbookdata`
--

LOCK TABLES `authorbookdata` WRITE;
/*!40000 ALTER TABLE `authorbookdata` DISABLE KEYS */;
/*!40000 ALTER TABLE `authorbookdata` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `authordata`
--

DROP TABLE IF EXISTS `authordata`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `authordata` (
  `authorid` int(11) NOT NULL,
  `authorname` varchar(255) NOT NULL,
  PRIMARY KEY (`authorid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `authordata`
--

LOCK TABLES `authordata` WRITE;
/*!40000 ALTER TABLE `authordata` DISABLE KEYS */;
/*!40000 ALTER TABLE `authordata` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `book`
--

DROP TABLE IF EXISTS `book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `book` (
  `isbn` bigint(20) NOT NULL,
  `title` varchar(45) NOT NULL,
  `price` float NOT NULL,
  `quantity` int(11) NOT NULL,
  `coverphoto` varchar(255) DEFAULT NULL,
  `category` varchar(255) NOT NULL,
  `description` tinytext,
  `threshholdlimit` int(11) NOT NULL,
  `rating` float DEFAULT NULL,
  `author` varchar(45) NOT NULL,
  PRIMARY KEY (`isbn`),
  UNIQUE KEY `isbn_UNIQUE` (`isbn`),
  UNIQUE KEY `coverphoto_UNIQUE` (`coverphoto`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book`
--

LOCK TABLES `book` WRITE;
/*!40000 ALTER TABLE `book` DISABLE KEYS */;
INSERT INTO `book` VALUES (123,'Algorithms',89.99,3,'https://upload.wikimedia.org/wikipedia/en/thumb/4/41/Clrs3.jpeg/220px-Clrs3.jpeg','Textbook','math book',5,3.9,'Thomas Cormen'),(234,'Calculus',64.99,4,'https://images-na.ssl-images-amazon.com/images/I/61jixF5KEkL.jpg','Textbook','another math book',5,3.2,'James Stewart'),(456,'Biology',69.99,2,'http://vidyaprakashan.com/wp-content/uploads/2013/02/CBSE-Text-Book-Biology-10.png','Textbook','science book',10,4.1,'Bill Nye'),(567,'Chemistry',79.99,7,'https://images-na.ssl-images-amazon.com/images/I/51GVJE1DjIL.jpg','Textbook','another science book',15,3.8,'Jeromy Chemical'),(90112,'temp',10,1,'temp','temp','Nothing',2,5,'temp');
/*!40000 ALTER TABLE `book` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `carddetails`
--

DROP TABLE IF EXISTS `carddetails`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `carddetails` (
  `cardnumber` varchar(255) NOT NULL,
  `cardtype` varchar(255) NOT NULL,
  `company` varchar(255) NOT NULL,
  `expirationdate` datetime NOT NULL,
  `billingaddrestreet` varchar(255) NOT NULL,
  `billingaddrzip` varchar(255) NOT NULL,
  `billingaddrestate` varchar(255) NOT NULL,
  `billingaddrecountry` varchar(255) NOT NULL,
  `userid` int(11) NOT NULL,
  PRIMARY KEY (`cardnumber`),
  UNIQUE KEY `cardnumber_UNIQUE` (`cardnumber`),
  UNIQUE KEY `company_UNIQUE` (`company`),
  UNIQUE KEY `villingaddrestreet_UNIQUE` (`billingaddrestreet`),
  UNIQUE KEY `userid_UNIQUE` (`userid`),
  CONSTRAINT `f_userid` FOREIGN KEY (`userid`) REFERENCES `users` (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `carddetails`
--

LOCK TABLES `carddetails` WRITE;
/*!40000 ALTER TABLE `carddetails` DISABLE KEYS */;
/*!40000 ALTER TABLE `carddetails` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `promocodes`
--

DROP TABLE IF EXISTS `promocodes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `promocodes` (
  `promocode` varchar(10) NOT NULL,
  `percentage` int(3) NOT NULL,
  PRIMARY KEY (`promocode`),
  UNIQUE KEY `promocode_UNIQUE` (`promocode`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `promocodes`
--

LOCK TABLES `promocodes` WRITE;
/*!40000 ALTER TABLE `promocodes` DISABLE KEYS */;
INSERT INTO `promocodes` VALUES ('abcd',10),('abcd1234',10);
/*!40000 ALTER TABLE `promocodes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `publisherbookdata`
--

DROP TABLE IF EXISTS `publisherbookdata`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `publisherbookdata` (
  `publisherid` int(11) NOT NULL,
  `piblishername` varchar(255) NOT NULL,
  `isbn` bigint(20) NOT NULL,
  PRIMARY KEY (`isbn`),
  UNIQUE KEY `isbn_UNIQUE` (`isbn`),
  KEY `f_pubid` (`publisherid`),
  CONSTRAINT `f_pubid` FOREIGN KEY (`publisherid`) REFERENCES `publisherdata` (`publisherid`),
  CONSTRAINT `f_pubisbn` FOREIGN KEY (`isbn`) REFERENCES `book` (`isbn`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `publisherbookdata`
--

LOCK TABLES `publisherbookdata` WRITE;
/*!40000 ALTER TABLE `publisherbookdata` DISABLE KEYS */;
/*!40000 ALTER TABLE `publisherbookdata` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `publisherdata`
--

DROP TABLE IF EXISTS `publisherdata`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `publisherdata` (
  `publisherid` int(11) NOT NULL,
  `pblishername` varchar(255) NOT NULL,
  PRIMARY KEY (`publisherid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `publisherdata`
--

LOCK TABLES `publisherdata` WRITE;
/*!40000 ALTER TABLE `publisherdata` DISABLE KEYS */;
/*!40000 ALTER TABLE `publisherdata` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shippingaddress`
--

DROP TABLE IF EXISTS `shippingaddress`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `shippingaddress` (
  `status` varchar(255) NOT NULL,
  `street` varchar(255) NOT NULL,
  `zip` int(11) NOT NULL,
  `state` varchar(255) NOT NULL,
  `country` varchar(255) NOT NULL,
  `userid` int(11) NOT NULL,
  KEY `f_shipuserid` (`userid`),
  CONSTRAINT `f_shipuserid` FOREIGN KEY (`userid`) REFERENCES `users` (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shippingaddress`
--

LOCK TABLES `shippingaddress` WRITE;
/*!40000 ALTER TABLE `shippingaddress` DISABLE KEYS */;
/*!40000 ALTER TABLE `shippingaddress` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shoppingcart`
--

DROP TABLE IF EXISTS `shoppingcart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `shoppingcart` (
  `userid` int(11) NOT NULL,
  `quantity` int(11) NOT NULL,
  `isbn` bigint(20) NOT NULL,
  KEY `f_shopuserid` (`userid`),
  KEY `f_shopisbn` (`isbn`),
  CONSTRAINT `f_shopisbn` FOREIGN KEY (`isbn`) REFERENCES `book` (`isbn`),
  CONSTRAINT `f_shopuserid` FOREIGN KEY (`userid`) REFERENCES `users` (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shoppingcart`
--

LOCK TABLES `shoppingcart` WRITE;
/*!40000 ALTER TABLE `shoppingcart` DISABLE KEYS */;
INSERT INTO `shoppingcart` VALUES (15,1,456),(15,2,123);
/*!40000 ALTER TABLE `shoppingcart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transactions`
--

DROP TABLE IF EXISTS `transactions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `transactions` (
  `tid` int(11) NOT NULL,
  `userid` int(11) NOT NULL,
  `quantity` int(11) NOT NULL,
  `date` datetime NOT NULL,
  `promocode` int(11) NOT NULL,
  `totalamountpaid` float NOT NULL,
  `isbn` bigint(20) NOT NULL,
  `orderstatus` varchar(45) NOT NULL,
  KEY `f_tuserid` (`userid`),
  KEY `f_tisbn` (`isbn`),
  CONSTRAINT `f_tisbn` FOREIGN KEY (`isbn`) REFERENCES `book` (`isbn`),
  CONSTRAINT `f_tuserid` FOREIGN KEY (`userid`) REFERENCES `users` (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transactions`
--

LOCK TABLES `transactions` WRITE;
/*!40000 ALTER TABLE `transactions` DISABLE KEYS */;
INSERT INTO `transactions` VALUES (1,15,1,'2017-12-03 07:30:00',0,74.68,123,'Not yet shipped'),(1,15,1,'2017-12-03 07:30:00',0,74.68,456,'Not yet shipped');
/*!40000 ALTER TABLE `transactions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `userid` int(11) NOT NULL AUTO_INCREMENT,
  `firstname` varchar(255) NOT NULL,
  `lastname` varchar(255) NOT NULL,
  `phonenumber` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL COMMENT 'Hashed and stored.',
  `usertype` int(11) NOT NULL COMMENT 'Type 1 is Admin.',
  `verifcode` varchar(255) NOT NULL,
  `shippingaddress` varchar(255) NOT NULL,
  `billingaddress` varchar(255) NOT NULL,
  `status` int(11) NOT NULL,
  `fogotpasswordcode` varchar(255) DEFAULT NULL,
  `subscribed` bit(1) DEFAULT NULL,
  UNIQUE KEY `email_UNIQUE` (`email`),
  UNIQUE KEY `phonenumber_UNIQUE` (`phonenumber`),
  UNIQUE KEY `userid_UNIQUE` (`userid`),
  UNIQUE KEY `fogotpasswordcode_UNIQUE` (`fogotpasswordcode`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
ALTER TABLE `users` AUTO_INCREMENT = 1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'nicky','desai','777','nope','admin',2,'verify','nope','nope',2,'forgot',NULL);
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

-- Dump completed on 2017-12-03 19:54:14
