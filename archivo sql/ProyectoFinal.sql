-- phpMyAdmin SQL Dump
-- version 4.6.6deb5
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost:3306
-- Tiempo de generación: 23-05-2020 a las 18:32:12
-- Versión del servidor: 5.7.30-0ubuntu0.18.04.1
-- Versión de PHP: 7.2.24-0ubuntu0.18.04.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `ProyectoFinal`
--
CREATE DATABASE IF NOT EXISTS `ProyectoFinal` DEFAULT CHARACTER SET utf8 COLLATE utf8_spanish_ci;
USE `ProyectoFinal`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `artist`
--

CREATE TABLE `artist` (
  `stage_name` varchar(60) COLLATE utf8_spanish_ci NOT NULL,
  `disc_num` varchar(20) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `artist`
--

INSERT INTO `artist` (`stage_name`, `disc_num`) VALUES
('Malú', '15 Discos');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `biography`
--

CREATE TABLE `biography` (
  `stage_name` varchar(60) COLLATE utf8_spanish_ci NOT NULL,
  `description` text COLLATE utf8_spanish_ci NOT NULL,
  `id_biography` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `biography`
--

INSERT INTO `biography` (`stage_name`, `description`, `id_biography`) VALUES
('Malú', 'Malú nació el 15 de marzo de 1982 en Madrid.\n\nSobrina del guitarrista Paco de Lucía, e hija del cantaor de flamenco Pepe de Lucia y la cantante Pepi Benítez.\n\nSu hermano mayor, José de Lucía, es guitarrista y la acompaña de gira como uno más de su banda. Su nombre artístico es la contracción de María Lucía.\n\n\nSe lo asignó su tía Reyes cuando tenía solo dos días de vida.\n\nCon quince años fue descubierta por el productor Jesús Yanes. Comenzó a grabar su primer disco, Aprendiz, en los primeros meses del año 1998. El álbum consiguió vender 400.000 copias. Logró el premio a la mejor artista revelación en los Premios Amigo de ese mismo año.\n\nEn 1999 Malú publicó el álbum Cambiarás, que en tan solo diez días vendió 100.000 copias. En 2001, salió a la luz Esta Vez, que vendió casi 300.000 copias en España. Su cuarto trabajo, Otra piel se lanzó al mercado en 2003.\n\nUn año después grabó un disco en directo llamado Por Una Vez, disco en el que colaboran cantantes como David de María, Antonio Orozco, Alejandro Sanz. En abril de 2005 publicó Malú su sexto álbum. En 2006 aparece su nuevo trabajo con el nombre de Desafío.\n', 7);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `discs`
--

CREATE TABLE `discs` (
  `id_disc` int(10) NOT NULL,
  `stage_name` varchar(60) COLLATE utf8_spanish_ci NOT NULL,
  `album_title` varchar(60) COLLATE utf8_spanish_ci NOT NULL,
  `song_num` varchar(20) COLLATE utf8_spanish_ci NOT NULL,
  `duration` varchar(60) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `discs`
--

INSERT INTO `discs` (`id_disc`, `stage_name`, `album_title`, `song_num`, `duration`) VALUES
(1, 'Malú', 'Oxígeno(2018)', '13 canciones', '50 min');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `user`
--

CREATE TABLE `user` (
  `nick` varchar(60) COLLATE utf8_spanish_ci NOT NULL,
  `password` varchar(60) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `user`
--

INSERT INTO `user` (`nick`, `password`) VALUES
('Admin', 'Admin1234');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `artist`
--
ALTER TABLE `artist`
  ADD PRIMARY KEY (`stage_name`);

--
-- Indices de la tabla `biography`
--
ALTER TABLE `biography`
  ADD PRIMARY KEY (`id_biography`),
  ADD KEY `stage_name` (`stage_name`);

--
-- Indices de la tabla `discs`
--
ALTER TABLE `discs`
  ADD PRIMARY KEY (`id_disc`),
  ADD KEY `stage_name` (`stage_name`);

--
-- Indices de la tabla `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`nick`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `biography`
--
ALTER TABLE `biography`
  MODIFY `id_biography` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT de la tabla `discs`
--
ALTER TABLE `discs`
  MODIFY `id_disc` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `biography`
--
ALTER TABLE `biography`
  ADD CONSTRAINT `biography_ibfk_1` FOREIGN KEY (`stage_name`) REFERENCES `artist` (`stage_name`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `discs`
--
ALTER TABLE `discs`
  ADD CONSTRAINT `discs_ibfk_1` FOREIGN KEY (`stage_name`) REFERENCES `artist` (`stage_name`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
