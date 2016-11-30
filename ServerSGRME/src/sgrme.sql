-- phpMyAdmin SQL Dump
-- version 4.5.2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Nov 15, 2016 at 10:29 
-- Server version: 10.1.13-MariaDB
-- PHP Version: 7.0.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `sgrme`
--

-- --------------------------------------------------------

--
-- Table structure for table `aeropuerto`
--

CREATE TABLE `aeropuerto` (
  `idaeropuerto` int(11) UNSIGNED NOT NULL,
  `codigo` varchar(20) COLLATE utf8_bin NOT NULL,
  `capacidad` int(8) NOT NULL,
  `nropaquetes` int(8) NOT NULL,
  `nroaviones` int(8) NOT NULL,
  `longitud` double DEFAULT '-98789.98789',
  `latitud` double DEFAULT '-98789.98789',
  `idlugar` int(11) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Table structure for table `almacenavion`
--

CREATE TABLE `almacenavion` (
  `idalmacenavion` int(11) UNSIGNED NOT NULL,
  `idavion` int(11) UNSIGNED NOT NULL,
  `idpaquete` int(11) UNSIGNED NOT NULL,
  `fecha` datetime NOT NULL,
  `idestado` int(11) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Table structure for table `avion`
--

CREATE TABLE `avion` (
  `idavion` int(11) UNSIGNED NOT NULL,
  `codigo` varchar(30) COLLATE utf8_bin NOT NULL,
  `capacidad` int(8) NOT NULL,
  `nropaquetes` int(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Table structure for table `cargo`
--

CREATE TABLE `cargo` (
  `idcargo` int(11) UNSIGNED NOT NULL,
  `nombre` varchar(40) COLLATE utf8_bin NOT NULL,
  `descripcion` varchar(150) COLLATE utf8_bin DEFAULT 'no se registro.'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dumping data for table `cargo`
--

INSERT INTO `cargo` (`idcargo`, `nombre`, `descripcion`) VALUES
(2, 'Soporte Tecnico', 'no se registro.'),
(3, 'Operario', 'no se registro.');

-- --------------------------------------------------------

--
-- Table structure for table `cliente`
--

CREATE TABLE `cliente` (
  `idcliente` int(11) UNSIGNED NOT NULL,
  `idpersona` int(11) UNSIGNED NOT NULL,
  `codigo` varchar(30) COLLATE utf8_bin NOT NULL,
  `fechadereg` datetime DEFAULT CURRENT_TIMESTAMP,
  `idusuario` int(11) UNSIGNED NOT NULL,
  `idestado` int(11) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Table structure for table `empleado`
--

CREATE TABLE `empleado` (
  `idempleado` int(11) UNSIGNED NOT NULL,
  `idpersona` int(11) UNSIGNED NOT NULL,
  `codigo` varchar(30) COLLATE utf8_bin NOT NULL,
  `fechadereg` datetime DEFAULT CURRENT_TIMESTAMP,
  `idusuario` int(11) UNSIGNED NOT NULL,
  `idcargo` int(11) UNSIGNED NOT NULL,
  `idestado` int(11) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Table structure for table `estado`
--

CREATE TABLE `estado` (
  `idestado` int(11) UNSIGNED NOT NULL,
  `nombre` varchar(40) COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dumping data for table `estado`
--

INSERT INTO `estado` (`idestado`, `nombre`) VALUES
(1, 'inactivo'),
(2, 'activo'),
(3, 'en camino'),
(4, 'ha arrivado');

-- --------------------------------------------------------

--
-- Table structure for table `itinerario`
--

CREATE TABLE `itinerario` (
  `iditinerario` int(11) UNSIGNED NOT NULL,
  `idpaquete` int(11) UNSIGNED NOT NULL,
  `idplan` int(11) UNSIGNED NOT NULL,
  `fecha` datetime NOT NULL,
  `nrocalculo` int(6) NOT NULL,
  `idestado` int(11) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Table structure for table `lugar`
--

CREATE TABLE `lugar` (
  `idlugar` int(11) UNSIGNED NOT NULL,
  `continente` varchar(100) COLLATE utf8_bin NOT NULL,
  `pais` varchar(100) COLLATE utf8_bin NOT NULL,
  `ciudad` varchar(200) COLLATE utf8_bin NOT NULL,
  `gmt` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Table structure for table `movimientoalmacen`
--

CREATE TABLE `movimientoalmacen` (
  `idmovimientoalmacen` int(11) UNSIGNED NOT NULL,
  `idpaquete` int(11) UNSIGNED NOT NULL,
  `idaeropuerto` int(11) UNSIGNED NOT NULL,
  `fecha` datetime NOT NULL,
  `idestado` int(11) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Table structure for table `movimientoavion`
--

CREATE TABLE `movimientoavion` (
  `idmovimientoavion` int(11) UNSIGNED NOT NULL,
  `idavion` int(11) UNSIGNED NOT NULL,
  `idaeropuerto` int(11) UNSIGNED NOT NULL,
  `fecha` datetime NOT NULL,
  `idestado` int(11) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Table structure for table `paquete`
--

CREATE TABLE `paquete` (
  `idpaquete` int(11) UNSIGNED NOT NULL,
  `codigounico` varchar(30) COLLATE utf8_bin NOT NULL,
  `descripcion` varchar(150) COLLATE utf8_bin NOT NULL,
  `idorigen` int(11) UNSIGNED NOT NULL,
  `iddestino` int(11) UNSIGNED NOT NULL,
  `fechainicio` datetime NOT NULL,
  `fechafin` datetime DEFAULT CURRENT_TIMESTAMP,
  `tiempomaximo` int(6) NOT NULL,
  `idcliente` int(11) UNSIGNED NOT NULL,
  `idpersona` int(11) UNSIGNED NOT NULL,
  `tiempoestimado` int(6) NOT NULL,
  `idestado` int(11) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Table structure for table `perfil`
--

CREATE TABLE `perfil` (
  `idperfil` int(11) UNSIGNED NOT NULL,
  `nombre` varchar(30) COLLATE utf8_bin NOT NULL,
  `descripcion` varchar(200) COLLATE utf8_bin DEFAULT 'No se registro descripcion.',
  `nivelacceso` int(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dumping data for table `perfil`
--

INSERT INTO `perfil` (`idperfil`, `nombre`, `descripcion`, `nivelacceso`) VALUES
(1, 'administrador general', 'No se registro descripcion.', 1),
(2, 'empleado', 'No se registro descripcion.', 2),
(3, 'cliente', 'No se registro descripcion.', 3);

-- --------------------------------------------------------

--
-- Table structure for table `persona`
--

CREATE TABLE `persona` (
  `idpersona` int(11) UNSIGNED NOT NULL,
  `documento` varchar(20) COLLATE utf8_bin NOT NULL COMMENT 'El documento puede ser dni o extranjero.',
  `apellidopat` varchar(60) COLLATE utf8_bin NOT NULL,
  `apellidomat` varchar(60) COLLATE utf8_bin NOT NULL,
  `nombres` varchar(120) COLLATE utf8_bin NOT NULL,
  `celular` varchar(35) COLLATE utf8_bin DEFAULT 'No se registro.',
  `correo` varchar(250) COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dumping data for table `persona`
--

INSERT INTO `persona` (`idpersona`, `documento`, `apellidopat`, `apellidomat`, `nombres`, `celular`, `correo`) VALUES
(3, '74653214', 'Macarron', 'Frances', 'Aureliano Antonio', '954332347', 'administrador@mail.com'),
(4, '96321485', 'Pamplina', 'Honga', 'Marta', 'No se registro.', 'empleado@mail.com'),
(5, '48659819', 'Palacios', 'Castillos', 'Platero', 'No se registro.', 'cliente@mail.com');

-- --------------------------------------------------------

--
-- Table structure for table `plandevuelo`
--

CREATE TABLE `plandevuelo` (
  `idplan` int(11) UNSIGNED NOT NULL,
  `horainicio` time NOT NULL,
  `horafin` time NOT NULL,
  `capacidad` int(11) NOT NULL,
  `nropaquetes` int(11) NOT NULL,
  `capaviones` int(4) NOT NULL,
  `idaeropuertoinicio` int(11) UNSIGNED NOT NULL,
  `idaeropuertofin` int(11) UNSIGNED NOT NULL,
  `distancia` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Table structure for table `usuario`
--

CREATE TABLE `usuario` (
  `idusuario` int(11) UNSIGNED NOT NULL,
  `usuario` varchar(60) COLLATE utf8_bin NOT NULL,
  `correo` varchar(250) COLLATE utf8_bin NOT NULL,
  `contrasenha` varchar(255) COLLATE utf8_bin NOT NULL,
  `idperfil` int(11) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dumping data for table `usuario`
--

INSERT INTO `usuario` (`idusuario`, `usuario`, `correo`, `contrasenha`, `idperfil`) VALUES
(2, 'sgrmeadmin', 'administrador@mail.com', 'admin123', 1),
(3, 'pamplina', 'empleado@mail.com', 'empleado123', 2),
(4, 'platero', 'cliente@mail.com', 'cliente123', 3);

-- --------------------------------------------------------

--
-- Table structure for table `vuelo`
--

CREATE TABLE `vuelo` (
  `idvuelo` int(11) UNSIGNED NOT NULL,
  `idavion` int(11) UNSIGNED NOT NULL,
  `idplan` int(11) UNSIGNED NOT NULL,
  `fecha` date NOT NULL,
  `tiempovuelo` int(6) NOT NULL,
  `idestado` int(11) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `aeropuerto`
--
ALTER TABLE `aeropuerto`
  ADD PRIMARY KEY (`idaeropuerto`),
  ADD UNIQUE KEY `codigo` (`codigo`),
  ADD KEY `idlugar` (`idlugar`);

--
-- Indexes for table `almacenavion`
--
ALTER TABLE `almacenavion`
  ADD PRIMARY KEY (`idalmacenavion`),
  ADD KEY `idavion` (`idavion`),
  ADD KEY `idpaquete` (`idpaquete`),
  ADD KEY `idestado` (`idestado`);

--
-- Indexes for table `avion`
--
ALTER TABLE `avion`
  ADD PRIMARY KEY (`idavion`),
  ADD UNIQUE KEY `codigo` (`codigo`);

--
-- Indexes for table `cargo`
--
ALTER TABLE `cargo`
  ADD PRIMARY KEY (`idcargo`);

--
-- Indexes for table `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`idcliente`),
  ADD UNIQUE KEY `idpersona_2` (`idpersona`),
  ADD UNIQUE KEY `idusuario_2` (`idusuario`),
  ADD UNIQUE KEY `codigo` (`codigo`),
  ADD KEY `idpersona` (`idpersona`),
  ADD KEY `idusuario` (`idusuario`),
  ADD KEY `idestado` (`idestado`);

--
-- Indexes for table `empleado`
--
ALTER TABLE `empleado`
  ADD PRIMARY KEY (`idempleado`),
  ADD UNIQUE KEY `idpersona_2` (`idpersona`),
  ADD UNIQUE KEY `idusuario_2` (`idusuario`),
  ADD UNIQUE KEY `codigo` (`codigo`),
  ADD KEY `idpersona` (`idpersona`),
  ADD KEY `idusuario` (`idusuario`),
  ADD KEY `idcargo` (`idcargo`),
  ADD KEY `idestado` (`idestado`);

--
-- Indexes for table `estado`
--
ALTER TABLE `estado`
  ADD PRIMARY KEY (`idestado`);

--
-- Indexes for table `itinerario`
--
ALTER TABLE `itinerario`
  ADD PRIMARY KEY (`iditinerario`,`idpaquete`,`idplan`),
  ADD KEY `idestado` (`idestado`),
  ADD KEY `idpaquete` (`idpaquete`),
  ADD KEY `idplan` (`idplan`);

--
-- Indexes for table `lugar`
--
ALTER TABLE `lugar`
  ADD PRIMARY KEY (`idlugar`);

--
-- Indexes for table `movimientoalmacen`
--
ALTER TABLE `movimientoalmacen`
  ADD PRIMARY KEY (`idmovimientoalmacen`),
  ADD KEY `idpaquete` (`idpaquete`),
  ADD KEY `idaeropuerto` (`idaeropuerto`),
  ADD KEY `idestado` (`idestado`);

--
-- Indexes for table `movimientoavion`
--
ALTER TABLE `movimientoavion`
  ADD PRIMARY KEY (`idmovimientoavion`),
  ADD KEY `idavion` (`idavion`),
  ADD KEY `idaeropuerto` (`idaeropuerto`),
  ADD KEY `idestado` (`idestado`);

--
-- Indexes for table `paquete`
--
ALTER TABLE `paquete`
  ADD PRIMARY KEY (`idpaquete`),
  ADD UNIQUE KEY `codigounico` (`codigounico`),
  ADD KEY `idorigen` (`idorigen`),
  ADD KEY `iddestino` (`iddestino`),
  ADD KEY `idcliente` (`idcliente`),
  ADD KEY `idpersona` (`idpersona`),
  ADD KEY `idestado` (`idestado`);

--
-- Indexes for table `perfil`
--
ALTER TABLE `perfil`
  ADD PRIMARY KEY (`idperfil`);

--
-- Indexes for table `persona`
--
ALTER TABLE `persona`
  ADD PRIMARY KEY (`idpersona`);

--
-- Indexes for table `plandevuelo`
--
ALTER TABLE `plandevuelo`
  ADD PRIMARY KEY (`idplan`),
  ADD KEY `idaeropuertoinicio` (`idaeropuertoinicio`),
  ADD KEY `idaeropuertofin` (`idaeropuertofin`);

--
-- Indexes for table `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`idusuario`),
  ADD UNIQUE KEY `usuario` (`usuario`),
  ADD UNIQUE KEY `correo` (`correo`),
  ADD KEY `idperfil` (`idperfil`);

--
-- Indexes for table `vuelo`
--
ALTER TABLE `vuelo`
  ADD PRIMARY KEY (`idvuelo`),
  ADD KEY `idavion` (`idavion`),
  ADD KEY `idplan` (`idplan`),
  ADD KEY `idestado` (`idestado`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `aeropuerto`
--
ALTER TABLE `aeropuerto`
  MODIFY `idaeropuerto` int(11) UNSIGNED NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `almacenavion`
--
ALTER TABLE `almacenavion`
  MODIFY `idalmacenavion` int(11) UNSIGNED NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `avion`
--
ALTER TABLE `avion`
  MODIFY `idavion` int(11) UNSIGNED NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `cargo`
--
ALTER TABLE `cargo`
  MODIFY `idcargo` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `cliente`
--
ALTER TABLE `cliente`
  MODIFY `idcliente` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT for table `empleado`
--
ALTER TABLE `empleado`
  MODIFY `idempleado` int(11) UNSIGNED NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `estado`
--
ALTER TABLE `estado`
  MODIFY `idestado` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `itinerario`
--
ALTER TABLE `itinerario`
  MODIFY `iditinerario` int(11) UNSIGNED NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `lugar`
--
ALTER TABLE `lugar`
  MODIFY `idlugar` int(11) UNSIGNED NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `movimientoalmacen`
--
ALTER TABLE `movimientoalmacen`
  MODIFY `idmovimientoalmacen` int(11) UNSIGNED NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `movimientoavion`
--
ALTER TABLE `movimientoavion`
  MODIFY `idmovimientoavion` int(11) UNSIGNED NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `paquete`
--
ALTER TABLE `paquete`
  MODIFY `idpaquete` int(11) UNSIGNED NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `perfil`
--
ALTER TABLE `perfil`
  MODIFY `idperfil` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `persona`
--
ALTER TABLE `persona`
  MODIFY `idpersona` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=30;
--
-- AUTO_INCREMENT for table `plandevuelo`
--
ALTER TABLE `plandevuelo`
  MODIFY `idplan` int(11) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `usuario`
--
ALTER TABLE `usuario`
  MODIFY `idusuario` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `aeropuerto`
--
ALTER TABLE `aeropuerto`
  ADD CONSTRAINT `aeropuerto_ibfk_1` FOREIGN KEY (`idlugar`) REFERENCES `lugar` (`idlugar`) ON UPDATE CASCADE;

--
-- Constraints for table `almacenavion`
--
ALTER TABLE `almacenavion`
  ADD CONSTRAINT `almacenavion_ibfk_1` FOREIGN KEY (`idavion`) REFERENCES `avion` (`idavion`) ON UPDATE CASCADE,
  ADD CONSTRAINT `almacenavion_ibfk_2` FOREIGN KEY (`idpaquete`) REFERENCES `paquete` (`idpaquete`) ON UPDATE CASCADE,
  ADD CONSTRAINT `almacenavion_ibfk_3` FOREIGN KEY (`idestado`) REFERENCES `estado` (`idestado`) ON UPDATE CASCADE;

--
-- Constraints for table `cliente`
--
ALTER TABLE `cliente`
  ADD CONSTRAINT `cliente_ibfk_1` FOREIGN KEY (`idpersona`) REFERENCES `persona` (`idpersona`) ON UPDATE CASCADE,
  ADD CONSTRAINT `cliente_ibfk_2` FOREIGN KEY (`idusuario`) REFERENCES `usuario` (`idusuario`) ON UPDATE CASCADE,
  ADD CONSTRAINT `cliente_ibfk_3` FOREIGN KEY (`idestado`) REFERENCES `estado` (`idestado`) ON UPDATE CASCADE;

--
-- Constraints for table `empleado`
--
ALTER TABLE `empleado`
  ADD CONSTRAINT `empleado_ibfk_1` FOREIGN KEY (`idpersona`) REFERENCES `persona` (`idpersona`) ON UPDATE CASCADE,
  ADD CONSTRAINT `empleado_ibfk_2` FOREIGN KEY (`idusuario`) REFERENCES `usuario` (`idusuario`) ON UPDATE CASCADE,
  ADD CONSTRAINT `empleado_ibfk_3` FOREIGN KEY (`idcargo`) REFERENCES `cargo` (`idcargo`) ON UPDATE CASCADE,
  ADD CONSTRAINT `empleado_ibfk_4` FOREIGN KEY (`idestado`) REFERENCES `estado` (`idestado`) ON UPDATE CASCADE;

--
-- Constraints for table `itinerario`
--
ALTER TABLE `itinerario`
  ADD CONSTRAINT `itinerario_ibfk_1` FOREIGN KEY (`idpaquete`) REFERENCES `paquete` (`idpaquete`) ON UPDATE CASCADE,
  ADD CONSTRAINT `itinerario_ibfk_2` FOREIGN KEY (`idplan`) REFERENCES `plandevuelo` (`idplan`) ON UPDATE CASCADE,
  ADD CONSTRAINT `itinerario_ibfk_3` FOREIGN KEY (`idestado`) REFERENCES `estado` (`idestado`) ON UPDATE CASCADE;

--
-- Constraints for table `movimientoalmacen`
--
ALTER TABLE `movimientoalmacen`
  ADD CONSTRAINT `movimientoalmacen_ibfk_1` FOREIGN KEY (`idpaquete`) REFERENCES `paquete` (`idpaquete`) ON UPDATE CASCADE,
  ADD CONSTRAINT `movimientoalmacen_ibfk_2` FOREIGN KEY (`idaeropuerto`) REFERENCES `aeropuerto` (`idaeropuerto`) ON UPDATE CASCADE,
  ADD CONSTRAINT `movimientoalmacen_ibfk_3` FOREIGN KEY (`idestado`) REFERENCES `estado` (`idestado`) ON UPDATE CASCADE;

--
-- Constraints for table `movimientoavion`
--
ALTER TABLE `movimientoavion`
  ADD CONSTRAINT `movimientoavion_ibfk_1` FOREIGN KEY (`idavion`) REFERENCES `avion` (`idavion`) ON UPDATE CASCADE,
  ADD CONSTRAINT `movimientoavion_ibfk_2` FOREIGN KEY (`idaeropuerto`) REFERENCES `aeropuerto` (`idaeropuerto`) ON UPDATE CASCADE,
  ADD CONSTRAINT `movimientoavion_ibfk_3` FOREIGN KEY (`idestado`) REFERENCES `estado` (`idestado`) ON UPDATE CASCADE;

--
-- Constraints for table `paquete`
--
ALTER TABLE `paquete`
  ADD CONSTRAINT `paquete_ibfk_1` FOREIGN KEY (`idorigen`) REFERENCES `aeropuerto` (`idaeropuerto`) ON UPDATE CASCADE,
  ADD CONSTRAINT `paquete_ibfk_2` FOREIGN KEY (`iddestino`) REFERENCES `aeropuerto` (`idaeropuerto`) ON UPDATE CASCADE,
  ADD CONSTRAINT `paquete_ibfk_3` FOREIGN KEY (`idpersona`) REFERENCES `persona` (`idpersona`) ON UPDATE CASCADE,
  ADD CONSTRAINT `paquete_ibfk_4` FOREIGN KEY (`idestado`) REFERENCES `estado` (`idestado`) ON UPDATE CASCADE,
  ADD CONSTRAINT `paquete_ibfk_5` FOREIGN KEY (`idcliente`) REFERENCES `cliente` (`idcliente`) ON UPDATE CASCADE;

--
-- Constraints for table `plandevuelo`
--
ALTER TABLE `plandevuelo`
  ADD CONSTRAINT `plandevuelo_ibfk_1` FOREIGN KEY (`idaeropuertoinicio`) REFERENCES `aeropuerto` (`idaeropuerto`) ON UPDATE CASCADE,
  ADD CONSTRAINT `plandevuelo_ibfk_2` FOREIGN KEY (`idaeropuertofin`) REFERENCES `aeropuerto` (`idaeropuerto`) ON UPDATE CASCADE;

--
-- Constraints for table `usuario`
--
ALTER TABLE `usuario`
  ADD CONSTRAINT `usuario_ibfk_1` FOREIGN KEY (`idperfil`) REFERENCES `perfil` (`idperfil`) ON UPDATE CASCADE;

--
-- Constraints for table `vuelo`
--
ALTER TABLE `vuelo`
  ADD CONSTRAINT `vuelo_ibfk_1` FOREIGN KEY (`idavion`) REFERENCES `avion` (`idavion`) ON UPDATE CASCADE,
  ADD CONSTRAINT `vuelo_ibfk_2` FOREIGN KEY (`idplan`) REFERENCES `plandevuelo` (`idplan`) ON UPDATE CASCADE,
  ADD CONSTRAINT `vuelo_ibfk_3` FOREIGN KEY (`idestado`) REFERENCES `estado` (`idestado`) ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
