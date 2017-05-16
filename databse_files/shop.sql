-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: shop
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
-- Table structure for table `archiwumuzytkownicy`
--

DROP TABLE IF EXISTS `archiwumuzytkownicy`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `archiwumuzytkownicy` (
  `idUzytkownika` int(10) unsigned DEFAULT NULL,
  `imie` varchar(50) COLLATE utf8_polish_ci DEFAULT NULL,
  `nazwisko` varchar(50) COLLATE utf8_polish_ci DEFAULT NULL,
  `login` varchar(20) COLLATE utf8_polish_ci DEFAULT NULL,
  `haslo` varchar(65) CHARACTER SET utf8 DEFAULT NULL,
  `mail` varchar(50) COLLATE utf8_polish_ci DEFAULT NULL,
  `idMiasta` int(10) unsigned DEFAULT NULL,
  `nazwaUlicy` varchar(50) COLLATE utf8_polish_ci DEFAULT NULL,
  `numerDomu` varchar(10) COLLATE utf8_polish_ci DEFAULT NULL,
  `idTypuKonta` int(3) unsigned DEFAULT NULL,
  `akcja` char(1) COLLATE utf8_polish_ci DEFAULT NULL,
  `data` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci
/*!50100 PARTITION BY HASH (year(`data`))
(PARTITION p0 ENGINE = InnoDB,
 PARTITION p1 ENGINE = InnoDB,
 PARTITION p2 ENGINE = InnoDB,
 PARTITION p3 ENGINE = InnoDB,
 PARTITION p4 ENGINE = InnoDB) */;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `archiwumuzytkownicy`
--

LOCK TABLES `archiwumuzytkownicy` WRITE;
/*!40000 ALTER TABLE `archiwumuzytkownicy` DISABLE KEYS */;
/*!40000 ALTER TABLE `archiwumuzytkownicy` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `blokady`
--

DROP TABLE IF EXISTS `blokady`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `blokady` (
  `idBlokady` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `login` varchar(20) COLLATE utf8_polish_ci DEFAULT 'NULL',
  `dataBlokady` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`idBlokady`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `blokady`
--

LOCK TABLES `blokady` WRITE;
/*!40000 ALTER TABLE `blokady` DISABLE KEYS */;
/*!40000 ALTER TABLE `blokady` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dostawcy`
--

DROP TABLE IF EXISTS `dostawcy`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dostawcy` (
  `idDostawcy` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `nazwa` varchar(50) COLLATE utf8_polish_ci NOT NULL,
  `cena` decimal(5,2) NOT NULL DEFAULT '0.00',
  PRIMARY KEY (`idDostawcy`),
  UNIQUE KEY `nazwa` (`nazwa`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dostawcy`
--

LOCK TABLES `dostawcy` WRITE;
/*!40000 ALTER TABLE `dostawcy` DISABLE KEYS */;
INSERT INTO `dostawcy` VALUES (1,'DPD',15.00),(2,'DHL',12.00),(3,'Poczta Polska',11.99),(4,'Inpost',13.50),(5,'ASD',12.00),(16,'ASDASD',12.01);
/*!40000 ALTER TABLE `dostawcy` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `front_page_view`
--

DROP TABLE IF EXISTS `front_page_view`;
/*!50001 DROP VIEW IF EXISTS `front_page_view`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `front_page_view` AS SELECT 
 1 AS `link`,
 1 AS `nazwa`,
 1 AS `idProduktu`,
 1 AS `ilosc`,
 1 AS `cena`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `historialogowan`
--

DROP TABLE IF EXISTS `historialogowan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `historialogowan` (
  `login` varchar(500) COLLATE utf8_polish_ci DEFAULT NULL,
  `dataZCzasem` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `czyZalogowanoPomyslnie` tinyint(1) DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `historialogowan`
--

LOCK TABLES `historialogowan` WRITE;
/*!40000 ALTER TABLE `historialogowan` DISABLE KEYS */;
/*!40000 ALTER TABLE `historialogowan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `kategorie`
--

DROP TABLE IF EXISTS `kategorie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `kategorie` (
  `idKategorii` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `nazwa` varchar(50) COLLATE utf8_polish_ci NOT NULL,
  PRIMARY KEY (`idKategorii`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kategorie`
--

LOCK TABLES `kategorie` WRITE;
/*!40000 ALTER TABLE `kategorie` DISABLE KEYS */;
/*!40000 ALTER TABLE `kategorie` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `komentarze`
--

DROP TABLE IF EXISTS `komentarze`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `komentarze` (
  `idProduktu` int(10) unsigned NOT NULL,
  `idUzytkownika` int(10) unsigned NOT NULL,
  `data` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `opis` text COLLATE utf8_polish_ci NOT NULL,
  PRIMARY KEY (`idProduktu`,`idUzytkownika`),
  KEY `idProduktu` (`idProduktu`),
  KEY `Komentarze_idUzytkownika` (`idUzytkownika`),
  CONSTRAINT `Komentarze_ibfk_1` FOREIGN KEY (`idProduktu`) REFERENCES `produkty` (`idProduktu`),
  CONSTRAINT `Komentarze_idUzytkownika` FOREIGN KEY (`idUzytkownika`) REFERENCES `uzytkownicy` (`idUzytkownika`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `komentarze`
--

LOCK TABLES `komentarze` WRITE;
/*!40000 ALTER TABLE `komentarze` DISABLE KEYS */;
/*!40000 ALTER TABLE `komentarze` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `marki`
--

DROP TABLE IF EXISTS `marki`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `marki` (
  `idMarki` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `nazwa` varchar(50) COLLATE utf8_polish_ci NOT NULL,
  PRIMARY KEY (`idMarki`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci ROW_FORMAT=COMPACT;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `marki`
--

LOCK TABLES `marki` WRITE;
/*!40000 ALTER TABLE `marki` DISABLE KEYS */;
/*!40000 ALTER TABLE `marki` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `miasta`
--

DROP TABLE IF EXISTS `miasta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `miasta` (
  `idMiasta` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `nazwa` varchar(30) COLLATE utf8_polish_ci DEFAULT NULL,
  PRIMARY KEY (`idMiasta`)
) ENGINE=InnoDB AUTO_INCREMENT=86 DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `miasta`
--

LOCK TABLES `miasta` WRITE;
/*!40000 ALTER TABLE `miasta` DISABLE KEYS */;
/*!40000 ALTER TABLE `miasta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `oceny`
--

DROP TABLE IF EXISTS `oceny`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `oceny` (
  `idProduktu` int(10) unsigned NOT NULL,
  `idUzytkownika` int(10) unsigned NOT NULL,
  `data` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `wartosc` decimal(3,1) unsigned NOT NULL,
  PRIMARY KEY (`idProduktu`,`idUzytkownika`),
  KEY `Oceny_ibfk_1` (`idProduktu`),
  KEY `Oceny_idUzytkownika` (`idUzytkownika`),
  CONSTRAINT `Oceny_ibfk_1` FOREIGN KEY (`idProduktu`) REFERENCES `produkty` (`idProduktu`) ON DELETE CASCADE,
  CONSTRAINT `Oceny_idUzytkownika` FOREIGN KEY (`idUzytkownika`) REFERENCES `uzytkownicy` (`idUzytkownika`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `oceny`
--

LOCK TABLES `oceny` WRITE;
/*!40000 ALTER TABLE `oceny` DISABLE KEYS */;
/*!40000 ALTER TABLE `oceny` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `produkty`
--

DROP TABLE IF EXISTS `produkty`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `produkty` (
  `idProduktu` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `nazwa` varchar(50) COLLATE utf8_polish_ci NOT NULL,
  `opis` text COLLATE utf8_polish_ci,
  `ilosc` int(6) unsigned NOT NULL,
  `idKategorii` int(10) unsigned DEFAULT NULL,
  `idMarki` int(10) unsigned DEFAULT NULL,
  `cena` decimal(6,2) unsigned NOT NULL,
  `ocena` decimal(4,2) unsigned DEFAULT NULL,
  PRIMARY KEY (`idProduktu`),
  KEY `fk_idMarki` (`idMarki`),
  KEY `fk_idKategorii` (`idKategorii`),
  CONSTRAINT `fk_idKategorii` FOREIGN KEY (`idKategorii`) REFERENCES `kategorie` (`idKategorii`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `fk_idMarki` FOREIGN KEY (`idMarki`) REFERENCES `marki` (`idMarki`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `produkty`
--

LOCK TABLES `produkty` WRITE;
/*!40000 ALTER TABLE `produkty` DISABLE KEYS */;
/*!40000 ALTER TABLE `produkty` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `produktyzamowienia`
--

DROP TABLE IF EXISTS `produktyzamowienia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `produktyzamowienia` (
  `idProduktu` int(10) unsigned NOT NULL,
  `idZamowienia` int(10) unsigned NOT NULL,
  `ilosc` int(3) unsigned NOT NULL DEFAULT '1',
  `cenaZamowieniowa` decimal(6,2) unsigned NOT NULL,
  PRIMARY KEY (`idProduktu`,`idZamowienia`),
  KEY `ProduktyZamowienia_ibfk_1` (`idZamowienia`),
  KEY `ProduktyZamowienia_ibfk_2` (`idProduktu`),
  CONSTRAINT `ProduktyZamowienia_ibfk_1` FOREIGN KEY (`idZamowienia`) REFERENCES `zamowienia` (`idZamowienia`) ON DELETE CASCADE,
  CONSTRAINT `ProduktyZamowienia_ibfk_2` FOREIGN KEY (`idProduktu`) REFERENCES `produkty` (`idProduktu`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `produktyzamowienia`
--

LOCK TABLES `produktyzamowienia` WRITE;
/*!40000 ALTER TABLE `produktyzamowienia` DISABLE KEYS */;
/*!40000 ALTER TABLE `produktyzamowienia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sesja`
--

DROP TABLE IF EXISTS `sesja`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sesja` (
  `idSesji` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `idUzytkownika` int(10) unsigned NOT NULL,
  `id` varchar(200) COLLATE utf8_polish_ci NOT NULL,
  `ip` varchar(200) COLLATE utf8_polish_ci DEFAULT NULL,
  `web` varchar(200) COLLATE utf8_polish_ci DEFAULT NULL,
  `czas` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `token` varchar(20) COLLATE utf8_polish_ci DEFAULT NULL,
  PRIMARY KEY (`idSesji`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sesja`
--

LOCK TABLES `sesja` WRITE;
/*!40000 ALTER TABLE `sesja` DISABLE KEYS */;
/*!40000 ALTER TABLE `sesja` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `statusyzamowien`
--

DROP TABLE IF EXISTS `statusyzamowien`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `statusyzamowien` (
  `idStatusuZamowienia` int(5) unsigned NOT NULL AUTO_INCREMENT,
  `nazwaStatusuZamowienia` varchar(30) COLLATE utf8_polish_ci NOT NULL,
  PRIMARY KEY (`idStatusuZamowienia`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `statusyzamowien`
--

LOCK TABLES `statusyzamowien` WRITE;
/*!40000 ALTER TABLE `statusyzamowien` DISABLE KEYS */;
/*!40000 ALTER TABLE `statusyzamowien` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `typykont`
--

DROP TABLE IF EXISTS `typykont`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `typykont` (
  `idTypuKonta` int(3) unsigned NOT NULL AUTO_INCREMENT,
  `typKonta` varchar(20) COLLATE utf8_polish_ci DEFAULT '',
  PRIMARY KEY (`idTypuKonta`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `typykont`
--

LOCK TABLES `typykont` WRITE;
/*!40000 ALTER TABLE `typykont` DISABLE KEYS */;
INSERT INTO `typykont` VALUES (1,'użytkownik'),(2,'administrator');
/*!40000 ALTER TABLE `typykont` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `uzytkownicy`
--

DROP TABLE IF EXISTS `uzytkownicy`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `uzytkownicy` (
  `idUzytkownika` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `imie` varchar(30) COLLATE utf8_polish_ci DEFAULT NULL,
  `nazwisko` varchar(30) COLLATE utf8_polish_ci DEFAULT NULL,
  `login` varchar(20) COLLATE utf8_polish_ci DEFAULT NULL,
  `mail` varchar(50) COLLATE utf8_polish_ci DEFAULT NULL,
  `telefon` varchar(12) COLLATE utf8_polish_ci DEFAULT NULL,
  `idMiasta` int(10) unsigned DEFAULT NULL,
  `nazwaUlicy` varchar(30) COLLATE utf8_polish_ci DEFAULT NULL,
  `numerDomu` varchar(10) COLLATE utf8_polish_ci DEFAULT NULL,
  `idTypuKonta` int(3) unsigned DEFAULT NULL,
  `sol` varchar(10) COLLATE utf8_polish_ci DEFAULT NULL,
  `haslo` varchar(65) COLLATE utf8_polish_ci DEFAULT NULL,
  PRIMARY KEY (`idUzytkownika`),
  UNIQUE KEY `UniqueLoginConstrain` (`login`),
  UNIQUE KEY `login` (`login`),
  UNIQUE KEY `mail` (`mail`),
  KEY `idTypuKonta` (`idTypuKonta`),
  KEY `Uzytkownicy_ibfk_1` (`idMiasta`),
  CONSTRAINT `Uzytkownicy_ibfk_1` FOREIGN KEY (`idMiasta`) REFERENCES `miasta` (`idMiasta`) ON DELETE SET NULL,
  CONSTRAINT `idTypuKonta` FOREIGN KEY (`idTypuKonta`) REFERENCES `typykont` (`idTypuKonta`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `uzytkownicy`
--

LOCK TABLES `uzytkownicy` WRITE;
/*!40000 ALTER TABLE `uzytkownicy` DISABLE KEYS */;
/*!40000 ALTER TABLE `uzytkownicy` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `v_order_info`
--

DROP TABLE IF EXISTS `v_order_info`;
/*!50001 DROP VIEW IF EXISTS `v_order_info`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `v_order_info` AS SELECT 
 1 AS `Id_zamowienia`,
 1 AS `Adres`,
 1 AS `Login`,
 1 AS `Data_zamowienia`,
 1 AS `Nazwa_dostawcy`,
 1 AS `Cena_dostawcy`,
 1 AS `Status_zamowienia`,
 1 AS `Kosz_całkowity`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `v_product_info`
--

DROP TABLE IF EXISTS `v_product_info`;
/*!50001 DROP VIEW IF EXISTS `v_product_info`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `v_product_info` AS SELECT 
 1 AS `Nazwa_produktu`,
 1 AS `Ilość`,
 1 AS `Cena_produktu`,
 1 AS `Średnia_ocen`,
 1 AS `Opis`,
 1 AS `Marka`,
 1 AS `Kategoria`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `v_user_info`
--

DROP TABLE IF EXISTS `v_user_info`;
/*!50001 DROP VIEW IF EXISTS `v_user_info`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `v_user_info` AS SELECT 
 1 AS `idUzytkownika`,
 1 AS `imie`,
 1 AS `nazwisko`,
 1 AS `login`,
 1 AS `haslo`,
 1 AS `mail`,
 1 AS `telefon`,
 1 AS `miasto`,
 1 AS `nazwaUlicy`,
 1 AS `numerDomu`,
 1 AS `typKonta`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `zamowienia`
--

DROP TABLE IF EXISTS `zamowienia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `zamowienia` (
  `idZamowienia` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `idUzytkownika` int(10) unsigned NOT NULL,
  `dataZamowienia` timestamp NULL DEFAULT NULL,
  `dataRealizacjiZam` timestamp NULL DEFAULT NULL,
  `uwaga` text COLLATE utf8_polish_ci,
  `idDostawcy` int(10) unsigned DEFAULT NULL,
  `idStatusuZamowienia` int(5) unsigned DEFAULT NULL,
  PRIMARY KEY (`idZamowienia`),
  KEY `idDostawcy` (`idDostawcy`),
  KEY `idUzytkownika` (`idUzytkownika`),
  KEY `idStatusuZamownienia` (`idStatusuZamowienia`),
  CONSTRAINT `idDostawcy` FOREIGN KEY (`idDostawcy`) REFERENCES `dostawcy` (`idDostawcy`),
  CONSTRAINT `idStatusuZamownienia` FOREIGN KEY (`idStatusuZamowienia`) REFERENCES `statusyzamowien` (`idStatusuZamowienia`),
  CONSTRAINT `idUzytkownika` FOREIGN KEY (`idUzytkownika`) REFERENCES `uzytkownicy` (`idUzytkownika`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `zamowienia`
--

LOCK TABLES `zamowienia` WRITE;
/*!40000 ALTER TABLE `zamowienia` DISABLE KEYS */;
/*!40000 ALTER TABLE `zamowienia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `zdjecia`
--

DROP TABLE IF EXISTS `zdjecia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `zdjecia` (
  `idZdjecia` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `link` mediumtext COLLATE utf8_polish_ci NOT NULL,
  `idProduktu` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`idZdjecia`),
  KEY `fk_idProduktu` (`idProduktu`) USING BTREE,
  CONSTRAINT `idProduktu_fk` FOREIGN KEY (`idProduktu`) REFERENCES `produkty` (`idProduktu`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `zdjecia`
--

LOCK TABLES `zdjecia` WRITE;
/*!40000 ALTER TABLE `zdjecia` DISABLE KEYS */;
/*!40000 ALTER TABLE `zdjecia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Final view structure for view `front_page_view`
--

/*!50001 DROP VIEW IF EXISTS `front_page_view`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY INVOKER */
/*!50001 VIEW `front_page_view` AS select `zdjecia`.`link` AS `link`,`produkty`.`nazwa` AS `nazwa`,`produkty`.`idProduktu` AS `idProduktu`,`produkty`.`ilosc` AS `ilosc`,`produkty`.`cena` AS `cena` from (`produkty` left join `zdjecia` on((`zdjecia`.`idProduktu` = `produkty`.`idProduktu`))) where (`produkty`.`ilosc` > 0) order by rand() limit 6 */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `v_order_info`
--

/*!50001 DROP VIEW IF EXISTS `v_order_info`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `v_order_info` AS select `z`.`idZamowienia` AS `Id_zamowienia`,concat(`m`.`nazwa`,' ',`u`.`nazwaUlicy`,' ',`u`.`numerDomu`) AS `Adres`,`u`.`login` AS `Login`,`z`.`dataZamowienia` AS `Data_zamowienia`,`d`.`nazwa` AS `Nazwa_dostawcy`,`d`.`cena` AS `Cena_dostawcy`,`sz`.`nazwaStatusuZamowienia` AS `Status_zamowienia`,(sum((`p`.`cena` * `pz`.`ilosc`)) + `d`.`cena`) AS `Kosz_całkowity` from ((((((`uzytkownicy` `u` join `miasta` `m` on((`m`.`idMiasta` = `u`.`idMiasta`))) join `zamowienia` `z` on((`z`.`idUzytkownika` = `u`.`idUzytkownika`))) join `dostawcy` `d` on((`d`.`idDostawcy` = `z`.`idDostawcy`))) join `statusyzamowien` `sz` on((`sz`.`idStatusuZamowienia` = `z`.`idStatusuZamowienia`))) join `produktyzamowienia` `pz` on((`pz`.`idZamowienia` = `z`.`idZamowienia`))) join `produkty` `p` on((`p`.`idProduktu` = `pz`.`idProduktu`))) where (`z`.`dataZamowienia` is not null) group by `z`.`idZamowienia`,concat(`m`.`nazwa`,' ',`u`.`nazwaUlicy`,' ',`u`.`numerDomu`),`u`.`login`,`z`.`dataZamowienia`,`d`.`nazwa`,`d`.`cena`,`sz`.`nazwaStatusuZamowienia` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `v_product_info`
--

/*!50001 DROP VIEW IF EXISTS `v_product_info`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY INVOKER */
/*!50001 VIEW `v_product_info` AS select `p`.`nazwa` AS `Nazwa_produktu`,`p`.`ilosc` AS `Ilość`,`p`.`cena` AS `Cena_produktu`,`p`.`ocena` AS `Średnia_ocen`,`p`.`opis` AS `Opis`,`m`.`nazwa` AS `Marka`,`k`.`nazwa` AS `Kategoria` from ((`produkty` `p` join `marki` `m` on((`p`.`idMarki` = `m`.`idMarki`))) join `kategorie` `k` on((`k`.`idKategorii` = `p`.`idKategorii`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `v_user_info`
--

/*!50001 DROP VIEW IF EXISTS `v_user_info`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY INVOKER */
/*!50001 VIEW `v_user_info` AS select `u`.`idUzytkownika` AS `idUzytkownika`,`u`.`imie` AS `imie`,`u`.`nazwisko` AS `nazwisko`,`u`.`login` AS `login`,`u`.`haslo` AS `haslo`,`u`.`mail` AS `mail`,`u`.`telefon` AS `telefon`,`m`.`nazwa` AS `miasto`,`u`.`nazwaUlicy` AS `nazwaUlicy`,`u`.`numerDomu` AS `numerDomu`,`tk`.`typKonta` AS `typKonta` from ((`uzytkownicy` `u` join `miasta` `m` on((`m`.`idMiasta` = `u`.`idMiasta`))) join `typykont` `tk` on((`tk`.`idTypuKonta` = `u`.`idTypuKonta`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-05-16 20:09:53
