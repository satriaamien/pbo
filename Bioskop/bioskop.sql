-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 28, 2018 at 02:53 PM
-- Server version: 10.1.37-MariaDB
-- PHP Version: 7.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `bioskop`
--

-- --------------------------------------------------------

--
-- Table structure for table `cinema`
--

CREATE TABLE `cinema` (
  `id_cinema` int(5) NOT NULL,
  `name_cinema` varchar(50) NOT NULL,
  `jumlah_film` int(5) NOT NULL,
  `jumlah_studio` int(4) NOT NULL,
  `jumlah_jadwal` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `cinema`
--

INSERT INTO `cinema` (`id_cinema`, `name_cinema`, `jumlah_film`, `jumlah_studio`, `jumlah_jadwal`) VALUES
(1, 'Transmart Buah Batu', 5, 4, 10),
(2, 'CGV', 5, 4, 10);

-- --------------------------------------------------------

--
-- Table structure for table `film`
--

CREATE TABLE `film` (
  `id_film` int(15) NOT NULL,
  `judul_film` varchar(50) NOT NULL,
  `genre_film` varchar(50) NOT NULL,
  `durasi_film` varchar(20) NOT NULL,
  `sinopsis_film` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `film`
--

INSERT INTO `film` (`id_film`, `judul_film`, `genre_film`, `durasi_film`, `sinopsis_film`) VALUES
(1, 'Frozen', 'Kartun', '120', 'Disney'),
(2, 'Wreck It Ralph', 'Kartun', '180', 'Persahabatan');

-- --------------------------------------------------------

--
-- Table structure for table `location`
--

CREATE TABLE `location` (
  `id_lokasi` int(5) NOT NULL,
  `nama_lokasi` varchar(50) NOT NULL,
  `jumlah_bioskop` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `location`
--

INSERT INTO `location` (`id_lokasi`, `nama_lokasi`, `jumlah_bioskop`) VALUES
(1, 'Bandung', 5),
(2, 'Jakarta', 5);

-- --------------------------------------------------------

--
-- Table structure for table `object_admin`
--

CREATE TABLE `object_admin` (
  `id_admin` varchar(255) NOT NULL,
  `object_admin` longblob NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `object_admin`
--

INSERT INTO `object_admin` (`id_admin`, `object_admin`) VALUES
('Ariq', 0xaced00057372000d62696f736b6f702e41646d696e376e4cb3fe8dca0e0200014c000a6b6f64655f61646d696e7400124c6a6176612f6c616e672f537472696e673b7872000c62696f736b6f702e757365728c6d56c3e2d4e7960200044c0005656d61696c71007e00014c00046e616d6571007e00014c00047061737371007e00014c000570686f6e6571007e00017870740005656d61696c7400044172697174000331323374000430393939740003413932),
('intan', 0xaced00057372000d62696f736b6f702e41646d696e376e4cb3fe8dca0e0200014c000a6b6f64655f61646d696e7400124c6a6176612f6c616e672f537472696e673b7872000c62696f736b6f702e757365728c6d56c3e2d4e7960200044c0005656d61696c71007e00014c00046e616d6571007e00014c00047061737371007e00014c000570686f6e6571007e00017870740005656d61696c740005696e74616e7400033132337400053039393939740003693932),
('saminto', 0xaced00057372000d62696f736b6f702e41646d696e376e4cb3fe8dca0e0200014c000a6b6f64655f61646d696e7400124c6a6176612f6c616e672f537472696e673b7872000c62696f736b6f702e757365728c6d56c3e2d4e7960200044c0005656d61696c71007e00014c00046e616d6571007e00014c00047061737371007e00014c000570686f6e6571007e00017870740005656d61696c74000773616d696e746f7400033132337400053037373737740003733732);

-- --------------------------------------------------------

--
-- Table structure for table `seat`
--

CREATE TABLE `seat` (
  `nomor_kursi` int(10) NOT NULL,
  `baris_kursi` varchar(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `film`
--
ALTER TABLE `film`
  ADD PRIMARY KEY (`id_film`);

--
-- Indexes for table `location`
--
ALTER TABLE `location`
  ADD PRIMARY KEY (`id_lokasi`);

--
-- Indexes for table `object_admin`
--
ALTER TABLE `object_admin`
  ADD PRIMARY KEY (`id_admin`);

--
-- Indexes for table `seat`
--
ALTER TABLE `seat`
  ADD PRIMARY KEY (`nomor_kursi`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `film`
--
ALTER TABLE `film`
  MODIFY `id_film` int(15) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `location`
--
ALTER TABLE `location`
  MODIFY `id_lokasi` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `seat`
--
ALTER TABLE `seat`
  MODIFY `nomor_kursi` int(10) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
