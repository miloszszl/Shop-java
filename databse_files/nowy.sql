-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Wersja serwera:               5.7.17-log - MySQL Community Server (GPL)
-- Serwer OS:                    Win64
-- HeidiSQL Wersja:              9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Zrzut struktury tabela shop.archiwumuzytkownicy
CREATE TABLE IF NOT EXISTS `archiwumuzytkownicy` (
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

-- Zrzucanie danych dla tabeli shop.archiwumuzytkownicy: ~0 rows (około)
/*!40000 ALTER TABLE `archiwumuzytkownicy` DISABLE KEYS */;
/*!40000 ALTER TABLE `archiwumuzytkownicy` ENABLE KEYS */;

-- Zrzut struktury tabela shop.blokady
CREATE TABLE IF NOT EXISTS `blokady` (
  `idBlokady` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `login` varchar(20) COLLATE utf8_polish_ci DEFAULT 'NULL',
  `dataBlokady` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`idBlokady`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

-- Zrzucanie danych dla tabeli shop.blokady: ~0 rows (około)
/*!40000 ALTER TABLE `blokady` DISABLE KEYS */;
/*!40000 ALTER TABLE `blokady` ENABLE KEYS */;

-- Zrzut struktury tabela shop.dostawcy
CREATE TABLE IF NOT EXISTS `dostawcy` (
  `idDostawcy` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `nazwa` varchar(50) COLLATE utf8_polish_ci NOT NULL,
  `cena` decimal(5,2) NOT NULL DEFAULT '0.00',
  PRIMARY KEY (`idDostawcy`),
  UNIQUE KEY `nazwa` (`nazwa`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

-- Zrzucanie danych dla tabeli shop.dostawcy: ~6 rows (około)
/*!40000 ALTER TABLE `dostawcy` DISABLE KEYS */;
INSERT INTO `dostawcy` (`idDostawcy`, `nazwa`, `cena`) VALUES
	(1, 'DPD', 15.00),
	(2, 'DHL', 12.00),
	(3, 'Poczta Polska', 11.99),
	(4, 'Inpost', 13.50),
	(5, 'ASD', 12.00),
	(16, 'ASDASD', 12.01);
/*!40000 ALTER TABLE `dostawcy` ENABLE KEYS */;

-- Zrzut struktury widok shop.front_page_view
-- Tworzenie tymczasowej tabeli aby przezwyciężyć błędy z zależnościami w WIDOKU
CREATE TABLE `front_page_view` (
	`link` MEDIUMTEXT NULL COLLATE 'utf8_polish_ci',
	`nazwa` VARCHAR(50) NOT NULL COLLATE 'utf8_polish_ci',
	`idProduktu` INT(10) UNSIGNED NOT NULL,
	`ilosc` INT(6) UNSIGNED NOT NULL,
	`cena` DECIMAL(6,2) UNSIGNED NOT NULL
) ENGINE=MyISAM;

-- Zrzut struktury tabela shop.historialogowan
CREATE TABLE IF NOT EXISTS `historialogowan` (
  `login` varchar(500) COLLATE utf8_polish_ci DEFAULT NULL,
  `dataZCzasem` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `czyZalogowanoPomyslnie` tinyint(1) DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

-- Zrzucanie danych dla tabeli shop.historialogowan: ~0 rows (około)
/*!40000 ALTER TABLE `historialogowan` DISABLE KEYS */;
/*!40000 ALTER TABLE `historialogowan` ENABLE KEYS */;

-- Zrzut struktury tabela shop.kategorie
CREATE TABLE IF NOT EXISTS `kategorie` (
  `idKategorii` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `nazwa` varchar(50) COLLATE utf8_polish_ci NOT NULL,
  PRIMARY KEY (`idKategorii`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

-- Zrzucanie danych dla tabeli shop.kategorie: ~0 rows (około)
/*!40000 ALTER TABLE `kategorie` DISABLE KEYS */;
INSERT INTO `kategorie` (`idKategorii`, `nazwa`) VALUES
	(1, 'KLAPKI');
/*!40000 ALTER TABLE `kategorie` ENABLE KEYS */;

-- Zrzut struktury tabela shop.komentarze
CREATE TABLE IF NOT EXISTS `komentarze` (
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

-- Zrzucanie danych dla tabeli shop.komentarze: ~0 rows (około)
/*!40000 ALTER TABLE `komentarze` DISABLE KEYS */;
/*!40000 ALTER TABLE `komentarze` ENABLE KEYS */;

-- Zrzut struktury tabela shop.marki
CREATE TABLE IF NOT EXISTS `marki` (
  `idMarki` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `nazwa` varchar(50) COLLATE utf8_polish_ci NOT NULL,
  PRIMARY KEY (`idMarki`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci ROW_FORMAT=COMPACT;

-- Zrzucanie danych dla tabeli shop.marki: ~0 rows (około)
/*!40000 ALTER TABLE `marki` DISABLE KEYS */;
INSERT INTO `marki` (`idMarki`, `nazwa`) VALUES
	(1, 'KUBOT');
/*!40000 ALTER TABLE `marki` ENABLE KEYS */;

-- Zrzut struktury tabela shop.miasta
CREATE TABLE IF NOT EXISTS `miasta` (
  `idMiasta` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `nazwa` varchar(30) COLLATE utf8_polish_ci DEFAULT NULL,
  PRIMARY KEY (`idMiasta`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

-- Zrzucanie danych dla tabeli shop.miasta: ~0 rows (około)
/*!40000 ALTER TABLE `miasta` DISABLE KEYS */;
/*!40000 ALTER TABLE `miasta` ENABLE KEYS */;

-- Zrzut struktury tabela shop.oceny
CREATE TABLE IF NOT EXISTS `oceny` (
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

-- Zrzucanie danych dla tabeli shop.oceny: ~0 rows (około)
/*!40000 ALTER TABLE `oceny` DISABLE KEYS */;
/*!40000 ALTER TABLE `oceny` ENABLE KEYS */;

-- Zrzut struktury tabela shop.produkty
CREATE TABLE IF NOT EXISTS `produkty` (
  `idProduktu` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `nazwa` varchar(50) COLLATE utf8_polish_ci NOT NULL,
  `opis` text COLLATE utf8_polish_ci,
  `ilosc` int(6) unsigned NOT NULL,
  `idKategorii` int(10) unsigned DEFAULT NULL,
  `idMarki` int(10) unsigned DEFAULT NULL,
  `cena` decimal(6,2) unsigned NOT NULL,
  `ocena` decimal(4,2) unsigned DEFAULT NULL,
  `zdjecie` varchar(150) COLLATE utf8_polish_ci DEFAULT NULL,
  PRIMARY KEY (`idProduktu`),
  KEY `fk_idMarki` (`idMarki`),
  KEY `fk_idKategorii` (`idKategorii`),
  CONSTRAINT `fk_idKategorii` FOREIGN KEY (`idKategorii`) REFERENCES `kategorie` (`idKategorii`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `fk_idMarki` FOREIGN KEY (`idMarki`) REFERENCES `marki` (`idMarki`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

-- Zrzucanie danych dla tabeli shop.produkty: ~2 rows (około)
/*!40000 ALTER TABLE `produkty` DISABLE KEYS */;
INSERT INTO `produkty` (`idProduktu`, `nazwa`, `opis`, `ilosc`, `idKategorii`, `idMarki`, `cena`, `ocena`, `zdjecie`) VALUES
	(1, 'SUPER KLAPKI', 'Elo mordy\r\n', 4, 1, 1, 10.00, 1.00, 'eb6845e4-402c-40bf-93db-8efc70de3366'),
	(2, 'ADIBAS', 'no hej', 3, 1, 1, 2.00, 0.00, 'ea14e131-e0ea-4011-b506-02df27060413');
/*!40000 ALTER TABLE `produkty` ENABLE KEYS */;

-- Zrzut struktury tabela shop.produktyzamowienia
CREATE TABLE IF NOT EXISTS `produktyzamowienia` (
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

-- Zrzucanie danych dla tabeli shop.produktyzamowienia: ~0 rows (około)
/*!40000 ALTER TABLE `produktyzamowienia` DISABLE KEYS */;
/*!40000 ALTER TABLE `produktyzamowienia` ENABLE KEYS */;

-- Zrzut struktury tabela shop.sesja
CREATE TABLE IF NOT EXISTS `sesja` (
  `idSesji` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `idUzytkownika` int(10) unsigned NOT NULL,
  `id` varchar(200) COLLATE utf8_polish_ci NOT NULL,
  `ip` varchar(200) COLLATE utf8_polish_ci DEFAULT NULL,
  `web` varchar(200) COLLATE utf8_polish_ci DEFAULT NULL,
  `czas` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `token` varchar(20) COLLATE utf8_polish_ci DEFAULT NULL,
  PRIMARY KEY (`idSesji`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

-- Zrzucanie danych dla tabeli shop.sesja: ~0 rows (około)
/*!40000 ALTER TABLE `sesja` DISABLE KEYS */;
/*!40000 ALTER TABLE `sesja` ENABLE KEYS */;

-- Zrzut struktury tabela shop.statusyzamowien
CREATE TABLE IF NOT EXISTS `statusyzamowien` (
  `idStatusuZamowienia` int(5) unsigned NOT NULL AUTO_INCREMENT,
  `nazwaStatusuZamowienia` varchar(30) COLLATE utf8_polish_ci NOT NULL,
  PRIMARY KEY (`idStatusuZamowienia`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

-- Zrzucanie danych dla tabeli shop.statusyzamowien: ~0 rows (około)
/*!40000 ALTER TABLE `statusyzamowien` DISABLE KEYS */;
/*!40000 ALTER TABLE `statusyzamowien` ENABLE KEYS */;

-- Zrzut struktury tabela shop.typykont
CREATE TABLE IF NOT EXISTS `typykont` (
  `idTypuKonta` int(3) unsigned NOT NULL AUTO_INCREMENT,
  `typKonta` varchar(20) COLLATE utf8_polish_ci DEFAULT '',
  PRIMARY KEY (`idTypuKonta`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

-- Zrzucanie danych dla tabeli shop.typykont: ~2 rows (około)
/*!40000 ALTER TABLE `typykont` DISABLE KEYS */;
INSERT INTO `typykont` (`idTypuKonta`, `typKonta`) VALUES
	(1, 'ROLE_ADMIN'),
	(2, 'ROLE_USER');
/*!40000 ALTER TABLE `typykont` ENABLE KEYS */;

-- Zrzut struktury tabela shop.uzytkownicy
CREATE TABLE IF NOT EXISTS `uzytkownicy` (
  `idUzytkownika` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `imie` varchar(30) COLLATE utf8_polish_ci DEFAULT NULL,
  `nazwisko` varchar(30) COLLATE utf8_polish_ci DEFAULT NULL,
  `login` varchar(20) COLLATE utf8_polish_ci DEFAULT NULL,
  `mail` varchar(50) COLLATE utf8_polish_ci DEFAULT NULL,
  `telefon` varchar(12) COLLATE utf8_polish_ci DEFAULT NULL,
  `idMiasta` int(10) unsigned DEFAULT NULL,
  `nazwaUlicy` varchar(30) COLLATE utf8_polish_ci DEFAULT NULL,
  `numerDomu` varchar(10) COLLATE utf8_polish_ci DEFAULT NULL,
  `idTypuKonta` int(3) unsigned DEFAULT '2',
  `sol` varchar(10) COLLATE utf8_polish_ci DEFAULT NULL,
  `haslo` varchar(65) COLLATE utf8_polish_ci DEFAULT NULL,
  `miasto` varchar(100) COLLATE utf8_polish_ci DEFAULT NULL,
  `wojewodztwo` varchar(100) COLLATE utf8_polish_ci DEFAULT NULL,
  `kodpocztowy` varchar(100) COLLATE utf8_polish_ci DEFAULT NULL,
  PRIMARY KEY (`idUzytkownika`),
  UNIQUE KEY `UniqueLoginConstrain` (`login`),
  UNIQUE KEY `login` (`login`),
  UNIQUE KEY `mail` (`mail`),
  KEY `idTypuKonta` (`idTypuKonta`),
  KEY `Uzytkownicy_ibfk_1` (`idMiasta`),
  CONSTRAINT `Uzytkownicy_ibfk_1` FOREIGN KEY (`idMiasta`) REFERENCES `miasta` (`idMiasta`) ON DELETE SET NULL,
  CONSTRAINT `idTypuKonta` FOREIGN KEY (`idTypuKonta`) REFERENCES `typykont` (`idTypuKonta`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

-- Zrzucanie danych dla tabeli shop.uzytkownicy: ~2 rows (około)
/*!40000 ALTER TABLE `uzytkownicy` DISABLE KEYS */;
INSERT INTO `uzytkownicy` (`idUzytkownika`, `imie`, `nazwisko`, `login`, `mail`, `telefon`, `idMiasta`, `nazwaUlicy`, `numerDomu`, `idTypuKonta`, `sol`, `haslo`, `miasto`, `wojewodztwo`, `kodpocztowy`) VALUES
	(12, NULL, NULL, 'admin', 'as', NULL, NULL, NULL, NULL, 1, NULL, 'password', NULL, NULL, NULL),
	(14, 'Janusz', 'Krzesiwo', 'user', 'qw', '34323234', NULL, 'Młyńska', '13', 2, NULL, 'password', 'Kraków', 'małopolskie', '32-323'),
	(15, NULL, NULL, 'asd', 'asd', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
/*!40000 ALTER TABLE `uzytkownicy` ENABLE KEYS */;

-- Zrzut struktury widok shop.v_order_info
-- Tworzenie tymczasowej tabeli aby przezwyciężyć błędy z zależnościami w WIDOKU
CREATE TABLE `v_order_info` (
	`Id_zamowienia` INT(10) UNSIGNED NOT NULL,
	`Adres` VARCHAR(72) NULL COLLATE 'utf8_polish_ci',
	`Login` VARCHAR(20) NULL COLLATE 'utf8_polish_ci',
	`Data_zamowienia` TIMESTAMP NULL,
	`Nazwa_dostawcy` VARCHAR(50) NOT NULL COLLATE 'utf8_polish_ci',
	`Cena_dostawcy` DECIMAL(5,2) NOT NULL,
	`Status_zamowienia` VARCHAR(30) NOT NULL COLLATE 'utf8_polish_ci',
	`Kosz_całkowity` DECIMAL(39,2) NULL
) ENGINE=MyISAM;

-- Zrzut struktury widok shop.v_product_info
-- Tworzenie tymczasowej tabeli aby przezwyciężyć błędy z zależnościami w WIDOKU
CREATE TABLE `v_product_info` (
	`Nazwa_produktu` VARCHAR(50) NOT NULL COLLATE 'utf8_polish_ci',
	`Ilość` INT(6) UNSIGNED NOT NULL,
	`Cena_produktu` DECIMAL(6,2) UNSIGNED NOT NULL,
	`Średnia_ocen` DECIMAL(4,2) UNSIGNED NULL,
	`Opis` TEXT NULL COLLATE 'utf8_polish_ci',
	`Marka` VARCHAR(50) NOT NULL COLLATE 'utf8_polish_ci',
	`Kategoria` VARCHAR(50) NOT NULL COLLATE 'utf8_polish_ci'
) ENGINE=MyISAM;

-- Zrzut struktury widok shop.v_user_info
-- Tworzenie tymczasowej tabeli aby przezwyciężyć błędy z zależnościami w WIDOKU
CREATE TABLE `v_user_info` (
	`idUzytkownika` INT(10) UNSIGNED NOT NULL,
	`imie` VARCHAR(30) NULL COLLATE 'utf8_polish_ci',
	`nazwisko` VARCHAR(30) NULL COLLATE 'utf8_polish_ci',
	`login` VARCHAR(20) NULL COLLATE 'utf8_polish_ci',
	`haslo` VARCHAR(65) NULL COLLATE 'utf8_polish_ci',
	`mail` VARCHAR(50) NULL COLLATE 'utf8_polish_ci',
	`telefon` VARCHAR(12) NULL COLLATE 'utf8_polish_ci',
	`miasto` VARCHAR(30) NULL COLLATE 'utf8_polish_ci',
	`nazwaUlicy` VARCHAR(30) NULL COLLATE 'utf8_polish_ci',
	`numerDomu` VARCHAR(10) NULL COLLATE 'utf8_polish_ci',
	`typKonta` VARCHAR(20) NULL COLLATE 'utf8_polish_ci'
) ENGINE=MyISAM;

-- Zrzut struktury tabela shop.zamowienia
CREATE TABLE IF NOT EXISTS `zamowienia` (
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

-- Zrzucanie danych dla tabeli shop.zamowienia: ~0 rows (około)
/*!40000 ALTER TABLE `zamowienia` DISABLE KEYS */;
/*!40000 ALTER TABLE `zamowienia` ENABLE KEYS */;

-- Zrzut struktury tabela shop.zdjecia
CREATE TABLE IF NOT EXISTS `zdjecia` (
  `idZdjecia` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `link` mediumtext COLLATE utf8_polish_ci NOT NULL,
  `idProduktu` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`idZdjecia`),
  KEY `fk_idProduktu` (`idProduktu`) USING BTREE,
  CONSTRAINT `idProduktu_fk` FOREIGN KEY (`idProduktu`) REFERENCES `produkty` (`idProduktu`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

-- Zrzucanie danych dla tabeli shop.zdjecia: ~0 rows (około)
/*!40000 ALTER TABLE `zdjecia` DISABLE KEYS */;
/*!40000 ALTER TABLE `zdjecia` ENABLE KEYS */;

-- Zrzut struktury widok shop.front_page_view
-- Usuwanie tabeli tymczasowej i tworzenie ostatecznej struktury WIDOKU
DROP TABLE IF EXISTS `front_page_view`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY INVOKER VIEW `front_page_view` AS select `zdjecia`.`link` AS `link`,`produkty`.`nazwa` AS `nazwa`,`produkty`.`idProduktu` AS `idProduktu`,`produkty`.`ilosc` AS `ilosc`,`produkty`.`cena` AS `cena` from (`produkty` left join `zdjecia` on((`zdjecia`.`idProduktu` = `produkty`.`idProduktu`))) where (`produkty`.`ilosc` > 0) order by rand() limit 6;

-- Zrzut struktury widok shop.v_order_info
-- Usuwanie tabeli tymczasowej i tworzenie ostatecznej struktury WIDOKU
DROP TABLE IF EXISTS `v_order_info`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_order_info` AS select `z`.`idZamowienia` AS `Id_zamowienia`,concat(`m`.`nazwa`,' ',`u`.`nazwaUlicy`,' ',`u`.`numerDomu`) AS `Adres`,`u`.`login` AS `Login`,`z`.`dataZamowienia` AS `Data_zamowienia`,`d`.`nazwa` AS `Nazwa_dostawcy`,`d`.`cena` AS `Cena_dostawcy`,`sz`.`nazwaStatusuZamowienia` AS `Status_zamowienia`,(sum((`p`.`cena` * `pz`.`ilosc`)) + `d`.`cena`) AS `Kosz_całkowity` from ((((((`uzytkownicy` `u` join `miasta` `m` on((`m`.`idMiasta` = `u`.`idMiasta`))) join `zamowienia` `z` on((`z`.`idUzytkownika` = `u`.`idUzytkownika`))) join `dostawcy` `d` on((`d`.`idDostawcy` = `z`.`idDostawcy`))) join `statusyzamowien` `sz` on((`sz`.`idStatusuZamowienia` = `z`.`idStatusuZamowienia`))) join `produktyzamowienia` `pz` on((`pz`.`idZamowienia` = `z`.`idZamowienia`))) join `produkty` `p` on((`p`.`idProduktu` = `pz`.`idProduktu`))) where (`z`.`dataZamowienia` is not null) group by `z`.`idZamowienia`,concat(`m`.`nazwa`,' ',`u`.`nazwaUlicy`,' ',`u`.`numerDomu`),`u`.`login`,`z`.`dataZamowienia`,`d`.`nazwa`,`d`.`cena`,`sz`.`nazwaStatusuZamowienia`;

-- Zrzut struktury widok shop.v_product_info
-- Usuwanie tabeli tymczasowej i tworzenie ostatecznej struktury WIDOKU
DROP TABLE IF EXISTS `v_product_info`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY INVOKER VIEW `v_product_info` AS select `p`.`nazwa` AS `Nazwa_produktu`,`p`.`ilosc` AS `Ilość`,`p`.`cena` AS `Cena_produktu`,`p`.`ocena` AS `Średnia_ocen`,`p`.`opis` AS `Opis`,`m`.`nazwa` AS `Marka`,`k`.`nazwa` AS `Kategoria` from ((`produkty` `p` join `marki` `m` on((`p`.`idMarki` = `m`.`idMarki`))) join `kategorie` `k` on((`k`.`idKategorii` = `p`.`idKategorii`)));

-- Zrzut struktury widok shop.v_user_info
-- Usuwanie tabeli tymczasowej i tworzenie ostatecznej struktury WIDOKU
DROP TABLE IF EXISTS `v_user_info`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY INVOKER VIEW `v_user_info` AS select `u`.`idUzytkownika` AS `idUzytkownika`,`u`.`imie` AS `imie`,`u`.`nazwisko` AS `nazwisko`,`u`.`login` AS `login`,`u`.`haslo` AS `haslo`,`u`.`mail` AS `mail`,`u`.`telefon` AS `telefon`,`m`.`nazwa` AS `miasto`,`u`.`nazwaUlicy` AS `nazwaUlicy`,`u`.`numerDomu` AS `numerDomu`,`tk`.`typKonta` AS `typKonta` from ((`uzytkownicy` `u` join `miasta` `m` on((`m`.`idMiasta` = `u`.`idMiasta`))) join `typykont` `tk` on((`tk`.`idTypuKonta` = `u`.`idTypuKonta`)));

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
