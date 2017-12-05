CREATE DATABASE  IF NOT EXISTS `bookstore` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `bookstore`;
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
INSERT INTO `book` VALUES (123,'Algorithms',89.99,50,'https://upload.wikimedia.org/wikipedia/en/thumb/4/41/Clrs3.jpeg/220px-Clrs3.jpeg','Textbook','math book',5,3.9,'Thomas Cormen'),(231,'Closing the Books: An Accountants Guide',95.99,50,'https://images-na.ssl-images-amazon.com/images/I/51ptRRMbOXL._SY344_BO1,204,203,200_.jpg','Textbook','Account book',10,1.3,'Michael Jackson'),(234,'Calculus',64.99,60,'https://images-na.ssl-images-amazon.com/images/I/61jixF5KEkL.jpg','Textbook','another math book',5,3.2,'James Stewart'),(239,'Biology',132,61,'https://cdn3.volusion.com/wmry5.zc4x3/v/vspfiles/photos/9781921403743-2.jpg?1510687600','Textbook','Science book',5,3,'Stemster'),(254,'Discrete mathematics and its applications',110.99,54,'https://images-na.ssl-images-amazon.com/images/I/51nSnO5i7eL._SX403_BO1,204,203,200_.jpg','Textbook','Discrete Math',39,2.3,'Kenneth'),(312,'Calculus 2',80.6,54,'https://www.math.ucdavis.edu/~hass/Books/T12ET.jpg','Textbook','Calculus 2',42,4.5,'Walter'),(325,'Go Web Programming',43.65,65,'http://www.allitebooks.com/wp-content/uploads/2016/10/Go-Web-Programming.jpg','Textbook','Web Programming',43,3.1,'Sheong'),(342,'The C++ Programming Language',34.54,32,'https://images-na.ssl-images-amazon.com/images/I/81b-3FJTE9L.jpg','Textbook','C++ book',51,4.5,'Brian'),(345,'Fundamentals of Database Systems',34.54,43,'https://images-na.ssl-images-amazon.com/images/I/41quNI7EQ-L._SX258_BO1,204,203,200_.jpg','Textbook','Database',40,3.2,'Elmasri'),(365,'The Videomaker Guide to Video Production',22.49,19,'https://images-na.ssl-images-amazon.com/images/I/51GQqXxZPqL._SX355_BO1,204,203,200_.jpg','Textbook','Videomaker',34,2.4,'George'),(423,'The Geology Book',54.45,54,'https://images-na.ssl-images-amazon.com/images/I/516kVSvCosL._SX258_BO1,204,203,200_.jpg','Textbook','Geology',54,4.7,'John'),(456,'Biology',69.99,30,'http://vidyaprakashan.com/wp-content/uploads/2013/02/CBSE-Text-Book-Biology-10.png','Textbook','science book',10,4.1,'Bill Nye'),(535,'Learning MySQL',20.99,50,'https://covers.oreillystatic.com/images/9780596008642/lrg.jpg','Textbook','MYSQL book',10,4.5,'Thomas'),(567,'Chemistry',79.99,100,'https://images-na.ssl-images-amazon.com/images/I/51GVJE1DjIL.jpg','Textbook','another science book',15,3.8,'Jeromy Chemical'),(646,'Learning Java',60.54,65,'https://images-na.ssl-images-amazon.com/images/I/51mfxfA8HdL._SX379_BO1,204,203,200_.jpg','Textbook','Learn Java',23,3.5,'Albert');
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
INSERT INTO `shoppingcart` VALUES (15,1,456),(15,2,123),(7,1,123),(7,1,456),(14,1,123),(14,1,234);
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
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (7,'YunHaddd1','qwdqwd','13154124','2daw2@hotmail.com','gokorea57',1,'F9X05R','f2112f1','123123',2,NULL,''),(14,'YunHa','Jung','4045797503','jungyunha1994@live.com','gokorea57',1,'C5IV55','4120 BreckenRidgeCT Alpharetta','4120 BreckenRidgeCT Alpharetta',2,NULL,''),(1,'nicky','desai','777','nope','admin',2,'verify','nope','nope',2,'forgot',NULL);
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

-- Dump completed on 2017-12-05  2:53:45
