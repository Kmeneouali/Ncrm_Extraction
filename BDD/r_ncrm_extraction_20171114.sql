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
-- Table structure for table `authorities`
--

DROP TABLE IF EXISTS `authorities`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `authorities` (
  `username` varchar(50) NOT NULL,
  `authority` varchar(50) NOT NULL,
  UNIQUE KEY `ix_auth_username` (`username`,`authority`),
  CONSTRAINT `fk_authorities_users` FOREIGN KEY (`username`) REFERENCES `users` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `authorities`
--

LOCK TABLES `authorities` WRITE;
/*!40000 ALTER TABLE `authorities` DISABLE KEYS */;
INSERT INTO `authorities` VALUES ('admin','ROLE_ADMIN'),('BAA','ROLE_BAA'),('BPM','ROLE_BPM'),('CFG','ROLE_CFG'),('PCDM','ROLE_PCDM'),('QMB','ROLE_QMB');
/*!40000 ALTER TABLE `authorities` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `baa_scanners`
--

DROP TABLE IF EXISTS `baa_scanners`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `baa_scanners` (
  `CDESCANNER` char(5) NOT NULL DEFAULT '',
  `AGE` char(5) NOT NULL DEFAULT '',
  `TYPE` char(2) DEFAULT NULL,
  `LIB` char(50) DEFAULT NULL,
  PRIMARY KEY (`CDESCANNER`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `baa_scanners`
--

LOCK TABLES `baa_scanners` WRITE;
/*!40000 ALTER TABLE `baa_scanners` DISABLE KEYS */;
INSERT INTO `baa_scanners` VALUES ('45000','01000','AG','Agence Casablanca');
/*!40000 ALTER TABLE `baa_scanners` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cfg_paid_chq`
--

DROP TABLE IF EXISTS `cfg_paid_chq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfg_paid_chq` (
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
) ENGINE=InnoDB AUTO_INCREMENT=16244 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cfg_paid_chq`
--

LOCK TABLES `cfg_paid_chq` WRITE;
/*!40000 ALTER TABLE `cfg_paid_chq` DISABLE KEYS */;
INSERT INTO `cfg_paid_chq` VALUES (16242,'0000007','10-05-2017','050810','050','810','0110103519222001','68','10000.00'),(16243,'0000032','10-05-2017','050780','050','780','0010100061922001','96','4000.00');
/*!40000 ALTER TABLE `cfg_paid_chq` ENABLE KEYS */;
UNLOCK TABLES;

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
) ENGINE=InnoDB AUTO_INCREMENT=16398 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cfg_paid_lcn`
--

LOCK TABLES `cfg_paid_lcn` WRITE;
/*!40000 ALTER TABLE `cfg_paid_lcn` DISABLE KEYS */;
INSERT INTO `cfg_paid_lcn` VALUES (16382,'2102952','10-05-2017','127270','127','270','2111170631350009','35','2000.00'),(16383,'7947464','10-05-2017','007425','007','425','0006243000301498','86','2250.00'),(16384,'0039311','10-05-2017','011022','011','022','0000042100000051','76','25000.00'),(16385,'8799015','10-05-2017','007450','007','450','0004884000303372','04','5000.00'),(16386,'8798967','10-05-2017','007450','007','450','0004884000303372','04','5000.00'),(16387,'8783001','10-05-2017','007780','007','780','0002625000301800','31','5000.00'),(16388,'9093636','10-05-2017','007450','007','450','0006585000301794','16','5000.00'),(16389,'8783055','10-05-2017','007780','007','780','0002625000301800','31','5000.00'),(16390,'9006114','10-05-2017','007450','007','450','0001757000303700','08','5000.00'),(16391,'7693161','10-05-2017','022450','022','450','0001210009100722','53','10000.00'),(16392,'6065552','10-05-2017','013810','013','810','0112400024100141','94','1200.00'),(16393,'4655756','10-05-2017','021270','021','270','0000041001141901','57','1150.00'),(16394,'9751620','10-05-2017','013810','013','810','0107000015200176','94','111600.00'),(16395,'9751205','10-05-2017','013810','013','810','0107000015200176','94','125400.00'),(16396,'3100715','08-05-2017','021450','021','450','0000026001040741','84','5000.00'),(16397,'5414185','08-05-2017','021810','021','810','0000069030269313','86','19500.00');
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
INSERT INTO `cfg_poche_affectation` VALUES ('001',15),('002',16),('003',17),('005',18),('007',5),('011',6),('013',7),('021',8),('022',9),('028',19),('050',10),('060',20),('070',21),('143',11),('145',11),('148',11),('150',11),('157',11),('164',11),('178',11),('181',11),('190',12),('225',13),('230',14),('310',22),('350',23);
/*!40000 ALTER TABLE `cfg_poche_affectation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ta_imp_chq_baa`
--

DROP TABLE IF EXISTS `ta_imp_chq_baa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ta_imp_chq_baa` (
  `REF` int(10) NOT NULL AUTO_INCREMENT,
  `PK_OBJ_IDT` varchar(32) DEFAULT NULL,
  `RIO` varchar(32) DEFAULT NULL,
  `RIOINI` varchar(32) DEFAULT NULL,
  `REJET` varchar(3) DEFAULT NULL,
  `ADR_RMT` varchar(50) DEFAULT NULL,
  `ADR_TIR` varchar(50) DEFAULT NULL,
  `CDEBPR` varchar(3) DEFAULT NULL,
  `CDEBPR_RMT` varchar(3) DEFAULT NULL,
  `AGE` varchar(5) DEFAULT NULL,
  `AGE_RMT` varchar(5) DEFAULT NULL,
  `AGE_RMT_LIB` varchar(35) DEFAULT NULL,
  `CPT` varchar(24) DEFAULT NULL,
  `CPTT` varchar(16) DEFAULT NULL,
  `DTEMI` varchar(8) DEFAULT NULL,
  `DTEREG` varchar(10) DEFAULT NULL,
  `LOC` varchar(3) DEFAULT NULL,
  `LOCT` varchar(3) DEFAULT NULL,
  `MEM2` varchar(5) DEFAULT NULL,
  `MNT` varchar(16) DEFAULT NULL,
  `MODE_ESC` varchar(1) DEFAULT NULL,
  `NSER` varchar(7) DEFAULT NULL,
  `SQCA` varchar(10) DEFAULT NULL,
  `RIB` varchar(2) DEFAULT NULL,
  `RIBR` varchar(2) DEFAULT NULL,
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
  `REJET_LIB` varchar(250) DEFAULT NULL,
  `DTREJET` varchar(8) DEFAULT NULL,
  `DTEINS` varchar(10) DEFAULT NULL,
  `DTEPRE` varchar(10) DEFAULT NULL,
  `DTEemission` varchar(10) DEFAULT NULL,
  `DTETRT` varchar(10) DEFAULT NULL,
  `tiers` varchar(10) DEFAULT NULL,
  `DTE_SORT` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`REF`),
  UNIQUE KEY `RIOINI_UNIQUE` (`RIOINI`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ta_imp_chq_baa`
--

