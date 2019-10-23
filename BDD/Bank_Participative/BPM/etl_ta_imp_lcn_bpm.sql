CREATE DATABASE  IF NOT EXISTS `etl` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `etl`;
-- MySQL dump 10.13  Distrib 5.6.17, for Win64 (x86_64)
--
-- Host: localhost    Database: etl
-- ------------------------------------------------------
-- Server version	5.5.40

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
-- Table structure for table `ta_imp_lcn_bpm`
--

DROP TABLE IF EXISTS `ta_imp_lcn_bpm`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ta_imp_lcn_bpm` (
  `REF` int(10) NOT NULL AUTO_INCREMENT,
  `PK_OBJ_IDT` int(11) DEFAULT NULL,
  `RIO` varchar(32) DEFAULT NULL,
  `RIOINI` varchar(32) DEFAULT NULL,
  `REJET` varchar(3) DEFAULT NULL,
  `ADR_RMT` varchar(50) DEFAULT NULL,
  `ADR_TIRE` varchar(50) DEFAULT NULL,
  `CDEBPR` varchar(3) DEFAULT NULL,
  `CDEBPR_RMT` varchar(3) DEFAULT NULL,
  `AGE` varchar(5) DEFAULT NULL,
  `AGE_RMT` varchar(4) DEFAULT NULL,
  `AGE_RMT_LIB` varchar(35) DEFAULT NULL,
  `CPT` varchar(16) DEFAULT NULL,
  `CPTT` varchar(16) DEFAULT NULL,
  `DTEEC` varchar(8) DEFAULT NULL,
  `DTEMI` varchar(8) DEFAULT NULL,
  `DTREG` varchar(10) DEFAULT NULL,
  `LOC` varchar(3) DEFAULT NULL,
  `LOCT` varchar(3) DEFAULT NULL,
  `MEM2` varchar(5) DEFAULT NULL,
  `MNT` varchar(16) DEFAULT NULL,
  `MODE_ESC` varchar(1) DEFAULT NULL,
  `NSER` varchar(7) DEFAULT NULL,
  `RIB` varchar(2) DEFAULT NULL,
  `RIBT` varchar(2) DEFAULT NULL,
  `RSOC_RMT` varchar(35) DEFAULT NULL,
  `RSOC_TIRE` varchar(35) DEFAULT NULL,
  `RSOC_BEN` varchar(35) DEFAULT NULL,
  `ZBK` varchar(3) DEFAULT NULL,
  `ZBK_lib` varchar(50) DEFAULT NULL,
  `NOMTIRE` varchar(50) DEFAULT NULL,
  `CIN` varchar(10) DEFAULT NULL,
  `RC` varchar(20) DEFAULT NULL,
  `lieuEmission` varchar(20) DEFAULT NULL,
  `MOTIF1` varchar(3) DEFAULT NULL,
  `MOTIF2` varchar(3) DEFAULT NULL,
  `MOTIF3` varchar(3) DEFAULT NULL,
  `adresseTire` varchar(100) DEFAULT NULL,
  `REJET_LIB` varchar(50) DEFAULT NULL,
  `DTREJET` varchar(8) DEFAULT NULL,
  `DTEINS` varchar(8) DEFAULT NULL,
  `DTEPRE` date DEFAULT NULL,
  `DTEemission` varchar(10) DEFAULT NULL,
  `tiers` varchar(9) DEFAULT NULL,
  `DTE_SORT` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`REF`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ta_imp_lcn_bpm`
--

LOCK TABLES `ta_imp_lcn_bpm` WRITE;
/*!40000 ALTER TABLE `ta_imp_lcn_bpm` DISABLE KEYS */;
INSERT INTO `ta_imp_lcn_bpm` VALUES (11,NULL,NULL,NULL,'014',NULL,NULL,'101',NULL,NULL,NULL,NULL,'000393778','0000568100002841',NULL,NULL,NULL,'780','041',NULL,'0000000001000000',NULL,'0000051',NULL,'61',NULL,NULL,NULL,'101',NULL,'DU MAROC                                          ','          ','                    ','CASABLANCA','','','','RUE DE TANGER N 25                                                                                  ',NULL,'20150331',NULL,NULL,'20161109','000068310',NULL),(12,NULL,NULL,NULL,'020',NULL,NULL,'101',NULL,NULL,NULL,NULL,'000393778','0000561100002388',NULL,NULL,NULL,'780','041',NULL,'0000000000300000',NULL,'0000077',NULL,'97',NULL,NULL,NULL,'101',NULL,'DU MAROC                                          ','          ','                    ','CASABLANCA','','','','RUE DE TANGER N 25                                                                                  ',NULL,'20150331',NULL,NULL,'20161109','000068310',NULL),(13,NULL,NULL,NULL,'010',NULL,NULL,'101',NULL,NULL,NULL,NULL,'000393778','0000561100002388',NULL,NULL,NULL,'780','041',NULL,'0000000002000000',NULL,'0000076',NULL,'97',NULL,NULL,NULL,'101',NULL,'LARBI BEN LARBI                                   ','BN1025487 ','                    ','CASABLANCA','','','','RUE DU MOUCHARD N 44                                                                                ',NULL,'20150331',NULL,NULL,'20161109','000068310',NULL);
/*!40000 ALTER TABLE `ta_imp_lcn_bpm` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-08-01 15:49:23
