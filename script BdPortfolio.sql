-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema PortfolioDB
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema PortfolioDB
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `PortfolioDB` DEFAULT CHARACTER SET utf8 ;
USE `PortfolioDB` ;

-- -----------------------------------------------------
-- Table `PortfolioDB`.`Tecnologias`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `PortfolioDB`.`Tecnologias` (
  `id` INT NOT NULL,
  `nombre` VARCHAR(45) NULL,
  `descripcion` VARCHAR(200) NULL,
  `porcentaje` INT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `PortfolioDB`.`Persona`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `PortfolioDB`.`Persona` (
  `id` INT NOT NULL,
  `nombre` VARCHAR(45) NULL,
  `apellido` VARCHAR(45) NULL,
  `fecha_nacimiento` VARCHAR(45) NULL,
  `acercaDe` VARCHAR(200) NULL,
  `url_foto` VARCHAR(200) NULL,
  `Tecnologias_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Persona_Tecnologias1_idx` (`Tecnologias_id` ASC) VISIBLE,
  CONSTRAINT `fk_Persona_Tecnologias1`
    FOREIGN KEY (`Tecnologias_id`)
    REFERENCES `PortfolioDB`.`Tecnologias` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `PortfolioDB`.`ExperienciaLaboral`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `PortfolioDB`.`ExperienciaLaboral` (
  `id` INT NOT NULL,
  `nombre_empresa` VARCHAR(45) NULL,
  `es_trabajo_actual` TINYINT NULL,
  `fecha_inicio` DATE NULL,
  `fecha_finalizacion` DATE NULL,
  `descripcion` VARCHAR(200) NULL,
  `table2col` VARCHAR(45) NULL,
  `Persona_id` INT NOT NULL,
  INDEX `fk_ExperienciaLaboral_Persona_idx` (`Persona_id` ASC) VISIBLE,
  CONSTRAINT `fk_ExperienciaLaboral_Persona`
    FOREIGN KEY (`Persona_id`)
    REFERENCES `PortfolioDB`.`Persona` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `PortfolioDB`.`Educacion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `PortfolioDB`.`Educacion` (
  `id` INT NOT NULL,
  `nombre_intitucion` VARCHAR(45) NULL,
  `fecha_inicio` VARCHAR(45) NULL,
  `fecha_finalizacion` VARCHAR(45) NULL,
  `Persona_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Educacion_Persona1_idx` (`Persona_id` ASC) VISIBLE,
  CONSTRAINT `fk_Educacion_Persona1`
    FOREIGN KEY (`Persona_id`)
    REFERENCES `PortfolioDB`.`Persona` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `PortfolioDB`.`Usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `PortfolioDB`.`Usuario` (
  `id` INT NOT NULL,
  `dni` INT NOT NULL,
  `nombre_usuario` VARCHAR(45) NOT NULL,
  `contraseña` VARCHAR(45) NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `apellido` VARCHAR(45) NOT NULL,
  `fecha_nacimiento` DATE NOT NULL,
  `Persona_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Usuario_Persona1_idx` (`Persona_id` ASC) VISIBLE,
  CONSTRAINT `fk_Usuario_Persona1`
    FOREIGN KEY (`Persona_id`)
    REFERENCES `PortfolioDB`.`Persona` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `PortfolioDB`.`Domicilio`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `PortfolioDB`.`Domicilio` (
  `id` INT NOT NULL,
  `direccion` VARCHAR(45) NULL,
  `localidad` VARCHAR(45) NULL,
  `codigo_postal` INT NULL,
  `provincia` VARCHAR(45) NULL,
  `pais` VARCHAR(45) NULL,
  `Persona_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Domicilio_Persona1_idx` (`Persona_id` ASC) VISIBLE,
  CONSTRAINT `fk_Domicilio_Persona1`
    FOREIGN KEY (`Persona_id`)
    REFERENCES `PortfolioDB`.`Persona` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `PortfolioDB`.`Proyectos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `PortfolioDB`.`Proyectos` (
  `id` INT NOT NULL,
  `nombre` VARCHAR(90) NULL,
  `fecha_inicio` DATE NULL,
  `fecha_finalizacion` DATE NULL,
  `descripcion` VARCHAR(200) NULL,
  `url_proyecto` VARCHAR(45) NULL,
  `Persona_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Proyectos_Persona1_idx` (`Persona_id` ASC) VISIBLE,
  CONSTRAINT `fk_Proyectos_Persona1`
    FOREIGN KEY (`Persona_id`)
    REFERENCES `PortfolioDB`.`Persona` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
