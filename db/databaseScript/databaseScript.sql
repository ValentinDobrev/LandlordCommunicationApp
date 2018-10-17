-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema landlordcommunication
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema landlordcommunication
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `landlordcommunication` DEFAULT CHARACTER SET utf8 ;
USE `landlordcommunication` ;

-- -----------------------------------------------------
-- Table `landlordcommunication`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `landlordcommunication`.`users` (
  `IdUser` INT(11) NOT NULL AUTO_INCREMENT,
  `FirstName` VARCHAR(45) NOT NULL,
  `Surname` VARCHAR(45) NOT NULL,
  `Email` VARCHAR(45) NOT NULL,
  `Budget` DECIMAL(10,0) NULL DEFAULT NULL,
  `IsTenant` TINYINT(1) NOT NULL,
  PRIMARY KEY (`IdUser`),
  UNIQUE INDEX `IdUser_UNIQUE` (`IdUser` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 12
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `landlordcommunication`.`ratingrecords`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `landlordcommunication`.`ratingrecords` (
  `IdRatingRecord` INT(11) NOT NULL AUTO_INCREMENT,
  `IdGiver` INT(11) NOT NULL,
  `IdTaker` INT(11) NOT NULL,
  `Rating` INT(11) NOT NULL,
  PRIMARY KEY (`IdRatingRecord`, `IdGiver`, `IdTaker`),
  INDEX `IdGiver_idx` (`IdGiver` ASC),
  INDEX `IdTaker_idx` (`IdTaker` ASC),
  CONSTRAINT `IdGiver`
    FOREIGN KEY (`IdGiver`)
    REFERENCES `landlordcommunication`.`users` (`IdUser`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `IdTaker`
    FOREIGN KEY (`IdTaker`)
    REFERENCES `landlordcommunication`.`users` (`IdUser`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 16
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `landlordcommunication`.`residences`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `landlordcommunication`.`residences` (
  `IdResidence` INT(11) NOT NULL AUTO_INCREMENT,
  `Address` VARCHAR(100) NOT NULL,
  `LandlordId` INT(11) NOT NULL,
  `Rent` DECIMAL(10,0) NOT NULL,
  PRIMARY KEY (`IdResidence`),
  UNIQUE INDEX `IdResidence_UNIQUE` (`IdResidence` ASC),
  INDEX `LandlordId_idx` (`LandlordId` ASC),
  CONSTRAINT `LandlordId`
    FOREIGN KEY (`LandlordId`)
    REFERENCES `landlordcommunication`.`users` (`IdUser`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 10
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `landlordcommunication`.`usertoresidence`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `landlordcommunication`.`usertoresidence` (
  `IdTenant` INT(11) NOT NULL,
  `IdLandlord` INT(11) NOT NULL,
  `IdResidence` INT(11) NOT NULL,
  PRIMARY KEY (`IdTenant`, `IdLandlord`, `IdResidence`),
  INDEX `IdResidence_idx` (`IdResidence` ASC),
  INDEX `IdLandlord_idx` (`IdLandlord` ASC),
  INDEX `IdTenant_idx` (`IdTenant` ASC),
  CONSTRAINT `IdLandlord`
    FOREIGN KEY (`IdLandlord`)
    REFERENCES `landlordcommunication`.`users` (`IdUser`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `IdResidence`
    FOREIGN KEY (`IdResidence`)
    REFERENCES `landlordcommunication`.`residences` (`IdResidence`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `IdTenant`
    FOREIGN KEY (`IdTenant`)
    REFERENCES `landlordcommunication`.`users` (`IdUser`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
