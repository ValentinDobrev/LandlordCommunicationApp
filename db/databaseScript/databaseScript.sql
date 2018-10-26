-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

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
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(45) NOT NULL,
  `surname` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `password` VARCHAR(200) NOT NULL,
  `budget` DECIMAL(10,0) NULL DEFAULT NULL,
  `is_tenant` TINYINT(1) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `IdUser_UNIQUE` (`id` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 24
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `landlordcommunication`.`residences`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `landlordcommunication`.`residences` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `address` VARCHAR(100) NOT NULL,
  `rent` DECIMAL(10,0) NOT NULL,
  `due_date` DATE NOT NULL,
  `notification_date` DATE NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `IdResidence_UNIQUE` (`id` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 29
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `landlordcommunication`.`messages`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `landlordcommunication`.`messages` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `text` VARCHAR(200) NULL DEFAULT NULL,
  `picture` BLOB NULL DEFAULT NULL,
  `sent_date` DATETIME NOT NULL,
  `sender_id` INT(11) NOT NULL,
  `receiver_id` INT(11) NOT NULL,
  `residence_id` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `receiver_id_idx` (`receiver_id` ASC),
  INDEX `sender_id_idx` (`sender_id` ASC),
  INDEX `residence_id_idx` (`residence_id` ASC),
  CONSTRAINT `receiverId`
    FOREIGN KEY (`receiver_id`)
    REFERENCES `landlordcommunication`.`users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `residenceId`
    FOREIGN KEY (`residence_id`)
    REFERENCES `landlordcommunication`.`residences` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `senderId`
    FOREIGN KEY (`sender_id`)
    REFERENCES `landlordcommunication`.`users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `landlordcommunication`.`ratingrecords`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `landlordcommunication`.`ratingrecords` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `giver_id` INT(11) NOT NULL,
  `taker_id` INT(11) NOT NULL,
  `rating` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `IdGiver_idx` (`giver_id` ASC),
  INDEX `IdTaker_idx` (`taker_id` ASC),
  CONSTRAINT `giverId`
    FOREIGN KEY (`giver_id`)
    REFERENCES `landlordcommunication`.`users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `takerId`
    FOREIGN KEY (`taker_id`)
    REFERENCES `landlordcommunication`.`users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 46
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `landlordcommunication`.`usertoresidence`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `landlordcommunication`.`usertoresidence` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `residence_id` INT(11) NOT NULL,
  `user_id` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `residence_id_idx` (`residence_id` ASC),
  INDEX `user_id_idx` (`user_id` ASC),
  CONSTRAINT `residence_id`
    FOREIGN KEY (`residence_id`)
    REFERENCES `landlordcommunication`.`residences` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `user_id`
    FOREIGN KEY (`user_id`)
    REFERENCES `landlordcommunication`.`users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 42
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
