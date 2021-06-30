-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 30-06-2021 a las 08:27:31
-- Versión del servidor: 10.4.13-MariaDB
-- Versión de PHP: 7.4.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `notas_db`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `asistencias`
--

CREATE TABLE `asistencias` (
  `idAsistencias` int(11) NOT NULL,
  `Inasist_justificada` varchar(2) DEFAULT NULL,
  `Inasist_Injustificada` varchar(2) DEFAULT NULL,
  `Tard_Justificada` varchar(2) DEFAULT NULL,
  `Tard_Injustificada` varchar(2) DEFAULT NULL,
  `Id_Estudiante` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `asistencias`
--

INSERT INTO `asistencias` (`idAsistencias`, `Inasist_justificada`, `Inasist_Injustificada`, `Tard_Justificada`, `Tard_Injustificada`, `Id_Estudiante`) VALUES
(1, '0', '1', '3', '1', 1),
(2, '2', '1', '1', '1', 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `conclucion_descriptiva`
--

CREATE TABLE `conclucion_descriptiva` (
  `idConclucion_descriptiva` int(11) NOT NULL,
  `Id_Estudiante` varchar(45) DEFAULT NULL,
  `Id_persona` varchar(45) DEFAULT NULL,
  `Descripcion` varchar(85) DEFAULT NULL,
  `Periodo` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `conclucion_descriptiva`
--

INSERT INTO `conclucion_descriptiva` (`idConclucion_descriptiva`, `Id_Estudiante`, `Id_persona`, `Descripcion`, `Periodo`) VALUES
(1, '1', '2', 'Tuvo un desempeño aceptable en el bimestre', '60');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `curso`
--

CREATE TABLE `curso` (
  `idCurso` int(11) NOT NULL,
  `Nombre_curso` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `curso`
--

INSERT INTO `curso` (`idCurso`, `Nombre_curso`) VALUES
(1, 'Matematica'),
(2, 'Lenguaje'),
(3, 'Religion'),
(4, 'Biologia'),
(5, 'Estudios Sociales'),
(6, 'Musica');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estudiante`
--

CREATE TABLE `estudiante` (
  `idEstudiante` int(11) NOT NULL,
  `Nombre` varchar(75) NOT NULL,
  `Apellidos` varchar(55) NOT NULL,
  `Dni` int(8) NOT NULL,
  `Codigo_est` varchar(20) NOT NULL,
  `IdGrado` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='		';

--
-- Volcado de datos para la tabla `estudiante`
--

INSERT INTO `estudiante` (`idEstudiante`, `Nombre`, `Apellidos`, `Dni`, `Codigo_est`, `IdGrado`) VALUES
(1, 'Celeste', 'Mamani Colque', 2452224, 'cmamani', 1),
(2, 'Lucia', 'Flores Flores', 4422335, 'lflores', 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `grado`
--

CREATE TABLE `grado` (
  `idGrado` int(11) NOT NULL,
  `Grado` varchar(45) NOT NULL,
  `Seccion` varchar(2) NOT NULL,
  `Tutor` varchar(75) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `grado`
--

INSERT INTO `grado` (`idGrado`, `Grado`, `Seccion`, `Tutor`) VALUES
(1, 'Primero', 'A', 'Jorge Torrez'),
(2, 'Primero', 'B', 'Sandra Gomez'),
(3, 'Segundo', 'A', 'Joel Quispe'),
(4, 'Segundo', 'B', 'Ivan Tapia');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `institución`
--

CREATE TABLE `institución` (
  `idInstitución` int(11) NOT NULL,
  `Nombre` varchar(85) NOT NULL,
  `Nivel` varchar(45) NOT NULL,
  `Codigo_Modular` varchar(10) NOT NULL,
  `Logo` varchar(75) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `institución`
--

INSERT INTO `institución` (`idInstitución`, `Nombre`, `Nivel`, `Codigo_Modular`, `Logo`) VALUES
(1, 'Unidad Educativa Tupac Katari', 'Primario', 'Bimestral', 'UETK');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `notas`
--

CREATE TABLE `notas` (
  `idNotas` int(11) NOT NULL,
  `Id_Estudiante` int(11) NOT NULL,
  `Id_Curso` int(11) NOT NULL,
  `Nota1` decimal(10,0) NOT NULL,
  `Nota2` decimal(10,0) NOT NULL,
  `Nota3` decimal(10,0) NOT NULL,
  `Nota4` decimal(10,0) NOT NULL,
  `Promedio` decimal(10,0) NOT NULL,
  `idPeriodo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `notas`
--

INSERT INTO `notas` (`idNotas`, `Id_Estudiante`, `Id_Curso`, `Nota1`, `Nota2`, `Nota3`, `Nota4`, `Promedio`, `idPeriodo`) VALUES
(1, 1, 4, '60', '80', '70', '70', '70', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `notas_periodo`
--

CREATE TABLE `notas_periodo` (
  `id_Periodo` int(11) NOT NULL,
  `Nota_Periodo1` varchar(45) DEFAULT NULL,
  `Nota_Periodo2` varchar(45) DEFAULT NULL,
  `Nota_Periodo3` varchar(45) DEFAULT NULL,
  `Nota_Periodo4` varchar(45) DEFAULT NULL,
  `Promedio_Anual` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `notas_periodo`
--

INSERT INTO `notas_periodo` (`id_Periodo`, `Nota_Periodo1`, `Nota_Periodo2`, `Nota_Periodo3`, `Nota_Periodo4`, `Promedio_Anual`) VALUES
(1, '60', '80', '70', '70', '70');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `personal`
--

CREATE TABLE `personal` (
  `idPersonal` int(11) NOT NULL,
  `Nombre` varchar(55) NOT NULL,
  `Apellidos` varchar(75) NOT NULL,
  `Usuario` varchar(10) NOT NULL,
  `Clave` varchar(8) NOT NULL,
  `IdTipo_usuario` int(11) NOT NULL,
  `Id_curso` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `personal`
--

INSERT INTO `personal` (`idPersonal`, `Nombre`, `Apellidos`, `Usuario`, `Clave`, `IdTipo_usuario`, `Id_curso`) VALUES
(1, 'Jose', 'Luna Calle', 'jluna', '1234', 1, 2),
(2, 'Ana', 'Roca Sanchez', 'aroca', '1122', 1, 4);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_usuario`
--

CREATE TABLE `tipo_usuario` (
  `idTipo_Usuario` int(11) NOT NULL,
  `Tipo` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tipo_usuario`
--

INSERT INTO `tipo_usuario` (`idTipo_Usuario`, `Tipo`) VALUES
(1, 'Docente'),
(2, 'Secretario'),
(3, 'Portero');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `asistencias`
--
ALTER TABLE `asistencias`
  ADD PRIMARY KEY (`idAsistencias`),
  ADD KEY `asist-estud_idx` (`Id_Estudiante`);

--
-- Indices de la tabla `conclucion_descriptiva`
--
ALTER TABLE `conclucion_descriptiva`
  ADD PRIMARY KEY (`idConclucion_descriptiva`);

--
-- Indices de la tabla `curso`
--
ALTER TABLE `curso`
  ADD PRIMARY KEY (`idCurso`);

--
-- Indices de la tabla `estudiante`
--
ALTER TABLE `estudiante`
  ADD PRIMARY KEY (`idEstudiante`);

--
-- Indices de la tabla `grado`
--
ALTER TABLE `grado`
  ADD PRIMARY KEY (`idGrado`);

--
-- Indices de la tabla `institución`
--
ALTER TABLE `institución`
  ADD PRIMARY KEY (`idInstitución`);

--
-- Indices de la tabla `notas`
--
ALTER TABLE `notas`
  ADD PRIMARY KEY (`idNotas`),
  ADD KEY `e-n_idx` (`Id_Estudiante`),
  ADD KEY `n-cur_idx` (`Id_Curso`);

--
-- Indices de la tabla `notas_periodo`
--
ALTER TABLE `notas_periodo`
  ADD PRIMARY KEY (`id_Periodo`);

--
-- Indices de la tabla `personal`
--
ALTER TABLE `personal`
  ADD PRIMARY KEY (`idPersonal`),
  ADD KEY `p-c_idx` (`Id_curso`),
  ADD KEY `p-u_idx` (`IdTipo_usuario`);

--
-- Indices de la tabla `tipo_usuario`
--
ALTER TABLE `tipo_usuario`
  ADD PRIMARY KEY (`idTipo_Usuario`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `asistencias`
--
ALTER TABLE `asistencias`
  MODIFY `idAsistencias` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `conclucion_descriptiva`
--
ALTER TABLE `conclucion_descriptiva`
  MODIFY `idConclucion_descriptiva` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `curso`
--
ALTER TABLE `curso`
  MODIFY `idCurso` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `estudiante`
--
ALTER TABLE `estudiante`
  MODIFY `idEstudiante` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `grado`
--
ALTER TABLE `grado`
  MODIFY `idGrado` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `institución`
--
ALTER TABLE `institución`
  MODIFY `idInstitución` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `notas`
--
ALTER TABLE `notas`
  MODIFY `idNotas` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `notas_periodo`
--
ALTER TABLE `notas_periodo`
  MODIFY `id_Periodo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `personal`
--
ALTER TABLE `personal`
  MODIFY `idPersonal` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `tipo_usuario`
--
ALTER TABLE `tipo_usuario`
  MODIFY `idTipo_Usuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `asistencias`
--
ALTER TABLE `asistencias`
  ADD CONSTRAINT `asist-estud` FOREIGN KEY (`Id_Estudiante`) REFERENCES `estudiante` (`idEstudiante`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `conclucion_descriptiva`
--
ALTER TABLE `conclucion_descriptiva`
  ADD CONSTRAINT `est-des` FOREIGN KEY (`idConclucion_descriptiva`) REFERENCES `estudiante` (`idEstudiante`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `estudiante`
--
ALTER TABLE `estudiante`
  ADD CONSTRAINT `e-g` FOREIGN KEY (`idEstudiante`) REFERENCES `grado` (`idGrado`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `notas`
--
ALTER TABLE `notas`
  ADD CONSTRAINT `e-n` FOREIGN KEY (`Id_Estudiante`) REFERENCES `estudiante` (`idEstudiante`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `n-cur` FOREIGN KEY (`Id_Curso`) REFERENCES `curso` (`idCurso`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `notas_periodo`
--
ALTER TABLE `notas_periodo`
  ADD CONSTRAINT `p-p` FOREIGN KEY (`id_Periodo`) REFERENCES `notas` (`idNotas`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `personal`
--
ALTER TABLE `personal`
  ADD CONSTRAINT `p-c` FOREIGN KEY (`Id_curso`) REFERENCES `curso` (`idCurso`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `p-u` FOREIGN KEY (`IdTipo_usuario`) REFERENCES `tipo_usuario` (`idTipo_Usuario`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
