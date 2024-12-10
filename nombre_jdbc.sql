CREATE DATABASE  IF NOT EXISTS `nombre_jdbc` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `nombre_jdbc`;
-- MySQL dump 10.13  Distrib 8.0.40, for Win64 (x86_64)
--
-- Host: localhost    Database: nombre_jdbc
-- ------------------------------------------------------
-- Server version	8.0.40

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `cursos`
--

DROP TABLE IF EXISTS `cursos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cursos` (
  `ID_CURSO` int NOT NULL AUTO_INCREMENT,
  `DESCRIPCION` varchar(100) DEFAULT NULL,
  `PRECIO` double DEFAULT NULL,
  PRIMARY KEY (`ID_CURSO`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cursos`
--

LOCK TABLES `cursos` WRITE;
/*!40000 ALTER TABLE `cursos` DISABLE KEYS */;
INSERT INTO `cursos` VALUES (1,'hola',2000),(2,'como estas',3000);
/*!40000 ALTER TABLE `cursos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `forma_pago`
--

DROP TABLE IF EXISTS `forma_pago`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `forma_pago` (
  `ID_FORMA_PAGO` int NOT NULL AUTO_INCREMENT,
  `DESCRIPCION` varchar(100) DEFAULT NULL,
  `RECARGAR` double DEFAULT NULL,
  PRIMARY KEY (`ID_FORMA_PAGO`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `forma_pago`
--

LOCK TABLES `forma_pago` WRITE;
/*!40000 ALTER TABLE `forma_pago` DISABLE KEYS */;
/*!40000 ALTER TABLE `forma_pago` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `inscripcion`
--

DROP TABLE IF EXISTS `inscripcion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `inscripcion` (
  `ID_INSCRIPCION` int NOT NULL AUTO_INCREMENT,
  `NOMBRE` varchar(100) DEFAULT NULL,
  `TELEFONO` varchar(20) DEFAULT NULL,
  `ID_CURSO` int DEFAULT NULL,
  `ID_FORMA_PAGO` int DEFAULT NULL,
  PRIMARY KEY (`ID_INSCRIPCION`),
  KEY `ID_CURSO` (`ID_CURSO`),
  KEY `ID_FORMA_PAGO` (`ID_FORMA_PAGO`),
  CONSTRAINT `inscripcion_ibfk_1` FOREIGN KEY (`ID_CURSO`) REFERENCES `cursos` (`ID_CURSO`),
  CONSTRAINT `inscripcion_ibfk_2` FOREIGN KEY (`ID_FORMA_PAGO`) REFERENCES `forma_pago` (`ID_FORMA_PAGO`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inscripcion`
--

LOCK TABLES `inscripcion` WRITE;
/*!40000 ALTER TABLE `inscripcion` DISABLE KEYS */;
/*!40000 ALTER TABLE `inscripcion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tarea`
--

DROP TABLE IF EXISTS `tarea`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tarea` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `descripcion` varchar(255) NOT NULL,
  `fecha` date NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tarea`
--

LOCK TABLES `tarea` WRITE;
/*!40000 ALTER TABLE `tarea` DISABLE KEYS */;
INSERT INTO `tarea` VALUES (3,'Ejemplo 2','Ejemplo 2','2024-12-01'),(4,'adsads','adsads','2024-12-06'),(5,'aa','aa','2024-12-12'),(6,'11','11','2024-12-12'),(8,'8','8','2024-12-08'),(9,'9','9','2024-12-09'),(10,'1111111111','11111111','2024-12-13'),(11,'2222222222222','2222222222222','2024-12-21');
/*!40000 ALTER TABLE `tarea` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tareaseliminadas`
--

DROP TABLE IF EXISTS `tareaseliminadas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tareaseliminadas` (
  `id_eliminada` int NOT NULL AUTO_INCREMENT,
  `id_tarea` int NOT NULL,
  `nombre_tarea` varchar(50) NOT NULL,
  `descripcion_tarea` varchar(255) NOT NULL,
  `fecha_tarea` date NOT NULL,
  `usuario_killer` varchar(50) NOT NULL,
  `motivo_eliminacion` varchar(255) NOT NULL,
  PRIMARY KEY (`id_eliminada`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tareaseliminadas`
--

LOCK TABLES `tareaseliminadas` WRITE;
/*!40000 ALTER TABLE `tareaseliminadas` DISABLE KEYS */;
INSERT INTO `tareaseliminadas` VALUES (1,1,'Luis','Hola esto es un texto descriptivo','2024-05-15','Gabriela','por que se me dio la gana'),(2,1,'Luis','Hola esto es un texto descriptivo','2024-05-15','Gabriela','por que se me dio la gana'),(3,2,'Ejemplo','Ejemplo','2024-12-12','Gabriela','por que se me dio la gana sin repetir');
/*!40000 ALTER TABLE `tareaseliminadas` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-12-09 21:03:58
