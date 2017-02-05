CREATE DATABASE  IF NOT EXISTS `msrs` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `msrs`;
-- MySQL dump 10.13  Distrib 5.6.35, for Linux (x86_64)
--
-- Host: 127.0.0.1    Database: msrs
-- ------------------------------------------------------
-- Server version	5.6.35

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
-- Table structure for table `benefit_type`
--

DROP TABLE IF EXISTS `benefit_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `benefit_type` (
  `benefittypeid` int(11) NOT NULL AUTO_INCREMENT,
  `benefittype` varchar(45) NOT NULL,
  `createdtime` datetime NOT NULL,
  `modifiedtime` datetime NOT NULL,
  PRIMARY KEY (`benefittypeid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `benefit_type`
--

LOCK TABLES `benefit_type` WRITE;
/*!40000 ALTER TABLE `benefit_type` DISABLE KEYS */;
INSERT INTO `benefit_type` VALUES (1,'Fever','2017-02-05 19:29:54','2017-02-05 19:29:54');
/*!40000 ALTER TABLE `benefit_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `emp`
--

DROP TABLE IF EXISTS `emp`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `emp` (
  `empid` int(11) NOT NULL AUTO_INCREMENT,
  `firstname` varchar(200) NOT NULL,
  `lastname` varchar(200) NOT NULL,
  `dob` date NOT NULL,
  `phone` varchar(45) NOT NULL,
  `email` varchar(500) NOT NULL,
  `adress1` varchar(200) DEFAULT NULL,
  `adress2` varchar(200) DEFAULT NULL,
  `district` varchar(200) NOT NULL,
  `state` varchar(200) NOT NULL,
  `pincode` varchar(45) NOT NULL,
  `aatharnumber` bigint(20) NOT NULL,
  `pancard` varchar(12) DEFAULT NULL,
  `doj` date NOT NULL COMMENT 'date of joining',
  `dor` date DEFAULT NULL COMMENT 'date of releaving',
  `createdtime` timestamp NOT NULL,
  `modifiedtime` timestamp NOT NULL,
  `gender` tinyint(1) NOT NULL COMMENT '0 for male, 1 for female and 2 for other',
  PRIMARY KEY (`empid`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `emp`
--

LOCK TABLES `emp` WRITE;
/*!40000 ALTER TABLE `emp` DISABLE KEYS */;
INSERT INTO `emp` VALUES (1,'Kiran','Kumar','1999-01-01','911234567890','kiran@kumar.com','a','b','c','d','e',12345678912,'askdfkds','1999-01-01','2099-01-01','2017-01-26 13:58:58','2017-01-26 13:58:58',0),(2,'Murali','Raju','1999-01-01','911234567891','murali@raju.com','c','e','f','g','h',12345678911,'askdfkfs','1919-01-01','2019-01-01','2017-01-28 10:03:40','2017-01-28 10:03:40',0),(3,'Vagdhan','t','1899-01-01','921234567891','vagdhan@t.com','c','e','f','g','h',12345678941,'askdfkfs','1919-01-01','2019-01-01','2017-01-28 10:08:17','2017-01-28 10:08:17',0),(4,'satish','s','1799-01-01','931234567891','satish@s.com','c','e','f','g','h',12345678943,'askdfk6s','1919-01-01','2019-01-01','2017-01-28 10:08:53','2017-01-28 10:08:53',0),(5,'satish1','s1','1799-01-01','931214567891','satish1@s1.com','c','e','f','g','h',12345678933,'askddk6s','1919-01-01','2019-01-01','2017-01-28 10:09:16','2017-01-28 10:09:16',0),(6,'datish1','d1','1799-01-01','941214567891','datish1@d1.com','c','e','f','g','h',13345678933,'askddk6s','1919-01-01','2019-01-01','2017-01-28 10:10:47','2017-01-28 10:10:47',0);
/*!40000 ALTER TABLE `emp` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `incident`
--

DROP TABLE IF EXISTS `incident`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `incident` (
  `incidentid` int(11) NOT NULL AUTO_INCREMENT,
  `details` varchar(2000) DEFAULT NULL,
  `benefittypeid` int(11) NOT NULL,
  `administrativeoffice` int(11) NOT NULL,
  `customeroffice` int(11) NOT NULL,
  `ishomevisitrequired` tinyint(1) NOT NULL,
  `firstdayofincident` date NOT NULL,
  `createdtime` datetime NOT NULL,
  `modifiedtime` timestamp NOT NULL,
  `empid` int(11) NOT NULL,
  PRIMARY KEY (`incidentid`),
  KEY `fk_incident_1_idx` (`benefittypeid`),
  KEY `fk_incident_2_idx` (`administrativeoffice`,`customeroffice`),
  KEY `fk_incident_3_idx` (`customeroffice`),
  CONSTRAINT `fk_incident_1` FOREIGN KEY (`benefittypeid`) REFERENCES `benefit_type` (`benefittypeid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_incident_2` FOREIGN KEY (`administrativeoffice`) REFERENCES `office_location` (`officelocationid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_incident_3` FOREIGN KEY (`customeroffice`) REFERENCES `office_location` (`officelocationid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `incident`
--

LOCK TABLES `incident` WRITE;
/*!40000 ALTER TABLE `incident` DISABLE KEYS */;
/*!40000 ALTER TABLE `incident` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nominee`
--

DROP TABLE IF EXISTS `nominee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `nominee` (
  `nomineeid` int(11) NOT NULL AUTO_INCREMENT,
  `empid` int(11) NOT NULL,
  `name` varchar(1000) NOT NULL,
  `relationship` varchar(50) NOT NULL,
  `age` tinyint(2) NOT NULL,
  `address1` varchar(200) DEFAULT NULL,
  `address2` varchar(200) DEFAULT NULL,
  `district` varchar(200) DEFAULT NULL,
  `state` varchar(45) DEFAULT NULL,
  `pincode` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`nomineeid`),
  KEY `fk_nominee_emp_idx` (`empid`),
  CONSTRAINT `fk_nominee_emp` FOREIGN KEY (`empid`) REFERENCES `emp` (`empid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nominee`
--

LOCK TABLES `nominee` WRITE;
/*!40000 ALTER TABLE `nominee` DISABLE KEYS */;
INSERT INTO `nominee` VALUES (1,1,'sanju','0',20,'a','b','c','d','e'),(2,2,'Mur','Friend',32,'street1','add2','hyd','ts','500001');
/*!40000 ALTER TABLE `nominee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `office_location`
--

DROP TABLE IF EXISTS `office_location`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `office_location` (
  `officelocationid` int(11) NOT NULL AUTO_INCREMENT,
  `officelocation` varchar(500) NOT NULL,
  `createdtime` datetime NOT NULL,
  `modifiedtime` timestamp NOT NULL,
  PRIMARY KEY (`officelocationid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `office_location`
--

LOCK TABLES `office_location` WRITE;
/*!40000 ALTER TABLE `office_location` DISABLE KEYS */;
INSERT INTO `office_location` VALUES (1,'mehdipatnam','2017-02-05 19:28:53','2017-02-05 13:58:53'),(2,'hitechcity','2017-02-05 19:29:04','2017-02-05 13:59:04');
/*!40000 ALTER TABLE `office_location` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-02-05 22:23:45
