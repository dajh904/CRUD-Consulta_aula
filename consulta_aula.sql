-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 26-10-2023 a las 03:15:55
-- Versión del servidor: 10.4.28-MariaDB
-- Versión de PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `consulta_aula`
--
CREATE DATABASE IF NOT EXISTS `consulta_aula` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `consulta_aula`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `asignatura`
--

CREATE TABLE `asignatura` (
  `COD` int(11) NOT NULL,
  `Nombre` varchar(50) NOT NULL,
  `Semestre` int(11) NOT NULL,
  `Docente_ID` int(11) NOT NULL,
  `Programa_ID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Volcado de datos para la tabla `asignatura`
--

INSERT INTO `asignatura` (`COD`, `Nombre`, `Semestre`, `Docente_ID`, `Programa_ID`) VALUES
(1733, 'Cálculo Diferencial', 2, 1, 2),
(2311, 'Electiva Complementaria II', 7, 1, 3),
(2523, 'Dibujo Mecánico', 2, 3, 1),
(2563, 'Proyecto Final de Diseño de Ingeniería de ...', 9, 6, 1),
(2636, 'Métodos Cuantitativos de Operaciones', 6, 9, 4),
(9254, 'Finanzas a Corto Plazo', 6, 11, 4),
(9266, 'Control de Gestión', 8, 4, 4),
(9274, 'Formulación y Evaluación de Proyectos', 9, 10, 4),
(9717, 'Algoritmia y Programación II', 2, 5, 1),
(9737, 'Modelado de Objetos y Personajes en 3D', 6, 8, 1),
(9770, 'Introducción a la Ingeniería Industrial', 1, 2, 1),
(9892, 'Ingeniería del Software II', 6, 7, 1),
(9911, 'Electiva Profesional III', 9, 1, 1),
(9912, 'Electiva Complementaria II', 9, 4, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `aula`
--

CREATE TABLE `aula` (
  `ID` varchar(7) NOT NULL,
  `Piso` int(11) NOT NULL,
  `Tipo` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Volcado de datos para la tabla `aula`
--

INSERT INTO `aula` (`ID`, `Piso`, `Tipo`) VALUES
('313B', 3, 'Sin Computadores'),
('317B', 3, 'Sin Computadores'),
('318B', 3, 'Computadores'),
('CC315B', 3, 'Sin Computadores'),
('CC316B', 3, 'Computadores');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `aula_asignatura`
--

CREATE TABLE `aula_asignatura` (
  `ID` int(11) NOT NULL,
  `Asignatura_Cod` int(11) NOT NULL,
  `Dia_ID` int(11) NOT NULL,
  `Aula_ID` varchar(7) NOT NULL,
  `Hora_ini` time NOT NULL,
  `Hora_fin` time NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Volcado de datos para la tabla `aula_asignatura`
--

INSERT INTO `aula_asignatura` (`ID`, `Asignatura_Cod`, `Dia_ID`, `Aula_ID`, `Hora_ini`, `Hora_fin`) VALUES
(1, 9770, 2, '318B', '18:00:00', '18:45:00'),
(2, 2523, 6, '317B', '14:00:00', '18:00:00'),
(3, 1733, 3, '313B', '18:45:00', '21:00:00'),
(4, 9912, 1, 'CC316B', '19:30:00', '21:00:00'),
(5, 9717, 2, 'CC316B', '06:00:00', '08:00:00'),
(6, 2563, 2, 'CC316B', '18:00:00', '20:15:00'),
(7, 9912, 2, 'CC316B', '20:15:00', '21:00:00'),
(8, 9717, 3, 'CC316B', '08:00:00', '10:00:00'),
(9, 9892, 3, 'CC316B', '19:30:00', '21:00:00'),
(10, 9717, 4, 'CC316B', '10:00:00', '12:00:00'),
(11, 9892, 4, 'CC316B', '18:00:00', '19:30:00'),
(12, 9737, 5, 'CC316B', '09:00:00', '12:00:00'),
(13, 9892, 5, 'CC316B', '18:00:00', '19:30:00'),
(14, 9911, 5, 'CC316B', '19:30:00', '21:00:00'),
(15, 2311, 1, 'CC315B', '08:00:00', '10:00:00'),
(16, 2636, 1, 'CC315B', '19:30:00', '21:00:00'),
(17, 9266, 2, 'CC315B', '08:00:00', '10:00:00'),
(18, 9274, 2, 'CC315B', '18:00:00', '19:30:00'),
(19, 2311, 3, 'CC315B', '08:00:00', '09:00:00'),
(20, 9254, 4, 'CC315B', '18:45:00', '21:00:00');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `dia`
--

CREATE TABLE `dia` (
  `ID` int(11) NOT NULL,
  `Nombre` varchar(9) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Volcado de datos para la tabla `dia`
--

INSERT INTO `dia` (`ID`, `Nombre`) VALUES
(4, 'Jueves'),
(1, 'Lunes'),
(2, 'Martes'),
(3, 'Miércoles'),
(6, 'Sábado'),
(5, 'Viernes');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `docente`
--

CREATE TABLE `docente` (
  `ID` int(11) NOT NULL,
  `Nombre` varchar(15) DEFAULT NULL,
  `Apellido` varchar(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Volcado de datos para la tabla `docente`
--

INSERT INTO `docente` (`ID`, `Nombre`, `Apellido`) VALUES
(1, '', ''),
(2, 'Ruth', 'Reyes'),
(3, 'Fabian', 'Basto'),
(4, 'Yohana', 'Tenorio'),
(5, 'Raúl', 'Rodriguez'),
(6, 'Jover', 'Cabrales'),
(7, 'Miguel', 'Perez'),
(8, 'Carlos', 'Lobo'),
(9, 'Luis', 'Santafe'),
(10, 'Neida', 'Albornoz'),
(11, 'Iván', 'Barrera');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `programa`
--

CREATE TABLE `programa` (
  `ID` int(11) NOT NULL,
  `Nombre` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Volcado de datos para la tabla `programa`
--

INSERT INTO `programa` (`ID`, `Nombre`) VALUES
(1, 'Ingeniería'),
(2, 'Contaduría'),
(3, 'Derecho'),
(4, 'Administración');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `asignatura`
--
ALTER TABLE `asignatura`
  ADD PRIMARY KEY (`COD`),
  ADD KEY `Docente_ID_FK1_idx` (`Docente_ID`),
  ADD KEY `PROGRAMA_FK2_idx` (`Programa_ID`);

--
-- Indices de la tabla `aula`
--
ALTER TABLE `aula`
  ADD PRIMARY KEY (`ID`);

--
-- Indices de la tabla `aula_asignatura`
--
ALTER TABLE `aula_asignatura`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `Asignatura_Cod_FK1_idx` (`Asignatura_Cod`),
  ADD KEY `DIA_FK2_idx` (`Dia_ID`),
  ADD KEY `AULA_FK3_idx` (`Aula_ID`);

--
-- Indices de la tabla `dia`
--
ALTER TABLE `dia`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `Nombre_UNIQUE` (`Nombre`);

--
-- Indices de la tabla `docente`
--
ALTER TABLE `docente`
  ADD PRIMARY KEY (`ID`);

--
-- Indices de la tabla `programa`
--
ALTER TABLE `programa`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `aula_asignatura`
--
ALTER TABLE `aula_asignatura`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;

--
-- AUTO_INCREMENT de la tabla `dia`
--
ALTER TABLE `dia`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT de la tabla `docente`
--
ALTER TABLE `docente`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT de la tabla `programa`
--
ALTER TABLE `programa`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `asignatura`
--
ALTER TABLE `asignatura`
  ADD CONSTRAINT `DOCENTE_FK1` FOREIGN KEY (`Docente_ID`) REFERENCES `docente` (`ID`),
  ADD CONSTRAINT `PROGRAMA_FK2` FOREIGN KEY (`Programa_ID`) REFERENCES `programa` (`ID`);

--
-- Filtros para la tabla `aula_asignatura`
--
ALTER TABLE `aula_asignatura`
  ADD CONSTRAINT `ASIGNATURA_FK1` FOREIGN KEY (`Asignatura_Cod`) REFERENCES `asignatura` (`COD`),
  ADD CONSTRAINT `AULA_FK3` FOREIGN KEY (`Aula_ID`) REFERENCES `aula` (`ID`),
  ADD CONSTRAINT `DIA_FK2` FOREIGN KEY (`Dia_ID`) REFERENCES `dia` (`ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
