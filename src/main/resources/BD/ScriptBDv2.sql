drop database bdprueba;

create database BDPrueba;
use bdprueba;

CREATE TABLE `cliente` (
  `idcliente` int NOT NULL AUTO_INCREMENT,
  `telefono` varchar(9) DEFAULT NULL,
  `correoelectronico` varchar(40) DEFAULT NULL,
  `apellido` varchar(50) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `direccion` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`idcliente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `libro` (
  `id` int NOT NULL AUTO_INCREMENT,
  `fechapublicacion` datetime(6) NOT NULL,
  `genero` varchar(30) NOT NULL,
  `autor` varchar(80) NOT NULL,
  `titulo` varchar(80) NOT NULL,
  `editorial` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `rol` (
  `idrol` int NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(255) DEFAULT NULL,
  `nomrol` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idrol`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `compra` (
  `idcliente` int DEFAULT NULL,
  `idcompra` int NOT NULL AUTO_INCREMENT,
  `montocompra` double DEFAULT NULL,
  `fecha` datetime(6) NOT NULL,
  PRIMARY KEY (`idcompra`),
  KEY `FKhakjb4v6avpttofgur1gl8qx3` (`idcliente`),
  CONSTRAINT `FKhakjb4v6avpttofgur1gl8qx3` FOREIGN KEY (`idcliente`) REFERENCES `cliente` (`idcliente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `detallecompra` (
  `cantidad` int NOT NULL,
  `id` int NOT NULL AUTO_INCREMENT,
  `idcompra` int DEFAULT NULL,
  `idlibro` int DEFAULT NULL,
  `preciounitario` double DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK3ksdgmiirs3seinqvljuy9ljl` (`idcompra`),
  KEY `FKaw1tdod598p5emqomtixy9uyr` (`idlibro`),
  CONSTRAINT `FK3ksdgmiirs3seinqvljuy9ljl` FOREIGN KEY (`idcompra`) REFERENCES `compra` (`idcompra`),
  CONSTRAINT `FKaw1tdod598p5emqomtixy9uyr` FOREIGN KEY (`idlibro`) REFERENCES `libro` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `empleado` (
  `idempleado` int NOT NULL AUTO_INCREMENT,
  `idrol` int DEFAULT NULL,
  `fechacontratacion` datetime(6) NOT NULL,
  `telefono` varchar(9) DEFAULT NULL,
  `email` varchar(40) DEFAULT NULL,
  `apellidos` varchar(50) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `direccion` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`idempleado`),
  KEY `FKnljsci9hpxci9db741qsgi2v6` (`idrol`),
  CONSTRAINT `FKnljsci9hpxci9db741qsgi2v6` FOREIGN KEY (`idrol`) REFERENCES `rol` (`idrol`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `inventario` (
  `cantidadstock` int NOT NULL,
  `id` int NOT NULL AUTO_INCREMENT,
  `idlibro` int DEFAULT NULL,
  `fechaultimaactualizacion` datetime(6) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK2rckc2eb8fa999jkcpwqde3ow` (`idlibro`),
  CONSTRAINT `FK2rckc2eb8fa999jkcpwqde3ow` FOREIGN KEY (`idlibro`) REFERENCES `libro` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `usuario` (
  `activo` bit(1) DEFAULT NULL,
  `idempleado` int DEFAULT NULL,
  `idusuario` int NOT NULL AUTO_INCREMENT,
  `apellidos` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `nombres` varchar(255) DEFAULT NULL,
  `nomusuario` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idusuario`),
  UNIQUE KEY `UK768w9b1roo5d8q5ajdbx2wf2g` (`idempleado`),
  CONSTRAINT `FK813qig86lht8b9pxmxi416a3r` FOREIGN KEY (`idempleado`) REFERENCES `empleado` (`idempleado`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-----------------------------------

-- Inserciones para la tabla 'rol'
INSERT INTO `rol` (`descripcion`, `nomrol`) VALUES ('Administrador del sistema', 'ADMIN');
INSERT INTO `rol` (`descripcion`, `nomrol`) VALUES ('Cliente', 'CLIENTE');

-- Inserciones para la tabla 'empleado'
INSERT INTO `empleado` (`idrol`, `fechacontratacion`, `telefono`, `email`, `apellidos`, `nombre`, `direccion`)
VALUES (1, '2020-01-15 08:00:00', '123456789', 'admin@empresa.com', 'García', 'Juan', 'Calle Falsa 123');
INSERT INTO `empleado` (`idrol`, `fechacontratacion`, `telefono`, `email`, `apellidos`, `nombre`, `direccion`)
VALUES (2, '2021-06-10 09:00:00', '987654321', 'cajero@empresa.com', 'López', 'Ana', 'Avenida Siempre Viva 456');

-- Inserciones para la tabla 'usuario'
INSERT INTO `usuario` (`activo`, `idempleado`, `apellidos`, `email`, `nombres`, `nomusuario`, `password`)
VALUES (1, 1, 'García', 'admin@empresa.com', 'Juan', 'juan', '$2a$12$aVTVfi9osx8YXjizp8haJOxANxVj.I7ZXTszh58m/lBYO2hUPSNiu');
INSERT INTO `usuario` (`activo`, `idempleado`, `apellidos`, `email`, `nombres`, `nomusuario`, `password`)
VALUES (1, 2, 'López', 'cajero@empresa.com', 'Ana', 'ana', '$2a$12$YyIW0iUvzzRRKbD1vFVEauEZ5uMcu0zYiDH/tLWhI1R05Aie1uyi.');

-- Inserciones para la tabla 'libro'
INSERT INTO `libro` (`fechapublicacion`, `genero`, `autor`, `titulo`, `editorial`)
VALUES ('2023-01-01 00:00:00', 'Ficción', 'Autor 1', 'Título 1', 'Editorial 1');
INSERT INTO `libro` (`fechapublicacion`, `genero`, `autor`, `titulo`, `editorial`)
VALUES ('2022-02-01 00:00:00', 'Fantasía', 'Autor 2', 'Título 2', 'Editorial 2');
INSERT INTO `libro` (`fechapublicacion`, `genero`, `autor`, `titulo`, `editorial`)
VALUES ('2021-03-01 00:00:00', 'Ciencia Ficción', 'Autor 3', 'Título 3', 'Editorial 3');
INSERT INTO `libro` (`fechapublicacion`, `genero`, `autor`, `titulo`, `editorial`)
VALUES ('2020-04-01 00:00:00', 'Romance', 'Autor 4', 'Título 4', 'Editorial 4');
INSERT INTO `libro` (`fechapublicacion`, `genero`, `autor`, `titulo`, `editorial`)
VALUES ('2019-05-01 00:00:00', 'Terror', 'Autor 5', 'Título 5', 'Editorial 5');
INSERT INTO `libro` (`fechapublicacion`, `genero`, `autor`, `titulo`, `editorial`)
VALUES ('2018-06-01 00:00:00', 'Suspense', 'Autor 6', 'Título 6', 'Editorial 6');
INSERT INTO `libro` (`fechapublicacion`, `genero`, `autor`, `titulo`, `editorial`)
VALUES ('2017-07-01 00:00:00', 'Aventura', 'Autor 7', 'Título 7', 'Editorial 7');
INSERT INTO `libro` (`fechapublicacion`, `genero`, `autor`, `titulo`, `editorial`)
VALUES ('2016-08-01 00:00:00', 'Biografía', 'Autor 8', 'Título 8', 'Editorial 8');
INSERT INTO `libro` (`fechapublicacion`, `genero`, `autor`, `titulo`, `editorial`)
VALUES ('2015-09-01 00:00:00', 'Historia', 'Autor 9', 'Título 9', 'Editorial 9');
INSERT INTO `libro` (`fechapublicacion`, `genero`, `autor`, `titulo`, `editorial`)
VALUES ('2014-10-01 00:00:00', 'Política', 'Autor 10', 'Título 10', 'Editorial 10');

-- Inserciones para la tabla 'inventario'
INSERT INTO `inventario` (`cantidadstock`, `idlibro`, `fechaultimaactualizacion`)
VALUES (10, 1, '2024-07-01 00:00:00');
INSERT INTO `inventario` (`cantidadstock`, `idlibro`, `fechaultimaactualizacion`)
VALUES (15, 2, '2024-07-01 00:00:00');
INSERT INTO `inventario` (`cantidadstock`, `idlibro`, `fechaultimaactualizacion`)
VALUES (5, 3, '2024-07-01 00:00:00');
INSERT INTO `inventario` (`cantidadstock`, `idlibro`, `fechaultimaactualizacion`)
VALUES (8, 4, '2024-07-01 00:00:00');
INSERT INTO `inventario` (`cantidadstock`, `idlibro`, `fechaultimaactualizacion`)
VALUES (12, 5, '2024-07-01 00:00:00');

-- Inserciones para la tabla 'cliente'
INSERT INTO `cliente` (`telefono`, `correoelectronico`, `apellido`, `nombre`, `direccion`)
VALUES ('123456789', 'cliente1@correo.com', 'Pérez', 'Carlos', 'Calle 1');
INSERT INTO `cliente` (`telefono`, `correoelectronico`, `apellido`, `nombre`, `direccion`)
VALUES ('987654321', 'cliente2@correo.com', 'Martínez', 'María', 'Calle 2');
INSERT INTO `cliente` (`telefono`, `correoelectronico`, `apellido`, `nombre`, `direccion`)
VALUES ('555666777', 'cliente3@correo.com', 'López', 'Pedro', 'Calle 3');
INSERT INTO `cliente` (`telefono`, `correoelectronico`, `apellido`, `nombre`, `direccion`)
VALUES ('444555666', 'cliente4@correo.com', 'Gómez', 'Ana', 'Calle 4');
INSERT INTO `cliente` (`telefono`, `correoelectronico`, `apellido`, `nombre`, `direccion`)
VALUES ('333444555', 'cliente5@correo.com', 'Ramírez', 'Jorge', 'Calle 5');

-- Inserciones para la tabla 'compra'
INSERT INTO `compra` (`idcliente`, `montocompra`, `fecha`)
VALUES (1, 100.50, '2024-06-01 10:00:00');
INSERT INTO `compra` (`idcliente`, `montocompra`, `fecha`)
VALUES (2, 150.75, '2024-06-02 11:00:00');
INSERT INTO `compra` (`idcliente`, `montocompra`, `fecha`)
VALUES (3, 200.00, '2024-06-03 12:00:00');
INSERT INTO `compra` (`idcliente`, `montocompra`, `fecha`)
VALUES (4, 250.25, '2024-06-04 13:00:00');
INSERT INTO `compra` (`idcliente`, `montocompra`, `fecha`)
VALUES (5, 300.50, '2024-06-05 14:00:00');
INSERT INTO `compra` (`idcliente`, `montocompra`, `fecha`)
VALUES (1, 120.75, '2024-06-06 15:00:00');
INSERT INTO `compra` (`idcliente`, `montocompra`, `fecha`)
VALUES (2, 130.80, '2024-06-07 16:00:00');
INSERT INTO `compra` (`idcliente`, `montocompra`, `fecha`)
VALUES (3, 140.85, '2024-06-08 17:00:00');
INSERT INTO `compra` (`idcliente`, `montocompra`, `fecha`)
VALUES (4, 160.90, '2024-06-09 18:00:00');
INSERT INTO `compra` (`idcliente`, `montocompra`, `fecha`)
VALUES (5, 170.95, '2024-06-10 19:00:00');

-- Inserciones para la tabla 'detallecompra'
INSERT INTO `detallecompra` (`cantidad`, `idcompra`, `idlibro`, `preciounitario`)
VALUES (2, 1, 1, 10.50);
INSERT INTO `detallecompra` (`cantidad`, `idcompra`, `idlibro`, `preciounitario`)
VALUES (1, 2, 2, 15.75);
INSERT INTO `detallecompra` (`cantidad`, `idcompra`, `idlibro`, `preciounitario`)
VALUES (3, 3, 3, 20.00);
INSERT INTO `detallecompra` (`cantidad`, `idcompra`, `idlibro`, `preciounitario`)
VALUES (1, 4, 4, 25.25);
INSERT INTO `detallecompra` (`cantidad`, `idcompra`, `idlibro`, `preciounitario`)
VALUES (2, 5, 5, 30.50);
INSERT INTO `detallecompra` (`cantidad`, `idcompra`, `idlibro`, `preciounitario`)
VALUES (1, 6, 6, 12.75);
INSERT INTO `detallecompra` (`cantidad`, `idcompra`, `idlibro`, `preciounitario`)
VALUES (3, 7, 7, 13.80);
INSERT INTO `detallecompra` (`cantidad`, `idcompra`, `idlibro`, `preciounitario`)
VALUES (2, 8, 8, 14.85);
INSERT INTO `detallecompra` (`cantidad`, `idcompra`, `idlibro`, `preciounitario`)
VALUES (1, 9, 9, 16.90);
INSERT INTO `detallecompra` (`cantidad`, `idcompra`, `idlibro`, `preciounitario`)
VALUES (2, 10, 10, 17.95);

select * from usuario;

# contraseña = 123, nomusuario = admin
update usuario
set `nomusuario` = 'juan'
where nombres='Juan';

# contraseña = 456
update usuario
set `nomusuario` = 'ana'
where nombres='Ana';



