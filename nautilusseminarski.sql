/*
SQLyog Community v13.1.5  (64 bit)
MySQL - 10.4.8-MariaDB : Database - nautilusseminarski
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`nautilusseminarski` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `nautilusseminarski`;

/*Table structure for table `artikal` */

DROP TABLE IF EXISTS `artikal`;

CREATE TABLE `artikal` (
  `ArtikalID` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `NazivArtikla` varchar(255) CHARACTER SET utf8mb4 DEFAULT NULL,
  `CenaArtiklaSaPdvom` double DEFAULT NULL,
  `CenaArtiklaBezPdva` double DEFAULT NULL,
  `JedinicaMere` varchar(50) CHARACTER SET utf8mb4 DEFAULT NULL,
  `KorisnikID` int(11) unsigned NOT NULL,
  `PdvStopaID` int(11) unsigned NOT NULL,
  PRIMARY KEY (`ArtikalID`),
  KEY `fk1_korisnik` (`KorisnikID`),
  KEY `fk2_pdvstopa` (`PdvStopaID`),
  CONSTRAINT `fk1_korisnik` FOREIGN KEY (`KorisnikID`) REFERENCES `korisnik` (`KorisnikID`),
  CONSTRAINT `fk2_pdvstopa` FOREIGN KEY (`PdvStopaID`) REFERENCES `pdvstopa` (`PdvStopaID`),
  CONSTRAINT `conJedMere` CHECK (`JedinicaMere` in ('ml','kom'))
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `artikal` */

insert  into `artikal`(`ArtikalID`,`NazivArtikla`,`CenaArtiklaSaPdvom`,`CenaArtiklaBezPdva`,`JedinicaMere`,`KorisnikID`,`PdvStopaID`) values 
(3,'Espreso sa mlekom',156,130,'ml',1,1),
(5,'Cedevita pomorandza',264,220,'ml',1,1),
(17,'Coca cola',180,150,'kom',1,1),
(19,'Jameson',240,200,'ml',1,1),
(20,'Sprite',216,180,'kom',1,1),
(21,'Espreso',108,90,'ml',1,1),
(22,'Nescafe',154,140,'ml',1,2);

/*Table structure for table `korisnik` */

DROP TABLE IF EXISTS `korisnik`;

CREATE TABLE `korisnik` (
  `KorisnikID` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `Ime` varchar(255) CHARACTER SET utf8mb4 DEFAULT NULL,
  `Prezime` varchar(255) CHARACTER SET utf8mb4 DEFAULT NULL,
  `Username` varchar(255) CHARACTER SET utf8mb4 DEFAULT NULL,
  `Password` varchar(255) CHARACTER SET utf8mb4 DEFAULT NULL,
  PRIMARY KEY (`KorisnikID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `korisnik` */

insert  into `korisnik`(`KorisnikID`,`Ime`,`Prezime`,`Username`,`Password`) values 
(1,'Marina','Nikolic','marina','marina'),
(2,'Jovana','Radojevic','jovana','jovana'),
(3,'Pavle','Glisovic','pavle','pavle');

/*Table structure for table `pdvstopa` */

DROP TABLE IF EXISTS `pdvstopa`;

CREATE TABLE `pdvstopa` (
  `PdvStopaID` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `Naziv` varchar(255) CHARACTER SET utf8mb4 DEFAULT NULL,
  `Iznos` double DEFAULT NULL,
  PRIMARY KEY (`PdvStopaID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `pdvstopa` */

insert  into `pdvstopa`(`PdvStopaID`,`Naziv`,`Iznos`) values 
(1,'Opšta stopa',20),
(2,'Posebna stopa',10);

/*Table structure for table `porudzbenica` */

DROP TABLE IF EXISTS `porudzbenica`;

CREATE TABLE `porudzbenica` (
  `PorudzbenicaID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `DatumPorudzbenice` date DEFAULT NULL,
  `UkupnaCenaSaPdvom` double DEFAULT NULL,
  `UkupnaCenaBezPdva` double DEFAULT NULL,
  `StoID` int(10) unsigned NOT NULL,
  `KorisnikID` int(10) unsigned NOT NULL,
  PRIMARY KEY (`PorudzbenicaID`),
  KEY `fk1_sto` (`StoID`),
  KEY `fk3_kori` (`KorisnikID`),
  CONSTRAINT `fk1_sto` FOREIGN KEY (`StoID`) REFERENCES `sto` (`StoID`),
  CONSTRAINT `fk3_kori` FOREIGN KEY (`KorisnikID`) REFERENCES `korisnik` (`KorisnikID`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `porudzbenica` */

insert  into `porudzbenica`(`PorudzbenicaID`,`DatumPorudzbenice`,`UkupnaCenaSaPdvom`,`UkupnaCenaBezPdva`,`StoID`,`KorisnikID`) values 
(16,'2020-02-03',834,730,3,1),
(17,'2020-02-03',1368,1140,8,1),
(19,'2020-02-26',1476,1230,1,1);

/*Table structure for table `stavkaporudzbenice` */

DROP TABLE IF EXISTS `stavkaporudzbenice`;

CREATE TABLE `stavkaporudzbenice` (
  `PorudzbenicaID` int(10) unsigned NOT NULL,
  `Rb` int(10) unsigned NOT NULL,
  `Kolicina` int(11) DEFAULT NULL,
  `UkupnaCenaSaPdvom` double DEFAULT NULL,
  `UkupnaCenaBezPdva` double DEFAULT NULL,
  `ArtikalID` int(10) unsigned NOT NULL,
  PRIMARY KEY (`PorudzbenicaID`,`Rb`),
  KEY `fk_artikal2` (`ArtikalID`),
  CONSTRAINT `fk_artikal` FOREIGN KEY (`ArtikalID`) REFERENCES `artikal` (`ArtikalID`) ON DELETE CASCADE,
  CONSTRAINT `fk_artikal2` FOREIGN KEY (`ArtikalID`) REFERENCES `artikal` (`ArtikalID`) ON UPDATE CASCADE,
  CONSTRAINT `fk_porudzbenica` FOREIGN KEY (`PorudzbenicaID`) REFERENCES `porudzbenica` (`PorudzbenicaID`) ON DELETE CASCADE,
  CONSTRAINT `fk_porudzbenica2` FOREIGN KEY (`PorudzbenicaID`) REFERENCES `porudzbenica` (`PorudzbenicaID`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `stavkaporudzbenice` */

insert  into `stavkaporudzbenice`(`PorudzbenicaID`,`Rb`,`Kolicina`,`UkupnaCenaSaPdvom`,`UkupnaCenaBezPdva`,`ArtikalID`) values 
(16,1,2,216,180,21),
(16,2,1,156,130,3),
(16,3,3,462,420,22),
(17,1,5,216,180,21),
(17,2,2,528,440,5),
(17,3,4,624,520,3),
(19,1,2,216,180,21),
(19,2,5,780,650,3),
(19,3,2,480,400,19);

/*Table structure for table `sto` */

DROP TABLE IF EXISTS `sto`;

CREATE TABLE `sto` (
  `StoID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `PozicijaStola` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `BrojLjudi` int(11) DEFAULT NULL,
  `Status` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`StoID`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `sto` */

insert  into `sto`(`StoID`,`PozicijaStola`,`BrojLjudi`,`Status`) values 
(1,'1 Sank',1,1),
(2,'2 Sank',1,0),
(3,'1 Basta',4,1),
(6,'2 Basta',3,0),
(7,'1 Sredina',6,0),
(8,'2 Sredina',4,1);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
