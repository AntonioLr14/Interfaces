
DROP TABLE IF EXISTS `citas`;

CREATE TABLE `citas` (
  `ID_Cita` int NOT NULL AUTO_INCREMENT,
  `ID_Paciente` varchar(45) NOT NULL,
  `ID_Doctor` varchar(45) NOT NULL,
  `ID_Tratamiento` int NOT NULL,
  `Fecha_Hora` varchar(45) NOT NULL,
  `Motivo_visita` varchar(45) NOT NULL,
  PRIMARY KEY (`ID_Cita`),
  KEY `ID_Paciente_idx` (`ID_Paciente`),
  KEY `ID_Doctor_idx` (`ID_Doctor`),
  KEY `ID_Tratamiento_idx` (`ID_Tratamiento`),
  CONSTRAINT `ID_Doctor` FOREIGN KEY (`ID_Doctor`) REFERENCES `doctores` (`DNI`),
  CONSTRAINT `ID_Paciente` FOREIGN KEY (`ID_Paciente`) REFERENCES `paciente` (`DNI`),
  CONSTRAINT `ID_Tratamiento` FOREIGN KEY (`ID_Tratamiento`) REFERENCES `tratamiento` (`ID_Tratamiento`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

LOCK TABLES `citas` WRITE;

INSERT INTO `citas` VALUES (1,'23456789B','12345678A',0,'20-11-2023 10:00','Dolor en la mandibula');

UNLOCK TABLES;

DROP TABLE IF EXISTS `doctores`;

CREATE TABLE `doctores` (
  `DNI` varchar(25) NOT NULL,
  `ID_Especialidad` int NOT NULL,
  `Direccion` varchar(45) DEFAULT NULL,
  `Fecha_Nacimiento` varchar(45) DEFAULT NULL,
  `Salario` double NOT NULL,
  `Correo` varchar(45) NOT NULL,
  PRIMARY KEY (`DNI`),
  KEY `ID_Especialidad_idx` (`ID_Especialidad`),
  CONSTRAINT `ID_Especialidad` FOREIGN KEY (`ID_Especialidad`) REFERENCES `especialidad` (`ID_Especialidad`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

LOCK TABLES `doctores` WRITE;

INSERT INTO `doctores` VALUES ('12345678A',0,NULL,NULL,1000,'Prueba@DENTILAX.com');

UNLOCK TABLES;

DROP TABLE IF EXISTS `especialidad`;

CREATE TABLE `especialidad` (
  `ID_Especialidad` int NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(45) NOT NULL,
  `Descripcion` varchar(45) NOT NULL,
  PRIMARY KEY (`ID_Especialidad`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

LOCK TABLES `especialidad` WRITE;

INSERT INTO `especialidad` VALUES (0,'Especialidad general','Especialista generico'),(1,'Dentista general','Observacion general'),(2,'Odontopediatra','Dentista pediatrico'),(3,'Ortodoncista','Especialista en ortodoncia'),(4,'Periodoncista','Especialista en encias'),(5,'Endodoncista','Especialista en tratamientos de conducto'),(6,'Patologo oral','Cirujano oral'),(7,'Prostodoncista','Especialista en protesis');

UNLOCK TABLES;

DROP TABLE IF EXISTS `paciente`;

CREATE TABLE `paciente` (
  `DNI` varchar(25) NOT NULL,
  `Correo` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`DNI`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

LOCK TABLES `paciente` WRITE;

INSERT INTO `paciente` VALUES ('23456789B','Prueba1@DENTILAX.com');

UNLOCK TABLES;

DROP TABLE IF EXISTS `pagar`;

CREATE TABLE `pagar` (
  `ID_Pago` int NOT NULL AUTO_INCREMENT,
  `DNI_Paciente` varchar(45) NOT NULL,
  `Cantidad_Pagada` double NOT NULL,
  `Tipo_Pago` varchar(45) NOT NULL,
  `Duracion_pago` varchar(45) NOT NULL,
  `Cantidad_Total_Pagar` double NOT NULL,
  PRIMARY KEY (`ID_Pago`),
  KEY `DNI_Paciente` (`DNI_Paciente`),
  CONSTRAINT `DNI_Paciente` FOREIGN KEY (`DNI_Paciente`) REFERENCES `paciente` (`DNI`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

LOCK TABLES `pagar` WRITE;

UNLOCK TABLES;

DROP TABLE IF EXISTS `pedidos`;

CREATE TABLE `pedidos` (
  `ID_Pedido` int NOT NULL AUTO_INCREMENT,
  `Cantidad` int NOT NULL,
  `Precio_Pedido` double NOT NULL,
  `Fecha` date NOT NULL,
  PRIMARY KEY (`ID_Pedido`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

LOCK TABLES `pedidos` WRITE;

UNLOCK TABLES;

DROP TABLE IF EXISTS `proveedor`;

CREATE TABLE `proveedor` (
  `ID_Proveedor` int NOT NULL AUTO_INCREMENT,
  `Direccion` varchar(45) DEFAULT NULL,
  `Correo` varchar(45) NOT NULL,
  PRIMARY KEY (`ID_Proveedor`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

LOCK TABLES `proveedor` WRITE;

INSERT INTO `proveedor` VALUES (3,NULL,'Prueba2@DENTILAX.com');

UNLOCK TABLES;

DROP TABLE IF EXISTS `solicitudes`;

CREATE TABLE `solicitudes` (
  `ID_Solicitud` int NOT NULL,
  `ID_Cita` int NOT NULL,
  `ID_Material` int NOT NULL,
  `Cantidad` int NOT NULL,
  PRIMARY KEY (`ID_Solicitud`),
  KEY `ID_Citas` (`ID_Cita`),
  KEY `ID_Material_idx` (`ID_Material`),
  CONSTRAINT `ID_Citas` FOREIGN KEY (`ID_Cita`) REFERENCES `citas` (`ID_Cita`),
  CONSTRAINT `ID_Material` FOREIGN KEY (`ID_Material`) REFERENCES `stock` (`ID_Material`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

LOCK TABLES `solicitudes` WRITE;

UNLOCK TABLES;

DROP TABLE IF EXISTS `stock`;

CREATE TABLE `stock` (
  `ID_Material` int NOT NULL AUTO_INCREMENT,
  `ID_Proveedor` int NOT NULL,
  `ID_Pedido` int NOT NULL,
  `Nombre` varchar(45) NOT NULL,
  `Cantidad` int NOT NULL,
  `Precio` double NOT NULL,
  `Observaciones` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ID_Material`),
  KEY `ID_Proveedor_idx` (`ID_Proveedor`),
  KEY `ID_Pedido_idx` (`ID_Pedido`),
  CONSTRAINT `ID_Pedido` FOREIGN KEY (`ID_Pedido`) REFERENCES `pedidos` (`ID_Pedido`),
  CONSTRAINT `ID_Proveedor` FOREIGN KEY (`ID_Proveedor`) REFERENCES `proveedor` (`ID_Proveedor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

LOCK TABLES `stock` WRITE;

UNLOCK TABLES;

DROP TABLE IF EXISTS `tratamiento`;

CREATE TABLE `tratamiento` (
  `ID_Tratamiento` int NOT NULL,
  `Nombre` varchar(45) NOT NULL,
  `Precio` double NOT NULL,
  PRIMARY KEY (`ID_Tratamiento`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

LOCK TABLES `tratamiento` WRITE;

INSERT INTO `tratamiento` VALUES (0,'Tratamiento general',0);

UNLOCK TABLES;

DROP TABLE IF EXISTS `usuario`;

CREATE TABLE `usuario` (
  `ID_Usuario` int NOT NULL AUTO_INCREMENT,
  `DNI_Usuario` varchar(45) NOT NULL,
  `Contrasenya` varchar(255) NOT NULL,
  `Nombre` varchar(45) NOT NULL,
  `Apellidos` varchar(45) NOT NULL,
  `Telefono` int NOT NULL,
  `Perfil` varchar(45) NOT NULL,
  `Estado` tinyint(1) NOT NULL,
  PRIMARY KEY (`ID_Usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=1124 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

LOCK TABLES `usuario` WRITE;

INSERT INTO `usuario` VALUES (1111,'1111A','D760688DA522B4DC3350E6FB68961B934F911C7D0FF337438CABF468789BA94CE7B661D7E08A279EF088716C4B1913B984513FEA4C557D404D598D4F2F1','Administrador','DENTILAX',123456789,'admin',1),(1112,'1111B','D760688DA522B4DC3350E6FB68961B934F911C7D0FF337438CABF468789BA94CE7B661D7E08A279EF088716C4B1913B984513FEA4C557D404D598D4F2F1','Medico','Prueba',234567890,'doctores',1),(1116,'23456789B','34804B9337EB52AC03F50A93A5542F833D3C9EB9DB30DF1AE065E8182D1FFCA7E93B3AD1EFE172A1DF9BF925B7C911161F79CCE566BBC6ABD8F253B16','Prueba1','Prueba2',234567890,'paciente',1),(1121,'12345678A','5CBC8B0D3336AA5FF896A1FEEAA1C21433A36B942E6CDD6F23269EB7967DB2C070FB20AD3065A6BCA8C21FC762B962D95EAA20AFEFCF1F76CA0DCDE2','Prueba','Prueba1',123456789,'doctores',1),(1122,'34567890C','77C8B682FF97B6B6462F14933BFEDE25F3AA6F2987B35F4368B0C8D565202F75675E77B75EBBEA40A67BF06774436C68DF1E85B147787E909C3CF878F0','Prueba2','Prueba3',345678901,'proveedor',1);

UNLOCK TABLES;
