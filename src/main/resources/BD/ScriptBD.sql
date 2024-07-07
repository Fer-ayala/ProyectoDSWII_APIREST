create database bdescuela;
use bdescuela;

CREATE TABLE `usuario` (
  `idusuario` int NOT NULL AUTO_INCREMENT,
  `activo` bit(1) DEFAULT NULL,
  `apellidos` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `nombres` varchar(255) DEFAULT NULL,
  `nomusuario` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idusuario`)) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
  
  
  CREATE TABLE `rol` (
  `idrol` int NOT NULL AUTO_INCREMENT,
  `nomrol` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idrol`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
  
  CREATE TABLE `usuario_rol` (
  `idusuario` int NOT NULL,
  `idrol` int NOT NULL,
  PRIMARY KEY (`idusuario`,`idrol`),
  KEY `FK772rw294omyd1mwl1b8wkf0yh` (`idrol`),
  CONSTRAINT `FK772rw294omyd1mwl1b8wkf0yh` FOREIGN KEY (`idrol`) REFERENCES `rol` (`idrol`),
  CONSTRAINT `FKjfkgavcj55g94opc35x6u3jyu` FOREIGN KEY (`idusuario`) REFERENCES `usuario` (`idusuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

# Inserciones

INSERT INTO `usuario` (`idusuario`, `activo`, `apellidos`, `email`, `nombres`, `nomusuario`, `password`) VALUES
# password123
(NULL, 1, 'Pérez', 'jperez@example.com', 'Juan', 'jperez', '$2a$12$xRbHh/ivAsP0I33v8wBSwOX2pSYlQtg7szozAP1/FA1cwgDvwDqeG'),
# password456
(NULL, 0, 'García', 'mgarcia@example.com', 'María', 'mgarcia', '$2a$12$2H..ItKJBRObyMSN9Pk0O.McepsUFBQgz5WgnISSwjsz8DxpiiEXa'),
# password789
(NULL, 1, 'Rodríguez', 'arodriguez@example.com', 'Ana', 'arodriguez', '$2a$12$Q3RZqTmGBp5v/Zn0O1sGPeNXydsSZiism2Ch1NqwnrvMlLENU4O5C'),
# password012
(NULL, 0, 'López', 'clopez@example.com', 'Carlos', 'clopez', '$2a$12$1R2cDFYBnNCug1OQfvAGQetD7aOipHDewTYlzlQeiX4K0BlrWNZj6'),
# password345
(NULL, 1, 'Martínez', 'rmartinez@example.com', 'Roberto', 'rmartinez', '$2a$12$xzCpd17VlaUkNLTDFNhXze9hnjIaN.FDQSCZIMAGxRsPZw/.mVX4W');


INSERT INTO `rol` (`idrol`, `nomrol`) VALUES
(NULL, 'ADMIN'),
(NULL, 'USUARIO'),
(NULL, 'INVITADO');


INSERT INTO `usuario_rol` (`idusuario`, `idrol`) VALUES
(1, 1), -- Juan Pérez es Administrador
(2, 2), -- María García es Usuario
(3, 3), -- Ana Rodríguez es Invitado
(4, 2), -- Carlos López es Usuario
(5, 1); -- Roberto Martínez es Administrador


select * from usuario;
select * from rol;
select * from usuario_rol;





