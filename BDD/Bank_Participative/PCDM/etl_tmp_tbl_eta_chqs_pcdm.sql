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
-- Table structure for table `tmp_tbl_eta_chqs_pcdm`
--

DROP TABLE IF EXISTS `tmp_tbl_eta_chqs_pcdm`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tmp_tbl_eta_chqs_pcdm` (
  `bmch_pk_obj_idt` int(11) NOT NULL DEFAULT '0',
  `DATE` date DEFAULT NULL,
  `age_r_lib` char(50) DEFAULT NULL,
  `bq_lib` varchar(45) DEFAULT NULL,
  `bmtn_OPE_ETA` char(1) NOT NULL DEFAULT '',
  `bmtn_ANO` text,
  `bmtn_ANO_lib` varchar(145) DEFAULT NULL,
  `bmtn_CDEBPR` char(3) DEFAULT NULL,
  `bmtn_COUNT_CHQ` varchar(5) DEFAULT NULL,
  `bmtn_DIFF` varchar(15) DEFAULT NULL,
  `bmtn_DIFF_NB` varchar(5) DEFAULT NULL,
  `bmtn_LECTEUR` char(3) DEFAULT NULL,
  `bmtn_MEM2` varchar(5) DEFAULT NULL,
  `bmtn_SUM_CHQ` varchar(15) DEFAULT NULL,
  `bmta_OPE_ETA` char(1) NOT NULL DEFAULT '',
  `bmta_Ano` text,
  `bmta_Ano_lib` varchar(145) DEFAULT NULL,
  `bmta_CDEBPR` char(3) DEFAULT NULL,
  `bmta_MEM2` varchar(5) DEFAULT NULL,
  `bmta_SQCA` varchar(10) DEFAULT NULL,
  `bmtr_NSER` varchar(7) DEFAULT NULL,
  `bmtr_MEM2` varchar(5) DEFAULT NULL,
  `bmtr_MNT` varchar(12) DEFAULT NULL,
  `bmtr_CDECLT` varchar(12) DEFAULT NULL,
  `bmtr_NBCH` double DEFAULT NULL,
  `bmtr_MODE_ESC` varchar(1) DEFAULT NULL,
  `bmtr_OPE_ETA` char(1) NOT NULL DEFAULT '',
  `bmtr_SQCA` double DEFAULT NULL,
  `bmtr_AGE_RMT` varchar(4) DEFAULT NULL,
  `bmtr_TIERS` varchar(7) DEFAULT NULL,
  `bmtr_REFCLI` varchar(15) DEFAULT NULL,
  `bmtr_ANO` text,
  `bmtr_ANO_lib` varchar(145) DEFAULT NULL,
  `bmch_fk_ope_mne` varchar(12) DEFAULT NULL,
  `bmch_instance` int(11) NOT NULL DEFAULT '0',
  `bmch_ope_eta` char(1) NOT NULL DEFAULT '',
  `bmch_ADR_RMT` varchar(35) DEFAULT NULL,
  `bmch_ADR_TIR` varchar(50) DEFAULT NULL,
  `bmch_AGE` varchar(4) DEFAULT NULL,
  `bmch_CDEBPR` char(3) DEFAULT NULL,
  `bmch_CDE_REJ` char(3) DEFAULT NULL,
  `bmch_CPT` varchar(16) DEFAULT NULL,
  `bmch_CPT2` varchar(16) DEFAULT NULL,
  `bmch_DBLT` char(1) DEFAULT NULL,
  `bmch_DTEEMI` varchar(8) DEFAULT NULL,
  `bmch_FLAG_IMP` char(1) DEFAULT NULL,
  `bmch_FLAG_REJET` char(1) DEFAULT NULL,
  `bmch_FLAG_AVAL` char(1) DEFAULT NULL,
  `bmch_LOC` char(3) DEFAULT NULL,
  `bmch_MEM2` varchar(5) DEFAULT NULL,
  `bmch_MNT` varchar(25) DEFAULT NULL,
  `bmch_NSER` varchar(7) DEFAULT NULL,
  `bmch_RIB` char(2) DEFAULT NULL,
  `bmch_RIO` varchar(32) DEFAULT NULL,
  `bmch_RSOC_TIR` varchar(35) DEFAULT NULL,
  `bmch_SQCA` double DEFAULT NULL,
  `bmch_ZBK` char(3) DEFAULT NULL,
  `bmch_ZIB` varchar(6) DEFAULT NULL,
  `bmch_ANO` text,
  `bmch_ANO_lib` varchar(145) DEFAULT NULL,
  `bmch_CONF` varchar(1) DEFAULT NULL,
  `bmch_VICE` text,
  `bmch_DTEINV` varchar(8) DEFAULT NULL,
  `bmch_AGE_RMT` varchar(4) DEFAULT NULL,
  PRIMARY KEY (`bmch_pk_obj_idt`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tmp_tbl_eta_chqs_pcdm`
--

LOCK TABLES `tmp_tbl_eta_chqs_pcdm` WRITE;
/*!40000 ALTER TABLE `tmp_tbl_eta_chqs_pcdm` DISABLE KEYS */;
INSERT INTO `tmp_tbl_eta_chqs_pcdm` VALUES (10,'2017-05-18','EP Mohamed V','C.I.H','I','','','365','','0.000','0','001','10940','','','','','365','10940','1','1002017','10940','1500.00','00000000001',2,'0','I',1,'940','00000','','','','Valid2',6,'I','','','940','365','','2356272211003000','2356272211003000','0','10052017','0','0','0','780','10940','1000','0000005','10','','',1,'230','230780','','','1','','20170510',''),(11,'2017-05-18','EP Mohamed V','UMNIA BANK','I','','','365','','0.000','0','001','10940','','','','','365','10940','1','1002017','10940','1500.00','00000000001',2,'0','I',1,'940','00000','','','','Valid2',6,'I','','','940','365','','0000030516160019','0000030516160019','0','11052017','0','0','0','810','10940','500','0000006','05','','',2,'360','360810','','','0','M011','20170511','');
/*!40000 ALTER TABLE `tmp_tbl_eta_chqs_pcdm` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-08-01 15:49:30
