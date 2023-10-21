-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema dentiapp
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema dentiapp
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `dentiapp` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `dentiapp` ;

-- -----------------------------------------------------
-- Table `dentiapp`.`especialidad`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dentiapp`.`especialidad` (
  `ID_Especialidad` INT NOT NULL AUTO_INCREMENT,
  `Nombre` VARCHAR(45) NOT NULL,
  `Descripcion` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`ID_Especialidad`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `dentiapp`.`doctores`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dentiapp`.`doctores` (
  `DNI` VARCHAR(25) NOT NULL,
  `ID_Especialidad` INT NOT NULL,
  `Nombre` VARCHAR(45) NOT NULL,
  `Apellidos` VARCHAR(45) NOT NULL,
  `Telefono` INT NOT NULL,
  `Direccion` VARCHAR(45) NULL DEFAULT NULL,
  `Fecha_Nacimiento` VARCHAR(45) NULL DEFAULT NULL,
  `Salario` DOUBLE NOT NULL,
  `Correo` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`DNI`),
  INDEX `ID_Especialidad_idx` (`ID_Especialidad` ASC) VISIBLE,
  CONSTRAINT `ID_Especialidad`
    FOREIGN KEY (`ID_Especialidad`)
    REFERENCES `dentiapp`.`especialidad` (`ID_Especialidad`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `dentiapp`.`paciente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dentiapp`.`paciente` (
  `DNI` VARCHAR(25) NOT NULL,
  `Nombre` VARCHAR(45) NOT NULL,
  `Apellido` VARCHAR(45) NOT NULL,
  `Telefono` INT NOT NULL,
  `Correo` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`DNI`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `dentiapp`.`tratamiento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dentiapp`.`tratamiento` (
  `ID_Tratamiento` INT NOT NULL,
  `Nombre` VARCHAR(45) NOT NULL,
  `Precio` DOUBLE NOT NULL,
  PRIMARY KEY (`ID_Tratamiento`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `dentiapp`.`citas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dentiapp`.`citas` (
  `ID_Cita` INT NOT NULL AUTO_INCREMENT,
  `ID_Paciente` VARCHAR(45) NOT NULL,
  `ID_Doctor` VARCHAR(45) NOT NULL,
  `ID_Tratamiento` INT NOT NULL,
  `Fecha_Hora` VARCHAR(45) NOT NULL,
  `Motivo_visita` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`ID_Cita`),
  INDEX `ID_Paciente_idx` (`ID_Paciente` ASC) VISIBLE,
  INDEX `ID_Doctor_idx` (`ID_Doctor` ASC) VISIBLE,
  INDEX `ID_Tratamiento_idx` (`ID_Tratamiento` ASC) VISIBLE,
  CONSTRAINT `ID_Doctor`
    FOREIGN KEY (`ID_Doctor`)
    REFERENCES `dentiapp`.`doctores` (`DNI`),
  CONSTRAINT `ID_Paciente`
    FOREIGN KEY (`ID_Paciente`)
    REFERENCES `dentiapp`.`paciente` (`DNI`),
  CONSTRAINT `ID_Tratamiento`
    FOREIGN KEY (`ID_Tratamiento`)
    REFERENCES `dentiapp`.`tratamiento` (`ID_Tratamiento`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `dentiapp`.`historial`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dentiapp`.`historial` (
  `ID_Historial` INT NOT NULL AUTO_INCREMENT,
  `ID_Cita` INT NOT NULL,
  `Fecha` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`ID_Historial`),
  INDEX `ID_Cita_idx` (`ID_Cita` ASC) VISIBLE,
  CONSTRAINT `ID_Cita`
    FOREIGN KEY (`ID_Cita`)
    REFERENCES `dentiapp`.`citas` (`ID_Cita`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `dentiapp`.`pagar`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dentiapp`.`pagar` (
  `ID_Pago` INT NOT NULL AUTO_INCREMENT,
  `DNI_Paciente` VARCHAR(45) NOT NULL,
  `Cantidad_Pagada` DOUBLE NOT NULL,
  `Tipo_Pago` VARCHAR(45) NOT NULL,
  `Duracion_pago` VARCHAR(45) NOT NULL,
  `Cantidad_Total_Pagar` DOUBLE NOT NULL,
  PRIMARY KEY (`ID_Pago`),
  INDEX `DNI_Paciente` (`DNI_Paciente` ASC) VISIBLE,
  CONSTRAINT `DNI_Paciente`
    FOREIGN KEY (`DNI_Paciente`)
    REFERENCES `dentiapp`.`paciente` (`DNI`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `dentiapp`.`pedidos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dentiapp`.`pedidos` (
  `ID_Pedido` INT NOT NULL AUTO_INCREMENT,
  `Cantidad` INT NOT NULL,
  `Precio_Pedido` DOUBLE NOT NULL,
  `Fecha` DATE NOT NULL,
  PRIMARY KEY (`ID_Pedido`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `dentiapp`.`proveedor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dentiapp`.`proveedor` (
  `ID_Proveedor` INT NOT NULL AUTO_INCREMENT,
  `Nombre` VARCHAR(45) NOT NULL,
  `Direccion` VARCHAR(45) NULL DEFAULT NULL,
  `Telefono` INT NOT NULL,
  `Correo` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`ID_Proveedor`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `dentiapp`.`stock`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dentiapp`.`stock` (
  `ID_Material` INT NOT NULL AUTO_INCREMENT,
  `ID_Proveedor` INT NOT NULL,
  `ID_Pedido` INT NOT NULL,
  `Nombre` VARCHAR(45) NOT NULL,
  `Cantidad` INT NOT NULL,
  `Precio` DOUBLE NOT NULL,
  `Observaciones` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`ID_Material`),
  INDEX `ID_Proveedor_idx` (`ID_Proveedor` ASC) VISIBLE,
  INDEX `ID_Pedido_idx` (`ID_Pedido` ASC) VISIBLE,
  CONSTRAINT `ID_Pedido`
    FOREIGN KEY (`ID_Pedido`)
    REFERENCES `dentiapp`.`pedidos` (`ID_Pedido`),
  CONSTRAINT `ID_Proveedor`
    FOREIGN KEY (`ID_Proveedor`)
    REFERENCES `dentiapp`.`proveedor` (`ID_Proveedor`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `dentiapp`.`solicitudes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dentiapp`.`solicitudes` (
  `ID_Solicitud` INT NOT NULL,
  `ID_Cita` INT NOT NULL,
  `ID_Material` INT NOT NULL,
  `Cantidad` INT NOT NULL,
  PRIMARY KEY (`ID_Solicitud`),
  INDEX `ID_Citas` (`ID_Cita` ASC) VISIBLE,
  INDEX `ID_Material_idx` (`ID_Material` ASC) VISIBLE,
  CONSTRAINT `ID_Citas`
    FOREIGN KEY (`ID_Cita`)
    REFERENCES `dentiapp`.`citas` (`ID_Cita`),
  CONSTRAINT `ID_Material`
    FOREIGN KEY (`ID_Material`)
    REFERENCES `dentiapp`.`stock` (`ID_Material`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `dentiapp`.`usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dentiapp`.`usuario` (
  `ID_Usuario` INT NOT NULL AUTO_INCREMENT,
  `Nombre` VARCHAR(45) NOT NULL,
  `Contrasenya` VARCHAR(45) NOT NULL,
  `Perfil` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`ID_Usuario`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
