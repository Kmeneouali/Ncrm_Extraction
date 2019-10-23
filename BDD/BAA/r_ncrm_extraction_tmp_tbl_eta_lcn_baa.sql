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
-- Table structure for table `tmp_tbl_eta_lcn_baa`
--

DROP TABLE IF EXISTS `tmp_tbl_eta_lcn_baa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tmp_tbl_eta_lcn_baa` (
  `bmlcn_pk_obj_idt` int(11) NOT NULL,
  `DATE` date DEFAULT NULL,
  `age_r_lib` char(32) DEFAULT NULL COMMENT 'Libelle de l agence',
  `bq_lib` varchar(45) DEFAULT NULL,
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
  `bmta_CDEBPR` varchar(3) CHARACTER SET utf8 DEFAULT NULL,
  `bmta_MEM2` char(0) CHARACTER SET utf8 NOT NULL DEFAULT '',
  `bmta_SQCA` varchar(10) CHARACTER SET utf8 DEFAULT NULL,
  `bmtr_NSER` varchar(7) CHARACTER SET utf8 DEFAULT NULL,
  `bmtr_MEM2` varchar(5) CHARACTER SET utf8 DEFAULT NULL,
  `bmtr_MNT` varchar(12) CHARACTER SET utf8 DEFAULT NULL,
  `bmtr_CDECLT` varchar(16) CHARACTER SET utf8 DEFAULT NULL,
  `bmtr_NBCH` double DEFAULT NULL,
  `bmtr_MODE_ESC` varchar(1) CHARACTER SET utf8 DEFAULT NULL,
  `bmtr_OPE_ETA` varchar(1) CHARACTER SET utf8 NOT NULL,
  `bmtr_SQCA` double DEFAULT NULL,
  `bmtr_AGE_RMT` varchar(5) CHARACTER SET utf8 DEFAULT NULL,
  `bmtr_TIERS` char(0) CHARACTER SET utf8 NOT NULL DEFAULT '',
  `bmtr_REFCLI` varchar(12) CHARACTER SET utf8 DEFAULT NULL,
  `bmtr_ANO` text CHARACTER SET utf8,
  `bmlcn_fk_ope_mne` varchar(12) CHARACTER SET utf8 DEFAULT NULL,
  `bmlcn_instance` int(11) NOT NULL,
  `bmlcn_ope_eta` varchar(1) CHARACTER SET utf8 NOT NULL,
  `bmlcn_ADR_RMT` char(0) CHARACTER SET utf8 NOT NULL DEFAULT '',
  `bmlcn_ADR_TIR` char(0) CHARACTER SET utf8 NOT NULL DEFAULT '',
  `bmlcn_AGE` varchar(3) CHARACTER SET utf8 DEFAULT NULL,
  `bmlcn_CDEBPR` char(0) CHARACTER SET utf8 NOT NULL DEFAULT '',
  `bmlcn_CDE_REJ` varchar(3) CHARACTER SET utf8 DEFAULT NULL,
  `bmlcn_CPT` varchar(16) CHARACTER SET utf8 DEFAULT NULL,
  `bmlcn_CPT2` varchar(16) CHARACTER SET utf8 DEFAULT NULL,
  `bmlcn_DBLT` varchar(1) CHARACTER SET utf8 DEFAULT NULL,
  `bmlcn_DTEEMI` varchar(10) CHARACTER SET utf8 DEFAULT NULL,
  `bmlcn_FLAG_REJET` varchar(1) CHARACTER SET utf8 DEFAULT NULL,
  `bmlcn_FLAG_AVAL` char(0) CHARACTER SET utf8 NOT NULL DEFAULT '',
  `bmlcn_LOC` varchar(3) CHARACTER SET utf8 DEFAULT NULL,
  `bmlcn_MEM2` varchar(5) CHARACTER SET utf8 DEFAULT NULL,
  `bmlcn_MNT` varchar(16) DEFAULT NULL,
  `bmlcn_NSER` varchar(7) CHARACTER SET utf8 DEFAULT NULL,
  `bmlcn_RIB` varchar(2) CHARACTER SET utf8 DEFAULT NULL,
  `bmlcn_RSOC_TIR` varchar(35) CHARACTER SET utf8 DEFAULT NULL,
  `bmlcn_SQCA` double DEFAULT NULL,
  `bmlcn_ZBK` varchar(3) CHARACTER SET utf8 DEFAULT NULL,
  `bmlcn_ZIB` varchar(6) CHARACTER SET utf8 DEFAULT NULL,
  `bmlcn_ANO` text CHARACTER SET utf8,
  `bmlcn_CONF` varchar(1) CHARACTER SET utf8 DEFAULT NULL,
  `bmlcn_VICE` text CHARACTER SET utf8,
  `bmlcn_AGE_RMT` varchar(5) CHARACTER SET utf8 DEFAULT NULL,
  `bmtn_ANO_lib` varchar(245) DEFAULT NULL,
  `bmta_ANO_lib` varchar(245) DEFAULT NULL,
  `bmtr_ANO_lib` varchar(245) DEFAULT NULL,
  `bmlcn_ANO_lib` varchar(245) DEFAULT NULL,
  PRIMARY KEY (`bmlcn_pk_obj_idt`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tmp_tbl_eta_lcn_baa`
--

LOCK TABLES `tmp_tbl_eta_lcn_baa` WRITE;
/*!40000 ALTER TABLE `tmp_tbl_eta_lcn_baa` DISABLE KEYS */;
INSERT INTO `tmp_tbl_eta_lcn_baa` VALUES (48,'2017-07-05','AGENCE CASABLANCA','BP Centre Sud','I','','','3','0.00','0','45000','45000','1050.00','I','','','1','7894563','45000','1050.00','0000021050100084',3,'1','I',2,'01000','','','','STOCK',44,'I','','','','','000','0111546100001028','0111546100001028','0','2017-07-05','0','','041','45000','400','0000137','18','ste de',3,'101','101041','','1','','','',NULL,'',''),(49,'2017-07-05','AGENCE CASABLANCA','BP Centre Sud','I','','','3','0.00','0','45000','45000','1050.00','I','','','1','7894563','45000','1050.00','0000021050100084',3,'1','I',2,'01000','','','','STOCK',44,'I','','','','','000','0111546100001028','0111546100001028','0','2017-07-05','0','','041','45000','500','0000135','18','constr',4,'101','101041','','1','','','',NULL,'',''),(50,'2017-07-05','AGENCE CASABLANCA','BP Centre Sud','I','','','3','0.00','0','45000','45000','1050.00','I','','','1','7894563','45000','1050.00','0000021050100084',3,'1','I',2,'01000','','','','STOCK',44,'I','','','','','000','0111546100001028','0111546100001028','0','2017-07-05','0','','041','45000','150','0000134','18','constru',5,'101','101041','','1','','','',NULL,'',''),(51,'2017-07-05','AGENCE CASABLANCA','','I','','','3','0.00','0','45000','45000','1050.00','I','','','1','7894563','45000','1050.00','0000021050100084',3,'1','I',2,'01000','','','','CORLCN',44,'D','','','','','000','100000021040006*','100000021040006*','0','2017-07-05','1','','','45000','','0000010','06','',6,'','045780','100','1','','','',NULL,'','Clé Rib incorrecte'),(54,'2017-07-05','AGENCE CASABLANCA','BANK AL AMAL','I','','','','0.000','0','45000','45000','','I','','','1','1326455','45000','600.00','0000021040100063',3,'1','I',7,'01000','','','','STOCK',44,'I','','','','','000','0111546100001028','0111546100001028','0','2017-07-05','0','','041','45000','100','0000132','18','const bat',8,'045','101041','','1','','','',NULL,'',''),(55,'2017-07-05','AGENCE CASABLANCA','BP Centre Sud','I','','','','0.000','0','45000','45000','','I','','','1','1326455','45000','600.00','0000021040100063',3,'1','I',7,'01000','','','','STOCK',44,'I','','','','','000','0111546100001028','0111546100001028','0','2017-07-05','0','','041','45000','200','0000133','18','constr bat',9,'101','101041','','1','','','',NULL,'',''),(56,'2017-07-05','AGENCE CASABLANCA','BP Centre Sud','I','','','','0.000','0','45000','45000','','I','','','1','1326455','45000','600.00','0000021040100063',3,'1','I',7,'01000','','','','STOCK',44,'I','','','','','000','0111546100001028','0111546100001028','0','2017-07-05','0','','041','45000','300','0000136','18','constr bat',10,'101','101041','','0','ASTI','','',NULL,'','');
/*!40000 ALTER TABLE `tmp_tbl_eta_lcn_baa` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-08-01 15:52:50
