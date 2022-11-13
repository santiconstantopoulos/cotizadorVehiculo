CREATE DATABASE `cotizador`;

USE cotizador;

CREATE TABLE `vehiculo` (
  `idVehiculo` int(11) NOT NULL AUTO_INCREMENT,
  `tipoVehiculo` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idVehiculo`),
  UNIQUE KEY `idVehiculo_UNIQUE` (`idVehiculo`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

CREATE TABLE `cotizacion` (
  `idCotizacion` int unsigned NOT NULL AUTO_INCREMENT,
  `idTipoVehiculo` int NOT NULL,
  `cantidadDias` int unsigned NOT NULL,
  `precioCotizacion` float NOT NULL,
  `Fecha_Creacion` date DEFAULT NULL,
  PRIMARY KEY (`idCotizacion`,`idTipoVehiculo`),
  KEY `fk_Cotizacion_Vehiculo_idx` (`idTipoVehiculo`),
  CONSTRAINT `fk_Cotizacion_Vehiculo` FOREIGN KEY (`idTipoVehiculo`) REFERENCES `vehiculo` (`idVehiculo`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb3;

INSERT INTO `vehiculo` (`idVehiculo`,`tipoVehiculo`) VALUES (1,'Automovil');
INSERT INTO `vehiculo` (`idVehiculo`,`tipoVehiculo`) VALUES (2,'Minibus');
INSERT INTO `vehiculo` (`idVehiculo`,`tipoVehiculo`) VALUES (3,'Camion');
INSERT INTO `vehiculo` (`idVehiculo`,`tipoVehiculo`) VALUES (4,'Furgoneta');
