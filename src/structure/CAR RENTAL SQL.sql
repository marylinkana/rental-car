CREATE DATABASE IF NOT EXISTS `CAR-RENTAL` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `CAR-RENTAL`;

CREATE TABLE `CUSTOMER` (
  `login` VARCHAR(42),
  `adress` VARCHAR(42),
  `name` VARCHAR(42),
  `password` VARCHAR(42),
  `phonenumber` INT,
  `age` DATE,
  `userlevel` VARCHAR(42),
  `discountlevel` DOUBLE,
  PRIMARY KEY (`login`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `RENT` (
  `immatriculation` VARCHAR(42),
  `login` VARCHAR(42),
  `idduration` SMALLINT,
  PRIMARY KEY (`immatriculation`, `login`, `idduration`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `CAR` (
  `immatriculation` VARCHAR(42),
  `description` VARCHAR(42),
  `picture` VARCHAR(42),
  `priceperday` DOUBLE,
  `discount` DOUBLE,
  PRIMARY KEY (`immatriculation`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `DURATION` (
  `idduration`SMALLINT,
  `start` DATE,
  `end`DATE,
  PRIMARY KEY (`idduration`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

ALTER TABLE `RENT` ADD FOREIGN KEY (`idduration`) REFERENCES `DURATION` (`idduration`);
ALTER TABLE `RENT` ADD FOREIGN KEY (`login`) REFERENCES `CUSTOMER` (`login`);
ALTER TABLE `RENT` ADD FOREIGN KEY (`immatriculation`) REFERENCES `CAR` (`immatriculation`);