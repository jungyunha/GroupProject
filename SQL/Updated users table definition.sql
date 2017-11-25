DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `userid` int(11) NOT NULL,
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
  `fogotpasswordcode` varchar(255),
  UNIQUE KEY `password_UNIQUE` (`password`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  UNIQUE KEY `phonenumber_UNIQUE` (`phonenumber`),
  UNIQUE KEY `userid_UNIQUE` (`userid`),
  UNIQUE KEY `fogotpasswordcode_UNIQUE` (`fogotpasswordcode`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;
