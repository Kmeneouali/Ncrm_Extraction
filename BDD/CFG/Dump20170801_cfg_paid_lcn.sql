CREATE DATABASE  IF NOT EXISTS `r_ncrm_extraction` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `r_ncrm_extraction`;
-- MySQL dump 10.13  Distrib 5.6.17, for Win64 (x86_64)
--
-- Host: 172.17.0.4    Database: r_ncrm_extraction
-- ------------------------------------------------------
-- Server version	5.7.17-log

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
-- Table structure for table `cfg_paid_lcn`
--

DROP TABLE IF EXISTS `cfg_paid_lcn`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfg_paid_lcn` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nser` char(7) NOT NULL,
  `dteTrt` char(10) NOT NULL,
  `zib` char(6) NOT NULL,
  `zbk` char(3) DEFAULT NULL,
  `loc` varchar(3) DEFAULT NULL,
  `cpt` char(16) NOT NULL,
  `rib` char(2) NOT NULL,
  `mnt` char(16) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16746 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cfg_paid_lcn`
--

LOCK TABLES `cfg_paid_lcn` WRITE;
/*!40000 ALTER TABLE `cfg_paid_lcn` DISABLE KEYS */;
INSERT INTO `cfg_paid_lcn` VALUES (16738,'7777746','18-07-2017','007780','007','780','0001261000003317','06','61040.00'),(16739,'4524507','18-07-2017','190780','190','780','2121150567600013','22','1980000.00'),(16740,'7753094','17-07-2017','007780','007','780','0003392000001401','46','96793.92'),(16741,'7760680','17-07-2017','007780','007','780','0001147000000851','20','155600.00'),(16742,'7777745','14-07-2017','007780','007','780','0001261000003317','06','61000.00'),(16743,'2547774','14-07-2017','022500','022','500','0003250003801316','65','10000.00'),(16744,'8349225','14-07-2017','007270','007','270','0000893000000270','20','3000.00'),(16745,'9754912','12-07-2017','013810','013','810','0107000015200176','94','24753.66');
/*!40000 ALTER TABLE `cfg_paid_lcn` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cfg_poche_affectation`
--

DROP TABLE IF EXISTS `cfg_poche_affectation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfg_poche_affectation` (
  `zbk` char(3) NOT NULL,
  `poche` int(11) NOT NULL,
  PRIMARY KEY (`zbk`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cfg_poche_affectation`
--

LOCK TABLES `cfg_poche_affectation` WRITE;
/*!40000 ALTER TABLE `cfg_poche_affectation` DISABLE KEYS */;
INSERT INTO `cfg_poche_affectation` VALUES ('001',15),('002',16),('003',17),('005',18),('007',5),('011',6),('013',7),('021',8),('022',9),('028',19),('050',10),('060',20),('070',21),('101',11),('117',11),('127',11),('133',11),('143',11),('145',11),('148',11),('150',11),('157',11),('164',11),('169',11),('178',11),('181',11),('190',12),('225',13),('230',14),('310',22),('350',23);
/*!40000 ALTER TABLE `cfg_poche_affectation` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-08-01 15:33:38
