CREATE DATABASE  IF NOT EXISTS `r_ncrm_extraction` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `r_ncrm_extraction`;
-- MySQL dump 10.13  Distrib 5.6.17, for Win64 (x86_64)
--
-- Host: localhost    Database: r_ncrm_extraction
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
-- Table structure for table `tmp_tbl_eta_chq_baa`
--

DROP TABLE IF EXISTS `tmp_tbl_eta_chq_baa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tmp_tbl_eta_chq_baa` (
  `bmch_pk_obj_idt` int(11) NOT NULL DEFAULT '0',
  `DATE` date DEFAULT NULL,
  `age_r_lib` char(32) DEFAULT NULL COMMENT 'Libelle de l agence',
  `bmtn_OPE_ETA` varchar(1) CHARACTER SET utf8 NOT NULL,
  `bmtn_ANO` text CHARACTER SET utf8,
  `bmtn_CDEBPR` char(0) CHARACTER SET utf8 NOT NULL DEFAULT '',
  `bmtn_COUNT_CHQ` varchar(5) CHARACTER SET utf8 DEFAULT NULL,
  `bmtn_DIFF` varchar(15) CHARACTER SET utf8 DEFAULT NULL,
  `bmtn_DIFF_NB` varchar(5) CHARACTER SET utf8 DEFAULT NULL,
  `bmtn_LECTEUR` varchar(5) CHARACTER SET utf8 DEFAULT NULL,
  `bmtn_MEM2` varchar(5) CHARACTER SET utf8 DEFAULT NULL,
  `bmtn_SUM_CHQ` varchar(15) CHARACTER SET utf8 DEFAULT NULL,
  `bmta_OPE_ETA` varchar(1) CHARACTER SET utf8 NOT NULL,
  `bmta_Ano` text CHARACTER SET utf8,
  `bmta_CDEBPR` varchar(3) CHARACTER SET utf8 DEFAULT NULL,
  `bmta_MEM2` char(0) CHARACTER SET utf8 NOT NULL DEFAULT '',
  `bmta_SQCA` varchar(10) CHARACTER SET utf8 DEFAULT NULL,
  `bmtr_NSER` varchar(7) CHARACTER SET utf8 DEFAULT NULL,
  `bmtr_MEM2` varchar(5) CHARACTER SET utf8 DEFAULT NULL,
  `bmtr_MNT` varchar(12) CHARACTER SET utf8 DEFAULT NULL,
  `bmtr_CDECLT` varchar(16) CHARACTER SET utf8 DEFAULT NULL,
  `bmtr_NBCH` double DEFAULT NULL,
  `bmtr_MODE_ESC` varchar(1) CHARACTER SET utf8 DEFAULT NULL,
  `bmtr_OPE_ETA` varchar(1) CHARACTER SET utf8 NOT NULL DEFAULT '',
  `bmtr_SQCA` double DEFAULT NULL,
  `bmtr_AGE_RMT` varchar(5) CHARACTER SET utf8 DEFAULT NULL,
  `bmtr_TIERS` char(0) CHARACTER SET utf8 NOT NULL DEFAULT '',
  `bmtr_REFCLI` varchar(12) CHARACTER SET utf8 DEFAULT NULL,
  `bmtr_ANO` text CHARACTER SET utf8,
  `bmch_fk_ope_mne` varchar(12) CHARACTER SET utf8 DEFAULT NULL,
  `bmch_instance` int(11) NOT NULL,
  `bmch_ope_eta` varchar(1) CHARACTER SET utf8 NOT NULL,
  `bmch_ADR_RMT` char(0) CHARACTER SET utf8 NOT NULL DEFAULT '',
  `bmch_ADR_TIR` char(0) CHARACTER SET utf8 NOT NULL DEFAULT '',
  `bmch_AGE` varchar(3) CHARACTER SET utf8 DEFAULT NULL,
  `bmch_CDEBPR` char(0) CHARACTER SET utf8 NOT NULL DEFAULT '',
  `bmch_CDE_REJ` char(0) CHARACTER SET utf8 NOT NULL DEFAULT '',
  `bmch_CPT` varchar(16) CHARACTER SET utf8 DEFAULT NULL,
  `bmch_CPT2` varchar(16) CHARACTER SET utf8 DEFAULT NULL,
  `bmch_DBLT` varchar(1) CHARACTER SET utf8 DEFAULT NULL,
  `bmch_DTEEMI` varchar(10) CHARACTER SET utf8 DEFAULT NULL,
  `bmch_FLAG_IMP` varchar(1) CHARACTER SET utf8 DEFAULT NULL,
  `bmch_FLAG_REJET` varchar(1) CHARACTER SET utf8 DEFAULT NULL,
  `bmch_FLAG_AVAL` char(0) CHARACTER SET utf8 NOT NULL DEFAULT '',
  `bmch_LOC` varchar(3) CHARACTER SET utf8 DEFAULT NULL,
  `bmch_MEM2` char(0) CHARACTER SET utf8 NOT NULL DEFAULT '',
  `bmch_MNT` double DEFAULT NULL,
  `bmch_NSER` varchar(7) CHARACTER SET utf8 DEFAULT NULL,
  `bmch_RIB` varchar(2) CHARACTER SET utf8 DEFAULT NULL,
  `bmch_RIO` varchar(32) CHARACTER SET utf8 DEFAULT NULL,
  `bmch_RSOC_TIR` char(0) CHARACTER SET utf8 NOT NULL DEFAULT '',
  `bmch_SQCA` double DEFAULT NULL,
  `bmch_ZBK` varchar(3) CHARACTER SET utf8 DEFAULT NULL,
  `bq_lib` varchar(45) DEFAULT NULL,
  `bmch_ZIB` varchar(6) CHARACTER SET utf8 DEFAULT NULL,
  `bmch_ANO` text CHARACTER SET utf8,
  `bmch_VICE` text CHARACTER SET utf8,
  `bmch_CONF` varchar(1) CHARACTER SET utf8 DEFAULT NULL,
  `bmch_DTEINV` varchar(10) CHARACTER SET utf8 DEFAULT NULL,
  `bmch_AGE_RMT` varchar(3) CHARACTER SET utf8 DEFAULT NULL,
  `bmtn_ANO_lib` varchar(45) DEFAULT NULL,
  `bmta_ANO_lib` varchar(245) DEFAULT NULL,
  `bmtr_ANO_lib` varchar(245) DEFAULT NULL,
  `bmch_ANO_lib` varchar(245) DEFAULT NULL,
  PRIMARY KEY (`bmch_pk_obj_idt`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tmp_tbl_eta_chq_baa`
--

LOCK TABLES `tmp_tbl_eta_chq_baa` WRITE;
/*!40000 ALTER TABLE `tmp_tbl_eta_chq_baa` DISABLE KEYS */;
INSERT INTO `tmp_tbl_eta_chq_baa` VALUES (276,'2017-07-05','AGENCE CASABLANCA','I','','','','0.000','0','45000','45000','','I','','','','1','1234566','45000','500.00','0000021050100084',2,'1','I',2,'01000','','','','END_TRT',272,'I','','','','','','1000021040100063','1000021040100063','0','2017-07-05','0','0','','780','',300,'0022220','06','','',3,'045','BANK AL AMAL','045780','','','1','2017-07-05','','','','',''),(277,'2017-07-05','AGENCE CASABLANCA','I','','','','0.000','0','45000','45000','','I','','','','1','1234566','45000','500.00','0000021050100084',2,'1','I',2,'01000','','','','END_TRT',272,'I','','','','','','0112133100007495','0112133100007495','0','2017-07-05','0','0','','041','',200,'0000012','89','','',4,'101','BP Centre Sud','101041','','','1','2017-07-05','','','','',''),(280,'2017-07-05','AGENCE CASABLANCA','I','','','','0.000','0','45000','45000','','I','','','','1','7894561','45000','1000.00','0000021050100084',3,'1','I',5,'01000','','','','END_TRT',272,'I','','','','','','1000021040100063','1000021040100063','0','2017-07-05','0','1','','780','',500,'0000019','06','','',6,'045','BANK AL AMAL','045780','','','1','2017-07-05','','','','',''),(281,'2017-07-05','AGENCE CASABLANCA','I','','','','0.000','0','45000','45000','','I','','','','1','7894561','45000','1000.00','0000021050100084',3,'1','I',5,'01000','','','','END_TRT',272,'I','','','','','','0111544100001012','0111544100001012','0','2017-07-05','0','0','','041','',100,'0000059','76','','',7,'101','BP Centre Sud','101041','','V002','0','2017-07-05','','','','',''),(282,'2017-07-05','AGENCE CASABLANCA','I','','','','0.000','0','45000','45000','','I','','','','1','7894561','45000','1000.00','0000021050100084',3,'1','I',5,'01000','','','','END_TRT',272,'I','','','','','','0111544100001012','0111544100001012','0','2017-07-05','0','0','','041','',400,'0000058','76','','',8,'101','BP Centre Sud','101041','','','1','2017-07-05','','','','',''),(285,'2017-07-05','AGENCE CASABLANCA','I','','','','0.000','0','45000','45000','','I','','','','1','4561233','45000','1600.00','0000021040100063',3,'1','I',9,'01000','','','','END_TRT',272,'I','','','','','','0111544100001012','0111544100001012','0','2017-07-05','0','0','','041','',600,'0000060','76','','',10,'101','BP Centre Sud','101041','','','1','2017-07-05','','','','',''),(286,'2017-07-05','AGENCE CASABLANCA','I','','','','0.000','0','45000','45000','','I','','','','1','4561233','45000','1600.00','0000021040100063',3,'1','I',9,'01000','','','','END_TRT',272,'I','','','','','','0112133100007495','0112133100007495','0','2017-07-05','0','1','','041','',700,'0000011','89','','',11,'101','BP Centre Sud','101041','','','1','2017-07-05','','','','',''),(287,'2017-07-05','AGENCE CASABLANCA','I','','','','0.000','0','45000','45000','','I','','','','1','4561233','45000','1600.00','0000021040100063',3,'1','I',9,'01000','','','','END_TRT',272,'I','','','','','','0112133100007495','0112133100007495','0','2017-07-05','0','0','','041','',300,'0000010','89','','',12,'101','BP Centre Sud','101041','','','1','2017-07-05','','','','','');
/*!40000 ALTER TABLE `tmp_tbl_eta_chq_baa` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-08-01 15:52:49
