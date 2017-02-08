-- MySQL dump 10.13  Distrib 5.6.17, for Win64 (x86_64)
--
-- Host: localhost    Database: conesc
-- ------------------------------------------------------
-- Server version	5.6.23-log

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
-- Table structure for table `alumnos`
--

DROP TABLE IF EXISTS `alumnos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `alumnos` (
  `idAlumno` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Grupos_idGrupo` int(10) unsigned NOT NULL,
  `Nombre` varchar(45) DEFAULT NULL,
  `Apepaterno` varchar(45) DEFAULT NULL,
  `Apematerno` varchar(45) DEFAULT NULL,
  `Fecha_Nacimiento` date DEFAULT NULL,
  `Telefono` varchar(10) DEFAULT NULL,
  `Curp` varchar(45) DEFAULT NULL,
  `Tutor` varchar(45) DEFAULT NULL,
  `Tipo_Sangre` varchar(45) DEFAULT NULL,
  `Num_Imss` varchar(45) DEFAULT NULL,
  `Sexo` varchar(20) DEFAULT NULL,
  `fecha_registro` date NOT NULL,
  `fecha_actualizacion` date NOT NULL,
  `activo` smallint(1) DEFAULT NULL,
  PRIMARY KEY (`idAlumno`),
  KEY `Alunmos_FKIndex1` (`Grupos_idGrupo`),
  CONSTRAINT `alumnos_ibfk_1` FOREIGN KEY (`Grupos_idGrupo`) REFERENCES `grupos` (`idGrupo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alumnos`
--

LOCK TABLES `alumnos` WRITE;
/*!40000 ALTER TABLE `alumnos` DISABLE KEYS */;
INSERT INTO `alumnos` VALUES (1,1,'CARLOS','GARCIA','MONTOYA','2000-11-15','96543902','GAMC001115HZSRNR03','SONIA JAZMIN GARCIA SILVA','O+','16161616166','MASCULINO','2017-01-31','2017-02-01',1),(2,1,'FRANCISCO','LOPEZ','MARTINEZ','2002-11-15','93212',NULL,'FRANCISCO LOPEZ HERNANDEZ','O+','123455','MASCULINO','2017-02-01','2017-02-01',1);
/*!40000 ALTER TABLE `alumnos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `docentes`
--

DROP TABLE IF EXISTS `docentes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `docentes` (
  `idDocente` int(10) NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(45) NOT NULL,
  `Apepaterno` varchar(45) NOT NULL,
  `Apematerno` varchar(45) DEFAULT NULL,
  `Telefono` varchar(10) NOT NULL,
  `Num_Empleados` varchar(10) NOT NULL,
  `Correo` varchar(45) NOT NULL,
  `activo` smallint(6) DEFAULT NULL,
  `fecha_registro` date DEFAULT NULL,
  PRIMARY KEY (`idDocente`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `docentes`
--

LOCK TABLES `docentes` WRITE;
/*!40000 ALTER TABLE `docentes` DISABLE KEYS */;
INSERT INTO `docentes` VALUES (1,'GERARDO','AGUILAR','MAURICIO','96548899','12345','lalito@correo.com',1,'2017-02-07');
/*!40000 ALTER TABLE `docentes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `docentes_materias`
--

DROP TABLE IF EXISTS `docentes_materias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `docentes_materias` (
  `iddocente` int(10) NOT NULL,
  `idmateria` int(10) NOT NULL,
  KEY `fk_dm_doc` (`iddocente`),
  KEY `fk_dm_mat` (`idmateria`),
  CONSTRAINT `fk_dm_doc` FOREIGN KEY (`iddocente`) REFERENCES `docentes` (`idDocente`),
  CONSTRAINT `fk_dm_mat` FOREIGN KEY (`idmateria`) REFERENCES `materias` (`idMateria`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `docentes_materias`
--

LOCK TABLES `docentes_materias` WRITE;
/*!40000 ALTER TABLE `docentes_materias` DISABLE KEYS */;
/*!40000 ALTER TABLE `docentes_materias` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estados`
--

DROP TABLE IF EXISTS `estados`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `estados` (
  `idEstados` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idEstados`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estados`
--

LOCK TABLES `estados` WRITE;
/*!40000 ALTER TABLE `estados` DISABLE KEYS */;
/*!40000 ALTER TABLE `estados` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `grupos`
--

DROP TABLE IF EXISTS `grupos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `grupos` (
  `idGrupo` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Grupo` varchar(20) DEFAULT NULL,
  `Semestre` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`idGrupo`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `grupos`
--

LOCK TABLES `grupos` WRITE;
/*!40000 ALTER TABLE `grupos` DISABLE KEYS */;
INSERT INTO `grupos` VALUES (1,'A','1'),(2,'B','1'),(3,'C','1'),(4,'A','2'),(5,'B','2'),(6,'C','2'),(7,'A','3'),(8,'B','3'),(9,'C','3'),(10,'A','4'),(11,'B','4'),(12,'C','4'),(13,'A','5'),(14,'B','5'),(15,'C','5'),(16,'A','6'),(17,'B','6'),(18,'C','6');
/*!40000 ALTER TABLE `grupos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `materias`
--

DROP TABLE IF EXISTS `materias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `materias` (
  `idMateria` int(10) NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(45) NOT NULL,
  `semestre` int(11) NOT NULL,
  PRIMARY KEY (`idMateria`),
  UNIQUE KEY `idMateria_UNIQUE` (`idMateria`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `materias`
--

LOCK TABLES `materias` WRITE;
/*!40000 ALTER TABLE `materias` DISABLE KEYS */;
INSERT INTO `materias` VALUES (1,'MATEMATICAS',1),(2,'ESPAÑOL',1),(3,'QUIMICA I',1),(4,'MATEMATICAS II',2);
/*!40000 ALTER TABLE `materias` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'conesc'
--

--
-- Dumping routines for database 'conesc'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-02-08 13:11:34