LOCK TABLES `ta_imp_chq_baa` WRITE;
/*!40000 ALTER TABLE `ta_imp_chq_baa` DISABLE KEYS */;
/*!40000 ALTER TABLE `ta_imp_chq_baa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ta_imp_chq_bpm`
--

DROP TABLE IF EXISTS `ta_imp_chq_bpm`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ta_imp_chq_bpm` (
  `REF` int(10) NOT NULL AUTO_INCREMENT,
  `PK_OBJ_IDT` varchar(32) DEFAULT NULL,
  `RIO` varchar(32) DEFAULT NULL,
  `RIOINI` varchar(32) DEFAULT NULL,
  `REJET` varchar(3) DEFAULT NULL,
  `ADR_RMT` varchar(50) DEFAULT NULL,
  `ADR_TIR` varchar(50) DEFAULT NULL,
  `CDEBPR` varchar(3) DEFAULT NULL,
  `CDEBPR_RMT` varchar(3) DEFAULT NULL,
  `AGE` varchar(5) DEFAULT NULL,
  `AGE_RMT` varchar(4) DEFAULT NULL,
  `AGE_RMT_LIB` varchar(35) DEFAULT NULL,
  `CPT` varchar(9) DEFAULT NULL,
  `CPTT` varchar(16) DEFAULT NULL,
  `DTEMI` varchar(8) DEFAULT NULL,
  `DTEREG` varchar(10) DEFAULT NULL,
  `LOC` varchar(3) DEFAULT NULL,
  `LOCT` varchar(3) DEFAULT NULL,
  `MEM2` varchar(5) DEFAULT NULL,
  `MNT` varchar(16) DEFAULT NULL,
  `MODE_ESC` varchar(1) DEFAULT NULL,
  `NSER` varchar(7) DEFAULT NULL,
  `SQCA` varchar(10) DEFAULT NULL,
  `RIB` varchar(2) DEFAULT NULL,
  `RIBR` varchar(2) DEFAULT NULL,
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
  `DTEINS` varchar(10) DEFAULT NULL,
  `DTEPRE` varchar(10) DEFAULT NULL,
  `DTEemission` varchar(10) DEFAULT NULL,
  `DTETRT` varchar(10) DEFAULT NULL,
  `tiers` varchar(10) DEFAULT NULL,
  `DTE_SORT` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`REF`),
  UNIQUE KEY `RIOINI_UNIQUE` (`RIOINI`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ta_imp_chq_bpm`
--

LOCK TABLES `ta_imp_chq_bpm` WRITE;
/*!40000 ALTER TABLE `ta_imp_chq_bpm` DISABLE KEYS */;
/*!40000 ALTER TABLE `ta_imp_chq_bpm` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ta_imp_chq_pcdm`
--

DROP TABLE IF EXISTS `ta_imp_chq_pcdm`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ta_imp_chq_pcdm` (
  `REF` int(10) NOT NULL AUTO_INCREMENT,
  `PK_OBJ_IDT` varchar(32) DEFAULT NULL,
  `RIO` varchar(32) DEFAULT NULL,
  `RIOINI` varchar(32) DEFAULT NULL,
  `REJET` varchar(3) DEFAULT NULL,
  `ADR_RMT` varchar(50) DEFAULT NULL,
  `ADR_TIR` varchar(50) DEFAULT NULL,
  `CDEBPR` varchar(3) DEFAULT NULL,
  `CDEBPR_RMT` varchar(3) DEFAULT NULL,
  `AGE` varchar(5) DEFAULT NULL,
  `AGE_RMT` varchar(4) DEFAULT NULL,
  `AGE_RMT_LIB` varchar(35) DEFAULT NULL,
  `CPT` varchar(24) DEFAULT NULL,
  `CPTT` varchar(16) DEFAULT NULL,
  `DTEMI` varchar(8) DEFAULT NULL,
  `DTEREG` varchar(10) DEFAULT NULL,
  `LOC` varchar(3) DEFAULT NULL,
  `LOCT` varchar(3) DEFAULT NULL,
  `MEM2` varchar(5) DEFAULT NULL,
  `MNT` varchar(16) DEFAULT NULL,
  `MODE_ESC` varchar(1) DEFAULT NULL,
  `NSER` varchar(7) DEFAULT NULL,
  `SQCA` varchar(10) DEFAULT NULL,
  `RIB` varchar(2) DEFAULT NULL,
  `RIBR` varchar(2) DEFAULT NULL,
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
  `REJET_LIB` varchar(250) DEFAULT NULL,
  `DTREJET` varchar(8) DEFAULT NULL,
  `DTEINS` varchar(10) DEFAULT NULL,
  `DTEPRE` varchar(10) DEFAULT NULL,
  `DTEemission` varchar(10) DEFAULT NULL,
  `DTETRT` varchar(10) DEFAULT NULL,
  `tiers` varchar(10) DEFAULT NULL,
  `DTE_SORT` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`REF`),
  UNIQUE KEY `RIOINI_UNIQUE` (`RIOINI`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ta_imp_chq_pcdm`
--

LOCK TABLES `ta_imp_chq_pcdm` WRITE;
/*!40000 ALTER TABLE `ta_imp_chq_pcdm` DISABLE KEYS */;
/*!40000 ALTER TABLE `ta_imp_chq_pcdm` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ta_imp_chq_qmb`
--

DROP TABLE IF EXISTS `ta_imp_chq_qmb`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ta_imp_chq_qmb` (
  `REF` int(10) NOT NULL AUTO_INCREMENT,
  `PK_OBJ_IDT` varchar(32) DEFAULT NULL,
  `RIO` varchar(32) DEFAULT NULL,
  `RIOINI` varchar(32) DEFAULT NULL,
  `REJET` varchar(3) DEFAULT NULL,
  `ADR_RMT` varchar(50) DEFAULT NULL,
  `ADR_TIR` varchar(50) DEFAULT NULL,
  `CDEBPR` varchar(3) DEFAULT NULL,
  `CDEBPR_RMT` varchar(3) DEFAULT NULL,
  `AGE` varchar(5) DEFAULT NULL,
  `AGE_RMT` varchar(4) DEFAULT NULL,
  `AGE_RMT_LIB` varchar(35) DEFAULT NULL,
  `CPT` varchar(12) DEFAULT NULL,
  `CPTT` varchar(16) DEFAULT NULL,
  `DTEMI` varchar(8) DEFAULT NULL,
  `DTEREG` varchar(10) DEFAULT NULL,
  `LOC` varchar(3) DEFAULT NULL,
  `LOCT` varchar(3) DEFAULT NULL,
  `MEM2` varchar(5) DEFAULT NULL,
  `MNT` varchar(16) DEFAULT NULL,
  `MODE_ESC` varchar(1) DEFAULT NULL,
  `NSER` varchar(7) DEFAULT NULL,
  `SQCA` varchar(10) DEFAULT NULL,
  `RIB` varchar(2) DEFAULT NULL,
  `RIBR` varchar(2) DEFAULT NULL,
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
  `REJET_LIB` varchar(250) DEFAULT NULL,
  `DTREJET` varchar(8) DEFAULT NULL,
  `DTEINS` varchar(10) DEFAULT NULL,
  `DTEPRE` varchar(10) DEFAULT NULL,
  `DTEemission` varchar(10) DEFAULT NULL,
  `DTETRT` varchar(10) DEFAULT NULL,
  `tiers` varchar(10) DEFAULT NULL,
  `DTE_SORT` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`REF`),
  UNIQUE KEY `RIOINI_UNIQUE` (`RIOINI`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ta_imp_chq_qmb`
--

LOCK TABLES `ta_imp_chq_qmb` WRITE;
/*!40000 ALTER TABLE `ta_imp_chq_qmb` DISABLE KEYS */;
/*!40000 ALTER TABLE `ta_imp_chq_qmb` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ta_imp_lcn_baa`
--

DROP TABLE IF EXISTS `ta_imp_lcn_baa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ta_imp_lcn_baa` (
  `REF` int(10) NOT NULL AUTO_INCREMENT,
  `PK_OBJ_IDT` int(11) DEFAULT NULL,
  `RIO` varchar(32) DEFAULT NULL,
  `RIOINI` varchar(32) DEFAULT NULL,
  `REJET` varchar(3) DEFAULT NULL,
  `ADR_RMT` varchar(250) DEFAULT NULL,
  `ADR_TIRE` varchar(250) DEFAULT NULL,
  `CDEBPR` varchar(3) DEFAULT NULL,
  `CDEBPR_RMT` varchar(3) DEFAULT NULL,
  `AGE` varchar(5) DEFAULT NULL,
  `AGE_RMT` varchar(5) DEFAULT NULL,
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
  `DTEINS` varchar(10) DEFAULT NULL,
  `DTEPRE` varchar(10) DEFAULT NULL,
  `DTEemission` varchar(10) DEFAULT NULL,
  `tiers` varchar(9) DEFAULT NULL,
  `DTE_SORT` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`REF`)
) ENGINE=InnoDB AUTO_INCREMENT=281 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ta_imp_lcn_baa`
--

LOCK TABLES `ta_imp_lcn_baa` WRITE;
/*!40000 ALTER TABLE `ta_imp_lcn_baa` DISABLE KEYS */;
INSERT INTO `ta_imp_lcn_baa` VALUES (280,280,'150MAD00100920171013285131100010','045MAD00100120171012010000000065','014',NULL,'Q EL KINDY BD PRINCE SIDI MED RUE 36 N 5 NADOR NADOR 62000 MAROC                                    ',NULL,NULL,NULL,'01000','AGENCE CASABLANCA','2121153148540013','2121153148540013','11102017',NULL,NULL,NULL,'500','45000','50000.00',NULL,'7914818',NULL,'55',NULL,NULL,NULL,'150','BP Nador El Hoceima','STE RIFONOR SARL A.U                              ','          ','7103                ','NADOR               ','014','   ','   ',NULL,'LIBELLE DANS UNE MONNAIE AUTRE QUE LE DIRHAM','20171013','2017-10-11','0','20171012',NULL,'13-10-2017');
/*!40000 ALTER TABLE `ta_imp_lcn_baa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `te_pacapt_sgda`
--

DROP TABLE IF EXISTS `te_pacapt_sgda`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `te_pacapt_sgda` (
  `idPcapt` int(11) NOT NULL AUTO_INCREMENT,
  `cdePcapt` varchar(5) NOT NULL,
  `Lib` varchar(45) DEFAULT NULL,
  `type` varchar(2) DEFAULT NULL,
  `active` varchar(1) DEFAULT NULL,
  `cdeAge` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`idPcapt`),
  UNIQUE KEY `cdePcapt_UNIQUE` (`cdePcapt`)
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `te_pacapt_sgda`
--

LOCK TABLES `te_pacapt_sgda` WRITE;
/*!40000 ALTER TABLE `te_pacapt_sgda` DISABLE KEYS */;
INSERT INTO `te_pacapt_sgda` VALUES (1,'10002','AGENCE BERNOUSSI','AG','1','10002'),(49,'10003','AGENCE AGADIR HASSAN II','AG','1','10003'),(50,'10007','AGENCE AGADIR BD SAFI','AG','1','10007'),(51,'10008','AGENCE RUE DE ROME','AG','1','10008');
/*!40000 ALTER TABLE `te_pacapt_sgda` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `te_pacapt_sgma`
--

DROP TABLE IF EXISTS `te_pacapt_sgma`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `te_pacapt_sgma` (
  `idPcapt` int(11) NOT NULL AUTO_INCREMENT,
  `cdePcapt` varchar(5) NOT NULL,
  `Lib` varchar(45) DEFAULT NULL,
  `type` varchar(2) DEFAULT NULL,
  `active` varchar(1) DEFAULT NULL,
  `cdeAge` varchar(5) DEFAULT NULL,
  `secteur` varchar(45) DEFAULT NULL,
  `circuit` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idPcapt`),
  UNIQUE KEY `cdePcapt_UNIQUE` (`cdePcapt`)
) ENGINE=InnoDB AUTO_INCREMENT=449 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `te_pacapt_sgma`
--

LOCK TABLES `te_pacapt_sgma` WRITE;
/*!40000 ALTER TABLE `te_pacapt_sgma` DISABLE KEYS */;
INSERT INTO `te_pacapt_sgma` VALUES (5,'10005','E EL FIDA','AG','0','005','SB','C12'),(6,'10006','G  ROCHES NOIRES','AG','0','006','SA','C2'),(7,'10007','AGADIR-FAR','AG','0','007','SE','052'),(8,'10008','AGADIR-KETTANI','AG','0','008','SE','052'),(9,'10009','FES-GRANDE POSTE','AG','0','009','SE','053'),(10,'10010','FES-VILLE NOUVELLE','AG','0','010','SE','053'),(11,'10011','KENITRA NAFOURA','AG','0','011','SE','058'),(12,'10012','MARRAKECH-MEDINA','AG','0','012','SE','054'),(13,'10014','MARRAKECH-GUELIZ','AG','0','014','SE','054'),(14,'10015','MEKNES HAMRIA','AG','0','015','SE','057'),(15,'10016','RABAT-GRANDE POSTE','AG','0','016','SE','050'),(16,'10017','SAFI','AG','0','017','SE','063'),(17,'10018','TANGER PRINCIPALE','AG','0','018','SE','051'),(18,'10019','TAROUDANT','AG','0','019','SE','071'),(19,'10020','Mohamedia principale','AG','0','020','SA','C7'),(20,'10021','NADOR HASSAN 1ER','AG','0','021','SE','064'),(21,'10022','CASABLANCA-SIEGE','AG','0','022','SD','CSG'),(22,'10023','H  COLMAR','AG','0','023','SC','C1'),(23,'10024','F  AIN CHOK','AG','0','024','SB','C9'),(24,'10025','BERKANE','AG','0','025','SE','078'),(25,'10026','OUJDA PRINCIPALE','AG','0','026','SE','056'),(26,'10027','I  CITE DJEMAA','AG','0','027','SA','C6'),(27,'10028','J  OUDAYAS','AG','0','028','SC','C1'),(28,'10029','INEZGANE','AG','0','029','SE','052'),(29,'10030','TIZNIT','AG','0','030','SE','065'),(30,'10031','TETOUAN','AG','0','031','SE','055'),(31,'10032','RABAT-TOUR HASSAN','AG','0','032','SE','050'),(32,'10033','KASBA TADLA','AG','0','033','SE','087'),(33,'10034','BENI-MELLAL','AG','0','034','SE','061'),(34,'10035','K OMAR SLAOUI','AG','0','035','SC','C3'),(35,'10036','M  IBN TACHFINE','AG','0','036','SC','C1'),(36,'10037','FES-MEDINA R\'SIF','AG','0','037','SE','053'),(37,'10038','MARRAKECH-BADIE','AG','0','038','SE','054'),(38,'10039','OULED TEIMA','AG','0','039','SE','097'),(39,'10040','MOHAMMEDIA EL ALIA','AG','0','040','SA','C7'),(40,'10041','P  ANAFE','AG','0','041','SC','C8'),(41,'10042','R  EL MASJID','AG','0','042','SB','C9'),(42,'10043','S ABDELMOUMEN','AG','0','043','SD','CSG'),(43,'10044','L  HAY MOHAMMEDI','AG','0','044','SC','C1'),(44,'10045','NADOR-MONT AROUIT','AG','0','045','SE','093'),(45,'10046','RABAT-DIOUR JAMAA','AG','0','046','SE','050'),(46,'10047','KENITRA-RIAD','AG','0','047','SE','058'),(47,'10048','TANGER-BENI MEKKADA','AG','0','048','SE','051'),(48,'10049','EL JADIDA','AG','0','049','SE','059'),(49,'10050','RABAT-MOULAY YOUSSEF','AG','0','050','SE','050'),(50,'10051','TEMARA','AG','0','051','SE','050'),(51,'10052','FES-ATLAS','AG','0','052','SE','053'),(52,'10053','TL  LIBERTE','AG','0','053','SC','C3'),(53,'10054','TB  BIR ANZARANE','AG','0','054','SC','C11'),(54,'10055','RESISTANCE','AG','0','055','SC','C1'),(55,'10056','RABAT YACOUB MANSOUR','AG','0','056','SE','050'),(56,'10057','KHEMISSET','AG','0','057','SE','088'),(57,'10058','TH  HABOUS','AG','0','058','SC','C1'),(58,'10059','AIT MELLOUL','AG','0','059','SE','052'),(59,'10060','TD  AIN DIAB','AG','0','060','SC','C11'),(60,'10061','TANGER LIBERTE','AG','0','061','SE','051'),(61,'10062','MARRAKECH R MILA','AG','0','062','SE','054'),(62,'10063','TF  HAY EL FARAH','AG','0','063','SB','C9'),(63,'10064','TJ  11 JANVIER','AG','0','064','SC','C3'),(64,'10065','SALE','AG','0','065','SE','050'),(65,'10066','TIFLET','AG','0','066','SE','104'),(66,'10067','KHORIBGA','AG','0','067','SE','066'),(67,'10068','TZ  EMILE ZOLA','AG','0','068','SA','C2'),(68,'10069','MIDAR','AG','0','069','SE','092'),(69,'10070','RABAT KAYS','AG','0','070','SE','050'),(70,'10071','AGADIR TALBORJT','AG','0','071','SE','052'),(71,'10072','TAZA','AG','0','072','SE','072'),(72,'10073','TP-POINCARE','AG','0','073','SC','C3'),(73,'10075','TY LALLA YACOUT','AG','0','075','SC','C3'),(74,'10076','SIDI SLIMANE','AG','0','076','SE','102'),(75,'10077','MEKNES-MEDINA','AG','0','077','SE','057'),(76,'10078','TN PANORAMIQUE','AG','0','078','SB','C9'),(77,'10079','TS-SIDI BERNOUSSI','AG','0','079','SA','C2'),(78,'10080','AL HOCEIMA','AG','0','080','SE','074'),(79,'10081','MEKNES-PRINCIPALE','AG','0','081','SE','057'),(80,'10082','FES BOUJLOUD','AG','0','082','SE','053'),(81,'10083','OUARZAZATE','AG','0','083','SE','095'),(82,'10084','TR BENOMAR','AG','0','084','SC','C8'),(83,'10085','CASA YACOUB MANSOUR','AG','0','085','SB','C5'),(84,'10087','CASA MY YOUSSEF','AG','0','087','SC','C8'),(85,'10088','MARRAKECH AMINE','AG','0','088','SE','054'),(86,'10089','TK-DAKAR-CASA','AG','0','089','SA','C2'),(87,'10090','RM-MEDIOUNA-CASA','AG','0','090','SB','C9'),(88,'10091','RABAT MICHLIFEN','AG','0','091','SE','050'),(89,'10092','OUJDA MEDINA','AG','0','092','SE','056'),(90,'10093','MARRAKECH PALMERAIE','AG','0','093','SE','054'),(91,'10094','MARRAKECH DAOUDIATE','AG','0','094','SE','054'),(92,'10095','TO HAY SADRI','AG','0','095','SB','C12'),(93,'10096','TA AL MASSIRA','AG','0','096','SC','C11'),(94,'10097','AGADIR PALACE','AG','0','097','SE','052'),(95,'10098','LARACHE','AG','0','098','SE','068'),(96,'10099','TG GHANDI','AG','0','099','SC','C11'),(97,'10100','TI ZERKTOUNI','AG','0','100','SC','C8'),(98,'10101','BERRECHID','AG','0','101','SE','060'),(99,'10102','TE AIN SEBAA','AG','0','102','SA','C2'),(100,'10103','NADOR PRINCIPALE','AG','0','103','SE','064'),(101,'10104','TANGER IBN TOUMERT','AG','0','104','SE','051'),(102,'10105','HAY HASSANI','AG','0','105','SC','C11'),(103,'10106','DIR REGIONALE RABAT','AG','0','106','SE','050'),(104,'10107','OUED EDDAHAB','AG','0','107','SA','C6'),(105,'10108','DRISS HARTI','AG','0','108','SA','C6'),(106,'10109','AL KHALIL','AG','0','109','SB','C9'),(107,'10110','MEKNES PLAISANCE','AG','0','110','SE','057'),(108,'10111','HASSAN SEGHIR','AG','0','111','SC','C3'),(109,'10112','MABROUKA','AG','0','112','SA','C6'),(110,'10113','DRISSIA','AG','0','113','SB','C9'),(111,'10114','RABAT BAB EL HAD','AG','0','114','SE','050'),(112,'10115','2 MARS CASABLANCA','AG','0','115','SC','C3'),(113,'10116','MEKNES ZITOUNE','AG','0','116','SE','057'),(114,'10117','ZENATA','AG','0','117','SA','C2'),(115,'10118','BOURGOGNE','AG','0','118','SC','C8'),(116,'10119','PASTEUR','AG','0','119','SC','C11'),(117,'10120','MUSTAPHA EL MAANI','AG','0','120','SC','C3'),(118,'10121','MARRAKECH HIVERNAGE','AG','0','121','SE','054'),(119,'10122','SALE TABRIQUET','AG','0','122','SE','050'),(120,'10123','SALMIA','AG','0','123','SA','C6'),(121,'10124','OULED ZIANE','AG','0','124','SB','C9'),(122,'10125','MOHAMMEDIA HOURYA','AG','0','125','SA','C7'),(123,'10126','RABAT AMAL','AG','0','126','SE','050'),(124,'10127','SETTAT','AG','0','127','SE','067'),(125,'10128','KENITRA Principale','AG','0','128','SE','058'),(126,'10129','TWIN CENTER','AG','0','129','SC','C8'),(127,'10130','CIL','AG','0','130','SC','C11'),(128,'10131','OULFA','AG','0','131','SB','C5'),(129,'10132','PLATEAU','AG','0','132','SB','C9'),(130,'10133','LA GIRONDE','AG','0','133','SB','C9'),(131,'10134','MLY DRISS 1ER','AG','0','134','SA','C6'),(132,'10135','BEAUSEJOUR','AG','0','135','SB','C4'),(133,'10136','BRAHIM ROUDANI','AG','0','136','SB','C4'),(134,'10137','FES ROUTE SEFROU','AG','0','137','SE','053'),(135,'10138','RABAT BENI ZNASSEN','AG','0','138','SE','050'),(136,'10139','LAAYOUNE','AG','0','139','SE','070'),(137,'10140','GRANDES ENTREPRISES','AG','0','140','SD','CSG'),(138,'10141','RABAT CHELLAH','AG','0','141','SE','050'),(139,'10142','MARRAKECH BAB DOUKALA','AG','0','142','SE','054'),(140,'10143','ZIRAOUI','AG','0','143','SC','C8'),(141,'10144','FES ROUTE D\'IMMOUZER','AG','0','144','SE','053'),(142,'10145','HAY SALAMA','AG','0','145','SB','C12'),(143,'10146','RABAT AL MANZAH','AG','0','146','SE','050'),(144,'10147','MARRAKECH AL MASSIRA','AG','0','147','SE','054'),(145,'10148','LES CRETES','AG','0','148','SB','C9'),(146,'10149','SIDI MAAROUF','AG','0','149','SB','C4'),(147,'10150','RABAT SOUISSI','AG','0','150','SE','050'),(148,'10151','MOULAY ISMAIL','AG','0','151','SA','C2'),(149,'10152','AGADIR HASSAN 1ER','AG','0','152','SE','052'),(150,'10153','TETOUAN SIDI EL MANDRI','AG','0','153','SE','055'),(151,'10154','AGENCE DES COMPTES PARTICULIER','AG','0','154','SD','CSG'),(152,'10155','OQBA BEN NAFIA','AG','0','155','SC','C1'),(153,'10156','OASIS','AG','0','156','SB','C4'),(154,'10157','AL MANAR','AG','0','157','SC','C8'),(155,'10158','GOULMIMA','AG','0','158','SC','C8'),(156,'10159','20 Aout','AG','0','159','SC','C3'),(157,'10160','AGENCE DES INSTITUTIONNELS','AG','0','160','SD','CSG'),(158,'10161','ESSAADA','AG','0','161','SA','C2'),(159,'10162','PALMIERS','AG','0','162','SB','C4'),(160,'10163','OULFA SEBOU','AG','0','163','SB','C5'),(161,'10164','LISSASFA','AG','0','164','SB','C5'),(162,'10165','Sidi Moumen','AG','0','165','SB','C12'),(163,'10166','MOULAY RACHID','AG','0','166','SA','C13'),(164,'10167','OUM RABII','AG','0','167','SB','C5'),(165,'10168','AMAR RIFFI','AG','0','168','SC','C3'),(166,'10169','ROND POINT D\'EUROPE','AG','0','169','SC','C3'),(167,'10170','BALADIA','AG','0','170','SB','C12'),(168,'10171','MAKDAD LAHRIZI','AG','0','171','SA','C6'),(169,'10172','MARRAKECH PRINCIPALE','AG','0','172','SE','054'),(170,'10174','Tanger Drissia','AG','0','174','SE','051'),(171,'10175','ESSAOUIRA','AG','0','175','SE','062'),(172,'10177','EL-KALAA DES SRARHNA','AG','0','177','SE','086'),(173,'10178','SALE PLATEAU','AG','0','178','SE','050'),(174,'10179','INARA','AG','0','179','SB','C9'),(175,'10181','HAY CHRIFA','AG','0','181','SB','C9'),(176,'10182','SIDI YOUSSEF BEN ALI','AG','0','182','SE','054'),(177,'10184','SOCRATE','AG','0','184','SC','C11'),(178,'10185','TANGER GZENAYA','AG','0','185','SE','051'),(179,'10186','EL MECHOUAR','AG','0','186','SC','C1'),(180,'10187','RABAT AKKARI','AG','0','187','SE','050'),(181,'10188','AGADIR DCHEIRA','AG','0','188','SE','052'),(182,'10189','EL BATHA','AG','0','189','SC','C11'),(183,'10190','AGADIR HASSAN II','AG','0','190','SE','052'),(184,'10191','SALE KARIA','AG','0','191','SE','050'),(185,'10192','JAWHARA','AG','0','192','SB','C12'),(186,'10193','FES ESSAADA','AG','0','193','SE','053'),(187,'10194','DR AGENCES ELOIGNEES','AG','0','194','',''),(188,'10195','AL BARAKA','AG','0','195','SA','C13'),(189,'10196','LA COLLINE','AG','0','196','SB','C4'),(190,'10197','RABAT HAY RIAD','AG','0','197','SE','050'),(191,'10198','DR CASA OUEST','AG','0','198','SB','C5'),(192,'10199','DR CASA CENTRE','AG','0','199','SA','C2'),(193,'10200','RABAT A.C.P','AG','0','200','SE','050'),(194,'10201','DR CASA EST','AG','0','201','SA','C2'),(195,'10202','LA CORNICHE','AG','0','202','SC','C11'),(196,'10203','TANGER MEXIQUE','AG','0','203','SE','051'),(197,'10204','TIT MELLIL','AG','0','204','SA','C13'),(198,'10205','DR MARRAKECH','AG','0','205','SE','054'),(199,'10206','DR AGADIR','AG','0','206','SE','052'),(200,'10207','DR FES','AG','0','207','SE','053'),(201,'10208','DR TANGER','AG','0','208','SE','051'),(202,'10209','HAY SALAM CASABLANCA','AG','0','209','SB','C5'),(203,'10210','EL JADIDA ESSAADA','AG','0','210','SE','059'),(204,'10211','DR L\'ORIENTAL','AG','0','211','SE','056'),(205,'10212','AGADIR INBIAT','AG','0','212','SE','052'),(206,'10213','TANGER PLACE IBERIA','AG','0','213','SE','051'),(207,'10214','SAAD EL KHEIR','AG','0','214','SB','C5'),(208,'10215','TANGER AL MAJD','AG','0','215','SE','051'),(209,'10216','KENITRA SAKNIA','AG','0','216','SE','058'),(210,'10217','TANGER CASTILLA','AG','0','217','SE','051'),(211,'10218','FAL OULD OUMEIR','AG','0','218','SE','050'),(212,'10219','AGADIR TADDART','AG','0','219','SE','052'),(213,'10220','MAJORELLE','AG','0','220','SE','054'),(214,'10221','HAY SALAM AGADIR','AG','0','221','SE','052'),(215,'10222','TEMARA MASSIRA','AG','0','222','SE','050'),(216,'10223','AGADIR-MASSIRA','AG','0','223','SE','052'),(217,'10224','TAROUDANT MHAITA','AG','0','224','SE','071'),(218,'10225','FNIDEQ','AG','0','225','SE','055'),(219,'10226','Marrakech ALLAL EL FASSI','AG','0','226','SE','054'),(220,'10227','MEKNES MARJANE','AG','0','227','SE','057'),(221,'10228','SIDI MOUMEN AL ADARISSA','AG','0','228','SB','C12'),(222,'10229','BERNOUSSI EL QODS','AG','0','229','SA','C2'),(223,'10230','TANGER PORT','AG','0','230','SE','051'),(224,'10231','TETOUAN PLACE HMAMA','AG','0','231','SE','055'),(225,'10232','FES SAISS','AG','0','232','SE','053'),(226,'10233','Tanger Placa TORO','AG','0','233','SE','051'),(227,'10234','TETOUAN MOHAMED V','AG','0','234','SE','055'),(228,'10235','LAHJAJMA','AG','0','235','SC','C11'),(229,'10236','ENNASSIM','AG','0','236','SB','C4'),(230,'10237','TANGER Quartier Administratif','AG','0','237','SE','051'),(231,'10238','BOUZIANE','AG','0','238','SB','C12'),(232,'10239','RABAT ASWAK ASSALAM','AG','0','239','SE','050'),(233,'10240','SOUHAIB ERROUMI','AG','0','240','SA','C2'),(234,'10241','ZOUBIR','AG','0','241','SB','C5'),(235,'10242','AGADIR AL HOUDA','AG','0','242','SE','052'),(236,'10243','MOUSSA BNOU NOUSSAIR','AG','0','243','SC','C8'),(237,'10244','BIOUGRA','AG','0','244','SE','079'),(238,'10245','TETOUAN BAB OKLA','AG','0','245','SE','055'),(239,'10246','AIT BAHA','AG','0','246','SE','073'),(240,'10247','TANGER ASWAK ASSALAM','AG','0','247','SE','051'),(241,'10248','AGADIR ASWAK ASSALAM','AG','0','248','SE','052'),(242,'10249','TEMARA ASWAK ASSALAM','AG','0','249','SE','050'),(243,'10250','OUJDA ALLAL EL FASSI','AG','0','250','SE','056'),(244,'10251','AEROPORT MOHAMMED V','AG','0','251','SE','094'),(245,'10252','LARACHE AL MAGHRIB AL JADID','AG','0','252','SE','068'),(246,'10253','EL JADIDA RTE DE MARRAKECH','AG','0','253','SE','059'),(247,'10254','OULFA OUED BEHT','AG','0','254','SB','C5'),(248,'10255','TANGER VAL FLEURI','AG','0','255','SE','051'),(249,'10256','BERKANE ANDALOUS','AG','0','256','SE','078'),(250,'10257','OULFA OUED LAOU','AG','0','257','SB','C5'),(251,'10258','SALE SOUANI','AG','0','258','SE','050'),(252,'10259','OUJDA ROUTE TAZA','AG','0','259','SE','056'),(253,'10260','Sidi Maarouf AL Mostaqbal','AG','0','260','SB','C4'),(254,'10261','MEKNES OUALILI','AG','0','261','SE','057'),(255,'10262','MEKNES AL ISMAILIA','AG','0','262','SE','057'),(256,'10263','TETOUAN MHANNECH','AG','0','263','SE','055'),(257,'10264','ERRACHIDIA','AG','0','264','SE','083'),(258,'10265','OUJDA ISLY','AG','0','265','SE','056'),(259,'10266','TEMARA OMAR BNOU KHATTAB','AG','0','266','SE','050'),(260,'10267','MARRAKECH ASWAK ASSALAM','AG','0','267','SE','054'),(261,'10268','OUJDA LAZARET','AG','0','268','SE','056'),(262,'10269','MEKNES RIAD','AG','0','269','SE','057'),(263,'10270','RABAT OCEAN','AG','0','270','SE','050'),(264,'10271','SAFI KENNEDY','AG','0','271','SE','063'),(265,'10272','DEROUA','AG','0','272','SE','106'),(266,'10273','TEMARA HASSAN I','AG','0','273','SE','050'),(267,'10274','KHOURIBGA ZELLAQA','AG','0','274','SE','066'),(268,'10275','ZEGHANGHAN','AG','0','275','SE','105'),(269,'10276','AGADIR  ABDERRAHIM BOUABID','AG','0','276','SE','052'),(270,'10277','AGADIR TIKIOUINE','AG','0','277','SE','052'),(271,'10278','KENITRA OULED OUJIH','AG','0','278','SE','058'),(272,'10279','SAFI DRISS 1ER','AG','0','279','SE','063'),(273,'10280','RABAT MAHAJ RYAD','AG','0','280','SE','050'),(274,'10281','ABDELKADER SAHRAOUI','AG','0','281','SA','C6'),(275,'10282','FES ZALAGH','AG','0','282','SE','053'),(276,'10283','TAOURIRT','AG','0','283','SE','103'),(277,'10284','BENI MELLAL MOHAMED V','AG','0','284','SE','061'),(278,'10285','AGADIR AL MOUKAOUAMA','AG','0','285','SE','052'),(279,'10286','TANGER CALIFORNIA','AG','0','286','SE','051'),(280,'10287','OUJDA AL JAWHARA','AG','0','287','SE','056'),(281,'10288','FES HAY TARIK','AG','0','288','SE','053'),(282,'10289','BEN SLIMANE','AG','0','289','SE','076'),(283,'10290','ESSAOUIRA DRISS 1ER','AG','0','290','SE','062'),(284,'10291','EL JADIDA IBNOU BADIS','AG','0','291','SE','059'),(285,'10292','DRISS EL HARTI FACULTE','AG','0','292','SB','C12'),(286,'10293','FES MONT FLEURI','AG','0','293','SE','053'),(287,'10294','TANGER IBN TACHFINE','AG','0','294','SE','051'),(288,'10295','TAMESNA','AG','0','295','SE','050'),(289,'10296','KENITRA LES MIMOSAS','AG','0','296','SE','058'),(290,'10297','CASA MEHDI BEN BARKA','AG','0','297','SC','C8'),(291,'10298','SKHIRAT','AG','0','298','SE','050'),(292,'10299','BENI MELLAL EL WAFA','AG','0','299','SE','061'),(293,'10300','SALE BETTANA','AG','0','300','SE','050'),(294,'10301','SIDI KACEM','AG','0','301','SE','101'),(295,'10302','FKIH BEN SALAH','AG','0','302','SE','090'),(296,'10303','CASA AIN BOURJA','AG','0','303','SC','C1'),(297,'10304','TANGER MESNANAA','AG','0','304','SE','051'),(298,'10305','CASA SIJILMASSA','AG','0','305','SC','C1'),(299,'10306','OUED ZEM','AG','0','306','SE','096'),(300,'10307','NADOR OULED MIMOUN','AG','0','307','SE','064'),(301,'10308','SAIDIA','AG','0','308','SE','056'),(302,'10309','GUERCIF','AG','0','309','SE','084'),(303,'10310','DRIOUCH','AG','0','310','SE','082'),(304,'10311','TAZA My YOUSSEF','AG','0','311','SE','072'),(305,'10312','SALE INBIAAT','AG','0','312','SE','050'),(306,'10314','MOHAMMEDIA LA RESISTANCE','AG','0','314','SA','C7'),(307,'10315','CASA AZHAR','AG','0','315','SA','C13'),(308,'10316','MARRAKECH MASSIRA KANTARA','AG','0','316','SE','054'),(309,'10317','OULFA MY THAMI','AG','0','317','SB','C5'),(310,'10318','SALA AL JADIDA','AG','0','318','SE','050'),(311,'10319','KENITRA IMAM ALI','AG','0','319','SE','058'),(312,'10320','TEMARA WIFAK','AG','0','320','SE','050'),(313,'10321','TANGER AVENUE DES FAR','AG','0','321','SE','051'),(314,'10322','TANGER MALABATA','AG','0','322','SE','051'),(315,'10323','TEMARA GUICHES OUDAYAS','AG','0','323','SE','050'),(316,'10324','SALE KARIMA','AG','0','324','SE','050'),(317,'10325','NADOR SAKIA AL HAMRA','AG','0','325','SE','064'),(318,'10326','AL QODS HAY MY ABDELLAH','AG','0','326','SB','C9'),(319,'10327','FORCES AUXILIAIRES','AG','0','327','SB','C12'),(320,'10328','MOHAMED ZEFZAF','AG','0','328','SA','C13'),(321,'10329','MOHAMMEDIA RIAD SALAM','AG','0','329','SA','C7'),(322,'10330','SBIT TIT MELLIL','AG','0','330','SA','C13'),(323,'10331','RABAT TAKADDOUM','AG','0','331','SE','050'),(324,'10332','AGADIR TAMDID','AG','0','332','SE','052'),(325,'10333','INEZGANE TARRAST','AG','0','333','SE','052'),(326,'10334','AGADIR HAY MOHAMMEDI','AG','0','334','SE','052'),(327,'10335','SOCIETE GENERALE TECHNOPOLIS','AG','0','335','SE','050'),(328,'10336','FES MOULAY DRISS','AG','0','336','SE','053'),(329,'10337','FES BD EL OUAFA','AG','0','337','SE','053'),(330,'10338','MEKNES QORTOBA','AG','0','338','SE','057'),(331,'10339','SETTAT LALLA AICHA','AG','0','339','SE','067'),(332,'10340','SEBT OULED NEMMA','AG','0','340','SE','098'),(333,'10341','BERRECHID HASSAN II','AG','0','341','SE','060'),(334,'10342','AIT MELLOUL ZONE INDUSTRIELLE','AG','0','342','SE','052'),(335,'10343','MARRAKECH-GARE','AG','0','343','SE','054'),(336,'10344','MARRAKECH IZDIHAR','AG','0','344','SE','054'),(337,'10345','FES BENSOUDA','AG','0','345','SE','053'),(338,'10346','FES NASSIM','AG','0','346','SE','053'),(339,'10347','MARRAKECH ESSAADA','AG','0','347','SE','054'),(340,'10348','FES ROUTE AIN CHKEF','AG','0','348','SE','053'),(341,'10349','AGADIR BENSERGAOU','AG','0','349','SE','052'),(342,'10350','GUELMIM','AG','0','350','SE','069'),(343,'10351','ANASSI','AG','0','351','SA','C13'),(344,'10352','EL JADIDA MOUILHA','AG','0','352','SE','059'),(345,'10353','AZEMMOUR','AG','0','353','SE','075'),(346,'10354','SALE HSSAINE','AG','0','354','SE','050'),(347,'10355','MADINAT ERRAHMA','AG','0','355','SB','C5'),(348,'10356','TANGER DRADEB','AG','0','356','SE','051'),(349,'10357','SIDI OTHMANE PREFECTURE','AG','0','357','SA','C6'),(350,'10358','AL HAMD','AG','0','358','SB','C12'),(351,'10359','AL QODS OULAD TALEB','AG','0','359','SB','C9'),(352,'10360','CASANEARSHORE','AG','0','360','SB','C4'),(353,'10361','SIDI BENNOUR','AG','0','361','SE','100'),(354,'10362','HAD SOUALEM','AG','0','362','SE','085'),(355,'10363','SALE CHMAOU','AG','0','363','SE','050'),(356,'10364','TANGER MY YOUSSEF','AG','0','364','SE','051'),(357,'10365','TAH','AG','0','365','SB','C9'),(358,'10366','MARRAKECH AZLI','AG','0','366','SE','054'),(359,'10367','MARRAKECH ROUTE TARGA','AG','0','367','SE','054'),(360,'10368','KSAR LEKBIR','AG','0','368','SE','091'),(361,'10369','MARTIL HASSAN II','AG','0','369','SE','055'),(362,'10370','TETOUAN BOUJARRAH','AG','0','370','SE','055'),(363,'10371','SEFROU','AG','0','371','SE','099'),(364,'10372','FOUARATE','AG','0','372','SC','C1'),(365,'10373','AHL LOUGHLAM','AG','0','373','SA','C13'),(366,'10374','AGADIR BOUARGANE','AG','0','374','SE','052'),(367,'10375','BENGUERIR','AG','0','375','SE','077'),(368,'10376','FES MED VI','AG','0','376','SE','053'),(369,'10377','KHENIFRA','AG','0','377','SE','089'),(370,'10378','AGADIR DCHIERA AL JIHADIA','AG','0','378','SE','052'),(371,'10379','AGADIR AL QODS','AG','0','379','SE','052'),(372,'10380','CHEFCHAOUNI','AG','0','380','SA','C2'),(373,'10381','AZROU','AG','0','381','SE','107'),(374,'10382','TANGER AOUAMA','AG','0','382','SE','051'),(375,'10383','CHAOUEN','AG','0','383','SE','081'),(376,'10384','M\'HAMID AL MATAR','AG','0','384','SE','054'),(377,'10385','OUJDA BAB SIDI ABDELOUAHAB','AG','0','385','SE','056'),(378,'10386','IHCHACH AGADIR','AG','0','386','SE','052'),(379,'10387','M\'HAMID ATLAS','AG','0','387','SE','054'),(380,'10388','BEN SLIMANE EXTENTION','AG','0','388','SE','076'),(381,'10389','BOUZNIKA','AG','0','389','SE','080'),(382,'10390','OUAHDA IFRIQUIA','AG','0','390','SA','C6'),(383,'10391','CASA AL MANZAH','AG','0','391','SB','C12'),(384,'10392','TIZNIT HASSAN II','AG','0','392','SE','065'),(385,'10393','RABAT QUARTIER HASSAN','AG','0','393','SE','050'),(386,'10394','DCHAR BENDIBANE','AG','0','394','SE','051'),(387,'10395','DERB OMAR','AG','0','395','SC','C1'),(388,'10396','SOUANI','AG','0','396','SE','051'),(389,'10397','AGADIR RUE DE MARRAKECH','AG','0','397','SE','052'),(390,'10398','LAAYOUNE Mohamed VI','AG','0','398','SE','070'),(391,'10399','AGADIR TILILA','AG','0','399','SE','052'),(392,'10400','AGADIR MASJID MOHAMMADI','AG','0','400','SE','052'),(393,'10401','AIN SEBAA GARE','AG','0','401','SA','C2'),(394,'10402','KENITRA LA GARE','AG','0','402','SE','058'),(395,'10403','GUELMIM OUED NOUN','AG','0','403','SE','069'),(396,'10404','RABAT HAY NAHDA','AG','0','404','SE','050'),(397,'10405','MCH HAY MOHAMMADI','AG','0','405','SE','054'),(398,'10406','B. MELLAL 20AOUT','AG','0','406','SE','061'),(399,'10407','ESSAOUIRA EL AKABA','AG','0','407','SE','062'),(400,'10408','MASSIRA EL BAHIA','AG','0','408','SE','054'),(401,'10409','AGADIR IBNOU ZOHR','AG','0','409','SE','052'),(402,'10410','CHOUHADA','AG','0','410','SC','C1'),(403,'10411','TARIK AL KHAYR','AG','0','411','SA','C13'),(404,'10412','ABOUAB MARRAKECH','AG','0','412','SE','054'),(405,'10413','DAKHLA','AG','0','413','SE','108'),(406,'10414','AL MASSAR','AG','0','414','SE','054'),(407,'10415','RIAD ESSALAM','AG','0','415','SE','052'),(408,'10416','BOUSKOURA OULED SALAH','AG','0','416','SE','109'),(409,'10417','AIT MELLOUL AL FATH','AG','0','417','SE','052'),(410,'10418','OULFA AL AZHAR','AG','0','418','SB','C5'),(411,'10419','Mohammedia Bd Sebta','AG','0','419','SA','C7'),(412,'10420','EL JADIDA KHALIL JABRANE','AG','0','420','SE','059'),(413,'10421','AGADIR 11 JANVIER','AG','0','421','SE','052'),(414,'10422','MARRAKECH PALESTINE','AG','0','422','SE','054'),(415,'10423','KHOURIBGA MED VI','AG','0','423','SE','066'),(416,'10424','El Kalaa des Sraghnas Bd Far','AG','0','424','SE','086'),(417,'10425','Mohammedia Le Parc','AG','0','425','SA','C7'),(418,'10426','Bd d\'Anfa','AG','0','426','SC','C8'),(419,'10427','Kenitra Route de SIDI YAHIA','AG','0','427',NULL,NULL),(420,'10700','BERRECHID ETTAKADOUM','AG','0','700','SE','060'),(421,'10701','MARRAKECH SIDI GHANEM','AG','0','701','SE','054'),(422,'10702','JURA','AG','0','702','SC','C11'),(423,'10703','FES MERINIDES','AG','0','703','SE','053'),(424,'10704','DERB MY CHERIF','AG','0','704','SC','C1'),(425,'10705','MARRAKECH SIDI M\'BAREK','AG','0','705','SE','054'),(426,'10706','OULFA HAJ FATEH','AG','0','706','SB','C5'),(427,'10707','SBATA','AG','0','707','SA','C6'),(428,'10708','SALE MY ISMAIL','AG','0','708','SE','050'),(429,'10709','SALE RAHMA','AG','0','709','SE','050'),(430,'10710','CASA REDA GUEDIRA','AG','0','710','SA','C6'),(431,'10711','CASA JOULANE','AG','0','711','SA','C6'),(432,'10712','CASA JAMILA','AG','0','712','SA','C6'),(433,'10713','ATTACHAROUK','AG','0','713','SA','C13'),(434,'10714','KENITRA LA VILLE HAUTE','AG','0','714','SE','058'),(435,'10800','BUREAU DE CHANGE TANGER LIBERT','AG','0','800',NULL,NULL),(436,'10801','BUREAU DE CHANGE MEDINA','AG','0','801',NULL,NULL),(437,'10850','Direction Banque Privée SGMA','AG','0','850',NULL,NULL),(438,'10851','AgenceBanque Privée Casa Ouest','AG','0','851','SD','CSG'),(439,'10852','Agence Banq privée Casa Centre','AG','0','852','SC','C11'),(440,'10853','Agence Banq privée Casa Est','AG','0','853','SA','C2'),(441,'10854','Agence Banque Privée RABAT','AG','0','854','SE','050'),(442,'10855','Agence Banque Privée MARRAKECH','AG','0','855','SE','054'),(443,'10856','Agence Banque Privée TANGER','AG','0','856','SE','051'),(444,'10857','Agence Banque Privée FES','AG','0','857','SE','053'),(445,'10858','Agence Banque Privée AGADIR','AG','0','858','SE','052'),(446,'10902','SOGEFACTORING','AG','0','902','SD','CSG'),(447,'10903','Service Clients Central','AG','0','903','SD','CSG'),(448,'10904','DR Service Clients Central','AG','0','904',NULL,NULL);
/*!40000 ALTER TABLE `te_pacapt_sgma` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `te_report_sgda`
--

DROP TABLE IF EXISTS `te_report_sgda`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `te_report_sgda` (
  `idR` bigint(20) NOT NULL AUTO_INCREMENT,
  `Id_report` varchar(255) DEFAULT NULL,
  `descreption` varchar(255) DEFAULT NULL,
  `modeleJRXML` varchar(255) DEFAULT NULL,
  `Requete` varchar(500) DEFAULT NULL,
  `typeGeneration` varchar(45) DEFAULT NULL,
  `active` tinyint(1) NOT NULL,
  `idT` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`idR`),
  KEY `FK91B14154DAB031B2` (`idT`),
  CONSTRAINT `FK91B14154DAB031B9` FOREIGN KEY (`idT`) REFERENCES `te_traitement_sgda` (`idT`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `te_report_sgda`
--

LOCK TABLES `te_report_sgda` WRITE;
/*!40000 ALTER TABLE `te_report_sgda` DISABLE KEYS */;
INSERT INTO `te_report_sgda` VALUES (1,'ETA_REM_CHQ_VF','Etat des remises chèque avec vices de forme','/jrxml/sgda/Etats/CHQ/ETA_CHQ_VF.jasper',NULL,'PDF',1,1),(2,'ETA_REM_CHQ_ANO','Etat des remises chèque en anomalie ','/jrxml/sgda/Etats/CHQ/ETA_CHQ_ANO.jasper',NULL,'PDF',1,1),(3,'ETA_REJ_TECH_CHQ','Etat des rejets techniques par agence','/jrxml/sgda/Etats/CHQ/ETA_CHQ_REJ_TECH.jasper',NULL,'PDF',1,1),(4,'ETA_AGE_REM_CHQ','Etat récapitulatif des remisesCHQ traitées AG','/jrxml/sgda/Etats/CHQ/ETA_CHQ_RECAP_BY_AG.jasper',NULL,'PDF',1,1),(5,'ETA_ALL_REJ_TECH_CHQ_CRT','Etat consolidé des rejets techniques','/jrxml/sgda/Etats/CHQ/CRT/ETA_CHQ_REJ_TECH_CRT.jasper',NULL,'PDF',1,2),(6,'ETA_ALL_REM_CHQ_VF_CRT','Etat consolidé des remises chèque avec vices de forme','/jrxml/sgda/Etats/CHQ/CRT/ETA_CHQ_VF_CRT.jasper',NULL,'PDF',1,2),(7,'ETA_ALL_REM_CHQ_ANO_CRT','Etat consolidé des remises chèque en anomalie','/jrxml/sgda/Etats/CHQ/CRT/ETA_CHQ_ANO_CRT.jasper',NULL,'PDF',1,2),(8,'ETA_RECAP_CHQ_BY_AGE_CRT','Etat récapitulatif par agence de traitement','/jrxml/sgda/Etats/CHQ/CRT/ETA_CHQ_RECAP_BY_AG_CRT.jasper',NULL,'PDF',1,2);
/*!40000 ALTER TABLE `te_report_sgda` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `te_report_sgma`
--

DROP TABLE IF EXISTS `te_report_sgma`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `te_report_sgma` (
  `idR` bigint(20) NOT NULL AUTO_INCREMENT,
  `Id_report` varchar(255) DEFAULT NULL,
  `descreption` varchar(255) DEFAULT NULL,
  `modeleJRXML` varchar(255) DEFAULT NULL,
  `Requete` varchar(500) DEFAULT NULL,
  `typeGeneration` varchar(45) DEFAULT NULL,
  `active` tinyint(1) NOT NULL,
  `idT` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`idR`),
  KEY `FK91B14154DAB031B2` (`idT`),
  CONSTRAINT `FK91B14154DAB031B2` FOREIGN KEY (`idT`) REFERENCES `te_traitement_sgma` (`idT`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `te_report_sgma`
--

LOCK TABLES `te_report_sgma` WRITE;
/*!40000 ALTER TABLE `te_report_sgma` DISABLE KEYS */;
INSERT INTO `te_report_sgma` VALUES (1,'ETA_REM_CHQ_VF','Etat des remises chèque avec vices de forme','/jrxml/sgma/Etats/CHQ/ETA_CHQ_VF.jasper',NULL,'PDF',1,1),(2,'ETA_REM_CHQ_ANO','Etat des remises chèque en anomalie ','/jrxml/sgma/Etats/CHQ/ETA_CHQ_ANO.jasper',NULL,'PDF',1,1),(3,'ETA_REJ_TECH_CHQ','Etat des rejets techniques par agence','/jrxml/sgma/Etats/CHQ/ETA_CHQ_REJ_TECH.jasper',NULL,'PDF',1,1),(4,'ETA_RECAP_REM_CHQ_ANO','Etat récaputilatif des remises chèques en anomalie','/jrxml/sgma/Etats/CHQ/ETA_CHQ_REM_ANO.jasper',NULL,'PDF',0,1),(5,'ETA_REM_CHQ_GR_ANN','Etat des remises annulées des clients GRMT rattachés à l\'agence','/jrxml/sgma/Etats/CHQ/ETA_CHQ_ANO_GR_ATTACH_AGE.jasper',NULL,'PDF',0,1),(6,'ETA_REM_CHQ_VF','Etat des remises chèque avec vices de forme GR','/jrxml/sgma/Etats/CHQ/ETA_CHQ_VF.jasper',NULL,'PDF',1,2),(7,'ETA_REM_CHQ_ANO','Etat des remises chèque en anomalie GR','/jrxml/sgma/Etats/CHQ/ETA_CHQ_ANO.jasper',NULL,'PDF',1,2),(8,'ETA_CHQ_REJ_TECH_GR','Etat detaillé des remises chèque avec rejets techniques','/jrxml/sgma/Etats/CHQ/ETA_CHQ_REJ_TECH.jasper',NULL,'PDF',1,2),(9,'ETA_CHQ_REM_ANO_GR','Etat récaputilatif des remises chèques en anomalie','/jrxml/sgma/Etats/CHQ/ETA_CHQ_REM_ANO.jasper',NULL,'PDF',0,2),(10,'ETA_ALL_REJ_TECH_CHQ_CRT','Etat consolidé des rejets techniques','/jrxml/sgma/Etats/CHQ/CRT/ETA_CHQ_REJ_TECH_CRT.jasper',NULL,'PDF',1,3),(12,'ETA_ALL_REM_CHQ_VF_CRT','Etat consolidé des remises chèque avec vices de forme','/jrxml/sgma/Etats/CHQ/CRT/ETA_CHQ_VF_CRT.jasper',NULL,'PDF',1,3),(13,'ETA_ALL_REM_CHQ_ANO_CRT','Etat consolidé des remises chèque en anomalie','/jrxml/sgma/Etats/CHQ/CRT/ETA_CHQ_ANO_CRT.jasper',NULL,'PDF',1,3),(14,'ETA_RECAP_CHQ_BY_AGE_CRT','Etat récapitulatif par agence de traitement','/jrxml/sgma/Etats/CHQ/CRT/ETA_CHQ_RECAP_BY_AG_CRT.jasper',NULL,'PDF',1,3),(15,'ETA_DETAIL_IMP_CHQ','Etat détaillé des impayés chèque par agence de numérisation','/jrxml/sgma/Impayees/CHQ/ETAT_IMPAYES_CHQ_BY_PCAP.jasper',NULL,'PDF',1,4),(16,'ETA_DETAIL_IMP_CHQ','Etat détaillé des impayés chèque par agence de numérisation GR','./jrxml/Impayees/CHQ/ETAT_IMPAYES_CHQ_BY_PCAP.jrxml',NULL,'PDF',0,5),(17,'ETA_REM_LCN_VF','Etat des remises chèque avec vices de forme','/jrxml/sgma/Etats/LCN/ETA_LCN_VF.jasper',NULL,'PDF',1,7),(18,'ETA_REM_LCN_ANO','Etat des remises chèque en anomalie ','/jrxml/sgma/Etats//LCN/ETA_LCN_ANO.jasper',NULL,'PDF',1,7),(19,'ETA_REJ_TECH_LCN','Etat des rejets techniques par agence','/jrxml/sgma/Etats/LCN/ETA_LCN_REJ_TECH.jasper',NULL,'PDF',1,7),(20,'ETA_RECAP_REM_LCN_ANO','Etat récaputilatif des remises lcn en anomalie','/jrxml/sgma/Etats/LCN/ETA_LCN_REM_ANO.jrxml',NULL,'PDF',0,7),(21,'ETA_REM_LCN_ANN_GR','Etat des remises annulées des clients GRMT rattachés à l\'agence','/jrxml/sgma/Etats/LCN/ETA_LCN_ANO_GR_ATTACH_AGE.jrxml',NULL,'PDF',0,7),(22,'ETA_REM_LCN_VF','Etat des remises chèque avec vices de forme GR','/jrxml/sgma/Etats/LCN/ETA_LCN_VF.jasper',NULL,'PDF',1,8),(23,'ETA_REM_LCN_ANO','Etat des remises chèque en anomalie GR','/jrxml/sgma/Etats/LCN/ETA_LCN_ANO.jasper',NULL,'PDF',1,8),(24,'ETA_LCN_REJ_TECH_GR','Etat detaillé des remises chèque avec rejets techniques','/jrxml/sgma/Etats/LCN/ETA_LCN_REJ_TECH.jasper',NULL,'PDF',1,8),(25,'ETA_LCN_REM_ANO','Etat récaputilatif des remises chèques en anomalie','/jrxml/sgma/Etats/LCN/ETA_LCN_REM_ANO.jasper',NULL,'PDF',0,8),(26,'ETA_ALL_REJ_TECH_LCN_CRT','Etat consolidé des rejets techniques','/jrxml/sgma/Etats/LCN/CRT/ETA_LCN_REJ_TECH_CRT.jasper',NULL,'PDF',1,9),(27,'ETA_ALL_REM_LCN_VF_CRT','Etat consolidé des remises chèque avec vices de forme','/jrxml/sgma/Etats/LCN/CRT/ETA_LCN_VF_CRT.jasper',NULL,'PDF',1,9),(28,'ETA_ALL_REM_LCN_ANO_CRT','Etat consolidé des remises chèque en anomalie','/jrxml/sgma/Etats/LCN/CRT/ETA_LCN_ANO_CRT.jasper',NULL,'PDF',1,9),(29,'ETA_RECAP_LCN_BY_AGE_CRT','Etat récapitulatif par agence de traitement','/jrxml/sgma/Etats/LCN/CRT/ETA_LCN_RECAP_BY_AG_CRT.jasper',NULL,'PDF',1,9),(30,'ETA_DETAIL_IMP_CHQ','Etat détaillé des impayés chèque par agence de numérisation','./jrxml/Impayees/CHQ/ETAT_IMPAYES_CHQ_BY_PCAP.jrxml',NULL,'PDF',0,4),(31,'ETA_DETAIL_IMP_CHQ','Etat détaillé des impayés chèque par agence de numérisation GR','./jrxml/Impayees/CHQ/ETAT_IMPAYES_CHQ_BY_PCAP.jrxml',NULL,'PDF',0,5),(32,'ETA_DETAIL_IMP_LCN','Etat détaillé des impayés LCN par agence de numérisation','/jrxml/sgma/Impayees/LCN/ETAT_IMPAYES_LCN_BY_PCAP.jasper',NULL,'PDF',1,10),(33,'ETA_LCN_ECHUES','Etat détaillé des LCN echues','/jrxml/sgma/Etats/LCN/ETA_LCN_ECHUES.jrxml',NULL,'PDF',0,7),(34,'ETA_LCN_ECHUES','Etat détaillé des LCN echues GR','/jrxml/sgma/Etats/LCN/ETA_LCN_ECHUES.jrxml',NULL,'PDF',0,8),(35,'ETA_LCN_A_CONSERVER','Etat détaillé des LCN à conserver','/jrxml/sgma/Etats/LCN/ETA_LCN_A_CONSERVER.jasper',NULL,'PDF',1,7),(36,'ETA_LCN_A_CONSERVER','Etat détaillé des LCN à conserver GR','/jrxml/sgma/Etats/LCN/ETA_LCN_A_CONSERVER.jasper',NULL,'PDF',1,8),(37,'ETA_AGE_REM_LCN','Etat récapitulatif des remises LCN traitées','/jrxml/sgma/Etats/LCN/ETA_LCN_RECAP_BY_AG.jasper',NULL,'PDF',1,7),(38,'ETA_AGE_REM_LCN','Etat récapitulatif des remises LCN traitées','/jrxml/sgma/Etats/LCN/ETA_LCN_RECAP_BY_AG.jasper',NULL,'PDF',1,8),(39,'ETA_AGE_REM_CHQ','Etat récapitulatif des remisesCHQ traitées AG','/jrxml/sgma/Etats/CHQ/ETA_CHQ_RECAP_BY_AG.jasper',NULL,'PDF',1,1),(40,'ETA_AGE_REM_CHQ','Etat récapitulatif des remisesCHQ traitées GR','/jrxml/sgma/Etats/CHQ/ETA_CHQ_RECAP_BY_AG.jasper',NULL,'PDF',1,2),(41,'ETA_LCN_A_CONSERVER_CRT','Etat détaillé des LCN à conserver CRT','/jrxml/sgma/Etats/LCN/CRT/ETA_LCN_A_CONSERVER.jasper',NULL,'PDF',1,9),(42,'ETA_RECAP_LCN_A_CONSERVER_CRT','Etat Recap des LCN à conserver CRT','/jrxml/sgma/Etats/LCN/CRT/ETA_REC_LCN_A_CONSERVER.jasper',NULL,'PDF',1,9);
/*!40000 ALTER TABLE `te_report_sgma` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `te_traitement_sgda`
--

DROP TABLE IF EXISTS `te_traitement_sgda`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `te_traitement_sgda` (
  `idT` bigint(20) NOT NULL AUTO_INCREMENT,
  `nom_Traitement` varchar(255) DEFAULT NULL,
  `Description` varchar(255) DEFAULT NULL,
  `DossierEnre` varchar(255) DEFAULT NULL,
  `Destinataire` varchar(45) DEFAULT NULL,
  `active` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`idT`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `te_traitement_sgda`
--

LOCK TABLES `te_traitement_sgda` WRITE;
/*!40000 ALTER TABLE `te_traitement_sgda` DISABLE KEYS */;
INSERT INTO `te_traitement_sgda` VALUES (1,'ETA_CHQ_SGDA_AG','Etats Cheque ALLER SGDA AG','G:\\sorties\\SGMA\\editions\\','ETA_AG',1),(2,'ETA_CHQ_SGDA_CRT','Etats Cheque ALLER SGDA CRT','G:\\sorties\\SGMA\\editions\\','ETA_CRT',1);
/*!40000 ALTER TABLE `te_traitement_sgda` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `te_traitement_sgma`
--

DROP TABLE IF EXISTS `te_traitement_sgma`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `te_traitement_sgma` (
  `idT` bigint(20) NOT NULL AUTO_INCREMENT,
  `nom_Traitement` varchar(255) DEFAULT NULL,
  `Description` varchar(255) DEFAULT NULL,
  `DossierEnre` varchar(255) DEFAULT NULL,
  `Destinataire` varchar(45) DEFAULT NULL,
  `active` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`idT`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `te_traitement_sgma`
--

LOCK TABLES `te_traitement_sgma` WRITE;
/*!40000 ALTER TABLE `te_traitement_sgma` DISABLE KEYS */;
INSERT INTO `te_traitement_sgma` VALUES (1,'ETA_CHQ_SGMA_AG','Etats Cheque ALLER SGMA AG','\\\\172.17.0.151\\sorties\\SGMA\\editions\\','ETA_AG',1),(2,'ETA_CHQ_SGMA_GR','Etats Cheque ALLER SGMA GR','\\\\172.17.0.151\\sorties\\SGMA\\editions\\','ETA_GR',0),(3,'ETA_CHQ_SGMA_CRT','Etats Cheque ALLER SGMA CRT','\\\\172.17.0.151\\sorties\\SGMA\\editions\\','ETA_CRT',1),(4,'IMP_CHQ_SGMA_AG','Etats Cheque ALLER SGMA AG','\\\\172.17.0.151\\sorties\\SGMA\\editions\\','IMP_AG',1),(5,'IMP_CHQ_SGMA_GR','Etats Cheque ALLER SGMA GR','\\\\172.17.0.151\\sorties\\SGMA\\editions\\','IMP_GR',0),(6,'IMP_CHQ_SGMA_CRT','Etats Cheque ALLER SGMA CRT','\\\\172.17.0.151\\sorties\\SGMA\\editions\\','IMP_CRT',0),(7,'ETA_LCN_SGMA_AG','Etats LCN ALLER SGMA AG','\\\\172.17.0.151\\sorties\\SGMA\\editions\\','ETA_AG',1),(8,'ETA_LCN_SGMA_GR','Etats LCN ALLER SGMA GR','\\\\172.17.0.151\\sorties\\SGMA\\editions\\','ETA_AG',0),(9,'ETA_LCN_SGMA_CRT','Etats LCN ALLER SGMA CRT','\\\\172.17.0.151\\sorties\\SGMA\\editions\\','ETA_CRT',1),(10,'IMP_LCN_SGMA_AG','IMPAYEE LCN  SGMA AG','\\\\172.17.0.151\\sorties\\SGMA\\editions\\','IMP_AG',1),(11,'IMP_LCN_SGMA_GR','IMPAYEE LCN  SGMA GR','G:\\sorties\\SGMA\\editions','IMP_GR',0);
/*!40000 ALTER TABLE `te_traitement_sgma` ENABLE KEYS */;
UNLOCK TABLES;

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
INSERT INTO `tmp_tbl_eta_chq_baa` VALUES (309,'2017-08-02','AGENCE CASABLANCA','I','','','','0.000','0','45000','45000','','I','','','','1','1234569','45000','100.00','0000021040100063',1,'1','I',2,'01000','','','','END_TRT',305,'I','','','','','','0001000009012123','0001000009012123','0','2017-08-02','0','0','','780','',100,'4155925','74','045MAD00100120170803010000000051','',3,'022','S.G.M.B','022780','','','1','2017-08-02','','','','','');
/*!40000 ALTER TABLE `tmp_tbl_eta_chq_baa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tmp_tbl_eta_chq_baa_lcn`
--

DROP TABLE IF EXISTS `tmp_tbl_eta_chq_baa_lcn`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tmp_tbl_eta_chq_baa_lcn` (
  `bmlcn_pk_obj_idt` int(11) NOT NULL,
  `DATE` date DEFAULT NULL,
  `age_r_lib` char(32) DEFAULT NULL COMMENT 'Libelle de l agence',
  `bq_lib` varchar(45) DEFAULT NULL,
  `bmtn_OPE_ETA` varchar(1) CHARACTER SET utf8 NOT NULL,
  `bmtn_ANO` text CHARACTER SET utf8,
  `bmtn_COUNT_CHQ` varchar(5) CHARACTER SET utf8 DEFAULT NULL,
  `bmtn_DIFF` varchar(15) CHARACTER SET utf8 DEFAULT NULL,
  `bmtn_DIFF_NB` varchar(5) CHARACTER SET utf8 DEFAULT NULL,
  `bmtn_LECTEUR` varchar(5) CHARACTER SET utf8 DEFAULT NULL,
  `bmtn_SUM_CHQ` varchar(15) CHARACTER SET utf8 DEFAULT NULL,
  `bmta_OPE_ETA` varchar(1) CHARACTER SET utf8 NOT NULL,
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
  `bmtr_REFCLI` varchar(12) CHARACTER SET utf8 DEFAULT NULL,
  `bmtr_ANO` text CHARACTER SET utf8,
  `bmlcn_fk_ope_mne` varchar(12) CHARACTER SET utf8 DEFAULT NULL,
  `bmlcn_instance` int(11) NOT NULL,
  `bmlcn_ope_eta` varchar(1) CHARACTER SET utf8 NOT NULL,
  `bmlcn_AGE` varchar(3) CHARACTER SET utf8 DEFAULT NULL,
  `bmlcn_zbk` varchar(3) CHARACTER SET utf8 DEFAULT NULL,
  `bmlcn_CDE_REJ` varchar(3) CHARACTER SET utf8 DEFAULT NULL,
  `bmlcn_CPT` varchar(16) CHARACTER SET utf8 DEFAULT NULL,
  `bmlcn_DBLT` varchar(1) CHARACTER SET utf8 DEFAULT NULL,
  `bmlcn_DTEEMI` varchar(10) CHARACTER SET utf8 DEFAULT NULL,
  `bmlcn_FLAG_REJET` varchar(1) CHARACTER SET utf8 DEFAULT NULL,
  `bmlcn_LOC` varchar(3) CHARACTER SET utf8 DEFAULT NULL,
  `bmlcn_MEM2` varchar(5) CHARACTER SET utf8 DEFAULT NULL,
  `bmlcn_MNT` double DEFAULT NULL,
  `bmlcn_NSER` varchar(7) CHARACTER SET utf8 DEFAULT NULL,
  `bmlcn_RIB` varchar(2) CHARACTER SET utf8 DEFAULT NULL,
  `bmlcn_RSOC_TIR` varchar(35) CHARACTER SET utf8 DEFAULT NULL,
  `bmlcn_SQCA` double DEFAULT NULL,
  `bmlcn_ZIB` varchar(6) CHARACTER SET utf8 DEFAULT NULL,
  `bmlcn_ANO` text CHARACTER SET utf8,
  `bmlcn_CONF` varchar(1) CHARACTER SET utf8 DEFAULT NULL,
  `bmlcn_VICE` text CHARACTER SET utf8,
  `bmlcn_SIGN` varchar(1) CHARACTER SET utf8 DEFAULT NULL,
  `bmlcn_AGE_RMT` varchar(5) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`bmlcn_pk_obj_idt`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tmp_tbl_eta_chq_baa_lcn`
--

LOCK TABLES `tmp_tbl_eta_chq_baa_lcn` WRITE;
/*!40000 ALTER TABLE `tmp_tbl_eta_chq_baa_lcn` DISABLE KEYS */;
/*!40000 ALTER TABLE `tmp_tbl_eta_chq_baa_lcn` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tmp_tbl_eta_chq_sgda`
--

DROP TABLE IF EXISTS `tmp_tbl_eta_chq_sgda`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tmp_tbl_eta_chq_sgda` (
  `pk_obj_idt_Chq` int(11) NOT NULL DEFAULT '0',
  `BMCH_CPT` varchar(16) DEFAULT NULL,
  `DTEMI` varchar(10) DEFAULT NULL,
  `BMCH_LOC` char(3) DEFAULT NULL,
  `BMCH_ZBK` char(3) DEFAULT NULL,
  `Bmch_ZBK_lib` varchar(45) DEFAULT NULL,
  `BMCH_NSER` varchar(7) DEFAULT NULL,
  `BMCH_RIB` char(2) DEFAULT NULL,
  `BMCH_CONF` char(1) DEFAULT NULL,
  `BMCH_CODE_ERREURS` varchar(45) DEFAULT NULL,
  `BMCH_ope_eta` char(1) NOT NULL DEFAULT '',
  `BMCH_ANO` text,
  `BMCH_MNT` varchar(15) DEFAULT NULL,
  `BMCH_FLAG_IMP` char(1) DEFAULT NULL,
  `BMCH_FLAG_REJET` char(1) DEFAULT NULL,
  `BMCH_FLAG_SCAN_GR` varchar(1) DEFAULT NULL,
  `bmch_SQCA` varchar(10) DEFAULT NULL,
  `bmch_ID_WEBCAPTUR` varchar(10) DEFAULT NULL,
  `bmch_AGE_SCAN` varchar(5) DEFAULT NULL,
  `BMTR_age` char(5) DEFAULT NULL,
  `ageTr_lib` varchar(32) DEFAULT NULL,
  `BMTR_ope_eta` char(1) NOT NULL DEFAULT '',
  `BMTR_Ano` text,
  `BMTR_Flag_Rejet` char(1) DEFAULT NULL,
  `BMTR_mode` char(1) DEFAULT NULL,
  `BMTR_MNT` varchar(15) DEFAULT NULL,
  `BMTR_CPT` varchar(9) DEFAULT NULL,
  `BMTR_RIB` char(2) DEFAULT NULL,
  `BMTR_loc` char(3) DEFAULT NULL,
  `BMTR_zbk` char(3) DEFAULT NULL,
  `BMTR_NSER` varchar(7) DEFAULT NULL,
  `BMTR_NBCH` varchar(4) DEFAULT NULL,
  `bmtr_ID_WEBCAPTUR` varchar(10) DEFAULT NULL,
  `bmtr_AGE_SCAN` varchar(5) DEFAULT NULL,
  `bmtr_SECTEUR` varchar(3) DEFAULT NULL,
  `BMTa_ope_eta` char(1) NOT NULL DEFAULT '',
  `BMTa_Ano` text,
  `BMTa_Flag_Rejet` char(1) DEFAULT NULL,
  `BMTa_mode` char(1) DEFAULT NULL,
  `BMTa_MNTR` varchar(15) DEFAULT NULL,
  `BMTA_MNTREM` varchar(15) DEFAULT NULL,
  `BMTA_MNT_DIFF` varchar(15) DEFAULT NULL,
  `BMTA_DIFF_NB` varchar(5) DEFAULT NULL,
  `BMTA_NSER_TA` varchar(7) DEFAULT NULL,
  `BMTA_CPT` varchar(9) DEFAULT NULL,
  `BMTA_NSER` varchar(7) DEFAULT NULL,
  `BMTA_COUNT_REM` varchar(5) DEFAULT NULL,
  `BMTA_age` char(5) DEFAULT NULL,
  `BMTN_Ano` text,
  `BMTN_ope_eta` char(1) NOT NULL DEFAULT '',
  `BMTN_DIFF` varchar(15) DEFAULT NULL,
  `BMTN_DIFF_NB` varchar(5) DEFAULT NULL,
  `BMTN_sum_chq` varchar(15) DEFAULT NULL,
  `BMTN_lecteur` varchar(5) DEFAULT NULL,
  `DATE` date DEFAULT NULL,
  `BMCH_REJET_DELTA` char(1) DEFAULT NULL,
  `bmch_sign` char(1) DEFAULT NULL,
  `BMCH_ANO_LIB` text,
  `BMTR_ANO_LIB` varchar(45) DEFAULT NULL,
  `BMTa_Ano_lib` varchar(45) DEFAULT NULL,
  `BMTN_ANO_LIB` varchar(45) DEFAULT NULL,
  `BMCH_RIO` varchar(45) DEFAULT NULL,
  `pk_obj_idt_rem` varchar(12) DEFAULT NULL,
  PRIMARY KEY (`pk_obj_idt_Chq`),
  KEY `IDX_pk_obj_idt_chq` (`pk_obj_idt_Chq`),
  KEY `IDX_pk_obj_idt_rem` (`pk_obj_idt_rem`),
  KEY `IDX_date` (`DATE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tmp_tbl_eta_chq_sgda`
--

LOCK TABLES `tmp_tbl_eta_chq_sgda` WRITE;
/*!40000 ALTER TABLE `tmp_tbl_eta_chq_sgda` DISABLE KEYS */;
INSERT INTO `tmp_tbl_eta_chq_sgda` VALUES (559,'0004995000170003','2017-10-30','010','007','A.W.B','2582178','82','1',NULL,'I','','937.97','0','0','0','3','0','100','10003','AGENCE AGADIR HASSAN II','I','','0','1','3774.13',NULL,NULL,NULL,NULL,'0000365','3','0','10003',NULL,'I','',NULL,NULL,NULL,NULL,'0.000','2','0002364',NULL,'0002364',NULL,'10003','','I','0.000','0',NULL,'10003','2017-10-30','','0','','','',NULL,'363MAD00100120171031367799991673','558'),(560,'0004995000170002','2017-10-30','010','007','A.W.B','2626342','85','1',NULL,'I','','2249.93','0','0','0','4','0','100','10003','AGENCE AGADIR HASSAN II','I','','0','1','3774.13',NULL,NULL,NULL,NULL,'0000365','3','0','10003',NULL,'I','',NULL,NULL,NULL,NULL,'0.000','2','0002364',NULL,'0002364',NULL,'10003','','I','0.000','0',NULL,'10003','2017-10-30','','0','','','',NULL,'363MAD00100120171031523423340761','558'),(561,'0004995000170003','2017-10-30','010','007','A.W.B','2582170','82','1',NULL,'I','','586.23','0','0','0','5','0','100','10003','AGENCE AGADIR HASSAN II','I','','0','1','3774.13',NULL,NULL,NULL,NULL,'0000365','3','0','10003',NULL,'I','',NULL,NULL,NULL,NULL,'0.000','2','0002364',NULL,'0002364',NULL,'10003','','I','0.000','0',NULL,'10003','2017-10-30','','0','','','',NULL,'363MAD00100120171031753254902094','558'),(566,'0001810010088443','2017-10-30','780','022','S.G.M.B','7946097','74','1',NULL,'I','','100000','0','1','0','3','0','100','10008','AGENCE RUE DE ROME','I','','0','1','100000',NULL,NULL,NULL,NULL,'0000174','1','0','10008',NULL,'I','',NULL,NULL,NULL,NULL,'0.000','0','0000012',NULL,'0000012',NULL,'10008','','I','0.000','0',NULL,'10008','2017-10-30','','1','','','',NULL,'363MAD00100220171031160769596167','565'),(569,'0001810010088443','2017-10-30','780','022','S.G.M.B','7946098','74','1',NULL,'I','','100000','0','1','0','5','0','100','10008','AGENCE RUE DE ROME','I','','0','1','100000',NULL,NULL,NULL,NULL,'0000173','1','0','10008',NULL,'I','',NULL,NULL,NULL,NULL,'0.000','0','0000012',NULL,'0000012',NULL,'10008','','I','0.000','0',NULL,'10008','2017-10-30','','1','','','',NULL,'363MAD00100220171031433348820285','568'),(574,'0001420005029767','2017-10-31','450','022','S.G.M.B','4085511','53','1',NULL,'I','','15000','0','0','0','3','0','100','10007','AGENCE AGADIR BD SAFI','I','','0','1','15000',NULL,NULL,NULL,NULL,'0000201','1','0','10007',NULL,'I','',NULL,NULL,NULL,NULL,'0.000','0','0001954',NULL,'0001954',NULL,'10007','','I','0.000','0',NULL,'10007','2017-10-31','','1','','','',NULL,'363MAD00100320171101178156368912','573'),(579,'0001240009002411','2017-10-31','780','022','S.G.M.B','6188627','74','1',NULL,'I','','20000','0','0','0','3','0','100','10002','AGENCE BERNOUSSI','I','','0','1','20000',NULL,NULL,NULL,NULL,'0000008','1','0','10002',NULL,'I','',NULL,NULL,NULL,NULL,'0.000','0','0001457',NULL,'0001457',NULL,'10002','','I','0.000','0',NULL,'10002','2017-10-31','','1','','','',NULL,'363MAD00100320171101377313059989','578'),(584,'0002430003902431','2017-10-31','780','022','S.G.M.B','5125688','74','1',NULL,'I','','1050','0','0','0','3','0','100','10008','AGENCE RUE DE ROME','I','','0','1','1350',NULL,NULL,NULL,NULL,'0000177','2','0','10008',NULL,'I','',NULL,NULL,NULL,NULL,'0.000','0','0000013',NULL,'0000013',NULL,'10008','','I','0.000','0','1350.00','10008','2017-10-31','','1','','','',NULL,'363MAD00100320171101142736599648','583'),(585,'2111111074610004','2017-10-31','780','190','B.C.P','5745846','37','1',NULL,'I','','300','0','0','0','4','0','100','10008','AGENCE RUE DE ROME','I','','0','1','1350',NULL,NULL,NULL,NULL,'0000177','2','0','10008',NULL,'I','',NULL,NULL,NULL,NULL,'0.000','0','0000013',NULL,'0000013',NULL,'10008','','I','0.000','0','1350.00','10008','2017-10-31','','0','','','',NULL,'363MAD00100420171101533809921752','583'),(588,'0110020372600211','2017-10-31','780','013','B.M.C.I','1150231','48','1',NULL,'I','','2500','0','0','0','6','0','100','10008','AGENCE RUE DE ROME','I','','0','1','3500',NULL,NULL,NULL,NULL,'0000178','2','0','10008',NULL,'I','',NULL,NULL,NULL,NULL,'0.000','0','0000013',NULL,'0000013',NULL,'10008','','I','0.000','0',NULL,'10008','2017-10-31','','0','','','',NULL,'363MAD00100220171101793513030263','587'),(589,'0001712000303113','2017-10-31','780','007','A.W.B','0276158','75','1',NULL,'I','','1000','0','1','0','7','0','100','10008','AGENCE RUE DE ROME','I','','0','1','3500',NULL,NULL,NULL,NULL,'0000178','2','0','10008',NULL,'I','',NULL,NULL,NULL,NULL,'0.000','0','0000013',NULL,'0000013',NULL,'10008','','I','0.000','0',NULL,'10008','2017-10-31','','0','','','',NULL,'363MAD00100120171101528132950883','587'),(594,'0000000000154765','2017-10-31','810','350','Poste du Maroc','7591893','23','1',NULL,'I','','26150','0','0','0','6','0','100','10007','AGENCE AGADIR BD SAFI','I','','0','1','26150',NULL,NULL,NULL,NULL,'0000202','1','0','10007',NULL,'I','',NULL,NULL,NULL,NULL,'0.000','0','0001902',NULL,'0001902',NULL,'10007','','I','0.000','0',NULL,'10007','2017-10-31','','0','','','',NULL,'363MAD00100520171101070305225577','593');
/*!40000 ALTER TABLE `tmp_tbl_eta_chq_sgda` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tmp_tbl_eta_chq_sgma`
--

DROP TABLE IF EXISTS `tmp_tbl_eta_chq_sgma`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tmp_tbl_eta_chq_sgma` (
  `pk_obj_idt_Chq` int(11) NOT NULL DEFAULT '0',
  `BMCH_CPT` varchar(16) DEFAULT NULL,
  `DTEMI` varchar(10) DEFAULT NULL,
  `BMCH_LOC` char(3) DEFAULT NULL,
  `BMCH_ZBK` char(3) DEFAULT NULL,
  `Bmch_ZBK_lib` varchar(45) DEFAULT NULL,
  `BMCH_NSER` varchar(7) DEFAULT NULL,
  `BMCH_RIB` char(2) DEFAULT NULL,
  `BMCH_CONF` char(1) DEFAULT NULL,
  `BMCH_CODE_ERREURS` varchar(45) DEFAULT NULL,
  `BMCH_ope_eta` char(1) NOT NULL DEFAULT '',
  `BMCH_ANO` text,
  `BMCH_MNT` varchar(15) DEFAULT NULL,
  `BMCH_FLAG_IMP` char(1) DEFAULT NULL,
  `BMCH_FLAG_REJET` char(1) DEFAULT NULL,
  `BMCH_FLAG_SCAN_GR` varchar(1) DEFAULT NULL,
  `bmch_SQCA` varchar(10) DEFAULT NULL,
  `bmch_ID_WEBCAPTUR` varchar(10) DEFAULT NULL,
  `bmch_AGE_SCAN` varchar(3) DEFAULT NULL,
  `BMTR_age` char(3) DEFAULT NULL,
  `ageTr_lib` varchar(32) DEFAULT NULL,
  `BMTR_ope_eta` char(1) NOT NULL DEFAULT '',
  `BMTR_Ano` text,
  `BMTR_Flag_Rejet` char(1) DEFAULT NULL,
  `BMTR_mode` char(1) DEFAULT NULL,
  `BMTR_MNT` varchar(15) DEFAULT NULL,
  `BMTR_CPT` varchar(9) DEFAULT NULL,
  `BMTR_RIB` char(2) DEFAULT NULL,
  `BMTR_loc` char(3) DEFAULT NULL,
  `BMTR_zbk` char(3) DEFAULT NULL,
  `BMTR_NSER` varchar(7) DEFAULT NULL,
  `BMTR_NBCH` varchar(4) DEFAULT NULL,
  `bmtr_ID_WEBCAPTUR` varchar(10) DEFAULT NULL,
  `bmtr_AGE_SCAN` varchar(3) DEFAULT NULL,
  `bmtr_SECTEUR` varchar(3) DEFAULT NULL,
  `BMTa_ope_eta` char(1) NOT NULL DEFAULT '',
  `BMTa_Ano` text,
  `BMTa_Flag_Rejet` char(1) DEFAULT NULL,
  `BMTa_mode` char(1) DEFAULT NULL,
  `BMTa_MNTR` varchar(15) DEFAULT NULL,
  `BMTA_MNTREM` varchar(15) DEFAULT NULL,
  `BMTA_MNT_DIFF` varchar(15) DEFAULT NULL,
  `BMTA_DIFF_NB` varchar(5) DEFAULT NULL,
  `BMTA_NSER_TA` varchar(7) DEFAULT NULL,
  `BMTA_CPT` varchar(9) DEFAULT NULL,
  `BMTA_NSER` varchar(7) DEFAULT NULL,
  `BMTA_COUNT_REM` varchar(5) DEFAULT NULL,
  `BMTA_age` char(3) DEFAULT NULL,
  `BMTN_Ano` text,
  `BMTN_ope_eta` char(1) NOT NULL DEFAULT '',
  `BMTN_DIFF` varchar(15) DEFAULT NULL,
  `BMTN_DIFF_NB` varchar(5) DEFAULT NULL,
  `BMTN_sum_chq` varchar(15) DEFAULT NULL,
  `BMTN_lecteur` varchar(5) DEFAULT NULL,
  `DATE` date DEFAULT NULL,
  `BMCH_REJET_DELTA` char(1) DEFAULT NULL,
  `bmch_sign` char(1) DEFAULT NULL,
  `BMCH_ANO_LIB` text,
  `BMTR_ANO_LIB` varchar(45) DEFAULT NULL,
  `BMTa_Ano_lib` varchar(45) DEFAULT NULL,
  `BMTN_ANO_LIB` varchar(45) DEFAULT NULL,
  `BMCH_RIO` varchar(45) DEFAULT NULL,
  `pk_obj_idt_rem` varchar(12) DEFAULT NULL,
  PRIMARY KEY (`pk_obj_idt_Chq`),
  KEY `IDX_pk_obj_idt_chq` (`pk_obj_idt_Chq`),
  KEY `IDX_pk_obj_idt_rem` (`pk_obj_idt_rem`),
  KEY `IDX_date` (`DATE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tmp_tbl_eta_chq_sgma`
--

LOCK TABLES `tmp_tbl_eta_chq_sgma` WRITE;
/*!40000 ALTER TABLE `tmp_tbl_eta_chq_sgma` DISABLE KEYS */;
INSERT INTO `tmp_tbl_eta_chq_sgma` VALUES (157338290,'0000010028329868','2017-09-14','780','022','S.G.M.B','8666954','74','1',NULL,'I','','10900','0','1','0','3','1','001','001','A MOHAMED V','I','','0','1','21000','006368874',NULL,NULL,NULL,'0000003','3','1','001','SC','I','',NULL,NULL,NULL,NULL,'0.000','0','0000003',NULL,'0000003',NULL,'001','','I','0.000','0',NULL,'10001','2017-09-14',NULL,'1','','','',NULL,NULL,'157338289'),(157338291,'0000010914038251','2017-09-14','780','022','S.G.M.B','9140382','07','1',NULL,'I','','10000','0','1','0','4','2','001','001','A MOHAMED V','I','','0','1','21000','006368874',NULL,NULL,NULL,'0000003','3','1','001','SC','I','',NULL,NULL,NULL,NULL,'0.000','0','0000003',NULL,'0000003',NULL,'001','','I','0.000','0',NULL,'10001','2017-09-14',NULL,'1','','','',NULL,NULL,'157338289'),(157338292,'0000010028345291','2017-09-14','780','022','S.G.M.B','7314694','74','0','DIFF','I','','100','0','1','0','5','3','001','001','A MOHAMED V','I','','0','1','21000','006368874',NULL,NULL,NULL,'0000003','3','1','001','SC','I','',NULL,NULL,NULL,NULL,'0.000','0','0000003',NULL,'0000003',NULL,'001','','I','0.000','0',NULL,'10001','2017-09-14',NULL,'1','','','',NULL,NULL,'157338289'),(157338297,'0000020013284246','2017-09-14','780','022','S.G.M.B','9534110','74','1',NULL,'I','','2000','0','1','0','8','4','001','002','B FAR','I','','0','1','85200','005391744',NULL,NULL,NULL,'0000001','3','2','001','SC','I','',NULL,NULL,NULL,NULL,'0.000','0','0000001',NULL,'0000001',NULL,'001','','I','0.000','0',NULL,'10001','2017-09-14',NULL,'1','','','',NULL,NULL,'157338296'),(157338298,'0000010027827408','2017-09-14','780','022','S.G.M.B','8775201','74','1',NULL,'I','','80000','0','1','0','9','5','001','002','B FAR','I','','0','1','85200','005391744',NULL,NULL,NULL,'0000001','3','2','001','SC','I','',NULL,NULL,NULL,NULL,'0.000','0','0000001',NULL,'0000001',NULL,'001','','I','0.000','0',NULL,'10001','2017-09-14',NULL,'1','','','',NULL,NULL,'157338296'),(157338299,'0000010027914902','2017-09-14','780','022','S.G.M.B','0292109','74','1',NULL,'I','','3200','0','1','0','10','6','001','002','B FAR','I','','0','1','85200','005391744',NULL,NULL,NULL,'0000001','3','2','001','SC','I','',NULL,NULL,NULL,NULL,'0.000','0','0000001',NULL,'0000001',NULL,'001','','I','0.000','0',NULL,'10001','2017-09-14',NULL,'1','','','',NULL,NULL,'157338296'),(157338304,'0000020005347706','2017-09-14','780','022','S.G.M.B','8838906','74','1',NULL,'I','','5000000','0','1','0','13','7','001','001','A MOHAMED V','I','','0','1','5026500','006375761',NULL,NULL,NULL,'0000006','3','3','001','SC','I','',NULL,NULL,NULL,NULL,'0.000','0','0000006',NULL,'0000006',NULL,'001','','I','0.000','0',NULL,'10001','2017-09-14',NULL,'1','','','',NULL,NULL,'157338303'),(157338305,'0000010009259571','2017-09-14','780','022','S.G.M.B','2619958','74','1',NULL,'I','','6500','0','1','0','14','8','001','001','A MOHAMED V','I','','0','1','5026500','006375761',NULL,NULL,NULL,'0000006','3','3','001','SC','I','',NULL,NULL,NULL,NULL,'0.000','0','0000006',NULL,'0000006',NULL,'001','','I','0.000','0',NULL,'10001','2017-09-14',NULL,'1','','','',NULL,NULL,'157338303'),(157338306,'0000020028355136','2017-09-14','780','022','S.G.M.B','2928813','74','1',NULL,'I','','20000','0','1','0','15','9','001','001','A MOHAMED V','I','','0','1','5026500','006375761',NULL,NULL,NULL,'0000006','3','3','001','SC','I','',NULL,NULL,NULL,NULL,'0.000','0','0000006',NULL,'0000006',NULL,'001','','I','0.000','0',NULL,'10001','2017-09-14',NULL,'1','','','',NULL,NULL,'157338303');
/*!40000 ALTER TABLE `tmp_tbl_eta_chq_sgma` ENABLE KEYS */;
UNLOCK TABLES;

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
/*!40000 ALTER TABLE `tmp_tbl_eta_lcn_baa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tmp_tbl_eta_lcn_sgda`
--

DROP TABLE IF EXISTS `tmp_tbl_eta_lcn_sgda`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tmp_tbl_eta_lcn_sgda` (
  `pk_obj_idt_LCN` varchar(25) NOT NULL DEFAULT '0',
  `Bmlcn_CPT` varchar(16) DEFAULT NULL,
  `DTEMI` varchar(10) DEFAULT NULL,
  `BMLCN_LOC` char(3) DEFAULT NULL,
  `BMLCN_ZBK` char(3) DEFAULT NULL,
  `bmlcn_ZBK_lib` varchar(45) DEFAULT NULL,
  `bmlcn_NSER` varchar(7) DEFAULT NULL,
  `bmlcn_RIB` char(2) DEFAULT NULL,
  `bmlcn_CONF` char(1) DEFAULT NULL,
  `bmlcn_CODE_ERREURS` varchar(40) DEFAULT NULL,
  `bmlcn_ope_eta` char(1) NOT NULL DEFAULT '',
  `bmlcn_ANO` text,
  `bmlcn_MNT` varchar(16) DEFAULT NULL,
  `bmlcn_FLAG_IMP` char(1) DEFAULT NULL,
  `bmlcn_FLAG_REJET` char(1) DEFAULT NULL,
  `bmlcn_FLAG_SCAN_GR` varchar(1) DEFAULT NULL,
  `bmlcn_SQCA` varchar(10) DEFAULT NULL,
  `bmlcn_ID_WEBCAPTUR` varchar(10) DEFAULT NULL,
  `bmlcn_AGE_SCAN` varchar(3) DEFAULT NULL,
  `BMTR_age` char(3) DEFAULT NULL,
  `ageTr_lib` varchar(32) DEFAULT NULL,
  `BMTR_ope_eta` char(1) NOT NULL DEFAULT '',
  `BMTR_Ano` text,
  `BMTR_Flag_Rejet` char(1) DEFAULT NULL,
  `BMTR_mode` char(1) DEFAULT NULL,
  `BMTR_MNT` varchar(16) DEFAULT NULL,
  `BMTR_CPT` varchar(9) DEFAULT NULL,
  `BMTR_RIB` char(2) DEFAULT NULL,
  `BMTR_zbk` char(3) DEFAULT NULL,
  `BMTR_NSER` varchar(7) DEFAULT NULL,
  `BMTR_NBCH` varchar(4) DEFAULT NULL,
  `bmtr_ID_WEBCAPTUR` varchar(10) DEFAULT NULL,
  `bmtr_AGE_SCAN` varchar(3) DEFAULT NULL,
  `bmtr_SECTEUR` varchar(3) DEFAULT NULL,
  `BMTa_ope_eta` char(1) NOT NULL DEFAULT '',
  `BMTa_Ano` text,
  `BMTa_Flag_Rejet` char(1) DEFAULT NULL,
  `BMTa_mode` char(1) DEFAULT NULL,
  `BMTa_MNTR` varchar(16) DEFAULT NULL,
  `BMTA_MNTREM` varchar(16) DEFAULT NULL,
  `BMTA_MNT_DIFF` varchar(15) DEFAULT NULL,
  `BMTA_DIFF_NB` varchar(5) DEFAULT NULL,
  `BMTA_NSER_TA` varchar(7) DEFAULT NULL,
  `BMTA_CPT` varchar(11) DEFAULT NULL,
  `BMTA_NSER` varchar(7) DEFAULT NULL,
  `BMTA_COUNT_REM` varchar(5) DEFAULT NULL,
  `BMTA_age` varchar(5) DEFAULT NULL,
  `BMTN_Ano` text,
  `BMTN_ope_eta` char(1) NOT NULL DEFAULT '',
  `BMTN_DIFF` varchar(15) DEFAULT NULL,
  `BMTN_DIFF_NB` varchar(5) DEFAULT NULL,
  `BMTN_sum_Lcn` varchar(15) DEFAULT NULL,
  `BMTN_lecteur` varchar(5) DEFAULT NULL,
  `DATE` varchar(10) DEFAULT NULL,
  `bmlcn_dteec` varchar(200) DEFAULT NULL,
  `bmlcn_sign` varchar(1) DEFAULT NULL,
  `BMTN_Ano_LIB` varchar(200) DEFAULT NULL,
  `BMTR_Ano_LIB` varchar(200) DEFAULT NULL,
  `BMTa_Ano_lib` varchar(200) DEFAULT NULL,
  `bmlcn_ANO_LIB` varchar(200) DEFAULT NULL,
  `bmlcn_rio` varchar(45) DEFAULT NULL,
  `bmlcn_REJET_DELTA` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`pk_obj_idt_LCN`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tmp_tbl_eta_lcn_sgda`
--

LOCK TABLES `tmp_tbl_eta_lcn_sgda` WRITE;
/*!40000 ALTER TABLE `tmp_tbl_eta_lcn_sgda` DISABLE KEYS */;
/*!40000 ALTER TABLE `tmp_tbl_eta_lcn_sgda` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tmp_tbl_eta_lcn_sgma`
--

DROP TABLE IF EXISTS `tmp_tbl_eta_lcn_sgma`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tmp_tbl_eta_lcn_sgma` (
  `pk_obj_idt_LCN` varchar(25) NOT NULL DEFAULT '0',
  `Bmlcn_CPT` varchar(16) DEFAULT NULL,
  `DTEMI` varchar(10) DEFAULT NULL,
  `BMLCN_LOC` char(3) DEFAULT NULL,
  `BMLCN_ZBK` char(3) DEFAULT NULL,
  `bmlcn_ZBK_lib` varchar(45) DEFAULT NULL,
  `bmlcn_NSER` varchar(7) DEFAULT NULL,
  `bmlcn_RIB` char(2) DEFAULT NULL,
  `bmlcn_CONF` char(1) DEFAULT NULL,
  `bmlcn_CODE_ERREURS` varchar(40) DEFAULT NULL,
  `bmlcn_ope_eta` char(1) NOT NULL DEFAULT '',
  `bmlcn_ANO` text,
  `bmlcn_MNT` varchar(16) DEFAULT NULL,
  `bmlcn_FLAG_IMP` char(1) DEFAULT NULL,
  `bmlcn_FLAG_REJET` char(1) DEFAULT NULL,
  `bmlcn_FLAG_SCAN_GR` varchar(1) DEFAULT NULL,
  `bmlcn_SQCA` varchar(10) DEFAULT NULL,
  `bmlcn_ID_WEBCAPTUR` varchar(10) DEFAULT NULL,
  `bmlcn_AGE_SCAN` varchar(3) DEFAULT NULL,
  `BMTR_age` char(3) DEFAULT NULL,
  `ageTr_lib` varchar(32) DEFAULT NULL,
  `BMTR_ope_eta` char(1) NOT NULL DEFAULT '',
  `BMTR_Ano` text,
  `BMTR_Flag_Rejet` char(1) DEFAULT NULL,
  `BMTR_mode` char(1) DEFAULT NULL,
  `BMTR_MNT` varchar(16) DEFAULT NULL,
  `BMTR_CPT` varchar(9) DEFAULT NULL,
  `BMTR_RIB` char(2) DEFAULT NULL,
  `BMTR_zbk` char(3) DEFAULT NULL,
  `BMTR_NSER` varchar(7) DEFAULT NULL,
  `BMTR_NBCH` varchar(4) DEFAULT NULL,
  `bmtr_ID_WEBCAPTUR` varchar(10) DEFAULT NULL,
  `bmtr_AGE_SCAN` varchar(3) DEFAULT NULL,
  `bmtr_SECTEUR` varchar(3) DEFAULT NULL,
  `BMTa_ope_eta` char(1) NOT NULL DEFAULT '',
  `BMTa_Ano` text,
  `BMTa_Flag_Rejet` char(1) DEFAULT NULL,
  `BMTa_mode` char(1) DEFAULT NULL,
  `BMTa_MNTR` varchar(16) DEFAULT NULL,
  `BMTA_MNTREM` varchar(16) DEFAULT NULL,
  `BMTA_MNT_DIFF` varchar(15) DEFAULT NULL,
  `BMTA_DIFF_NB` varchar(5) DEFAULT NULL,
  `BMTA_NSER_TA` varchar(7) DEFAULT NULL,
  `BMTA_CPT` varchar(11) DEFAULT NULL,
  `BMTA_NSER` varchar(7) DEFAULT NULL,
  `BMTA_COUNT_REM` varchar(5) DEFAULT NULL,
  `BMTA_age` varchar(5) DEFAULT NULL,
  `BMTN_Ano` text,
  `BMTN_ope_eta` char(1) NOT NULL DEFAULT '',
  `BMTN_DIFF` varchar(15) DEFAULT NULL,
  `BMTN_DIFF_NB` varchar(5) DEFAULT NULL,
  `BMTN_sum_Lcn` varchar(15) DEFAULT NULL,
  `BMTN_lecteur` varchar(5) DEFAULT NULL,
  `DATE` varchar(10) DEFAULT NULL,
  `bmlcn_dteec` varchar(200) DEFAULT NULL,
  `bmlcn_sign` varchar(1) DEFAULT NULL,
  `BMTN_Ano_LIB` varchar(200) DEFAULT NULL,
  `BMTR_Ano_LIB` varchar(200) DEFAULT NULL,
  `BMTa_Ano_lib` varchar(200) DEFAULT NULL,
  `bmlcn_ANO_LIB` varchar(200) DEFAULT NULL,
  `bmlcn_rio` varchar(45) DEFAULT NULL,
  `bmlcn_REJET_DELTA` varchar(1) DEFAULT NULL,
  `pk_obj_idt_rem` varchar(12) DEFAULT NULL,
  PRIMARY KEY (`pk_obj_idt_LCN`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tmp_tbl_eta_lcn_sgma`
--

LOCK TABLES `tmp_tbl_eta_lcn_sgma` WRITE;
/*!40000 ALTER TABLE `tmp_tbl_eta_lcn_sgma` DISABLE KEYS */;
INSERT INTO `tmp_tbl_eta_lcn_sgma` VALUES ('16180624','2121120134390000','2017-09-14','010','101','BP Centre Sud','6484042','86','1',NULL,'I','','1450',NULL,'0','0','3','0','206','007','AGADIR F.A.R','I','','1','1','1450','011297732',NULL,NULL,'0411282','1',NULL,'206','SE','I','',NULL,NULL,NULL,NULL,'-37354.98','-8','0430430',NULL,'0430430',NULL,NULL,'','I','0.000','0',NULL,'10206','2017-09-14','13092017','0','','','','',NULL,NULL,NULL),('16180627','0001854000000079','2017-09-14','028','007','A.W.B','8458929','60','1',NULL,'I','','2673',NULL,'0','0','5','0','206','007','AGADIR F.A.R','I','','1','1','2673','005120675',NULL,NULL,'0393682','1',NULL,'206','SE','I','',NULL,NULL,NULL,NULL,'-37354.98','-8','0430430',NULL,'0430430',NULL,NULL,'','I','0.000','0',NULL,'10206','2017-09-14','0','0','','','','',NULL,NULL,NULL),('16180630','0144019506510114','2017-09-14','028','225','C.A.M','7227021','09','1',NULL,'I','','2300',NULL,'0','0','7','0','206','007','AGADIR F.A.R','I','','1','1','2300','005120675',NULL,NULL,'0393683','1',NULL,'206','SE','I','',NULL,NULL,NULL,NULL,'-37354.98','-8','0430430',NULL,'0430430',NULL,NULL,'','I','0.000','0',NULL,'10206','2017-09-14','15092017','0','','','','',NULL,NULL,NULL),('16180633','0000336030022739','2017-09-14','010','021','C.D.M','5204417','14','1',NULL,'I','','2803.2',NULL,'0','0','9','0','206','007','AGADIR F.A.R','I','','1','1','2803.2','005120675',NULL,NULL,'0393684','1',NULL,'206','SE','I','',NULL,NULL,NULL,NULL,'-37354.98','-8','0430430',NULL,'0430430',NULL,NULL,'','I','0.000','0',NULL,'10206','2017-09-14','11092017','0','','','','',NULL,NULL,NULL),('16180636','0000042100008579','2017-09-14','022','011','B.M.C.E','0520248','03','1',NULL,'I','','2960',NULL,'0','0','11','0','206','007','AGADIR F.A.R','I','','1','1','2960','005120675',NULL,NULL,'0393685','1',NULL,'206','SE','I','',NULL,NULL,NULL,NULL,'-37354.98','-8','0430430',NULL,'0430430',NULL,NULL,'','I','0.000','0',NULL,'10206','2017-09-14','0','0','','','','',NULL,NULL,NULL),('16180639','2121148079650005','2017-09-14','010','101','BP Centre Sud','5673197','95','1',NULL,'I','','3000',NULL,'1','0','13','0','206','007','AGADIR F.A.R','I','','1','1','3000','005120675',NULL,NULL,'0393689','1',NULL,'206','SE','I','',NULL,NULL,NULL,NULL,'-37354.98','-8','0430430',NULL,'0430430',NULL,NULL,'','I','0.000','0',NULL,'10206','2017-09-14','12092017','0','','','','',NULL,NULL,NULL),('16180642','0000012100003129','2017-09-14','010','011','B.M.C.E','0092671','14','1',NULL,'I','','15234.6',NULL,'0','0','15','0','206','007','AGADIR F.A.R','I','','1','1','15234.6','005120675',NULL,NULL,'0393690','1',NULL,'206','SE','I','',NULL,NULL,NULL,NULL,'-37354.98','-8','0430430',NULL,'0430430',NULL,NULL,'','I','0.000','0',NULL,'10206','2017-09-14','0','0','','','','',NULL,NULL,NULL),('16180645','0000710005065741','2017-09-14','010','022','S.G.M.B','2233594','25','1',NULL,'I','','4105.5',NULL,'0','0','17','0','206','007','AGADIR F.A.R','I','','1','1','6934.18','005168302',NULL,NULL,'0206582','2',NULL,'206','SE','I','',NULL,NULL,NULL,NULL,'-37354.98','-8','0430430',NULL,'0430430',NULL,NULL,'','I','0.000','0',NULL,'10206','2017-09-14','15092017','2','','','','',NULL,NULL,NULL),('16180646','0000022100009531','2017-09-14','010','011','B.M.C.E','4683972','61','1',NULL,'I','','2828.68',NULL,'0','0','18','0','206','007','AGADIR F.A.R','I','','1','1','6934.18','005168302',NULL,NULL,'0206582','2',NULL,'206','SE','I','',NULL,NULL,NULL,NULL,'-37354.98','-8','0430430',NULL,'0430430',NULL,NULL,'','I','0.000','0',NULL,'10206','2017-09-14','15092017','0','','','','',NULL,NULL,NULL),('16180651','0114700000900148','2017-09-14','780','013','B.M.C.I','5961244','48','1',NULL,'I','','142177.5',NULL,'1','0','21','0','206','008','AGADIR KETTANI','I','','1','1','142177.5','005291928',NULL,NULL,'0395041','1',NULL,'206','SE','I','',NULL,NULL,NULL,NULL,'-615638.88','-2','0430431',NULL,'0430431',NULL,NULL,'','I','0.000','0',NULL,'10206','2017-09-14','05102017','0','','','','',NULL,NULL,NULL),('16180654','0000982000002490','2017-09-14','450','007','A.W.B','8033675','78','1',NULL,'I','','146730.88',NULL,'0','0','23','0','206','008','AGADIR KETTANI','I','','1','1','473461.38','005241876',NULL,NULL,'0514314','3',NULL,'206','SE','I','',NULL,NULL,NULL,NULL,'-615638.88','-2','0430431',NULL,'0430431',NULL,NULL,'','I','0.000','0',NULL,'10206','2017-09-14','10022018','0','','','','',NULL,NULL,NULL),('16180655','0000982000002490','2017-09-14','450','007','A.W.B','8033674','78','1',NULL,'I','','146730.5',NULL,'0','0','24','0','206','008','AGADIR KETTANI','I','','1','1','473461.38','005241876',NULL,NULL,'0514314','3',NULL,'206','SE','I','',NULL,NULL,NULL,NULL,'-615638.88','-2','0430431',NULL,'0430431',NULL,NULL,'','I','0.000','0',NULL,'10206','2017-09-14','20022018','0','','','','',NULL,NULL,NULL),('16180656','0000982000002490','2017-09-14','450','007','A.W.B','8033673','78','1',NULL,'I','','180000',NULL,'0','0','25','0','206','008','AGADIR KETTANI','I','','1','1','473461.38','005241876',NULL,NULL,'0514314','3',NULL,'206','SE','I','',NULL,NULL,NULL,NULL,'-615638.88','-2','0430431',NULL,'0430431',NULL,NULL,'','I','0.000','0',NULL,'10206','2017-09-14','20012018','0','','','','',NULL,NULL,NULL),('16180661','2111155523730004','2017-09-14','650','101','BP Centre Sud','8339458','88','1',NULL,'I','','20250',NULL,'1','0','28','0','206','029','INEZGANE','I','','1','1','20250','005053443',NULL,NULL,'0693416','1',NULL,'206','SE','I','',NULL,NULL,NULL,NULL,'-225000.00','-4','0355720',NULL,'0355720',NULL,NULL,'','I','0.000','0',NULL,'10206','2017-09-14','05092017','0','','','','',NULL,NULL,NULL),('16180664','2121192018610019','2017-09-14','017','101','BP Centre Sud','3156790','88','1',NULL,'I','','10000',NULL,'1','0','30','0','206','029','INEZGANE','I','','1','1','69200','010474482',NULL,NULL,'0691525','8',NULL,'206','SE','I','',NULL,NULL,NULL,NULL,'-225000.00','-4','0355720',NULL,'0355720',NULL,NULL,'','I','0.000','0',NULL,'10206','2017-09-14','15092017','0','','','','',NULL,NULL,NULL),('16180665','0005687000300795','2017-09-14','013','007','A.W.B','9037768','30','1',NULL,'I','','4000',NULL,'0','0','31','0','206','029','INEZGANE','I','','1','1','69200','010474482',NULL,NULL,'0691525','8',NULL,'206','SE','I','',NULL,NULL,NULL,NULL,'-225000.00','-4','0355720',NULL,'0355720',NULL,NULL,'','I','0.000','0',NULL,'10206','2017-09-14','15092017','0','','','','',NULL,NULL,NULL),('16180666','0000022000000926','2017-09-14','021','011','B.M.C.E','0396180','17','1',NULL,'I','','9250',NULL,'0','0','32','0','206','029','INEZGANE','I','','1','1','69200','010474482',NULL,NULL,'0691525','8',NULL,'206','SE','I','',NULL,NULL,NULL,NULL,'-225000.00','-4','0355720',NULL,'0355720',NULL,NULL,'','I','0.000','0',NULL,'10206','2017-09-14','15092017','0','','','','',NULL,NULL,NULL),('16180667','0000012000000021','2017-09-14','012','011','B.M.C.E','0356267','91','1',NULL,'I','','16000',NULL,'0','0','33','0','206','029','INEZGANE','I','','1','1','69200','010474482',NULL,NULL,'0691525','8',NULL,'206','SE','I','',NULL,NULL,NULL,NULL,'-225000.00','-4','0355720',NULL,'0355720',NULL,NULL,'','I','0.000','0',NULL,'10206','2017-09-14','15092017','0','','','','',NULL,NULL,NULL),('16180668','0005075000300280','2017-09-14','021','007','A.W.B','8614680','43','1',NULL,'I','','6800',NULL,'0','0','34','0','206','029','INEZGANE','I','','1','1','69200','010474482',NULL,NULL,'0691525','8',NULL,'206','SE','I','',NULL,NULL,NULL,NULL,'-225000.00','-4','0355720',NULL,'0355720',NULL,NULL,'','I','0.000','0',NULL,'10206','2017-09-14','10092017','0','','','','',NULL,NULL,NULL),('16180669','0003082000303807','2017-09-14','010','007','A.W.B','8683909','18','1',NULL,'I','','3000',NULL,'0','0','35','0','206','029','INEZGANE','I','','1','1','69200','010474482',NULL,NULL,'0691525','8',NULL,'206','SE','I','',NULL,NULL,NULL,NULL,'-225000.00','-4','0355720',NULL,'0355720',NULL,NULL,'','I','0.000','0',NULL,'10206','2017-09-14','10092017','0','','','','',NULL,NULL,NULL),('16180670','0318061116010126','2017-09-14','550','225','C.A.M','6047847','12','1',NULL,'I','','10800',NULL,'1','0','36','0','206','029','INEZGANE','I','','1','1','69200','010474482',NULL,NULL,'0691525','8',NULL,'206','SE','I','',NULL,NULL,NULL,NULL,'-225000.00','-4','0355720',NULL,'0355720',NULL,NULL,'','I','0.000','0',NULL,'10206','2017-09-14','05092017','0','','','','',NULL,NULL,NULL),('16180671','0000161001128006','2017-09-14','022','021','C.D.M','5510206','67','1',NULL,'I','','9350',NULL,'0','0','37','0','206','029','INEZGANE','I','','1','1','69200','010474482',NULL,NULL,'0691525','8',NULL,'206','SE','I','',NULL,NULL,NULL,NULL,'-225000.00','-4','0355720',NULL,'0355720',NULL,NULL,'','I','0.000','0',NULL,'10206','2017-09-14','15092017','0','','','','',NULL,NULL,NULL),('16180674','0005075000300353','2017-09-14','021','007','A.W.B','7800763','18','1',NULL,'I','','5000',NULL,'1','0','39','0','206','029','INEZGANE','I','','1','1','120250','010510275',NULL,NULL,'0691504','8',NULL,'206','SE','I','',NULL,NULL,NULL,NULL,'-225000.00','-4','0355720',NULL,'0355720',NULL,NULL,'','I','0.000','0',NULL,'10206','2017-09-14','30082017','0','','','','',NULL,NULL,NULL),('16180675','2111190625950002','2017-09-14','045','101','BP Centre Sud','9976288','94','1',NULL,'I','','16000',NULL,'0','0','40','0','206','029','INEZGANE','I','','1','1','120250','010510275',NULL,NULL,'0691504','8',NULL,'206','SE','I','',NULL,NULL,NULL,NULL,'-225000.00','-4','0355720',NULL,'0355720',NULL,NULL,'','I','0.000','0',NULL,'10206','2017-09-14','30082017','0','','','','',NULL,NULL,NULL),('16180676','2111145396750007','2017-09-14','212','148','BP Meknès','8890939','96','1',NULL,'I','','40000',NULL,'0','0','41','0','206','029','INEZGANE','I','','1','1','120250','010510275',NULL,NULL,'0691504','8',NULL,'206','SE','I','',NULL,NULL,NULL,NULL,'-225000.00','-4','0355720',NULL,'0355720',NULL,NULL,'','I','0.000','0',NULL,'10206','2017-09-14','30082017','0','','','','',NULL,NULL,NULL),('16180677','0000012100060365','2017-09-14','565','011','B.M.C.E','5183591','71','1',NULL,'I','','6000',NULL,'0','0','42','0','206','029','INEZGANE','I','','1','1','120250','010510275',NULL,NULL,'0691504','8',NULL,'206','SE','I','',NULL,NULL,NULL,NULL,'-225000.00','-4','0355720',NULL,'0355720',NULL,NULL,'','I','0.000','0',NULL,'10206','2017-09-14','30082017','0','','','','',NULL,NULL,NULL),('16180678','2111123152090009','2017-09-14','360','181','BP Rabat Kenitra','6152259','04','1',NULL,'I','','3250',NULL,'0','0','43','0','206','029','INEZGANE','I','','1','1','120250','010510275',NULL,NULL,'0691504','8',NULL,'206','SE','I','',NULL,NULL,NULL,NULL,'-225000.00','-4','0355720',NULL,'0355720',NULL,NULL,'','I','0.000','0',NULL,'10206','2017-09-14','30082017','0','','','','',NULL,NULL,NULL),('16180679','0001750009014850','2017-09-14','240','022','S.G.M.B','1639857','22','1',NULL,'I','','5000',NULL,'0','0','44','0','206','029','INEZGANE','I','','1','1','120250','010510275',NULL,NULL,'0691504','8',NULL,'206','SE','I','',NULL,NULL,NULL,NULL,'-225000.00','-4','0355720',NULL,'0355720',NULL,NULL,'','I','0.000','0',NULL,'10206','2017-09-14','30082017','1','','','','',NULL,NULL,NULL),('16180680','2111190625950002','2017-09-14','045','101','BP Centre Sud','9976285','94','1',NULL,'I','','15000',NULL,'0','0','45','0','206','029','INEZGANE','I','','1','1','120250','010510275',NULL,NULL,'0691504','8',NULL,'206','SE','I','',NULL,NULL,NULL,NULL,'-225000.00','-4','0355720',NULL,'0355720',NULL,NULL,'','I','0.000','0',NULL,'10206','2017-09-14','30052017','0','','','','',NULL,NULL,NULL),('16180681','0000204001033348','2017-09-14','010','021','C.D.M','5231488','05','1',NULL,'I','','30000',NULL,'0','0','46','0','206','029','INEZGANE','I','','1','1','120250','010510275',NULL,NULL,'0691504','8',NULL,'206','SE','I','',NULL,NULL,NULL,NULL,'-225000.00','-4','0355720',NULL,'0355720',NULL,NULL,'','I','0.000','0',NULL,'10206','2017-09-14','30062017','0','','','','',NULL,NULL,NULL),('16180684','0000322001013705','2017-09-14','022','021','C.D.M','5747573','46','1',NULL,'I','','15300',NULL,'0','0','48','0','206','029','INEZGANE','I','','1','1','15300','010597866',NULL,NULL,'0691524','1',NULL,'206','SE','I','',NULL,NULL,NULL,NULL,'-225000.00','-4','0355720',NULL,'0355720',NULL,NULL,'','I','0.000','0',NULL,'10206','2017-09-14','28082017','0','','','','',NULL,NULL,NULL),('16180689','0000590009564413','2017-09-14','022','022','S.G.M.B','2565898','24','1',NULL,'I','','2765',NULL,'0','0','51','0','206','059','AIT MELLOUL','I','','1','1','2765','009321040',NULL,NULL,'0653894','1',NULL,'206','SE','I','',NULL,NULL,NULL,NULL,'-9765.00','-2','0252996',NULL,'0252996',NULL,NULL,'','I','0.000','0',NULL,'10206','2017-09-14','15092017','1','','','','',NULL,NULL,NULL),('16180692','0006595000300168','2017-09-14','018','007','A.W.B','9348441','30','1',NULL,'I','','2000',NULL,'0','0','53','0','206','059','AIT MELLOUL','I','','1','1','7000','009408922',NULL,NULL,'0653893','2',NULL,'206','SE','I','',NULL,NULL,NULL,NULL,'-9765.00','-2','0252996',NULL,'0252996',NULL,NULL,'','I','0.000','0','7000.00','10206','2017-09-14','08092017','0','','','','',NULL,NULL,NULL),('16180693','0000112000000112','2017-09-14','010','011','B.M.C.E','0488430','78','1',NULL,'I','','5000',NULL,'0','0','54','0','206','059','AIT MELLOUL','I','','1','1','7000','009408922',NULL,NULL,'0653893','2',NULL,'206','SE','I','',NULL,NULL,NULL,NULL,'-9765.00','-2','0252996',NULL,'0252996',NULL,NULL,'','I','0.000','0','7000.00','10206','2017-09-14','15092017','0','','','','',NULL,NULL,NULL),('16180698','0153007396610104','2017-09-14','822','225','C.A.M','7547474','64','1',NULL,'I','','7600',NULL,'0','0','57','0','206','071','AGADIR TALBORJT','I','','1','1','7600','005086305',NULL,NULL,'0745959','1',NULL,'206','SE','I','',NULL,NULL,NULL,NULL,'-13289.95','-2','0425771',NULL,'0425771',NULL,NULL,'','I','0.000','0',NULL,'10206','2017-09-14','11092017','0','','','','',NULL,NULL,NULL),('16180701','0001844000000931','2017-09-14','010','007','A.W.B','7340560','29','1',NULL,'I','','5689.95',NULL,'0','0','59','0','206','071','AGADIR TALBORJT','I','','1','1','5689.95','005087857',NULL,NULL,'0745801','1',NULL,'206','SE','I','',NULL,NULL,NULL,NULL,'-13289.95','-2','0425771',NULL,'0425771',NULL,NULL,'','I','0.000','0',NULL,'10206','2017-09-14','15092017','0','','','','',NULL,NULL,NULL),('16180706','0000292100000918','2017-09-14','780','011','B.M.C.E','3970967','58','1',NULL,'I','','90000',NULL,'1','0','62','0','206','152','AGADIR HAY DAKHLA','I','','1','1','90000','009099591',NULL,NULL,'0545969','1',NULL,'206','SE','I','',NULL,NULL,NULL,NULL,'-176800.00','-2','0497751',NULL,'0497751',NULL,NULL,'','I','0.000','0','90000.00','10206','2017-09-14','15102017','0','','','','',NULL,NULL,NULL),('16180709','2121371740600031','2017-09-14','735','164','BP Tanger Tetouan','8998314','75','1',NULL,'I','','86800',NULL,'0','0','64','0','206','152','AGADIR HAY DAKHLA','I','','1','1','86800','027741051',NULL,NULL,'1048046','1',NULL,'206','SE','I','',NULL,NULL,NULL,NULL,'-176800.00','-2','0497751',NULL,'0497751',NULL,NULL,'','I','0.000','0',NULL,'10206','2017-09-14','31082017','0','','','','',NULL,NULL,NULL),('16181024','0141054816610121','2017-09-14','022','225','C.A.M','7224348','55','1',NULL,'D','','6300',NULL,'0','0','67','0','206','219','AGADIR TADDART','D','HFOUR','1','1','6500','005001841',NULL,NULL,'0712795','1',NULL,'206','SE','I','',NULL,NULL,NULL,NULL,'-136767.00','-2','0466024',NULL,'0466024',NULL,NULL,'','D','-200.00','0','6300.00','10206','2017-09-14','30102017','0','','Remise avec Erreur de sommation','','',NULL,NULL,NULL),('16181027','0141056706010121','2017-09-14','022','225','C.A.M','7560202','02','1',NULL,'I','','53092',NULL,'0','0','69','0','206','219','AGADIR TADDART','I','','1','1','103092','005001841',NULL,NULL,'0712796','2',NULL,'206','SE','I','',NULL,NULL,NULL,NULL,'-136767.00','-2','0466024',NULL,'0466024',NULL,NULL,'','I','0.000','0',NULL,'10206','2017-09-14','15012018','0','','','','',NULL,NULL,NULL),('16181028','0141056706610121','2017-09-14','022','225','C.A.M','7224251','31','1',NULL,'I','','50000',NULL,'0','0','70','0','206','219','AGADIR TADDART','I','','1','1','103092','005001841',NULL,NULL,'0712796','2',NULL,'206','SE','I','',NULL,NULL,NULL,NULL,'-136767.00','-2','0466024',NULL,'0466024',NULL,NULL,'','I','0.000','0',NULL,'10206','2017-09-14','15122017','0','','','','',NULL,NULL,NULL),('16181031','0128820130500172','2017-09-14','011','013','B.M.C.I','5734686','07','1',NULL,'D','','57415.75',NULL,'0','0','72','0','206','219','AGADIR TADDART','D','RE_BEN','1','1','114831.5','000000000',NULL,NULL,'0712794','2',NULL,'206',NULL,'I','',NULL,NULL,NULL,NULL,'-136767.00','-2','0466024',NULL,'0466024',NULL,NULL,'','D','0.000','0',NULL,'10206','2017-09-14','29122017','0','','Remise avec Cpte Bénéficiaire Erroné','','',NULL,NULL,NULL),('16181032','0128820130500172','2017-09-14','011','013','B.M.C.I','5734687','07','1',NULL,'D','','57415.75',NULL,'0','0','73','0','206','219','AGADIR TADDART','D','RE_BEN','1','1','114831.5','000000000',NULL,NULL,'0712794','2',NULL,'206',NULL,'I','',NULL,NULL,NULL,NULL,'-136767.00','-2','0466024',NULL,'0466024',NULL,NULL,'','D','0.000','0',NULL,'10206','2017-09-14','10012018','0','','Remise avec Cpte Bénéficiaire Erroné','','',NULL,NULL,NULL),('16181035','0476007066510114','2017-09-14','010','225','C.A.M','7675853','24','1',NULL,'I','','33675',NULL,'0','0','75','0','206','219','AGADIR TADDART','I','','1','1','33675','005014451',NULL,NULL,'0176627','1',NULL,'206','SE','I','',NULL,NULL,NULL,NULL,'-136767.00','-2','0466024',NULL,'0466024',NULL,NULL,'','I','0.000','0',NULL,'10206','2017-09-14','12092017','0','','','','',NULL,NULL,NULL),('16181040','0476002166510101','2017-09-14','010','225','C.A.M','6897556','39','1',NULL,'I','','34713',NULL,'0','0','78','0','206','223','AGADIR MASSIRA','I','','1','1','34713','027802368',NULL,NULL,'0730426','1',NULL,'206','SE','I','',NULL,NULL,NULL,NULL,'-61524.40','-2','0337735',NULL,'0337735',NULL,NULL,'','I','0.000','0',NULL,'10206','2017-09-14','15092017','0','','','','',NULL,NULL,NULL),('16181043','0003320027534739','2017-09-14','010','022','S.G.M.B','3119023','25','1',NULL,'I','','8304.34',NULL,'0','0','80','0','206','223','AGADIR MASSIRA','I','','1','1','26811.4','005014061',NULL,NULL,'0280491','2',NULL,'206','SE','I','',NULL,NULL,NULL,NULL,'-61524.40','-2','0337735',NULL,'0337735',NULL,NULL,'','I','0.000','0',NULL,'10206','2017-09-14','18092017','1','','','','',NULL,NULL,NULL),('16181044','0003320027534739','2017-09-14','010','022','S.G.M.B','3119025','25','1',NULL,'I','','18507.06',NULL,'0','0','81','0','206','223','AGADIR MASSIRA','I','','1','1','26811.4','005014061',NULL,NULL,'0280491','2',NULL,'206','SE','I','',NULL,NULL,NULL,NULL,'-61524.40','-2','0337735',NULL,'0337735',NULL,NULL,'','I','0.000','0',NULL,'10206','2017-09-14','18092017','1','','','','',NULL,NULL,NULL),('16181049','2121145181970008','2017-09-14','010','101','BP Centre Sud','5787209','93','1',NULL,'I','','10000',NULL,'0','0','84','0','206','276','AGADIR ABDERRAHIM BOUABID','I','','1','1','10000','027815291',NULL,NULL,'0571575','1',NULL,'206','SE','I','',NULL,NULL,NULL,NULL,'-10000.00','-1','0104113',NULL,'0104113',NULL,NULL,'','I','0.000','0','10000.00','10206','2017-09-14','12092017','0','','','','',NULL,NULL,NULL),('16181054','0000042100012411','2017-09-14','010','011','B.M.C.E','0410556','51','1',NULL,'I','','2730.47',NULL,'0','0','87','0','206','399','AGADIR MAKKA','I','','1','1','2730.47','028695359',NULL,NULL,'0290798','1',NULL,'206','SE','I','',NULL,NULL,NULL,NULL,'-2730.47','-1','0226900',NULL,'0226900',NULL,NULL,'','I','0.000','0',NULL,'10206','2017-09-14','13092017','0','','','','',NULL,NULL,NULL),('16181059','0000032000001854','2017-09-14','650','011','B.M.C.E','4175632','81','1',NULL,'I','','6000',NULL,'0','0','90','0','206','398','LAAYOUNE Route Smara','I','','1','1','6000','028226607',NULL,NULL,'0227277','1',NULL,'206','SE','I','',NULL,NULL,NULL,NULL,'-96110.00','-11','0446977',NULL,'0446977',NULL,NULL,'','I','0.000','0',NULL,'10206','2017-09-14','12092017','0','','','','',NULL,NULL,NULL),('16181062','2121145750440003','2017-09-14','028','101','BP Centre Sud','1045941','20','1',NULL,'I','','5600',NULL,'0','0','92','0','206','188','AGADIR DCHEIRA','I','','1','1','5600','005010053',NULL,NULL,'0572737','1',NULL,'206','SE','I','',NULL,NULL,NULL,NULL,'-96110.00','-11','0446977',NULL,'0446977',NULL,NULL,'','I','0.000','0',NULL,'10206','2017-09-14','15092017','0','','','','',NULL,NULL,NULL),('16181065','0000258030025082','2017-09-14','010','021','C.D.M','5345762','68','1',NULL,'I','','40280',NULL,'1','0','94','0','206','188','AGADIR DCHEIRA','I','','1','1','40280','005010053',NULL,NULL,'0572733','1',NULL,'206','SE','I','',NULL,NULL,NULL,NULL,'-96110.00','-11','0446977',NULL,'0446977',NULL,NULL,'','I','0.000','0',NULL,'10206','2017-09-14','10092017','0','','','','',NULL,NULL,NULL),('16181068','2121110327710015','2017-09-14','010','101','BP Centre Sud','7838519','84','1',NULL,'I','','2600',NULL,'0','0','96','0','206','188','AGADIR DCHEIRA','I','','1','1','2600','005010053',NULL,NULL,'0572743','1',NULL,'206','SE','I','',NULL,NULL,NULL,NULL,'-96110.00','-11','0446977',NULL,'0446977',NULL,NULL,'','I','0.000','0',NULL,'10206','2017-09-14','15092017','0','','','','',NULL,NULL,NULL),('16181071','0000375000308170','2017-09-14','750','007','A.W.B','8339873','79','1',NULL,'I','','3300',NULL,'0','0','98','0','206','188','AGADIR DCHEIRA','I','','1','1','3300','005010053',NULL,NULL,'0572741','1',NULL,'206','SE','I','',NULL,NULL,NULL,NULL,'-96110.00','-11','0446977',NULL,'0446977',NULL,NULL,'','I','0.000','0',NULL,'10206','2017-09-14','15092017','0','','','','',NULL,NULL,NULL),('16181074','0000375000309353','2017-09-14','750','007','A.W.B','8218506','22','1',NULL,'I','','3600',NULL,'0','0','100','0','206','188','AGADIR DCHEIRA','I','','1','1','3600','005010053',NULL,NULL,'0572740','1',NULL,'206','SE','I','',NULL,NULL,NULL,NULL,'-96110.00','-11','0446977',NULL,'0446977',NULL,NULL,'','I','0.000','0',NULL,'10206','2017-09-14','16092017','0','','','','',NULL,NULL,NULL),('16181077','2111123669810006','2017-09-14','019','101','BP Centre Sud','4389921','30','1',NULL,'I','','6000',NULL,'0','0','102','0','206','188','AGADIR DCHEIRA','I','','1','1','6000','005010053',NULL,NULL,'0572736','1',NULL,'206','SE','I','',NULL,NULL,NULL,NULL,'-96110.00','-11','0446977',NULL,'0446977',NULL,NULL,'','I','0.000','0',NULL,'10206','2017-09-14','15092017','0','','','','',NULL,NULL,NULL),('16181080','0305012086010122','2017-09-14','010','225','C.A.M','7470162','38','1',NULL,'I','','5000',NULL,'0','0','104','0','206','188','AGADIR DCHEIRA','I','','1','1','5000','005010053',NULL,NULL,'0572738','1',NULL,'206','SE','I','',NULL,NULL,NULL,NULL,'-96110.00','-11','0446977',NULL,'0446977',NULL,NULL,'','I','0.000','0',NULL,'10206','2017-09-14','15092017','0','','','','',NULL,NULL,NULL),('16181083','0000332000310018','2017-09-14','320','007','A.W.B','8548793','40','1',NULL,'I','','6000',NULL,'0','0','106','0','206','188','AGADIR DCHEIRA','I','','1','1','6000','005010053',NULL,NULL,'0572735','1',NULL,'206','SE','I','',NULL,NULL,NULL,NULL,'-96110.00','-11','0446977',NULL,'0446977',NULL,NULL,'','I','0.000','0',NULL,'10206','2017-09-14','15092017','0','','','','',NULL,NULL,NULL),('16181086','0007225000000062','2017-09-14','325','007','A.W.B','6959757','76','1',NULL,'I','','6930',NULL,'0','0','108','0','206','188','AGADIR DCHEIRA','I','','1','1','6930','005010053',NULL,NULL,'0572734','1',NULL,'206','SE','I','',NULL,NULL,NULL,NULL,'-96110.00','-11','0446977',NULL,'0446977',NULL,NULL,'','I','0.00','0','6930.00','10206','2017-09-14','15092017','0','','','','',NULL,NULL,NULL),('16181089','2111107202610007','2017-09-14','325','101','BP Centre Sud','5881053','85','1',NULL,'I','','3000',NULL,'0','0','110','0','206','417','SGMA_AIT MELLOUL_AL FATH','I','','1','1','10800','031436958',NULL,NULL,'0227276','2',NULL,'206','SE','I','',NULL,NULL,NULL,NULL,'-96110.00','-11','0446977',NULL,'0446977',NULL,NULL,'','I','0.000','0',NULL,'10206','2017-09-14','30082017','0','','','','',NULL,NULL,NULL),('16181090','0004987000302655','2017-09-14','556','007','A.W.B','9300711','63','1',NULL,'I','','7800',NULL,'0','0','111','0','206','417','SGMA_AIT MELLOUL_AL FATH','I','','1','1','10800','031436958',NULL,NULL,'0227276','2',NULL,'206','SE','I','',NULL,NULL,NULL,NULL,'-96110.00','-11','0446977',NULL,'0446977',NULL,NULL,'','I','0.000','0',NULL,'10206','2017-09-14','30082017','0','','','','',NULL,NULL,NULL),('16181343','2121150324490005','2017-09-14','590','145','BP Marrakech Beni Mellal','8394636','43','1',NULL,'I','','200000',NULL,'0','0','3','0','017','017','SAFI','I','','1','1','200000','005404492',NULL,NULL,'0377090','1',NULL,'017','SE','I','',NULL,NULL,NULL,NULL,'-217600.00','-4','0314064',NULL,'0314064',NULL,NULL,'','I','0.000','0','200000.00','10017','2017-09-14','29092017','0','','','','',NULL,NULL,NULL),('16181346','2111138373670009','2017-09-14','750','101','BP Centre Sud','5712622','78','1',NULL,'I','','2600',NULL,'0','0','5','0','017','017','SAFI','I','','1','1','12600','011069971',NULL,NULL,'0467397','2',NULL,'017','SE','I','',NULL,NULL,NULL,NULL,'-217600.00','-4','0314064',NULL,'0314064',NULL,NULL,'','I','0.000','0',NULL,'10017','2017-09-14','12092017','0','','','','',NULL,NULL,NULL),('16181347','0000920005015921','2017-09-14','570','022','S.G.M.B','1600815','43','1',NULL,'I','','10000',NULL,'0','0','6','0','017','017','SAFI','I','','1','1','12600','011069971',NULL,NULL,'0467397','2',NULL,'017','SE','I','',NULL,NULL,NULL,NULL,'-217600.00','-4','0314064',NULL,'0314064',NULL,NULL,'','I','0.000','0',NULL,'10017','2017-09-14','30082017','2','','','','',NULL,NULL,NULL),('16181350','0222176856010107','2017-09-14','593','225','C.A.M','7352118','82','1',NULL,'I','','3000',NULL,'0','0','8','0','017','017','SAFI','I','','1','1','3000','005396441',NULL,NULL,'0965224','1',NULL,'017','SE','I','',NULL,NULL,NULL,NULL,'-217600.00','-4','0314064',NULL,'0314064',NULL,NULL,'','I','0.000','0',NULL,'10017','2017-09-14','14092017','0','','','','',NULL,NULL,NULL),('16181353','0013151000300929','2017-09-14','590','007','A.W.B','8706165','01','1',NULL,'I','','2000',NULL,'0','0','10','0','017','168','AMAR RIFFI','I','','1','1','2000','027776254',NULL,NULL,'0467393','1',NULL,'017','SC','I','',NULL,NULL,NULL,NULL,'-217600.00','-4','0314064',NULL,'0314064',NULL,NULL,'','I','0.000','0',NULL,'10017','2017-09-14','01092017','0','','','','',NULL,NULL,NULL),('16181962','2121159912860008','2017-09-14','433','143','BP Laayoune','4095127','66','1',NULL,'I','','2064',NULL,'0','0','114','0','206','008','AGADIR KETTANI','I','','1','1','2064','005077461',NULL,NULL,'0503220','1',NULL,'206','SE','I','',NULL,NULL,NULL,NULL,'-495860.08','-11','0026793',NULL,'0026793',NULL,NULL,'','I','0.000','0',NULL,'10206','2017-09-14','0','0','','','','',NULL,NULL,NULL),('16181965','0010513000300429','2017-09-14','022','007','A.W.B','7907805','59','1',NULL,'I','','10400',NULL,'0','0','116','0','206','008','AGADIR KETTANI','I','','1','1','10400','004005126',NULL,NULL,'0511471','1',NULL,'206','SE','I','',NULL,NULL,NULL,NULL,'-495860.08','-11','0026793',NULL,'0026793',NULL,NULL,'','I','0.000','0',NULL,'10206','2017-09-14','13082017','0','','','','',NULL,NULL,NULL),('16181968','2111142328330008','2017-09-14','530','143','BP Laayoune','6470200','43','1',NULL,'I','','8384.44',NULL,'0','0','118','0','206','008','AGADIR KETTANI','I','','1','1','8384.44','010810840',NULL,NULL,'0678736','1',NULL,'206','SE','I','',NULL,NULL,NULL,NULL,'-495860.08','-11','0026793',NULL,'0026793',NULL,NULL,'','I','0.000','0',NULL,'10206','2017-09-14','10092017','0','','','','',NULL,NULL,NULL),('16181971','0003320027534739','2017-09-14','010','022','S.G.M.B','3119050','25','1',NULL,'I','','6776.34',NULL,'0','0','120','0','206','008','AGADIR KETTANI','I','','1','1','15911.34','028992520',NULL,NULL,'0400964','3',NULL,'206','SE','I','',NULL,NULL,NULL,NULL,'-495860.08','-11','0026793',NULL,'0026793',NULL,NULL,'','I','0.000','0',NULL,'10206','2017-09-14','15102017','1','','','','',NULL,NULL,NULL),('16181972','0002210005005138','2017-09-14','010','022','S.G.M.B','2691080','25','1',NULL,'I','','1194',NULL,'0','0','121','0','206','008','AGADIR KETTANI','I','','1','1','15911.34','028992520',NULL,NULL,'0400964','3',NULL,'206','SE','I','',NULL,NULL,NULL,NULL,'-495860.08','-11','0026793',NULL,'0026793',NULL,NULL,'','I','0.000','0',NULL,'10206','2017-09-14','20092017','1','','','','',NULL,NULL,NULL),('16181973','0003320027534739','2017-09-14','010','022','S.G.M.B','3119051','25','1',NULL,'I','','7941',NULL,'0','0','122','0','206','008','AGADIR KETTANI','I','','1','1','15911.34','028992520',NULL,NULL,'0400964','3',NULL,'206','SE','I','',NULL,NULL,NULL,NULL,'-495860.08','-11','0026793',NULL,'0026793',NULL,NULL,'','I','0.000','0',NULL,'10206','2017-09-14','30102017','1','','','','',NULL,NULL,NULL),('16181976','0004992000000848','2017-09-14','010','007','A.W.B','0747503','58','1',NULL,'I','','39690.72',NULL,'1','0','124','0','206','008','AGADIR KETTANI','I','','1','1','39690.72','028992520',NULL,NULL,'0400965','1',NULL,'206','SE','I','',NULL,NULL,NULL,NULL,'-495860.08','-11','0026793',NULL,'0026793',NULL,NULL,'','I','0.000','0',NULL,'10206','2017-09-14','28122017','0','','','','',NULL,NULL,NULL),('16181979','0000012100006791','2017-09-14','010','011','B.M.C.E','0415357','86','1',NULL,'I','','15000',NULL,'0','0','126','0','206','008','AGADIR KETTANI','I','','1','1','15000','005077461',NULL,NULL,'0503215','1',NULL,'206','SE','I','',NULL,NULL,NULL,NULL,'-495860.08','-11','0026793',NULL,'0026793',NULL,NULL,'','I','0.000','0',NULL,'10206','2017-09-14','14102017','0','','','','',NULL,NULL,NULL),('16181982','2121159912860008','2017-09-14','433','143','BP Laayoune','4095126','66','1',NULL,'I','','21000',NULL,'0','0','128','0','206','008','AGADIR KETTANI','I','','1','1','21000','005077461',NULL,NULL,'0503214','1',NULL,'206','SE','I','',NULL,NULL,NULL,NULL,'-495860.08','-11','0026793',NULL,'0026793',NULL,NULL,'','I','0.000','0',NULL,'10206','2017-09-14','24122017','0','','','','',NULL,NULL,NULL),('16181985','2121159912860008','2017-09-14','433','143','BP Laayoune','4095120','66','1',NULL,'I','','21000',NULL,'0','0','130','0','206','008','AGADIR KETTANI','I','','1','1','21000','005077461',NULL,NULL,'0503213','1',NULL,'206','SE','I','',NULL,NULL,NULL,NULL,'-495860.08','-11','0026793',NULL,'0026793',NULL,NULL,'','I','0.000','0',NULL,'10206','2017-09-14','24112017','0','','','','',NULL,NULL,NULL),('16181988','0000012100006791','2017-09-14','010','011','B.M.C.E','0415359','86','1',NULL,'I','','15000',NULL,'0','0','132','0','206','008','AGADIR KETTANI','I','','1','1','15000','005077461',NULL,NULL,'0503218','1',NULL,'206','SE','I','',NULL,NULL,NULL,NULL,'-495860.08','-11','0026793',NULL,'0026793',NULL,NULL,'','I','0.000','0',NULL,'10206','2017-09-14','23122017','0','','','','',NULL,NULL,NULL),('16181991','0000012100006791','2017-09-14','010','011','B.M.C.E','0415358','86','1',NULL,'I','','15000',NULL,'0','0','134','0','206','008','AGADIR KETTANI','I','','1','1','15000','005077461',NULL,NULL,'0503216','1',NULL,'206','SE','I','',NULL,NULL,NULL,NULL,'-495860.08','-11','0026793',NULL,'0026793',NULL,NULL,'','I','0.000','0',NULL,'10206','2017-09-14','16122017','0','','','','',NULL,NULL,NULL),('16181994','0476006446510116','2017-09-14','010','225','C.A.M','7012248','89','1',NULL,'I','','332409.58',NULL,'0','0','136','0','206','008','AGADIR KETTANI','I','','1','1','332409.58','005230721',NULL,NULL,'1440659','1',NULL,'206','SE','I','',NULL,NULL,NULL,NULL,'-495860.08','-11','0026793',NULL,'0026793',NULL,NULL,'','I','0.000','0',NULL,'10206','2017-09-14','0','0','','','','',NULL,NULL,NULL),('16181999','0126600000500107','2017-09-14','450','013','B.M.C.I','4881932','27','1',NULL,'I','','82223.73',NULL,'1','0','139','0','206','071','AGADIR TALBORJT','I','','1','1','82223.73','005086693',NULL,NULL,'0160906','1',NULL,'206','SE','I','',NULL,NULL,NULL,NULL,'-82223.73','-1','0425774',NULL,'0425774',NULL,NULL,'','I','0.000','0',NULL,'10206','2017-09-14','18092017','0','','','','',NULL,NULL,NULL),('16182004','2121188108050009','2017-09-14','010','101','BP Centre Sud','5527722','27','1',NULL,'I','','15371.44',NULL,'0','0','142','0','206','223','AGADIR MASSIRA','I','','1','1','123852.24','027379836',NULL,NULL,'0330359','5',NULL,'206','SE','I','',NULL,NULL,NULL,NULL,'-211108.24','-4','0337736',NULL,'0337736',NULL,NULL,'','I','0.000','0',NULL,'10206','2017-09-14','30092017','0','','','','',NULL,NULL,NULL),('16182005','2121104193510013','2017-09-14','010','101','BP Centre Sud','4584773','68','1',NULL,'I','','13217.5',NULL,'0','0','143','0','206','223','AGADIR MASSIRA','I','','1','1','123852.24','027379836',NULL,NULL,'0330359','5',NULL,'206','SE','I','',NULL,NULL,NULL,NULL,'-211108.24','-4','0337736',NULL,'0337736',NULL,NULL,'','I','0.000','0',NULL,'10206','2017-09-14','29092017','0','','','','',NULL,NULL,NULL),('16182006','0000336030029181','2017-09-14','010','021','C.D.M','5378534','88','1',NULL,'I','','12998.15',NULL,'0','0','144','0','206','223','AGADIR MASSIRA','I','','1','1','123852.24','027379836',NULL,NULL,'0330359','5',NULL,'206','SE','I','',NULL,NULL,NULL,NULL,'-211108.24','-4','0337736',NULL,'0337736',NULL,NULL,'','I','0.000','0',NULL,'10206','2017-09-14','14092017','0','','','','',NULL,NULL,NULL),('16182007','0004992000000848','2017-09-14','010','007','A.W.B','0747473','58','1',NULL,'I','','54346.48',NULL,'1','0','145','0','206','223','AGADIR MASSIRA','I','','1','1','123852.24','027379836',NULL,NULL,'0330359','5',NULL,'206','SE','I','',NULL,NULL,NULL,NULL,'-211108.24','-4','0337736',NULL,'0337736',NULL,NULL,'','I','0.000','0',NULL,'10206','2017-09-14','20092017','0','','','','',NULL,NULL,NULL),('16182008','0004150030742633','2017-09-14','010','022','S.G.M.B','3441960','25','1',NULL,'I','','27918.67',NULL,'0','0','146','0','206','223','AGADIR MASSIRA','I','','1','1','123852.24','027379836',NULL,NULL,'0330359','5',NULL,'206','SE','I','',NULL,NULL,NULL,NULL,'-211108.24','-4','0337736',NULL,'0337736',NULL,NULL,'','I','0.000','0',NULL,'10206','2017-09-14','05092017','1','','','','',NULL,NULL,NULL),('16182011','2121195690420011','2017-09-14','727','164','BP Tanger Tetouan','4919860','55','0','RATU','I','','14000',NULL,'0','0','148','0','206','223','AGADIR MASSIRA','I','','1','1','21506','005005040',NULL,NULL,'0484835','3',NULL,'206','SE','I','',NULL,NULL,NULL,NULL,'-211108.24','-4','0337736',NULL,'0337736',NULL,NULL,'','I','0.000','0',NULL,'10206','2017-09-14','05062017','0','','','','',NULL,NULL,NULL),('16182012','2121195690420011','2017-09-14','727','164','BP Tanger Tetouan','4919864','55','1',NULL,'I','','3900',NULL,'0','0','149','0','206','223','AGADIR MASSIRA','I','','1','1','21506','005005040',NULL,NULL,'0484835','3',NULL,'206','SE','I','',NULL,NULL,NULL,NULL,'-211108.24','-4','0337736',NULL,'0337736',NULL,NULL,'','I','0.000','0',NULL,'10206','2017-09-14','10072017','0','','','','',NULL,NULL,NULL),('16182013','0000062100002992','2017-09-14','010','011','B.M.C.E','0410587','78','1',NULL,'I','','3606',NULL,'0','0','150','0','206','223','AGADIR MASSIRA','I','','1','1','21506','005005040',NULL,NULL,'0484835','3',NULL,'206','SE','I','',NULL,NULL,NULL,NULL,'-211108.24','-4','0337736',NULL,'0337736',NULL,NULL,'','I','0.000','0',NULL,'10206','2017-09-14','15092017','0','','','','',NULL,NULL,NULL),('16182016','0003320027516212','2017-09-14','010','022','S.G.M.B','3270939','25','1',NULL,'I','','750',NULL,'0','0','152','0','206','223','AGADIR MASSIRA','I','','1','1','750','027467136',NULL,NULL,'0730427','1',NULL,'206','SE','I','',NULL,NULL,NULL,NULL,'-211108.24','-4','0337736',NULL,'0337736',NULL,NULL,'','I','0.000','0',NULL,'10206','2017-09-14','0','1','','','','',NULL,NULL,NULL),('16182019','0000710005070688','2017-09-14','010','022','S.G.M.B','9624390','25','1',NULL,'I','','65000',NULL,'0','0','154','0','206','223','AGADIR MASSIRA','I','','1','1','65000','027569665',NULL,NULL,'0730434','1',NULL,'206','SE','I','',NULL,NULL,NULL,NULL,'-211108.24','-4','0337736',NULL,'0337736',NULL,NULL,'','I','0.000','0',NULL,'10206','2017-09-14','30082017','1','','','','',NULL,NULL,NULL),('16182024','0000042100009624','2017-09-14','022','011','B.M.C.E','0326618','69','1',NULL,'I','','100000',NULL,'0','0','157','0','206','342','AIT MELLOUL ZONE INDUSTRIELLE','I','','1','1','100000','027346845',NULL,NULL,'0621349','1',NULL,'206','SE','I','',NULL,NULL,NULL,NULL,'-1577012.69','-6','0401019',NULL,'0401019',NULL,NULL,'','I','0.000','0','100000.00','10206','2017-09-14','02102017','0','','','','',NULL,NULL,NULL),('16182027','0000052100000176','2017-09-14','022','011','B.M.C.E','0484717','39','1',NULL,'I','','30265.47',NULL,'0','0','159','0','206','342','AIT MELLOUL ZONE INDUSTRIELLE','I','','1','1','276657.04','005061289',NULL,NULL,'0695588','7',NULL,'206','SE','I','',NULL,NULL,NULL,NULL,'-1577012.69','-6','0401019',NULL,'0401019',NULL,NULL,'','I','0.000','0',NULL,'10206','2017-09-14','20122017','0','','','','',NULL,NULL,NULL),('16182028','0058122536510119','2017-09-14','028','225','C.A.M','7281027','55','1',NULL,'I','','16552.24',NULL,'0','0','160','0','206','342','AIT MELLOUL ZONE INDUSTRIELLE','I','','1','1','276657.04','005061289',NULL,NULL,'0695588','7',NULL,'206','SE','I','',NULL,NULL,NULL,NULL,'-1577012.69','-6','0401019',NULL,'0401019',NULL,NULL,'','I','0.000','0',NULL,'10206','2017-09-14','22122017','0','','','','',NULL,NULL,NULL),('16182029','0003420005002701','2017-09-14','010','022','S.G.M.B','2992407','25','1',NULL,'I','','30749.48',NULL,'0','0','161','0','206','342','AIT MELLOUL ZONE INDUSTRIELLE','I','','1','1','276657.04','005061289',NULL,NULL,'0695588','7',NULL,'206','SE','I','',NULL,NULL,NULL,NULL,'-1577012.69','-6','0401019',NULL,'0401019',NULL,NULL,'','I','0.000','0',NULL,'10206','2017-09-14','22122017','2','','','','',NULL,NULL,NULL),('16182030','0058122536510119','2017-09-14','028','225','C.A.M','7281018','55','1',NULL,'I','','57594.92',NULL,'0','0','162','0','206','342','AIT MELLOUL ZONE INDUSTRIELLE','I','','1','1','276657.04','005061289',NULL,NULL,'0695588','7',NULL,'206','SE','I','',NULL,NULL,NULL,NULL,'-1577012.69','-6','0401019',NULL,'0401019',NULL,NULL,'','I','0.000','0',NULL,'10206','2017-09-14','26122017','0','','','','',NULL,NULL,NULL),('16182031','0000052100000176','2017-09-14','022','011','B.M.C.E','0484712','39','1',NULL,'I','','55000',NULL,'0','0','163','0','206','342','AIT MELLOUL ZONE INDUSTRIELLE','I','','1','1','276657.04','005061289',NULL,NULL,'0695588','7',NULL,'206','SE','I','',NULL,NULL,NULL,NULL,'-1577012.69','-6','0401019',NULL,'0401019',NULL,NULL,'','I','0.000','0',NULL,'10206','2017-09-14','27122017','0','','','','',NULL,NULL,NULL),('16182032','0000052100000176','2017-09-14','022','011','B.M.C.E','0484718','39','1',NULL,'I','','30200',NULL,'0','0','164','0','206','342','AIT MELLOUL ZONE INDUSTRIELLE','I','','1','1','276657.04','005061289',NULL,NULL,'0695588','7',NULL,'206','SE','I','',NULL,NULL,NULL,NULL,'-1577012.69','-6','0401019',NULL,'0401019',NULL,NULL,'','I','0.000','0',NULL,'10206','2017-09-14','28122017','0','','','','',NULL,NULL,NULL),('16182033','0003420005002701','2017-09-14','010','022','S.G.M.B','2992319','25','1',NULL,'I','','56294.93',NULL,'0','0','165','0','206','342','AIT MELLOUL ZONE INDUSTRIELLE','I','','1','1','276657.04','005061289',NULL,NULL,'0695588','7',NULL,'206','SE','I','',NULL,NULL,NULL,NULL,'-1577012.69','-6','0401019',NULL,'0401019',NULL,NULL,'','I','0.000','0',NULL,'10206','2017-09-14','31122017','2','','','','',NULL,NULL,NULL),('16182036','0101132656010105','2017-09-14','465','225','C.A.M','7771954','72','1',NULL,'I','','33600',NULL,'0','0','167','0','206','342','AIT MELLOUL ZONE INDUSTRIELLE','I','','1','1','453600','005003671',NULL,NULL,'0408145','3',NULL,'206','SE','I','',NULL,NULL,NULL,NULL,'-1577012.69','-6','0401019',NULL,'0401019',NULL,NULL,'','I','0.000','0',NULL,'10206','2017-09-14','15012018','0','','','','',NULL,NULL,NULL),('16182037','0141070336010124','2017-09-14','022','225','C.A.M','7187671','17','0','RATU','I','','400000',NULL,'0','0','168','0','206','342','AIT MELLOUL ZONE INDUSTRIELLE','I','','1','1','453600','005003671',NULL,NULL,'0408145','3',NULL,'206','SE','I','',NULL,NULL,NULL,NULL,'-1577012.69','-6','0401019',NULL,'0401019',NULL,NULL,'','I','0.000','0',NULL,'10206','2017-09-14','31012018','0','','','','',NULL,NULL,NULL),('16182038','0002440027833737','2017-09-14','011','022','S.G.M.B','2633936','33','1',NULL,'I','','20000',NULL,'0','0','169','0','206','342','AIT MELLOUL ZONE INDUSTRIELLE','I','','1','1','453600','005003671',NULL,NULL,'0408145','3',NULL,'206','SE','I','',NULL,NULL,NULL,NULL,'-1577012.69','-6','0401019',NULL,'0401019',NULL,NULL,'','I','0.000','0',NULL,'10206','2017-09-14','30012018','1','','','','',NULL,NULL,NULL),('16182041','0730001336610107','2017-09-14','022','225','C.A.M','7363574','71','1',NULL,'I','','50000',NULL,'0','0','171','0','206','342','AIT MELLOUL ZONE INDUSTRIELLE','I','','1','1','174808','005003671',NULL,NULL,'0408144','5',NULL,'206','SE','I','',NULL,NULL,NULL,NULL,'-1577012.69','-6','0401019',NULL,'0401019',NULL,NULL,'','I','0.000','0',NULL,'10206','2017-09-14','10102017','0','','','','',NULL,NULL,NULL),('16182042','0730001336610107','2017-09-14','022','225','C.A.M','7363575','71','1',NULL,'I','','50000',NULL,'0','0','172','0','206','342','AIT MELLOUL ZONE INDUSTRIELLE','I','','1','1','174808','005003671',NULL,NULL,'0408144','5',NULL,'206','SE','I','',NULL,NULL,NULL,NULL,'-1577012.69','-6','0401019',NULL,'0401019',NULL,NULL,'','I','0.000','0',NULL,'10206','2017-09-14','20102017','0','','','','',NULL,NULL,NULL),('16182043','0144013426510117','2017-09-14','028','225','C.A.M','7030571','11','1',NULL,'I','','25000',NULL,'0','0','173','0','206','342','AIT MELLOUL ZONE INDUSTRIELLE','I','','1','1','174808','005003671',NULL,NULL,'0408144','5',NULL,'206','SE','I','',NULL,NULL,NULL,NULL,'-1577012.69','-6','0401019',NULL,'0401019',NULL,NULL,'','I','0.000','0',NULL,'10206','2017-09-14','20102017','0','','','','',NULL,NULL,NULL),('16182044','0141045166610122','2017-09-14','022','225','C.A.M','7449874','76','1',NULL,'I','','38208',NULL,'0','0','174','0','206','342','AIT MELLOUL ZONE INDUSTRIELLE','I','','1','1','174808','005003671',NULL,NULL,'0408144','5',NULL,'206','SE','I','',NULL,NULL,NULL,NULL,'-1577012.69','-6','0401019',NULL,'0401019',NULL,NULL,'','I','0.000','0',NULL,'10206','2017-09-14','30102017','0','','','','',NULL,NULL,NULL),('16182045','0101132656010105','2017-09-14','465','225','C.A.M','7771952','72','1',NULL,'I','','11600',NULL,'0','0','175','0','206','342','AIT MELLOUL ZONE INDUSTRIELLE','I','','1','1','174808','005003671',NULL,NULL,'0408144','5',NULL,'206','SE','I','',NULL,NULL,NULL,NULL,'-1577012.69','-6','0401019',NULL,'0401019',NULL,NULL,'','I','0.000','0',NULL,'10206','2017-09-14','15102017','0','','','','',NULL,NULL,NULL),('16182048','0730001336610107','2017-09-14','022','225','C.A.M','7363578','71','1',NULL,'I','','50000',NULL,'0','0','177','0','206','342','AIT MELLOUL ZONE INDUSTRIELLE','I','','1','1','399277','005003671',NULL,NULL,'0408146','4',NULL,'206','SE','I','',NULL,NULL,NULL,NULL,'-1577012.69','-6','0401019',NULL,'0401019',NULL,NULL,'','I','0.000','0',NULL,'10206','2017-09-14','01122017','0','','','','',NULL,NULL,NULL),('16182049','0730001336610107','2017-09-14','022','225','C.A.M','7363579','71','1',NULL,'I','','41307',NULL,'0','0','178','0','206','342','AIT MELLOUL ZONE INDUSTRIELLE','I','','1','1','399277','005003671',NULL,NULL,'0408146','4',NULL,'206','SE','I','',NULL,NULL,NULL,NULL,'-1577012.69','-6','0401019',NULL,'0401019',NULL,NULL,'','I','0.000','0',NULL,'10206','2017-09-14','20122017','0','','','','',NULL,NULL,NULL),('16182050','0141070336010124','2017-09-14','022','225','C.A.M','7187669','17','1',NULL,'I','','287970',NULL,'0','0','179','0','206','342','AIT MELLOUL ZONE INDUSTRIELLE','I','','1','1','399277','005003671',NULL,NULL,'0408146','4',NULL,'206','SE','I','',NULL,NULL,NULL,NULL,'-1577012.69','-6','0401019',NULL,'0401019',NULL,NULL,'','I','0.000','0',NULL,'10206','2017-09-14','31122017','0','','','','',NULL,NULL,NULL),('16182051','0002440027833737','2017-09-14','011','022','S.G.M.B','2633935','33','1',NULL,'I','','20000',NULL,'0','0','180','0','206','342','AIT MELLOUL ZONE INDUSTRIELLE','I','','1','1','399277','005003671',NULL,NULL,'0408146','4',NULL,'206','SE','I','',NULL,NULL,NULL,NULL,'-1577012.69','-6','0401019',NULL,'0401019',NULL,NULL,'','I','0.000','0',NULL,'10206','2017-09-14','30122017','1','','','','',NULL,NULL,NULL),('16182054','0730001336610107','2017-09-14','022','225','C.A.M','7363576','71','1',NULL,'I','','50000',NULL,'0','0','182','0','206','342','AIT MELLOUL ZONE INDUSTRIELLE','I','','1','1','172670.65','005003671',NULL,NULL,'0408147','6',NULL,'206','SE','I','',NULL,NULL,NULL,NULL,'-1577012.69','-6','0401019',NULL,'0401019',NULL,NULL,'','I','0.00','0','172670.65','10206','2017-09-14','01112017','0','','','','',NULL,NULL,NULL),('16182055','0730001336610107','2017-09-14','022','225','C.A.M','7363577','71','1',NULL,'I','','50000',NULL,'0','0','183','0','206','342','AIT MELLOUL ZONE INDUSTRIELLE','I','','1','1','172670.65','005003671',NULL,NULL,'0408147','6',NULL,'206','SE','I','',NULL,NULL,NULL,NULL,'-1577012.69','-6','0401019',NULL,'0401019',NULL,NULL,'','I','0.00','0','172670.65','10206','2017-09-14','20112017','0','','','','',NULL,NULL,NULL),('16182056','0144013426510117','2017-09-14','028','225','C.A.M','7030572','11','1',NULL,'I','','27851.25',NULL,'0','0','184','0','206','342','AIT MELLOUL ZONE INDUSTRIELLE','I','','1','1','172670.65','005003671',NULL,NULL,'0408147','6',NULL,'206','SE','I','',NULL,NULL,NULL,NULL,'-1577012.69','-6','0401019',NULL,'0401019',NULL,NULL,'','I','0.00','0','172670.65','10206','2017-09-14','20112017','0','','','','',NULL,NULL,NULL),('16182057','0002440027833737','2017-09-14','011','022','S.G.M.B','2633934','33','1',NULL,'I','','4970.4',NULL,'0','0','185','0','206','342','AIT MELLOUL ZONE INDUSTRIELLE','I','','1','1','172670.65','005003671',NULL,NULL,'0408147','6',NULL,'206','SE','I','',NULL,NULL,NULL,NULL,'-1577012.69','-6','0401019',NULL,'0401019',NULL,NULL,'','I','0.00','0','172670.65','10206','2017-09-14','30112017','1','','','','',NULL,NULL,NULL),('16182058','0483015976610114','2017-09-14','010','225','C.A.M','7493058','32','0','DIFF','I','','12449',NULL,'0','0','186','0','206','342','AIT MELLOUL ZONE INDUSTRIELLE','I','','1','1','172670.65','005003671',NULL,NULL,'0408147','6',NULL,'206','SE','I','',NULL,NULL,NULL,NULL,'-1577012.69','-6','0401019',NULL,'0401019',NULL,NULL,'','I','0.00','0','172670.65','10206','2017-09-14','12112017','0','','','','',NULL,NULL,NULL),('16182059','0706009146610105','2017-09-14','011','225','C.A.M','7346256','24','1',NULL,'I','','27400',NULL,'0','0','187','0','206','342','AIT MELLOUL ZONE INDUSTRIELLE','I','','1','1','172670.65','005003671',NULL,NULL,'0408147','6',NULL,'206','SE','I','',NULL,NULL,NULL,NULL,'-1577012.69','-6','0401019',NULL,'0401019',NULL,NULL,'','I','0.00','0','172670.65','10206','2017-09-14','25112017','0','','','','',NULL,NULL,NULL),('16185883','0000092100061845','2017-09-14','780','011','B.M.C.E','0001302','55','1',NULL,'I','','2841.6',NULL,'0','0','13','0','017','017','SAFI','I','','1','1','8032.8','005473362',NULL,NULL,'0462851','2',NULL,'017','SE','I','',NULL,NULL,NULL,NULL,'-557553.42','-3','0314066',NULL,'0314066',NULL,NULL,'','I','0.000','0','8032.80','10017','2017-09-14','10092017','0','','','','',NULL,NULL,NULL),('16185884','0000092100061845','2017-09-14','780','011','B.M.C.E','0001115','55','1',NULL,'I','','5191.2',NULL,'0','0','14','0','017','017','SAFI','I','','1','1','8032.8','005473362',NULL,NULL,'0462851','2',NULL,'017','SE','I','',NULL,NULL,NULL,NULL,'-557553.42','-3','0314066',NULL,'0314066',NULL,NULL,'','I','0.000','0','8032.80','10017','2017-09-14','10082017','0','','','','',NULL,NULL,NULL),('16185887','0000303000041706','2017-09-14','450','007','A.W.B','3733652','91','1',NULL,'I','','6446.2',NULL,'0','0','16','0','017','102','TE AIN SEBAA','I','','1','1','160008.25','028863463',NULL,NULL,'0467398','8',NULL,'017','SA','I','',NULL,NULL,NULL,NULL,'-557553.42','-3','0314066',NULL,'0314066',NULL,NULL,'','I','0.000','0',NULL,'10017','2017-09-14','30092017','0','','','','',NULL,NULL,NULL),('16185888','0002530007600357','2017-09-14','170','022','S.G.M.B','2359689','44','1',NULL,'I','','41193.8',NULL,'0','0','17','0','017','102','TE AIN SEBAA','I','','1','1','160008.25','028863463',NULL,NULL,'0467398','8',NULL,'017','SA','I','',NULL,NULL,NULL,NULL,'-557553.42','-3','0314066',NULL,'0314066',NULL,NULL,'','I','0.000','0',NULL,'10017','2017-09-14','31102017','2','','','','',NULL,NULL,NULL),('16185889','0012831000300510','2017-09-14','240','007','A.W.B','7410111','58','1',NULL,'I','','2428.65',NULL,'1','0','18','0','017','102','TE AIN SEBAA','I','','1','1','160008.25','028863463',NULL,NULL,'0467398','8',NULL,'017','SA','I','',NULL,NULL,NULL,NULL,'-557553.42','-3','0314066',NULL,'0314066',NULL,NULL,'','I','0.000','0',NULL,'10017','2017-09-14','28092017','0','','','','',NULL,NULL,NULL),('16185890','2121194779310011','2017-09-14','240','101','BP Centre Sud','7237546','31','1',NULL,'I','','27701.93',NULL,'0','0','19','0','017','102','TE AIN SEBAA','I','','1','1','160008.25','028863463',NULL,NULL,'0467398','8',NULL,'017','SA','I','',NULL,NULL,NULL,NULL,'-557553.42','-3','0314066',NULL,'0314066',NULL,NULL,'','I','0.000','0',NULL,'10017','2017-09-14','31102017','0','','','','',NULL,NULL,NULL),('16185891','0135100226010117','2017-09-14','240','225','C.A.M','7011381','93','1',NULL,'I','','22240.44',NULL,'0','0','20','0','017','102','TE AIN SEBAA','I','','1','1','160008.25','028863463',NULL,NULL,'0467398','8',NULL,'017','SA','I','',NULL,NULL,NULL,NULL,'-557553.42','-3','0314066',NULL,'0314066',NULL,NULL,'','I','0.000','0',NULL,'10017','2017-09-14','30102017','0','','','','',NULL,NULL,NULL),('16185892','0004957000301202','2017-09-14','450','007','A.W.B','7252633','38','1',NULL,'I','','9202.82',NULL,'0','0','21','0','017','102','TE AIN SEBAA','I','','1','1','160008.25','028863463',NULL,NULL,'0467398','8',NULL,'017','SA','I','',NULL,NULL,NULL,NULL,'-557553.42','-3','0314066',NULL,'0314066',NULL,NULL,'','I','0.000','0',NULL,'10017','2017-09-14','30092017','0','','','','',NULL,NULL,NULL),('16185893','2121172034880002','2017-09-14','450','145','BP Marrakech Beni Mellal','3885440','16','1',NULL,'I','','15730.79',NULL,'0','0','22','0','017','102','TE AIN SEBAA','I','','1','1','160008.25','028863463',NULL,NULL,'0467398','8',NULL,'017','SA','I','',NULL,NULL,NULL,NULL,'-557553.42','-3','0314066',NULL,'0314066',NULL,NULL,'','I','0.000','0',NULL,'10017','2017-09-14','30092017','0','','','','',NULL,NULL,NULL),('16185894','0000012100060178','2017-09-14','607','011','B.M.C.E','4553905','95','1',NULL,'I','','35063.62',NULL,'0','0','23','0','017','102','TE AIN SEBAA','I','','1','1','160008.25','028863463',NULL,NULL,'0467398','8',NULL,'017','SA','I','',NULL,NULL,NULL,NULL,'-557553.42','-3','0314066',NULL,'0314066',NULL,NULL,'','I','0.000','0',NULL,'10017','2017-09-14','30102017','0','','','','',NULL,NULL,NULL),('16185897','0113300020200114','2017-09-14','590','013','B.M.C.I','6138860','80','1',NULL,'I','','32522.57',NULL,'0','0','25','0','017','102','TE AIN SEBAA','I','','1','1','389512.37','028863463',NULL,NULL,'0462850','12',NULL,'017','SA','I','',NULL,NULL,NULL,NULL,'-557553.42','-3','0314066',NULL,'0314066',NULL,NULL,'','I','0.00','0','389512.37','10017','2017-09-14','30092017','0','','','','',NULL,NULL,NULL),('16185898','2121171828510015','2017-09-14','590','145','BP Marrakech Beni Mellal','2777993','61','1',NULL,'I','','3423.21',NULL,'0','0','26','0','017','102','TE AIN SEBAA','I','','1','1','389512.37','028863463',NULL,NULL,'0462850','12',NULL,'017','SA','I','',NULL,NULL,NULL,NULL,'-557553.42','-3','0314066',NULL,'0314066',NULL,NULL,'','I','0.00','0','389512.37','10017','2017-09-14','30092017','0','','','','',NULL,NULL,NULL),('16185899','0003945000000283','2017-09-14','590','007','A.W.B','1257409','85','1',NULL,'I','','41144.32',NULL,'1','0','27','0','017','102','TE AIN SEBAA','I','','1','1','389512.37','028863463',NULL,NULL,'0462850','12',NULL,'017','SA','I','',NULL,NULL,NULL,NULL,'-557553.42','-3','0314066',NULL,'0314066',NULL,NULL,'','I','0.00','0','389512.37','10017','2017-09-14','30102017','0','','','','',NULL,NULL,NULL),('16185900','2121150327400001','2017-09-14','590','117','BP El Jadida Safi','4872705','28','1',NULL,'I','','29712',NULL,'0','0','28','0','017','102','TE AIN SEBAA','I','','1','1','389512.37','028863463',NULL,NULL,'0462850','12',NULL,'017','SA','I','',NULL,NULL,NULL,NULL,'-557553.42','-3','0314066',NULL,'0314066',NULL,NULL,'','I','0.00','0','389512.37','10017','2017-09-14','30102017','0','','','','',NULL,NULL,NULL),('16185901','0113300020200114','2017-09-14','590','013','B.M.C.I','6138862','80','1',NULL,'I','','28262.33',NULL,'0','0','29','0','017','102','TE AIN SEBAA','I','','1','1','389512.37','028863463',NULL,NULL,'0462850','12',NULL,'017','SA','I','',NULL,NULL,NULL,NULL,'-557553.42','-3','0314066',NULL,'0314066',NULL,NULL,'','I','0.00','0','389512.37','10017','2017-09-14','30102017','0','','','','',NULL,NULL,NULL),('16185902','0000170028100649','2017-09-14','590','022','S.G.M.B','1858794','09','1',NULL,'I','','28888.11',NULL,'0','0','30','0','017','102','TE AIN SEBAA','I','','1','1','389512.37','028863463',NULL,NULL,'0462850','12',NULL,'017','SA','I','',NULL,NULL,NULL,NULL,'-557553.42','-3','0314066',NULL,'0314066',NULL,NULL,'','I','0.00','0','389512.37','10017','2017-09-14','30102017','2','','','','',NULL,NULL,NULL),('16185903','0113300016400139','2017-09-14','590','013','B.M.C.I','5866921','80','1',NULL,'I','','39377.94',NULL,'0','0','31','0','017','102','TE AIN SEBAA','I','','1','1','389512.37','028863463',NULL,NULL,'0462850','12',NULL,'017','SA','I','',NULL,NULL,NULL,NULL,'-557553.42','-3','0314066',NULL,'0314066',NULL,NULL,'','I','0.00','0','389512.37','10017','2017-09-14','30112018','0','','','','',NULL,NULL,NULL),('16185904','2121172844050002','2017-09-14','590','117','BP El Jadida Safi','4748413','14','1',NULL,'I','','83268.56',NULL,'1','0','32','0','017','102','TE AIN SEBAA','I','','1','1','389512.37','028863463',NULL,NULL,'0462850','12',NULL,'017','SA','I','',NULL,NULL,NULL,NULL,'-557553.42','-3','0314066',NULL,'0314066',NULL,NULL,'','I','0.00','0','389512.37','10017','2017-09-14','30092017','0','','','','',NULL,NULL,NULL),('16185905','2121199504800020','2017-09-14','590','145','BP Marrakech Beni Mellal','6292871','50','1',NULL,'I','','22729.82',NULL,'0','0','33','0','017','102','TE AIN SEBAA','I','','1','1','389512.37','028863463',NULL,NULL,'0462850','12',NULL,'017','SA','I','',NULL,NULL,NULL,NULL,'-557553.42','-3','0314066',NULL,'0314066',NULL,NULL,'','I','0.00','0','389512.37','10017','2017-09-14','30102017','0','','','','',NULL,NULL,NULL),('16185906','0000303000041706','2017-09-14','450','007','A.W.B','3733655','91','1',NULL,'I','','4281.82',NULL,'0','0','34','0','017','102','TE AIN SEBAA','I','','1','1','389512.37','028863463',NULL,NULL,'0462850','12',NULL,'017','SA','I','',NULL,NULL,NULL,NULL,'-557553.42','-3','0314066',NULL,'0314066',NULL,NULL,'','I','0.00','0','389512.37','10017','2017-09-14','30102017','0','','','','',NULL,NULL,NULL),('16185907','0004003000300046','2017-09-14','607','007','A.W.B','9213420','26','1',NULL,'I','','63526.26',NULL,'0','0','35','0','017','102','TE AIN SEBAA','I','','1','1','389512.37','028863463',NULL,NULL,'0462850','12',NULL,'017','SA','I','',NULL,NULL,NULL,NULL,'-557553.42','-3','0314066',NULL,'0314066',NULL,NULL,'','I','0.00','0','389512.37','10017','2017-09-14','30112017','0','','','','',NULL,NULL,NULL),('16185908','0672010696610116','2017-10-24','590','225','C.A.M','6790334','88','1',NULL,'I','','12375.43',NULL,'0','0','36','0','017','102','TE AIN SEBAA','I','','1','1','389512.37','028863463',NULL,NULL,'0462850','12',NULL,'017','SA','I','',NULL,NULL,NULL,NULL,'-557553.42','-3','0314066',NULL,'0314066',NULL,NULL,'','I','0.00','0','389512.37','10017','2017-09-14','30102017','0','','','','',NULL,NULL,NULL),('16440771','0000538000000675','2017-10-24','270','007','A.W.B','3866651','95','1',NULL,'I','','5000',NULL,'0','0','10','364','140','140','AGENCE GRANDES ENTREPRISES','I','','0','1','5000','005079238',NULL,NULL,'0000008','1','136','140','SD','I','',NULL,NULL,NULL,NULL,'10000.00','0','0000008',NULL,'0000008',NULL,NULL,'','I','0.000','0',NULL,'10140','2017-10-24','02082017','0','','','','',NULL,NULL,'16440719'),('16440776','0000004092000271','2017-10-24','780','007','A.W.B','2024370','23','1',NULL,'I','','10000',NULL,'1','0','9','363','140','140','AGENCE GRANDES ENTREPRISES','I','','0','1','10000','005079238',NULL,NULL,'0000009','1','137','140','SD','I','',NULL,NULL,NULL,NULL,'0.000','0','0000009',NULL,'0000009',NULL,NULL,'','I','0.000','0',NULL,'10140','2017-10-24','01122017','0','','','','',NULL,NULL,'16440720');
/*!40000 ALTER TABLE `tmp_tbl_eta_lcn_sgma` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tmp_tbl_impy_chq_sgma`
--

DROP TABLE IF EXISTS `tmp_tbl_impy_chq_sgma`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tmp_tbl_impy_chq_sgma` (
  `REF` int(32) NOT NULL,
  `PK_OBJ_IDT` varchar(32) DEFAULT NULL,
  `RIO` varchar(32) DEFAULT NULL,
  `RIOINI` varchar(32) DEFAULT NULL,
  `REJET` varchar(3) DEFAULT NULL,
  `ADR_RMT` varchar(150) DEFAULT NULL,
  `ADR_TIR` varchar(150) DEFAULT NULL,
  `ZBKT` varchar(3) DEFAULT NULL,
  `AGE_RMT` varchar(4) DEFAULT NULL,
  `AGE_RMT_LIB` varchar(35) DEFAULT NULL,
  `CPT` varchar(12) DEFAULT NULL,
  `CPTT` varchar(16) DEFAULT NULL,
  `DTEREG` varchar(10) DEFAULT NULL,
  `LOCT` varchar(3) DEFAULT NULL,
  `MEM2` varchar(5) DEFAULT NULL,
  `MNT` varchar(16) DEFAULT NULL,
  `NSER` varchar(7) DEFAULT NULL,
  `SQCA` varchar(10) DEFAULT NULL,
  `RIBT` varchar(2) DEFAULT NULL,
  `RSOC_RMT` varchar(35) DEFAULT NULL,
  `RSOC_TIRE` varchar(35) DEFAULT NULL,
  `ZBK_lib` varchar(50) DEFAULT NULL,
  `NOMTIRE` varchar(50) DEFAULT NULL,
  `CIN` varchar(10) DEFAULT NULL,
  `RC` varchar(20) DEFAULT NULL,
  `lieuEmission` varchar(20) DEFAULT NULL,
  `MOTIF1` varchar(3) DEFAULT NULL,
  `MOTIF2` varchar(3) DEFAULT NULL,
  `MOTIF3` varchar(3) DEFAULT NULL,
  `REJET_LIB` varchar(255) DEFAULT NULL,
  `DTREJET` varchar(8) DEFAULT NULL,
  `DTEINS` varchar(10) DEFAULT NULL,
  `DTEPRE` varchar(10) DEFAULT NULL,
  `DTEemission` varchar(8) DEFAULT NULL,
  `DTETRT` varchar(10) DEFAULT NULL,
  `DTE_SORT` varchar(10) DEFAULT NULL,
  `ID_WEBCAPTUR` varchar(10) DEFAULT NULL,
  `AGE_SCAN` varchar(3) DEFAULT NULL,
  PRIMARY KEY (`REF`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tmp_tbl_impy_chq_sgma`
--

LOCK TABLES `tmp_tbl_impy_chq_sgma` WRITE;
/*!40000 ALTER TABLE `tmp_tbl_impy_chq_sgma` DISABLE KEYS */;
INSERT INTO `tmp_tbl_impy_chq_sgma` VALUES (156285580,'156285580','00000000000000000000000000000000','00000000000000000000000000000000','020','','213 IMM 13 GH 1 RYAD EL OULFA  CASABLANCA','022','001','A MOHAMED V','006368874','0000010028329868','2017-09-14','780','10001','10900.00','8666954','3','74','','','S.G.M.B','nom001653466','','nrc001653466','','020','','','DEFAUT OU INSUFFISANCE DE PROVISION','20161215','2017-09-14','','20161214','2017-09-14','03-10-2017','1','001'),(156285594,'156285594','00000000000000000000000000000000','00000000000000000000000000000000','020','','5 AVE DES FAR  CASABLANCA','022','001','A MOHAMED V','006375761','0000020005347706','2017-09-14','780','10001','5000000.00','8838906','13','74','','','S.G.M.B','nom000006005','','nrc000006005','','020','','','DEFAUT OU INSUFFISANCE DE PROVISION','20161215','2017-09-14','','20161214','2017-09-14','03-10-2017','7','001'),(156285595,'156285595','00000000000000000000000000000000','00000000000000000000000000000000','020','','RES NAKHLA 5 APPT 12 AV AKID ALLAM CASABLANCA','022','001','A MOHAMED V','006375761','0000010009259571','2017-09-14','780','10001','6500.00','2619958','14','74','','','S.G.M.B','nom001013081pre001013081','BH271958','','','020','','','DEFAUT OU INSUFFISANCE DE PROVISION','20161215','2017-09-14','','20161214','2017-09-14','03-10-2017','8','001'),(156285596,'156285596','00000000000000000000000000000000','00000000000000000000000000000000','020','','SAADA 3 N 46 LAMHAMID  MARRAKECH','022','001','A MOHAMED V','006375761','0000020028355136','2017-09-14','780','10001','20000.00','2928813','15','74','','','S.G.M.B','nom001380644pre001380644','EE442564','','','020','','','DEFAUT OU INSUFFISANCE DE PROVISION','20161215','2017-09-14','','20161214','2017-09-14','03-10-2017','9','001');
/*!40000 ALTER TABLE `tmp_tbl_impy_chq_sgma` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tmp_tbl_impy_lcn_sgma`
--

DROP TABLE IF EXISTS `tmp_tbl_impy_lcn_sgma`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tmp_tbl_impy_lcn_sgma` (
  `REF` int(32) NOT NULL,
  `PK_OBJ_IDT` varchar(32) DEFAULT NULL,
  `RIO` varchar(32) DEFAULT NULL,
  `RIOINI` varchar(32) DEFAULT NULL,
  `REJET` varchar(3) DEFAULT NULL,
  `ADR_RMT` varchar(150) DEFAULT NULL,
  `ADR_TIR` varchar(150) DEFAULT NULL,
  `ZBKT` varchar(3) DEFAULT NULL,
  `AGE_RMT` varchar(4) DEFAULT NULL,
  `AGE_RMT_LIB` varchar(35) DEFAULT NULL,
  `CPT` varchar(16) DEFAULT NULL,
  `CPTT` varchar(16) DEFAULT NULL,
  `DTEREG` varchar(10) DEFAULT NULL,
  `LOCT` varchar(3) DEFAULT NULL,
  `MEM2` varchar(5) DEFAULT NULL,
  `MNT` varchar(16) DEFAULT NULL,
  `NSER` varchar(7) DEFAULT NULL,
  `SQCA` varchar(10) DEFAULT NULL,
  `RIBT` varchar(2) DEFAULT NULL,
  `RSOC_RMT` varchar(35) DEFAULT NULL,
  `RSOC_TIRE` varchar(35) DEFAULT NULL,
  `ZBK_lib` varchar(50) DEFAULT NULL,
  `NOMTIRE` varchar(50) DEFAULT NULL,
  `CIN` varchar(10) DEFAULT NULL,
  `RC` varchar(20) DEFAULT NULL,
  `lieuEmission` varchar(20) DEFAULT NULL,
  `MOTIF1` varchar(3) DEFAULT NULL,
  `MOTIF2` varchar(3) DEFAULT NULL,
  `MOTIF3` varchar(3) DEFAULT NULL,
  `REJET_LIB` varchar(255) DEFAULT NULL,
  `DTREJET` varchar(8) DEFAULT NULL,
  `DTEINS` varchar(10) DEFAULT NULL,
  `DTEPRE` varchar(10) DEFAULT NULL,
  `DTEemission` varchar(8) DEFAULT NULL,
  `DTETRT` varchar(10) DEFAULT NULL,
  `DTE_SORT` varchar(10) DEFAULT NULL,
  `DTEEC` varchar(10) DEFAULT NULL,
  `ID_WEBCAPTUR` varchar(10) DEFAULT NULL,
  `AGE_SCAN` varchar(3) DEFAULT NULL,
  PRIMARY KEY (`REF`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tmp_tbl_impy_lcn_sgma`
--

LOCK TABLES `tmp_tbl_impy_lcn_sgma` WRITE;
/*!40000 ALTER TABLE `tmp_tbl_impy_lcn_sgma` DISABLE KEYS */;
INSERT INTO `tmp_tbl_impy_lcn_sgma` VALUES (16298653,'16298653','007MAD00600620171103000020021912','022MAD00301720171102000220638284','014',NULL,'HAY KOUCHA BLOC 3 TAOUSSOUIA N 5 TAZA 35010 TAZA                                                    ','007','140','AGENCE GRANDES ENTREPRISES','005079238','0000538000000675',NULL,'270','10140','5000.00','3866651','10','95',NULL,NULL,'A.W.B','TENDET DE TRAVAUX DIVERS ET VENTE DE MATERIAUX    ','          ',' 69 1460            ','TAZA                ','014','   ','   ','ABSENCE OU INSUFFISANCE DE LA PROVISION','20171102','2017-10-24',NULL,'20171102',NULL,'26-10-2017','02112017','364','140');
/*!40000 ALTER TABLE `tmp_tbl_impy_lcn_sgma` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tr_agence`
--

DROP TABLE IF EXISTS `tr_agence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tr_agence` (
  `AGE` char(3) NOT NULL DEFAULT '' COMMENT 'Code  agence',
  `LIB` char(32) DEFAULT NULL COMMENT 'Libelle de l agence',
  `SHP` tinyint(1) DEFAULT NULL COMMENT 'flag SP HP',
  `CIRCUIT` varchar(3) DEFAULT NULL,
  `SECTEUR` varchar(3) DEFAULT NULL,
  PRIMARY KEY (`AGE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Table correspondance Agence/SPHP';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tr_agence`
--

LOCK TABLES `tr_agence` WRITE;
/*!40000 ALTER TABLE `tr_agence` DISABLE KEYS */;
INSERT INTO `tr_agence` VALUES ('000','CRT_MDP',0,'',''),('001','A MOHAMED V',0,'C3','SC'),('002','B FAR',0,'C3','SC'),('003','C STRASBOURG',0,'C3','SC'),('004','D MAARIF',0,'C4','SB'),('005','E EL FIDA',0,'C12','SB'),('006','G ROCHES NOIRES',0,'C2','SA'),('007','AGADIR F.A.R',0,'052','SE'),('008','AGADIR KETTANI',0,'052','SE'),('009','FES GRANDE POSTE',0,'053','SE'),('010','FES VILLE NOUVELLE',0,'053','SE'),('011','KENITRA NAFOURA',0,'058','SE'),('012','MARRAKECH MEDINA',0,'054','SE'),('014','MARRAKECH GUELIZ',0,'054','SE'),('015','MEKNES HAMRIA',0,'057','SE'),('016','RABAT GRANDE POSTE',0,'050','SE'),('017','SAFI',0,'063','SE'),('018','TANGER PRINCIPALE',0,'051','SE'),('019','TAROUDANT',0,'071','SE'),('020','MOHAMEDIA PRINCIPALE',0,'C7','SA'),('021','NADOR HASSAN 1ER',0,'064','SE'),('022','AGENCE SIEGE',0,'CSG','SD'),('023','H COLMAR',0,'C1','SC'),('024','F AIN CHOCK',0,'C9','SB'),('025','BERKANE',0,'078','SE'),('026','OUJDA PRINCIPALE',0,'056','SE'),('027','I CITE DJEMAA',0,'C6','SA'),('028','J OUDAYAS',0,'C1','SC'),('029','INEZGANE',0,'052','SE'),('030','TIZNIT',0,'065','SE'),('031','TETOUAN',0,'055','SE'),('032','RABAT TOUR HASSANE',0,'050','SE'),('033','KASBA TADLA',0,'087','SE'),('034','BENI MELLAL',0,'061','SE'),('035','K OMAR SLAOUI',0,'C3','SC'),('036','M IBN TACHFINE',0,'C1','SC'),('037','FES MEDINA',0,'053','SE'),('038','MARRAKECH BADIE',0,'054','SE'),('039','OULED TEIMA',0,'097','SE'),('040','MOHAMEDIA ALIA',0,'C7','SA'),('041','P ANAFE',0,'C8','SC'),('042','R HAY EL MASJID',0,'C9','SB'),('043','S ABDELMOUMEN',0,'CSG','SD'),('044','L HAY MOHAMEDI',0,'C1','SC'),('045','MONT AROUIT',0,'093','SE'),('046','RABAT DIOUR JEMAA',0,'050','SE'),('047','KENITRA RIAD',0,'058','SE'),('048','TANGER BENI MEKKADA',0,'051','SE'),('049','EL JADIDA',0,'059','SE'),('050','RABAT MOULAY YOUSSEF',0,'050','SE'),('051','TEMARA',0,'050','SE'),('052','FES ATLAS',0,'053','SE'),('053','LIBERTE',0,'C3','SC'),('054','TB BIR ANZARAN',0,'C11','SC'),('055','SGMA_CASA_LA RESISTANCE',0,'C1','SC'),('056','RABAT YACOUB EL MANSOUR',0,'050','SE'),('057','KHEMISSET',0,'088','SE'),('058','TH HABOUS',0,'C1','SC'),('059','AIT MELLOUL',0,'052','SE'),('060','TD LIDO AIN DIAB',0,'C11','SC'),('061','TANGER LIBERTE',0,'051','SE'),('062','Marrackech R\'mmilla',0,'054','SE'),('063','TF HAY EL FARAH',0,'C9','SB'),('064','TJ 11 JANVIER',0,'C3','SC'),('065','SALE',0,'050','SE'),('066','TIFLET',0,'104','SE'),('067','KHOURIBGA',0,'066','SE'),('068','TZ EMILE ZOLA',0,'C2','SA'),('069','MIDAR',0,'092','SE'),('070','RABAT KAYS',0,'050','SE'),('071','AGADIR TALBORJT',0,'052','SE'),('072','TAZA',0,'072','SE'),('073','TP POINCARE',0,'C3','SC'),('074','FES MERINIDES',0,'053','SE'),('075','TY LALLA YACOUT',0,'C3','SC'),('076','SIDI SLIMANE',0,'102','SE'),('077','MEKNES MEDINA',0,'057','SE'),('078','TN PANORAMIQUE',0,'C9','SB'),('079','TS BERNOUSSI',0,'C2','SA'),('080','AL HOCEIMA',0,'074','SE'),('081','MEKNES PRINCIPALE',0,'057','SE'),('082','FES BOUJLOUD',0,'053','SE'),('083','OUARZAZATE',0,'095','SE'),('084','TR BENOMAR',0,'C8','SC'),('085','TC YACOUB EL MANSOUR',0,'C5','SB'),('087','CASA MOULAY YOUSSEF',0,'C8','SC'),('088','MARRAKECH AMINE',0,'054','SE'),('089','TK DAKAR',0,'C2','SA'),('090','RM MEDIOUNA',0,'C9','SB'),('091','RABAT MICHLIFEN',0,'050','SE'),('092','OUJDA MEDINA',0,'056','SE'),('093','MARRAKECH PALMERAIE',0,'054','SE'),('094','MARRAKECH DAOUDIATE',0,'054','SE'),('095','TO HAY SADRI',0,'C12','SB'),('096','TA AL MASSIRA',0,'C11','SC'),('097','AGADIR PALACE',0,'052','SE'),('098','LARACHE',0,'068','SE'),('099','TG GHANDI',0,'C11','SC'),('100','TI ZERKTOUNI',0,'C8','SC'),('101','BERRECHID',0,'060','SE'),('102','TE AIN SEBAA',0,'C2','SA'),('103','NADOR PRINCIPALE',0,'064','SE'),('104','TANGER IBN TOUMERT',0,'051','SE'),('105','HAY EL HASSANI',0,'C11','SC'),('106','DIR. REG. RABAT',0,'050','SE'),('107','OUED EDDAHAB',0,'C6','SA'),('108','DRISS EL HARTI',0,'C6','SA'),('109','AL KHALIL',0,'C9','SB'),('110','Meknes Plaisance',0,'057','SE'),('111','HASSAN SEGHIR',0,'C3','SC'),('112','MABROUKA',0,'C6','SA'),('113','DRISSIA',0,'C9','SB'),('114','RABAT BAB EL HAD',0,'050','SE'),('115','2 MARS',0,'C3','SC'),('116','MEKNES ZITOUNE',0,'057','SE'),('117','ZENATA',0,'C2','SA'),('118','BOURGOGNE',0,'C8','SC'),('119','PASTEUR',0,'C11','SC'),('120','MOSTAPHA EL MAANI',0,'C3','SC'),('121','MARRAKECH HIVERNAGE',0,'054','SE'),('122','SALE TABRIQUET',0,'050','SE'),('123','SALMIA',0,'C6','SA'),('124','OULED ZIANE',0,'C9','SB'),('125','MOHAMEDIA HOURYA',0,'C7','SA'),('126','RABAT AMAL',0,'050','SE'),('127','SETTAT',0,'067','SE'),('128','KENITRA PRINCIPALE',0,'058','SE'),('129','TWIN CENTER',0,'C8','SC'),('130','C.I.L',0,'C11','SC'),('131','OULFA',0,'C5','SB'),('132','PLATEAU',0,'C9','SB'),('133','LA GIRONDE',0,'C9','SB'),('134','DRISS 1ER',0,'C6','SA'),('135','BEAUSEJOUR',0,'C4','SB'),('136','BRAHIM ROUDANI',0,'C4','SB'),('137','FES ROUTE DE SEFROU',0,'053','SE'),('138','RABAT BENI ZNASSEN',0,'050','SE'),('139','LAAYOUNE',0,'070','SE'),('140','AGENCE GRANDES ENTREPRISES',0,'CSG','SD'),('141','RABAT CHELLAH',0,'050','SE'),('142','MARRAKECH BAB DOUKALLA',0,'054','SE'),('143','ZIRAOUI',0,'C8','SC'),('144','FES ROUTE D IMOUZZER',0,'053','SE'),('145','HAY SALAMA',0,'C12','SB'),('146','RABAT EL MANZAH',0,'050','SE'),('147','MARRAKECH AL MASSIRA',0,'054','SE'),('148','LES CRETES',0,'C9','SB'),('149','SIDI MAAROUF',0,'C4','SB'),('150','RABAT SOUISSI',0,'050','SE'),('151','MOULAY SMAIL',0,'C2','SA'),('152','AGADIR HAY DAKHLA',0,'052','SE'),('153','TETOUAN SIDI MANDRI',0,'055','SE'),('154','COMPTES PARTICULIERS',0,'CSG','SD'),('155','OQBA BEN NAFIA',0,'C1','SC'),('156','OASIS',0,'C4','SB'),('157','AL MANAR',0,'C8','SC'),('158','GOULMINA',0,'C8','SC'),('159','20 AOUT',0,'C3','SC'),('160','AGENCE FINANCIERE',0,'CSG','SD'),('161','ESSAADA',0,'C2','SA'),('162','PALMIERS',0,'C4','SB'),('163','OULFA SEBOU',0,'C5','SB'),('164','LISSASFA',0,'C5','SB'),('165','SIDI MOUMEN',0,'C12','SB'),('166','MOULAY RACHID',0,'C13','SA'),('167','OUM RABII',0,'C5','SB'),('168','AMAR RIFFI',0,'C3','SC'),('169','ROND POINT D EUROPE',0,'C3','SC'),('170','BALADIA',0,'C12','SB'),('171','MAKDAD LAHRIZI',0,'C6','SA'),('172','MARRAKECH PRINCIPALE',0,'054','SE'),('173','FES R SIF',0,'053','SE'),('174','TANGER DRISSIA',0,'051','SE'),('175','ESSAOUIRA',0,'062','SE'),('176','TANGER MEDINA',0,'051','SE'),('177','KALAAT SRAGHNA',0,'086','SE'),('178','SALE PLATEAU',0,'050','SE'),('179','INARA',0,'C9','SB'),('180','MARRAKECH ROUTE DE SAFI',0,'054','SE'),('181','HAY CHRIFA',0,'C9','SB'),('182','MARRAKECH SIDI YOUSSEF BEN ALI',0,'054','SE'),('183','MARRAKECH SIDI GHANEM',0,'054','SE'),('184','SOCRATE',0,'C11','SC'),('185','TANGER ZONE FRANCHE',0,'051','SE'),('186','EL MECHOUAR',0,'C1','SC'),('187','RABAT AKKARI',0,'050','SE'),('188','AGADIR DCHEIRA',0,'052','SE'),('189','EL BATHA',0,'C11','SC'),('190','AGADIR HASSAN II',0,'052','SE'),('191','SALE KARIA',0,'050','SE'),('192','JAWHARA',0,'C12','SB'),('193','FES ESSAADA',0,'053','SE'),('194','D.G.A.E',0,'',''),('195','AL BARAKA',0,'C13','SA'),('196','LA COLLINE',0,'C4','SB'),('197','RABAT HAY RIAD',0,'050','SE'),('198','DIRECTION REGION CASA OUEST',0,'C5','SB'),('199','DIRECTION REGION CASA CENTRE',0,'C2','SA'),('200','L ACP RABAT',0,'050','SE'),('201','DIRECTION REGION CASA EST',0,'C2','SA'),('202','LA CORNICHE',0,'C11','SC'),('203','TANGER MEXIQUE',0,'051','SE'),('204','TIT MELLIL (AL AZHAR)',0,'C13','SA'),('205','DIRECTION REGIONALE MARRAKECH',0,'054','SE'),('206','DIRECTION REGIONALE AGADIR',0,'052','SE'),('207','DIRECTION REGIONALE FES',0,'053','SE'),('208','DIRECTION REGIONALE TANGER',0,'051','SE'),('209','HAY SALAM',0,'C5','SB'),('210','EL JADIDA ESSAADA',0,'059','SE'),('211','OUJDA DR L\'ORIENTALE',0,'056','SE'),('212','AGADIR INBIAT',0,'052','SE'),('213','TANGER VAL IBERIA',0,'051','SE'),('214','SAAD EL KHEIR',0,'C5','SB'),('215','TANGER AL MAJD',0,'051','SE'),('216','KENITRA SAKNIA',0,'058','SE'),('217','TANGER CASTILLA',0,'051','SE'),('218','RABAT- FAL OULD OUMEIR',0,'050','SE'),('219','AGADIR TADDART',0,'052','SE'),('220','MARRAKECH MAJORELLE',0,'054','SE'),('221','AGADIR HAY SALAM',0,'052','SE'),('222','TEMARA MASSIRA',0,'050','SE'),('223','AGADIR MASSIRA',0,'052','SE'),('224','TAROUDANT MHAITA',0,'071','SE'),('225','FNIDEQ',0,'055','SE'),('226','MARRAKECH ALLAL EL FASSI',0,'054','SE'),('227','MEKNES MARJANE',0,'057','SE'),('228','SIDI MOUMEN EL ADARISSA',0,'C12','SB'),('229','AL KODSS',0,'C2','SA'),('230','TANGER PORT',0,'051','SE'),('231','TETOUAN PLACE HAMAMA',0,'055','SE'),('232','FES SAISS',0,'053','SE'),('233','TANGER PLAZA TORRO',0,'051','SE'),('234','TETOUAN MOHAMMED 5',0,'055','SE'),('235','LAHJAJMA',0,'C11','SC'),('236','ENNASIM',0,'C4','SB'),('237','TANGER QUARTIER ADMINISTRATIF',0,'051','SE'),('238','BOUZIANE',0,'C12','SB'),('239','RABAT ASSWAK ASSALAM',0,'050','SE'),('240','SOUHAIB ERROUMI',0,'C2','SA'),('241','ZOUIBIR',0,'C5','SB'),('242','AL HOUDA AGADIR',0,'052','SE'),('243','MOUSSA BNOU NOUSSAIR',0,'C8','SC'),('244','BIOUGRA',0,'079','SE'),('245','TETOUAN BAB OKLA',0,'055','SE'),('246','AIT BAHA',0,'073','SE'),('247','TANGER ASWAK SALAM',0,'051','SE'),('248','AGADIR ASWAK ASSALAM',0,'052','SE'),('249','TEMARA ASWAK ASSALAM',0,'050','SE'),('250','OUJDA ALLAL FASSI',0,'056','SE'),('251','NOUASSER AEROPRT Med V',0,'094','SE'),('252','LARACHE-AL MAGHRIB AL JADID',0,'068','SE'),('253','EL JADIDA RTE DE MARRAKECH',0,'059','SE'),('254','OULFA OUED BEHT',0,'C5','SB'),('255','TANGER VAL FLEURI',0,'051','SE'),('256','BERKANE ANDALOUS',0,'078','SE'),('257','OULFA OUED LAOU',0,'C5','SB'),('258','SALE EXTENSION',0,'050','SE'),('259','OUJDA ROUTE TAZA',0,'056','SE'),('260','SIDI MAAROUF AL MOSTAQBAL',0,'C4','SB'),('261','MEKNES OUALILI',0,'057','SE'),('262','MEKNES AL ISMAILIA',0,'057','SE'),('263','TETOUAN MHANNECH',0,'055','SE'),('264','ERRACHIDIA',0,'083','SE'),('265','OUJDA ISLY',0,'056','SE'),('266','TEMARA BNOU KHATIB',0,'050','SE'),('267','MARRAKECH ASWAK ASSALAM',0,'054','SE'),('268','OUJDA ZITOUNE',0,'056','SE'),('269','MEKNES RIAD',0,'057','SE'),('270','RABAT OCEAN',0,'050','SE'),('271','SAFI KENNEDY',0,'063','SE'),('272','DEROUA',0,'106','SE'),('273','TEMARA HASSAN I',0,'050','SE'),('274','KHORIBGA ZELLAKA',0,'066','SE'),('275','ZEGHANGHEN',0,'105','SE'),('276','AGADIR ABDERRAHIM BOUABID',0,'052','SE'),('277','AGADIR TIKIOUINE',0,'052','SE'),('278','KENITRA OULED OUJIH',0,'058','SE'),('279','SAFI MY DRISS I',0,'063','SE'),('280','RABAT MAHAJ RYAD',0,'050','SE'),('281','ABDELKADER SAHRAOUI',0,'C6','SA'),('282','FES ZELLAGH',0,'053','SE'),('283','TAOURIRT',0,'103','SE'),('284','BENI MELLAL MOHAMED V',0,'061','SE'),('285','AGADIR AL MOKAOUAMA',0,'052','SE'),('286','TANGER CALIFORNIA',0,'051','SE'),('287','OUJDA OUED ENNACHEF',0,'056','SE'),('288','FES HAY TARIK',0,'053','SE'),('289','BEN SLIMANE',0,'076','SE'),('290','ESSAOUIRA DRISS 1ER',0,'062','SE'),('291','EL JADIDA IBNOU BADIS',0,'059','SE'),('292','DRISS EL HARTI FACULTE',0,'C12','SB'),('293','FES MONT FLEURI',0,'053','SE'),('294','TANGER IBNOU TACHFINE',0,'051','SE'),('295','TAMESNA',0,'050','SE'),('296','KENITRA MIMOSAS',0,'058','SE'),('297','CASA MEHDI BENBARKA',0,'C8','SC'),('298','SKHIRAT',0,'050','SE'),('299','BENI MELLAL EL WAFA',0,'061','SE'),('300','SALE BETTANA',0,'050','SE'),('301','SIDI KACEM',0,'101','SE'),('302','FKIH BEN SALEH',0,'090','SE'),('303','CASA AIN BOURJA',0,'C1','SC'),('304','TANGER MESNANA',0,'051','SE'),('305','CASA SIJILMASSA',0,'C1','SC'),('306','OUED ZEM',0,'096','SE'),('307','NADOR OULED MIMOUN',0,'064','SE'),('308','SAIDIA',0,'056','SE'),('309','GUERCIF',0,'084','SE'),('310','DRIOUCH',0,'082','SE'),('311','TAZA MY YOUSSEF',0,'072','SE'),('312','SALE INBIAAT',0,'050','SE'),('313','SAFI MEFTAH AL KHEIR',0,'063','SE'),('314','MOHAMEDIA LA RESISTANCE',0,'C7','SA'),('315','CASA AZHAR',0,'C13','SA'),('316','MARRAKECH MASSIRA KANTARA',0,'054','SE'),('317','CASA OULFA MY THAMI',0,'C5','SB'),('318','SALE EL JADIDA',0,'050','SE'),('319','KENITRA IMAM ALI',0,'058','SE'),('320','TEMARA WIFAK',0,'050','SE'),('321','Tanger-Avdes FAR',0,'051','SE'),('322','TANGER-Malabata',0,'051','SE'),('323','TEMARA GUICHES OUDAYAS',0,'050','SE'),('324','SALE KARIMA',0,'050','SE'),('325','NADOR SAKIA AL HAMRA',0,'064','SE'),('326','AL QODS HAY MY ABDELLAH',0,'C9','SB'),('327','FORCES AUXILIAIRES',0,'C12','SB'),('328','MOHAMED ZAFZAF',0,'C13','SA'),('329','MOHAMEDIA RIAD SALAM',0,'C7','SA'),('330','SBIT TIT MELLIL',0,'C13','SA'),('331','RABAT TAKADDOUM',0,'050','SE'),('332','AGADIR TAMDID',0,'052','SE'),('333','INEZGANE TARRAST',0,'052','SE'),('334','AGARID HAY MOHAMMEDI',0,'052','SE'),('335','SOCIETE GENERALE TECHNOPOLIS',0,'050','SE'),('336','FES MOULAY DRISS',0,'053','SE'),('337','FES BD EL OUAFA',0,'053','SE'),('338','MEKNES QORTOBA',0,'057','SE'),('339','SETTAT LALLA AICHA',0,'067','SE'),('340','SEBT OULED NEMMA',0,'098','SE'),('341','BERCHID HASSAN II',0,'060','SE'),('342','AIT MELLOUL ZONE INDUSTRIELLE',0,'052','SE'),('343','MARRAKECH GARE',0,'054','SE'),('344','MARRAKECH IZDIHAR',0,'054','SE'),('345','FES BENSOUDA',0,'053','SE'),('346','FES NASSIM',0,'053','SE'),('347','MARRAKECH ESSAADA',0,'054','SE'),('348','FES ROUTE AIN CHKEF',0,'053','SE'),('349','AGADIR BENSERGAOU',0,'052','SE'),('350','GUELMIM',0,'069','SE'),('351','ANASSI',0,'C13','SA'),('352','EL JADIDA MOUILHA',0,'059','SE'),('353','AZEMMOUR',0,'075','SE'),('354','SALE HSSAINE',0,'050','SE'),('355','MADINAT ERRAHMA',0,'C5','SB'),('356','TANGER DRADS',0,'051','SE'),('357','SIDI OTHMANE PREFECTURE',0,'C6','SA'),('358','AL HAMD',0,'C12','SB'),('359','AL QODS OULAD TALEB',0,'C9','SB'),('360','CASANEARCHORE',0,'C4','SB'),('361','SIDI BENNOUR',0,'100','SE'),('362','HAD SOUALEM',0,'085','SE'),('363','SALE CHMAOU',0,'050','SE'),('364','TANGER MY YOUSSEF',0,'051','SE'),('365','TAH',0,'C9','SB'),('366','MARRAKECH AZLI',0,'054','SE'),('367','MARRAKECH ROUTE TARGA',0,'054','SE'),('368','KSAR LEKBIR',0,'091','SE'),('369','MARTIL HASSAN II',0,'055','SE'),('370','TETOUAN BOUJARRAH',0,'055','SE'),('371','SEFROU',0,'099','SE'),('372','FOUARATE',0,'C1','SC'),('373','ANASSI EXTENSION',0,'C13','SA'),('374','AGADIR BOUARGANE',0,'052','SE'),('375','BENGUERIR',0,'077','SE'),('376','FES MED VI',0,'053','SE'),('377','KHENIFRA',0,'089','SE'),('378','AGADIR DCHEIRA AL JIHADIA',0,'052','SE'),('379','AGADIR AL QODS',0,'052','SE'),('380','CHEFCHAOUI',0,'C2','SA'),('381','AZROU',0,'107','SE'),('382','TANGER AOUAMA',0,'051','SE'),('383','CHAOUEN',0,'081','SE'),('384','MARRAKECH - M HAMID AL MATAR',0,'054','SE'),('385','OUJDA BAB SIDI ABDELOUAHAB',0,'056','SE'),('386','AGADIR IHCHACH',0,'052','SE'),('387','M HAMID ATLAS',0,'054','SE'),('388','BEN SLIMANE',0,'076','SE'),('389','BOUZNIKA',0,'080','SE'),('390','OUAHDA IFRIQUIA',0,'C6','SA'),('391','CASA AL MANZAH',0,'C12','SB'),('392','TIZNIT HASSAN II',0,'065','SE'),('393','RABAT QUARTIER HASSAN',0,'050','SE'),('394','TANGER DCHAR BENDIBANE',0,'051','SE'),('395','DERB OMAR',0,'C1','SC'),('396','TANGER SOUANI',0,'051','SE'),('397','AGADIR RUE DE MARRAKECH',0,'052','SE'),('398','LAAYOUNE Route Smara',0,'070','SE'),('399','AGADIR MAKKA',0,'052','SE'),('400','AGADIR MASJID MOHAMMADI',0,'052','SE'),('401','AIN SEBAA GARE',0,'C2','SA'),('402','KENITRA LA GARE',0,'058','SE'),('403','GUELMIM OUED NOUN',0,'069','SE'),('404','RABAT HAY NAHDA',0,'050','SE'),('405','MARRAKECH HAY MOHAMMADI',0,'054','SE'),('406','B. MELLAL 20 AOUT',0,'061','SE'),('407','ESSAOUIRA EL AKABA',0,'062','SE'),('408','MASSIRA EL BAHIA',0,'054','SE'),('409','AGADIR IBNOU ZOHR',0,'052','SE'),('410','CHOUHADA',0,'C1','SC'),('411','TARIK AL KHAYR',0,'C13','SA'),('412','ABOUAB MARRAKECH',0,'054','SE'),('413','DAKHLA',0,'108','SE'),('414','MARRAKECH  AL MASSAR',0,'054','SE'),('415','RIAD ESSALAM',0,'052','SE'),('416','BOUSKOURA OULED SALAH',0,'109','SE'),('417','SGMA_AIT MELLOUL_AL FATH',0,'052','SE'),('418','SGMA_OULFA _AL AZHAR',0,'C5','SB'),('419','SGMA_MOHAMMEDIA_BAB SEBTA',0,'C7','SA'),('420','SGMA_EL JADIDA_KHALIL JABRANE',0,'059','SE'),('421','SGMA_AGADIR_11JANVIER',0,'052','SE'),('422','SGMA_MARRAKECH_PALESTINE',0,'054','SE'),('423','SGMA_KHOURIBGA_MED VI',0,'066','SE'),('424','SGMA_KALAA DES SRAGHNAS_BD FAR',0,'086','SE'),('425','SGMA_MOHAMMEDIA_LE PARC',0,'C7','SA'),('426','SGMA_CASA_BD D ANFA',0,'C8','SC'),('427','SGMA_KENITRE_ROUTE SIDI YAHYA',0,NULL,NULL),('437','KENITRA ROUTE SIDI YAHIA',0,'058','SE'),('700','BERRECHID ETTAKADOUM',0,'060','SE'),('701','MARRAKECH SIDI GHANEM',0,'054','SE'),('702','JURA',0,'C11','SC'),('703','FES MERINIDES',0,'053','SE'),('704','DERB MLY CHERIF',0,'C1','SC'),('705','MARRAKECH SIDI M\'BAREK',0,'054','SE'),('706','OULFA  HAJ  FATEH',0,'C5','SB'),('707','CASA SBATA',0,'C6','SA'),('708','SALE MY ISMAIL',0,'050','SE'),('709','SALE RAHMA',0,'050','SE'),('710','CASA REDA GUEDIRA',0,'C6','SA'),('711','CASA JOULANE',0,'C6','SA'),('712','CASA JAMILA',0,'C6','SA'),('713','ATTACHAROUK',0,'C13','SA'),('714','KENITRA LA VILLE HAUTE',0,'058','SE'),('851','Agence Banque Privée Casa Ouest',0,'CSG','SD'),('852','Agence Banque Privée Casa Centre',0,'C11','SC'),('853','Agence Banque Privée Casa Est',0,'C2','SA'),('854','Agence Banque Privée RABAT',0,'050','SE'),('855','Agence Banque Privée Marrakech',0,'054','SE'),('856','Agence Banque Privée Tanger',0,'051','SE'),('857','Agence Banque Privée Fès',0,'053','SE'),('858','Agence Banque Privée Agadir',0,'052','SE'),('901','WERSTERN UNION TANGER MANZAH',0,'051','SE'),('902','FACTORING',0,'CSG','SD'),('903','SERVICE CLIENTS CENTRAL',0,'CSG','SD');
/*!40000 ALTER TABLE `tr_agence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `enabled` tinyint(1) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES ('admin','21232f297a57a5a743894a0e4a801fc3',1),('BAA','cd280a85ef3fb6a6ca11a507c38e53c6',1),('BPM','fb7218d9dac59e6acee0d6b50ee0c4b7',1),('CFG','fdd77d900c9de5478ef8d20aff4680dc',1),('PCDM','72ed13e6f24b4ea7ff75ce09e822943c',1),('QMB','5f63f601dd3206cdc43defce916c69ce',1);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'r_ncrm_extraction'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-11-14 10:08:17
