-- phpMyAdmin SQL Dump
-- version 4.0.10deb1
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 24-06-2017 a las 18:30:45
-- Versión del servidor: 5.5.46-0ubuntu0.14.04.2
-- Versión de PHP: 5.5.9-1ubuntu4.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `requisitoxml2`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Estadorequisito`
--

CREATE TABLE IF NOT EXISTS `Estadorequisito` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `descripcionEstado` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=78 ;

--
-- Volcado de datos para la tabla `Estadorequisito`
--

INSERT INTO `Estadorequisito` (`id`, `descripcionEstado`) VALUES
(75, 'Abierto'),
(76, 'EnProgreso'),
(77, 'Abierto');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Gestionrequisito`
--

CREATE TABLE IF NOT EXISTS `Gestionrequisito` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `sistemaNombre` varchar(100) NOT NULL,
  `version` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=59 ;

--
-- Volcado de datos para la tabla `Gestionrequisito`
--

INSERT INTO `Gestionrequisito` (`id`, `nombre`, `sistemaNombre`, `version`) VALUES
(57, 'Sistema', 'Requisito2017', 0),
(58, 'Sistema', 'Requisito2017', 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Proyecto`
--

CREATE TABLE IF NOT EXISTS `Proyecto` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `version` int(11) NOT NULL DEFAULT '0',
  `nombreProyecto` varchar(100) NOT NULL,
  `descripcionProyecto` varchar(100) NOT NULL,
  `aplicacion_id` int(11) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `aplicacion_id` (`aplicacion_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=90 ;

--
-- Volcado de datos para la tabla `Proyecto`
--

INSERT INTO `Proyecto` (`id`, `version`, `nombreProyecto`, `descripcionProyecto`, `aplicacion_id`) VALUES
(86, 0, 'Expansion', 'Linea Electrica Salta', 57),
(87, 0, 'Desarrollo', 'Sistema Stock', 57),
(88, 0, 'Desarrollo', 'Sistema Stock', 58),
(89, 0, 'Expansion', 'Linea Electrica Salta', 58);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Requisito`
--

CREATE TABLE IF NOT EXISTS `Requisito` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `version` int(11) NOT NULL DEFAULT '0',
  `nombre` varchar(20) NOT NULL,
  `necesidad` varchar(20) NOT NULL,
  `prioridad` varchar(20) NOT NULL,
  `riesgo` varchar(20) NOT NULL,
  `proyecto` int(11) DEFAULT NULL,
  `estado` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `proyecto` (`proyecto`),
  KEY `estado` (`estado`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=219 ;

--
-- Volcado de datos para la tabla `Requisito`
--

INSERT INTO `Requisito` (`id`, `version`, `nombre`, `necesidad`, `prioridad`, `riesgo`, `proyecto`, `estado`) VALUES
(209, 0, 'Vehiculo Traslado', 'Compra', 'Alta', 'Bajo', 86, 75),
(210, 0, 'Banco Macro', 'Credito', 'Alta', 'Medio', NULL, NULL),
(211, 1, 'Requerimiento', 'Analizar', 'Media', 'Bajo', 87, 75),
(212, 1, 'Server', 'Contratacion', 'Alta', 'Bajo', 86, 76),
(213, 0, 'Agua', 'Extraccion', 'Media', 'Bajo', 86, 75),
(214, 1, 'Server', 'Contratacion', 'Alta', 'Bajo', 89, 77),
(215, 1, 'Vehiculo Traslado', 'Compra', 'Alta', 'Bajo', 89, 77),
(216, 0, 'Banco Macro', 'Credito', 'Alta', 'Medio', NULL, NULL),
(217, 1, 'Agua', 'Extraccion', 'Media', 'Bajo', 89, 77),
(218, 0, 'Requerimiento', 'Analizar', 'Media', 'Bajo', 88, 77);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `RequisitoCompuesto`
--

CREATE TABLE IF NOT EXISTS `RequisitoCompuesto` (
  `id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `RequisitoCompuesto`
--

INSERT INTO `RequisitoCompuesto` (`id`) VALUES
(209),
(212),
(214),
(215);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `RequisitoCompuesto_Requisito`
--

CREATE TABLE IF NOT EXISTS `RequisitoCompuesto_Requisito` (
  `compuesto_id` int(11) NOT NULL,
  `simple_id` int(11) NOT NULL,
  PRIMARY KEY (`compuesto_id`,`simple_id`),
  UNIQUE KEY `simple_id` (`simple_id`),
  KEY `compuesto_id` (`compuesto_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `RequisitoCompuesto_Requisito`
--

INSERT INTO `RequisitoCompuesto_Requisito` (`compuesto_id`, `simple_id`) VALUES
(209, 210),
(215, 216);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `RequisitoSimple`
--

CREATE TABLE IF NOT EXISTS `RequisitoSimple` (
  `id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `RequisitoSimple`
--

INSERT INTO `RequisitoSimple` (`id`) VALUES
(211),
(213),
(217),
(218);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Requisito_Abierto`
--

CREATE TABLE IF NOT EXISTS `Requisito_Abierto` (
  `id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `Requisito_Abierto`
--

INSERT INTO `Requisito_Abierto` (`id`) VALUES
(75),
(77);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Requisito_Cerrado`
--

CREATE TABLE IF NOT EXISTS `Requisito_Cerrado` (
  `id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Requisito_EnProgreso`
--

CREATE TABLE IF NOT EXISTS `Requisito_EnProgreso` (
  `id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `Requisito_EnProgreso`
--

INSERT INTO `Requisito_EnProgreso` (`id`) VALUES
(76);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Stakeholder`
--

CREATE TABLE IF NOT EXISTS `Stakeholder` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `version` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `apellido` varchar(100) NOT NULL,
  `rol` varchar(20) NOT NULL,
  `dni` varchar(10) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=88 ;

--
-- Volcado de datos para la tabla `Stakeholder`
--

INSERT INTO `Stakeholder` (`id`, `version`, `nombre`, `apellido`, `rol`, `dni`) VALUES
(84, 0, 'Martin', 'Palermo', 'Analista Junior', '25678987'),
(85, 0, 'Tito', 'Puente', 'Programador Junior', '25678907'),
(86, 0, 'Martin', 'Palermo', 'Analista Junior', '25678987'),
(87, 0, 'Tito', 'Puente', 'Programador Junior', '25678907');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Stakeholder_Requisitos`
--

CREATE TABLE IF NOT EXISTS `Stakeholder_Requisitos` (
  `stakeholder_id` int(11) NOT NULL,
  `requisitos_id` int(11) NOT NULL,
  PRIMARY KEY (`stakeholder_id`,`requisitos_id`),
  KEY `requisitos_id` (`requisitos_id`),
  KEY `stakeholder_id` (`stakeholder_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `Stakeholder_Requisitos`
--

INSERT INTO `Stakeholder_Requisitos` (`stakeholder_id`, `requisitos_id`) VALUES
(84, 211),
(85, 211),
(86, 218),
(87, 218);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `Proyecto`
--
ALTER TABLE `Proyecto`
  ADD CONSTRAINT `Proyecto_ibfk_1` FOREIGN KEY (`aplicacion_id`) REFERENCES `Gestionrequisito` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `Requisito`
--
ALTER TABLE `Requisito`
  ADD CONSTRAINT `Requisito_ibfk_1` FOREIGN KEY (`proyecto`) REFERENCES `Proyecto` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `Requisito_ibfk_2` FOREIGN KEY (`estado`) REFERENCES `Estadorequisito` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `RequisitoCompuesto`
--
ALTER TABLE `RequisitoCompuesto`
  ADD CONSTRAINT `RequisitoCompuesto_ibfk_1` FOREIGN KEY (`id`) REFERENCES `Requisito` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `RequisitoCompuesto_Requisito`
--
ALTER TABLE `RequisitoCompuesto_Requisito`
  ADD CONSTRAINT `RequisitoCompuesto_Requisito_ibfk_2` FOREIGN KEY (`simple_id`) REFERENCES `Requisito` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `RequisitoCompuesto_Requisito_ibfk_1` FOREIGN KEY (`compuesto_id`) REFERENCES `RequisitoCompuesto` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `RequisitoSimple`
--
ALTER TABLE `RequisitoSimple`
  ADD CONSTRAINT `RequisitoSimple_ibfk_1` FOREIGN KEY (`id`) REFERENCES `Requisito` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `Requisito_Abierto`
--
ALTER TABLE `Requisito_Abierto`
  ADD CONSTRAINT `Requisito_Abierto_ibfk_1` FOREIGN KEY (`id`) REFERENCES `Estadorequisito` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `Requisito_Cerrado`
--
ALTER TABLE `Requisito_Cerrado`
  ADD CONSTRAINT `Requisito_Cerrado_ibfk_1` FOREIGN KEY (`id`) REFERENCES `Estadorequisito` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `Requisito_EnProgreso`
--
ALTER TABLE `Requisito_EnProgreso`
  ADD CONSTRAINT `Requisito_EnProgreso_ibfk_1` FOREIGN KEY (`id`) REFERENCES `Estadorequisito` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `Stakeholder_Requisitos`
--
ALTER TABLE `Stakeholder_Requisitos`
  ADD CONSTRAINT `Stakeholder_Requisitos_ibfk_1` FOREIGN KEY (`stakeholder_id`) REFERENCES `Stakeholder` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `Stakeholder_Requisitos_ibfk_2` FOREIGN KEY (`requisitos_id`) REFERENCES `Requisito` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
