CREATE DATABASE IF NOT EXISTS `CAR_RENTAL` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `CAR_RENTAL`;

CREATE TABLE `CUSTOMER` (
  `login` VARCHAR(42),
  `adress` VARCHAR(42),
  `name` VARCHAR(42),
  `password` VARCHAR(42),
  `phonenumber` VARCHAR(42),
  `age` VARCHAR(42),
  `customertype` VARCHAR(42),
  `discountlevel` VARCHAR(42),
  PRIMARY KEY (`login`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `RENT` (
  `immatriculation` VARCHAR(42),
  `login` VARCHAR(42),
  `idduration` VARCHAR(42),
  PRIMARY KEY (`immatriculation`, `login`, `idDuration`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `CAR` (
  `immatriculation` VARCHAR(42),
  `description` VARCHAR(42),
  `picture` VARCHAR(42),
  `priceperday` VARCHAR(42),
  `discount` VARCHAR(42),
  PRIMARY KEY (`immatriculation`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `DURATION` (
  `idDuration` VARCHAR(42),
  `start` VARCHAR(42),
  `end` VARCHAR(42),
  PRIMARY KEY (`idDuration`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

ALTER TABLE `RENT` ADD FOREIGN KEY (`idDuration`) REFERENCES `DURATION` (`idDuration`);
ALTER TABLE `RENT` ADD FOREIGN KEY (`login`) REFERENCES `CUSTOMER` (`login`);
ALTER TABLE `RENT` ADD FOREIGN KEY (`immatriculation`) REFERENCES `CAR` (`immatriculation`);