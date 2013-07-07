-- phpMyAdmin SQL Dump
-- version 4.0.3
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Jul 07, 2013 at 06:16 PM
-- Server version: 5.5.24-log
-- PHP Version: 5.4.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `db_rsbk_aslab`
--
CREATE DATABASE IF NOT EXISTS `db_rsbk_aslab` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `db_rsbk_aslab`;

-- --------------------------------------------------------

--
-- Table structure for table `tbl_aslab`
--

CREATE TABLE IF NOT EXISTS `tbl_aslab` (
  `nim` varchar(15) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `angkatan` int(4) NOT NULL,
  `praktikum` varchar(50) NOT NULL,
  `bab` varchar(50) NOT NULL,
  `foto` varchar(50) NOT NULL,
  PRIMARY KEY (`nim`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_aslab`
--

INSERT INTO `tbl_aslab` (`nim`, `nama`, `angkatan`, `praktikum`, `bab`, `foto`) VALUES
('211120110120043', 'Khaer Ansori', 2010, 'Dasar Komputer dan Pemrograman', 'I Pendahuluan', 'aan.jpg'),
('bbbbb', 'bbbbbb', 11, 'bbbb', 'bbbbb', 'bbbbbb'),
('cccc', 'ccccccc', 0, 'cccc', 'ccccc', 'ccccc'),
('sdfsd', 'sdfsd', 123, 'sdfs', 'sdfsdf', 'sdf'),
('zzz', 'zzz', 123123, 'zzz', 'zzz', 'zzz');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
