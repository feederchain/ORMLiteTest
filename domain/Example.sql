-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: May 06, 2019 at 10:41 PM
-- Server version: 5.5.59-MariaDB
-- PHP Version: 5.6.39

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `Example`
--
CREATE DATABASE IF NOT EXISTS `Example` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `Example`;

-- --------------------------------------------------------

--
-- Table structure for table `ITEM`
--

CREATE TABLE `ITEM` (
  `ID` int(11) NOT NULL,
  `NAME` char(50) NOT NULL,
  `QUANTITY` int(11) NOT NULL,
  `ID_VEND` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Truncate table before insert `ITEM`
--

TRUNCATE TABLE `ITEM`;
--
-- Dumping data for table `ITEM`
--

INSERT INTO `ITEM` (`ID`, `NAME`, `QUANTITY`, `ID_VEND`) VALUES
(1, 'Brush', 10, 10),
(2, 'Pepsi', 20, 20),
(3, 'Tire', 40, 30);

-- --------------------------------------------------------

--
-- Table structure for table `VENDOR`
--

CREATE TABLE `VENDOR` (
  `ID` int(11) NOT NULL,
  `NAME` char(50) NOT NULL,
  `PHONE` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Truncate table before insert `VENDOR`
--

TRUNCATE TABLE `VENDOR`;
--
-- Dumping data for table `VENDOR`
--

INSERT INTO `VENDOR` (`ID`, `NAME`, `PHONE`) VALUES
(10, 'Colgate', 444),
(20, 'PepsiCo', 555),
(30, 'Michelin', 666),
(40, 'Gramchi', 777);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `ITEM`
--
ALTER TABLE `ITEM`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `ID` (`ID`),
  ADD KEY `ID_VEND` (`ID_VEND`);

--
-- Indexes for table `VENDOR`
--
ALTER TABLE `VENDOR`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `ID` (`ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `ITEM`
--
ALTER TABLE `ITEM`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

--
-- AUTO_INCREMENT for table `VENDOR`
--
ALTER TABLE `VENDOR`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=42;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `ITEM`
--
ALTER TABLE `ITEM`
  ADD CONSTRAINT `ITEM_ibfk_1` FOREIGN KEY (`ID_VEND`) REFERENCES `VENDOR` (`ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
